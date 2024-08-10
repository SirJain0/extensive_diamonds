package sirjain.extensivediamonds;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sirjain.extensivediamonds.data.EDLootTableModifier;
import sirjain.extensivediamonds.data.EDOrePlacement.EDOreGeneration;
import sirjain.extensivediamonds.block.EDBlocks;
import sirjain.extensivediamonds.items.EDItems;

public class ExtensiveDiamonds implements ModInitializer {
	public static final String MOD_ID = "extensivediamonds";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Extensive Diamonds!");

		EDItems.registerDiamonds();
		EDItems.registerCombat();
		EDItems.registerArmorSprites();
		EDBlocks.registerOres();
		EDBlocks.registerOreBlocks();

		EDOreGeneration.registerOres();
		EDLootTableModifier.registerLootTableModifiers();

		EDItems.registerItemsInVanillaTabs();
	}
}