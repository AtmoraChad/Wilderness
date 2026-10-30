package net.atomorachad.wilderness.entity.custom;

import net.atomorachad.wilderness.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public class BrownBearEntity extends Animal implements NeutralMob {
    private static final EntityDataAccessor<Boolean> DATA_STANDING_ID = SynchedEntityData.defineId(BrownBearEntity.class, EntityDataSerializers.BOOLEAN);
    private static final float STAND_ANIMATION_TICKS = 6.0F;
    private float clientSideStandAnimationO;
    private float clientSideStandAnimation;
    private int warningSoundTicks;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private long persistentAngerEndTime;
    private @Nullable EntityReference<LivingEntity> persistentAngerTarget;
    private static final EntityDimensions BABY_DIMENSIONS = EntityDimensions.scalable(0.7F, 0.7F)
            .withEyeHeight(0.34375F)
            .withAttachments(EntityAttachments.builder().attach(EntityAttachment.PASSENGER, 0.0F, 0.625F, 0.0F));

    public BrownBearEntity(final EntityType<? extends BrownBearEntity> type, final Level level) {
        super(type, level);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(final ServerLevel level, final AgeableMob partner) {
        return ModEntities.BROWN_BEAR.create(level, EntitySpawnReason.BREEDING);
    }

    @Override
    public boolean isFood(final ItemStack itemStack) {
        return false;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BrownBearEntity.BrownBearMeleeAttackGoal());
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0, bear -> bear.isBaby() ? DamageTypeTags.PANIC_CAUSES : DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new BrownBearEntity.BrownBearHurtByTargetGoal());
        this.targetSelector.addGoal(2, new BrownBearEntity.BrownBearAttackPlayersGoal());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Fox.class, 10, true, true, (target, level) -> !this.isBaby()));
        this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MAX_HEALTH, 30.0)
                .add(Attributes.FOLLOW_RANGE, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, 6.0);
    }

    public static boolean checkBrownBearSpawnRules(
            final EntityType<BrownBearEntity> type, final LevelAccessor level, final EntitySpawnReason spawnReason, final BlockPos pos, final RandomSource random
    ) {
        return level.getBlockState(pos.below()).is(BlockTags.FOXES_SPAWNABLE_ON) && isBrightEnoughToSpawn(level, pos);
    }

    @Override
    protected void readAdditionalSaveData(final ValueInput input) {
        super.readAdditionalSaveData(input);
        this.readPersistentAngerSaveData(this.level(), input);
    }

    @Override
    protected void addAdditionalSaveData(final ValueOutput output) {
        super.addAdditionalSaveData(output);
        this.addPersistentAngerSaveData(output);
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setTimeToRemainAngry(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    @Override
    public void setPersistentAngerEndTime(final long endTime) {
        this.persistentAngerEndTime = endTime;
    }

    @Override
    public long getPersistentAngerEndTime() {
        return this.persistentAngerEndTime;
    }

    @Override
    public void setPersistentAngerTarget(final @Nullable EntityReference<LivingEntity> persistentAngerTarget) {
        this.persistentAngerTarget = persistentAngerTarget;
    }

    @Override
    public @Nullable EntityReference<LivingEntity> getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isBaby() ? SoundEvents.POLAR_BEAR_AMBIENT_BABY : SoundEvents.POLAR_BEAR_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(final DamageSource source) {
        return SoundEvents.POLAR_BEAR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.POLAR_BEAR_DEATH;
    }

    @Override
    protected void playStepSound(final BlockPos pos, final BlockState blockState) {
        this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 1.0F);
    }

    protected void playWarningSound() {
        if (this.warningSoundTicks <= 0) {
            this.makeSound(SoundEvents.POLAR_BEAR_WARNING);
            this.warningSoundTicks = 40;
        }
    }

    @Override
    protected void defineSynchedData(final SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        entityData.define(DATA_STANDING_ID, false);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            if (this.clientSideStandAnimation != this.clientSideStandAnimationO) {
                this.refreshDimensions();
            }

            this.clientSideStandAnimationO = this.clientSideStandAnimation;
            if (this.isStanding()) {
                this.clientSideStandAnimation = Mth.clamp(this.clientSideStandAnimation + 1.0F, 0.0F, 6.0F);
            } else {
                this.clientSideStandAnimation = Mth.clamp(this.clientSideStandAnimation - 1.0F, 0.0F, 6.0F);
            }
        }

        if (this.warningSoundTicks > 0) {
            this.warningSoundTicks--;
        }

        if (!this.level().isClientSide()) {
            this.updatePersistentAnger((ServerLevel)this.level(), true);
        }
    }

    @Override
    public EntityDimensions getDefaultDimensions(final Pose pose) {
        EntityDimensions dimension = this.isBaby() ? BABY_DIMENSIONS : super.getDefaultDimensions(pose);
        if (this.clientSideStandAnimation > 0.0F) {
            float standFactor = this.clientSideStandAnimation / 6.0F;
            float heightScaleFactor = 1.0F + standFactor;
            return dimension.scale(1.0F, heightScaleFactor);
        } else {
            return dimension;
        }
    }

    public boolean isStanding() {
        return this.entityData.get(DATA_STANDING_ID);
    }

    public void setStanding(final boolean value) {
        this.entityData.set(DATA_STANDING_ID, value);
    }

    public float getStandingAnimationScale(final float a) {
        return Mth.lerp(a, this.clientSideStandAnimationO, this.clientSideStandAnimation) / 6.0F;
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.98F;
    }

    @Override
    public SpawnGroupData finalizeSpawn(
            final ServerLevelAccessor level, final DifficultyInstance difficulty, final EntitySpawnReason spawnReason, @Nullable SpawnGroupData groupData
    ) {
        if (groupData == null) {
            groupData = new AgeableMob.AgeableMobGroupData(1.0F);
        }

        return super.finalizeSpawn(level, difficulty, spawnReason, groupData);
    }

    private class BrownBearAttackPlayersGoal extends NearestAttackableTargetGoal<Player> {
        public BrownBearAttackPlayersGoal() {
            super(BrownBearEntity.this, Player.class, 20, true, true, null);
        }

        @Override
        public boolean canUse() {
            if (BrownBearEntity.this.isBaby()) {
                return false;
            }

            if (super.canUse()) {
                for (BrownBearEntity bear : BrownBearEntity.this.level().getEntitiesOfClass(BrownBearEntity.class, BrownBearEntity.this.getBoundingBox().inflate(8.0, 4.0, 8.0))) {
                    if (bear.isBaby()) {
                        return true;
                    }
                }
            }

            return false;
        }

        @Override
        protected double getFollowDistance() {
            return super.getFollowDistance() * 0.5;
        }
    }

    private class BrownBearHurtByTargetGoal extends HurtByTargetGoal {
        public BrownBearHurtByTargetGoal() {
            super(BrownBearEntity.this);
        }

        @Override
        public void start() {
            super.start();
            if (BrownBearEntity.this.isBaby()) {
                this.alertOthers();
                this.stop();
            }
        }

        @Override
        protected void alertOther(final Mob other, final LivingEntity hurtByMob) {
            if (other instanceof BrownBearEntity && !other.isBaby()) {
                super.alertOther(other, hurtByMob);
            }
        }
    }

    private class BrownBearMeleeAttackGoal extends MeleeAttackGoal {
        public BrownBearMeleeAttackGoal() {
            super(BrownBearEntity.this, 1.25, true);
        }

        @Override
        protected void checkAndPerformAttack(final LivingEntity target) {
            if (this.canPerformAttack(target)) {
                this.resetAttackCooldown();
                this.mob.doHurtTarget(getServerLevel(this.mob), target);
                BrownBearEntity.this.setStanding(false);
            } else if (this.mob.distanceToSqr(target) < (target.getBbWidth() + 3.0F) * (target.getBbWidth() + 3.0F)) {
                if (this.isTimeToAttack()) {
                    BrownBearEntity.this.setStanding(false);
                    this.resetAttackCooldown();
                }

                if (this.getTicksUntilNextAttack() <= 10) {
                    BrownBearEntity.this.setStanding(true);
                    BrownBearEntity.this.playWarningSound();
                }
            } else {
                this.resetAttackCooldown();
                BrownBearEntity.this.setStanding(false);
            }
        }

        @Override
        public void stop() {
            BrownBearEntity.this.setStanding(false);
            super.stop();
        }
    }
}
