package sirjain.extensivediamonds.data.EDOrePlacement;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import sirjain.extensivediamonds.ExtensiveDiamonds;
import sirjain.extensivediamonds.block.EDBlocks;

import java.util.List;

public class EDConfiguredFeatures {
	public static final RegistryKey<ConfiguredFeature<?, ?>> RED_DIAMOND_ORE_KEY = registerKey("red_diamond_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_DIAMOND_ORE_KEY = registerKey("green_diamond_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> DARK_DIAMOND_ORE_KEY = registerKey("dark_diamond_ore");

	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
		RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

		List<OreFeatureConfig.Target> overworldRedDiamondOres =
			List.of(OreFeatureConfig.createTarget(stoneReplaceables, EDBlocks.RED_DIAMOND_ORE.getDefaultState()),
				OreFeatureConfig.createTarget(deepslateReplaceables, EDBlocks.DEEPSLATE_RED_DIAMOND_ORE.getDefaultState()));

		List<OreFeatureConfig.Target> overworldGreenDiamondOres =
			List.of(OreFeatureConfig.createTarget(stoneReplaceables, EDBlocks.GREEN_DIAMOND_ORE.getDefaultState()),
				OreFeatureConfig.createTarget(deepslateReplaceables, EDBlocks.DEEPSLATE_GREEN_DIAMOND_ORE.getDefaultState()));

		List<OreFeatureConfig.Target> overworldDarkDiamondOres =
			List.of(OreFeatureConfig.createTarget(stoneReplaceables, EDBlocks.DARK_DIAMOND_ORE.getDefaultState()),
				OreFeatureConfig.createTarget(deepslateReplaceables, EDBlocks.DEEPSLATE_DARK_DIAMOND_ORE.getDefaultState()));

		register(context, RED_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRedDiamondOres, 3));
		register(context, GREEN_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldGreenDiamondOres, 2));
		register(context, DARK_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldDarkDiamondOres, 2));
	}

	public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ExtensiveDiamonds.MOD_ID, name));
	}

	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
	                                                                               RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}
