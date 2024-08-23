package sirjain.extensivediamonds.data.EDOrePlacement;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import sirjain.extensivediamonds.ExtensiveDiamonds;

import java.util.List;

public class EDPlacedFeatures {
	public static final RegistryKey<PlacedFeature> RED_DIAMOND_ORE_PLACED_KEY = registerKey("red_diamond_ore_placed");
	public static final RegistryKey<PlacedFeature> GREEN_DIAMOND_ORE_PLACED_KEY = registerKey("green_diamond_ore_placed");
	public static final RegistryKey<PlacedFeature> DARK_DIAMOND_ORE_PLACED_KEY = registerKey("dark_diamond_ore_placed");

	public static void bootstrap(Registerable<PlacedFeature> context) {
		var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

		register(context, RED_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EDConfiguredFeatures.RED_DIAMOND_ORE_KEY),
			EDOrePlacement.modifiersWithCount(3,
				HeightRangePlacementModifier.uniform(YOffset.fixed(-51), YOffset.fixed(-36))));

		register(context, GREEN_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EDConfiguredFeatures.GREEN_DIAMOND_ORE_KEY),
			EDOrePlacement.modifiersWithCount(3,
				HeightRangePlacementModifier.uniform(YOffset.fixed(-62), YOffset.fixed(-37))));

		register(context, DARK_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EDConfiguredFeatures.DARK_DIAMOND_ORE_KEY),
			EDOrePlacement.modifiersWithCount(2,
				HeightRangePlacementModifier.uniform(YOffset.fixed(-62), YOffset.fixed(-40))));
	}

	public static RegistryKey<PlacedFeature> registerKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ExtensiveDiamonds.MOD_ID, name));
	}

	private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
	                             List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}
}
