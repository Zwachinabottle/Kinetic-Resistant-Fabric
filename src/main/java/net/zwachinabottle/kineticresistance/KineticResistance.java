package net.zwachinabottle.kineticresistance;

import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zwachinabottle.kineticresistance.enchantment.KineticResistanceEnchantment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KineticResistance implements ModInitializer {
	public static final KineticResistanceEnchantment KINETIC_RESISTANCE = new KineticResistanceEnchantment(Enchantment.Rarity.RARE, KineticResistanceEnchantment.Type.KINETIC, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET, EquipmentSlot.HEAD);

	public static final String MOD_ID = "kineticresistance";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Registry.register(Registries.ENCHANTMENT, new Identifier("kineticresistance", "kinetic_resistance"), KINETIC_RESISTANCE);
	}
}