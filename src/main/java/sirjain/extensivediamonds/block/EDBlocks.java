package sirjain.extensivediamonds.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import sirjain.extensivediamonds.ExtensiveDiamonds;

public class EDBlocks {
	public static Block RED_DIAMOND_ORE;
	public static Block GREEN_DIAMOND_ORE;
	public static Block DARK_DIAMOND_ORE;
	public static Block DEEPSLATE_RED_DIAMOND_ORE;
	public static Block DEEPSLATE_GREEN_DIAMOND_ORE;
	public static Block DEEPSLATE_DARK_DIAMOND_ORE;
	public static Block BLOCK_OF_GREEN_DIAMOND;
	public static Block BLOCK_OF_RED_DIAMOND;
	public static Block BLOCK_OF_DARK_DIAMOND;

	public static Item BLOCK_RED_DIAMOND_ORE;
	public static Item BLOCK_GREEN_DIAMOND_ORE;
	public static Item BLOCK_DARK_DIAMOND_ORE;
	public static Item BLOCK_DEEPSLATE_RED_DIAMOND_ORE;
	public static Item BLOCK_DEEPSLATE_GREEN_DIAMOND_ORE;
	public static Item BLOCK_DEEPSLATE_DARK_DIAMOND_ORE;
	public static Item BLOCK_OF_GREEN_DIAMOND_BLOCK;
	public static Item BLOCK_OF_DARK_DIAMOND_BLOCK;
	public static Item BLOCK_OF_RED_DIAMOND_BLOCK;

	// Includes deepslate and regular ore blocks.
	public static void registerOres() {
		RED_DIAMOND_ORE = registerOre("red_diamond_ore");
		GREEN_DIAMOND_ORE = registerOre("green_diamond_ore");
		DARK_DIAMOND_ORE = registerOre("dark_diamond_ore");
		DEEPSLATE_RED_DIAMOND_ORE = registerDeepslateOre("deepslate_red_diamond_ore");
		DEEPSLATE_GREEN_DIAMOND_ORE = registerDeepslateOre("deepslate_green_diamond_ore");
		DEEPSLATE_DARK_DIAMOND_ORE = registerDeepslateOre("deepslate_dark_diamond_ore");

		BLOCK_RED_DIAMOND_ORE = registerBlockItem("red_diamond_ore", RED_DIAMOND_ORE);
		BLOCK_GREEN_DIAMOND_ORE = registerBlockItem("green_diamond_ore", GREEN_DIAMOND_ORE);
		BLOCK_DARK_DIAMOND_ORE = registerBlockItem("dark_diamond_ore", DARK_DIAMOND_ORE);
		BLOCK_DEEPSLATE_RED_DIAMOND_ORE = registerBlockItem("deepslate_red_diamond_ore", DEEPSLATE_RED_DIAMOND_ORE);
		BLOCK_DEEPSLATE_GREEN_DIAMOND_ORE = registerBlockItem("deepslate_green_diamond_ore", DEEPSLATE_GREEN_DIAMOND_ORE);
		BLOCK_DEEPSLATE_DARK_DIAMOND_ORE = registerBlockItem("deepslate_dark_diamond_ore", DEEPSLATE_DARK_DIAMOND_ORE);
	}

	public static void registerOreBlocks() {
		BLOCK_OF_RED_DIAMOND = registerOreBlock("block_of_red_diamond", StatusEffects.STRENGTH);
		BLOCK_OF_GREEN_DIAMOND = registerOreBlock("block_of_green_diamond", StatusEffects.LUCK);
		BLOCK_OF_DARK_DIAMOND = registerOreBlock("block_of_dark_diamond", StatusEffects.RESISTANCE);

		BLOCK_OF_RED_DIAMOND_BLOCK = registerBlockItem("block_of_red_diamond", BLOCK_OF_RED_DIAMOND);
		BLOCK_OF_GREEN_DIAMOND_BLOCK = registerBlockItem("block_of_green_diamond", BLOCK_OF_GREEN_DIAMOND);
		BLOCK_OF_DARK_DIAMOND_BLOCK = registerBlockItem("block_of_dark_diamond", BLOCK_OF_DARK_DIAMOND);
	}

	public static Block registerOre(String id) {
		return Registry.register(
			Registries.BLOCK,
			Identifier.of(ExtensiveDiamonds.MOD_ID, id),
			new ExperienceDroppingBlock(
				UniformIntProvider.create(0, 3),
				AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)
					.requiresTool()
					.strength(3.0f, 3.0f)
				)
		);
	}

	public static Block registerDeepslateOre(String id) {
		return Registry.register(
			Registries.BLOCK,
			Identifier.of(ExtensiveDiamonds.MOD_ID, id),
			new ExperienceDroppingBlock(
				UniformIntProvider.create(0, 4),
				AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
					.requiresTool()
					.strength(3.0f, 3.0f)
				)
		);
	}

	public static Block registerOreBlock(String id, RegistryEntry<StatusEffect> effect) {
		return Registry.register(
			Registries.BLOCK,
			Identifier.of(ExtensiveDiamonds.MOD_ID, id),
			new EDDiamondBlock(
				AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)
					.requiresTool()
					.strength(3.0f, 3.0f),
				1, effect
			)
		);
	}

	public static Item registerBlockItem(String id, Block block) {
		return Registry.register(
			Registries.ITEM,
			Identifier.of(ExtensiveDiamonds.MOD_ID, id),
			new BlockItem(block, new Item.Settings())
		);
	}
}