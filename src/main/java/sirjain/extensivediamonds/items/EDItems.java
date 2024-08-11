package sirjain.extensivediamonds.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import sirjain.extensivediamonds.ExtensiveDiamonds;
import sirjain.extensivediamonds.block.EDBlocks;
import sirjain.extensivediamonds.items.material.EDArmorMaterials;
import sirjain.extensivediamonds.items.material.FusedDiamondArmorItem;
import sirjain.extensivediamonds.items.material.EDToolMaterials;
import sirjain.extensivediamonds.items.swords.DarkDiamondSwordItem;
import sirjain.extensivediamonds.items.swords.FusedDiamondSwordItem;
import sirjain.extensivediamonds.items.swords.GreenDiamondSwordItem;
import sirjain.extensivediamonds.items.swords.RedDiamondSwordItem;
import sirjain.extensivediamonds.items.tools.FusedDiamondAxeItem;
import sirjain.extensivediamonds.items.tools.FusedDiamondHoeItem;
import sirjain.extensivediamonds.items.tools.FusedDiamondPickaxeItem;
import sirjain.extensivediamonds.items.tools.FusedDiamondShovelItem;

public class EDItems {
	public static Item RED_DIAMOND;
	public static Item GREEN_DIAMOND;
	public static Item DARK_DIAMOND;
	public static Item FUSED_DIAMOND;
	public static Item RED_DIAMOND_SWORD;
	public static Item GREEN_DIAMOND_SWORD;
	public static Item DARK_DIAMOND_SWORD;
	public static Item FUSED_DIAMOND_SWORD;
	public static Item FUSED_DIAMOND_AXE;
	public static Item FUSED_DIAMOND_HOE;
	public static Item FUSED_DIAMOND_SHOVEL;
	public static Item FUSED_DIAMOND_PICKAXE;
	public static Item FUSED_DIAMOND_HELMET;
	public static Item FUSED_DIAMOND_CHEST;
	public static Item FUSED_DIAMOND_LEGS;
	public static Item FUSED_DIAMOND_BOOTS;

	public static void registerDiamonds() {
		RED_DIAMOND = registerBasicItem("red_diamond");
		GREEN_DIAMOND = registerBasicItem("green_diamond");
		DARK_DIAMOND = registerBasicItem("dark_diamond");
		FUSED_DIAMOND = registerBasicItemWithSettings("fused_diamond", new Item.Settings().rarity(Rarity.UNCOMMON));
	}

	public static void registerCombat() {
		RED_DIAMOND_SWORD = registerCustomItem("red_diamond_sword", new RedDiamondSwordItem(EDToolMaterials.RED_DIAMOND, new Item.Settings()));
		GREEN_DIAMOND_SWORD = registerCustomItem("green_diamond_sword", new GreenDiamondSwordItem(EDToolMaterials.GREEN_DIAMOND, new Item.Settings()));
		DARK_DIAMOND_SWORD = registerCustomItem("dark_diamond_sword", new DarkDiamondSwordItem(EDToolMaterials.DARK_DIAMOND, new Item.Settings()));

		FUSED_DIAMOND_SWORD = registerCustomItem("fused_diamond_sword", new FusedDiamondSwordItem(EDToolMaterials.FUSED_DIAMOND, new Item.Settings().rarity(Rarity.UNCOMMON)));
		FUSED_DIAMOND_AXE = registerCustomItem("fused_diamond_axe", new FusedDiamondAxeItem(EDToolMaterials.FUSED_DIAMOND, new Item.Settings().rarity(Rarity.UNCOMMON)));
		FUSED_DIAMOND_HOE = registerCustomItem("fused_diamond_hoe", new FusedDiamondHoeItem(EDToolMaterials.FUSED_DIAMOND, new Item.Settings().rarity(Rarity.UNCOMMON)));
		FUSED_DIAMOND_SHOVEL = registerCustomItem("fused_diamond_shovel", new FusedDiamondShovelItem(EDToolMaterials.FUSED_DIAMOND, new Item.Settings().rarity(Rarity.UNCOMMON)));
		FUSED_DIAMOND_PICKAXE = registerCustomItem("fused_diamond_pickaxe",new FusedDiamondPickaxeItem(EDToolMaterials.FUSED_DIAMOND, new Item.Settings().rarity(Rarity.UNCOMMON)));
	}

	public static void registerArmorSprites() {
		FUSED_DIAMOND_HELMET = registerFusedArmorItem("fused_diamond_helmet", ArmorItem.Type.HELMET);
		FUSED_DIAMOND_CHEST = registerFusedArmorItem("fused_diamond_chestplate", ArmorItem.Type.CHESTPLATE);
		FUSED_DIAMOND_LEGS = registerFusedArmorItem("fused_diamond_leggings", ArmorItem.Type.LEGGINGS);
		FUSED_DIAMOND_BOOTS = registerFusedArmorItem("fused_diamond_boots", ArmorItem.Type.BOOTS);
	}

	public static void registerItemsInVanillaTabs() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(Items.DIAMOND, RED_DIAMOND, GREEN_DIAMOND, DARK_DIAMOND, FUSED_DIAMOND);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.addAfter(Items.DIAMOND_SWORD, RED_DIAMOND_SWORD, GREEN_DIAMOND_SWORD, DARK_DIAMOND_SWORD, FUSED_DIAMOND_SWORD);
			entries.addAfter(Items.DIAMOND_AXE, FUSED_DIAMOND_AXE);
			entries.addAfter(Items.DIAMOND_BOOTS, FUSED_DIAMOND_HELMET, FUSED_DIAMOND_CHEST, FUSED_DIAMOND_LEGS, FUSED_DIAMOND_BOOTS);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(
			Items.DIAMOND_HOE,

			FUSED_DIAMOND_SHOVEL,
			FUSED_DIAMOND_PICKAXE,
			FUSED_DIAMOND_AXE,
			FUSED_DIAMOND_HOE
		));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.addAfter(
			Items.DEEPSLATE_DIAMOND_ORE,

			EDBlocks.BLOCK_RED_DIAMOND_ORE,
			EDBlocks.BLOCK_DEEPSLATE_RED_DIAMOND_ORE,
			EDBlocks.BLOCK_GREEN_DIAMOND_ORE,
			EDBlocks.BLOCK_DEEPSLATE_GREEN_DIAMOND_ORE,
			EDBlocks.BLOCK_DARK_DIAMOND_ORE,
			EDBlocks.BLOCK_DEEPSLATE_DARK_DIAMOND_ORE
		));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.addAfter(
			Items.DIAMOND_BLOCK,

			EDBlocks.BLOCK_OF_RED_DIAMOND_BLOCK,
			EDBlocks.BLOCK_OF_GREEN_DIAMOND_BLOCK,
			EDBlocks.BLOCK_OF_DARK_DIAMOND_BLOCK
		));
	}

	public static Item registerBasicItem(String id) {
		return Registry.register(
			Registries.ITEM,
			Identifier.of(ExtensiveDiamonds.MOD_ID, id),
			new Item(new Item.Settings())
		);
	}

	public static Item registerBasicItemWithSettings(String id, Item.Settings settings) {
		return Registry.register(
			Registries.ITEM,
			Identifier.of(ExtensiveDiamonds.MOD_ID, id),
			new Item(settings)
		);
	}

	public static Item registerCustomItem(String id, Item item) {
		return Registry.register(
			Registries.ITEM,
			Identifier.of(ExtensiveDiamonds.MOD_ID, id),
			item
		);
	}

	public static Item registerFusedArmorItem(String id, ArmorItem.Type type) {
		return Registry.register(
			Registries.ITEM,
			Identifier.of(ExtensiveDiamonds.MOD_ID, id),
			new FusedDiamondArmorItem(EDArmorMaterials.FUSED_DIAMOND_ARMOR_MATERIAL, type, new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(type.getMaxDamage(41)))
		);
	}
}
