package sirjain.extensivediamonds.items.material;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import sirjain.extensivediamonds.ExtensiveDiamonds;
import sirjain.extensivediamonds.items.EDItems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class EDArmorMaterials {
	public static final RegistryEntry<ArmorMaterial> FUSED_DIAMOND_ARMOR_MATERIAL = registerArmorMaterial("fused_diamond",
		() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
			map.put(ArmorItem.Type.BOOTS, 7);
			map.put(ArmorItem.Type.LEGGINGS, 10);
			map.put(ArmorItem.Type.CHESTPLATE, 12);
			map.put(ArmorItem.Type.HELMET, 6);
			map.put(ArmorItem.Type.BODY, 10);
		}), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(EDItems.FUSED_DIAMOND),
			List.of(new ArmorMaterial.Layer(Identifier.of(ExtensiveDiamonds.MOD_ID, "fused_diamond"))), 0, 0));

	public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
		return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(ExtensiveDiamonds.MOD_ID, name), material.get());
	}
}
