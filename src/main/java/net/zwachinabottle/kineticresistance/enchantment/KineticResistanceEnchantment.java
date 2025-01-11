package net.zwachinabottle.kineticresistance.enchantment;

import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class KineticResistanceEnchantment extends Enchantment {
    public final Type type;

    public KineticResistanceEnchantment(Rarity Rarity, Type type, EquipmentSlot... applicableSlots) {
        super(Rarity, EnchantmentTarget.ARMOR, applicableSlots);
        this.type = type;
    }
    public int getMinPower(int pEnchantmentLevel) {
        return this.type.getMinCost() + (pEnchantmentLevel - 1) * this.type.getLevelCost();
    }

    public int getMaxPower(int pEnchantmentLevel) {
        return this.getMinPower(pEnchantmentLevel) + this.type.getLevelCost();
    }

    public int getMaxLevel() {
        return 4;
    }

    public int getProtectionAmount (int level, DamageSource source) {
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return 0;
        } else if (this.type == Type.KINETIC) {
            return (source.isOf(RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("minecraft", "fly_into_wall"))) || source.isOf(RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("minecraft", "falling_stalactite"))) || source.isOf(RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("minecraft", "falling_anvil"))) || source.isOf(RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("minecraft", "falling_block")))) ? level:0;
        } else {
            return 0;
        }
    }

    /*public static double getExplosionKnockbackAfterDampener(LivingEntity pLivingEntity, double pDamage) {
        int $$2 = EnchantmentHelper.getEnchantmentLevel(Enchantments.BLAST_PROTECTION, pLivingEntity);
        if ($$2 > 0) {
            pDamage *= Mth.clamp(1.0 - (double)$$2 * 0.15, 0.0, 1.0);
        }

        return pDamage;
    }*/

    public static enum Type {
        KINETIC(1, 8);


        private final int minCost;
        private final int levelCost;

        private Type(int pMinCost, int pLevelCost) {
            this.minCost = pMinCost;
            this.levelCost = pLevelCost;
        }

        public int getMinCost() {
            return this.minCost;
        }

        public int getLevelCost() {
            return this.levelCost;
        }
    }
}