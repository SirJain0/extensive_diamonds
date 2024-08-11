package sirjain.extensivediamonds.data;

import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import sirjain.extensivediamonds.items.EDItems;

public class EDLootTableModifier {
	public static void registerLootTableModifiers() {
		LootTableEvents.MODIFY.register((key, tableBuilder, source, wrapperLookup) -> {
			if (key == LootTables.VILLAGE_DESERT_HOUSE_CHEST) appendItemToLootTable(EDItems.FUSED_DIAMOND, 0.04f, tableBuilder);
			else if (key == LootTables.ANCIENT_CITY_CHEST) appendItemToLootTable(EDItems.FUSED_DIAMOND, 0.2f, tableBuilder);
			else if (key == LootTables.VILLAGE_ARMORER_CHEST) appendItemToLootTable(EDItems.FUSED_DIAMOND, 06f, tableBuilder);
			else if (key == LootTables.VILLAGE_BUTCHER_CHEST) appendItemToLootTable(EDItems.FUSED_DIAMOND, 0.05f, tableBuilder);
			else if (key == LootTables.VILLAGE_TEMPLE_CHEST) appendItemToLootTable(EDItems.FUSED_DIAMOND, 0.06f, tableBuilder);
		});
	}

	public static void appendItemToLootTable(Item item, float chance, LootTable.Builder tableBuilder) {
		LootPool.Builder poolBuilder = new LootPool.Builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.conditionally(RandomChanceLootCondition.builder(chance))
			.with(ItemEntry.builder(item))
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

		tableBuilder.pool(poolBuilder);
	}
}
