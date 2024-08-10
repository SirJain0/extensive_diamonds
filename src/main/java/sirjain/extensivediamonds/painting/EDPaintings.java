package sirjain.extensivediamonds.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sirjain.extensivediamonds.ExtensiveDiamonds;

public class EDPaintings {
	public static final PaintingVariant GEMS = registerPainting("gems", new PaintingVariant(32, 16));
	public static final PaintingVariant GEMS_LOGO = registerPainting("gems_logo", new PaintingVariant(16, 16));

	private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
		return Registry.register(Registries.PAINTING_VARIANT, Identifier.of(ExtensiveDiamonds.MOD_ID, name), paintingVariant);
	}

	public static void registerPaintings() {
		ExtensiveDiamonds.LOGGER.debug("Registering paintings for Extensive Diamonds!");
	}
}