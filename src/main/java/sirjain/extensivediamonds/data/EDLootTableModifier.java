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
import net.minecraft.util.Identifier;
import sirjain.extensivediamonds.items.EDItems;

public class EDLootTableModifier {
	public static void registerLootTableModifiers() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			addItem(LootTables.VILLAGE_DESERT_HOUSE_CHEST.getRegistry(), EDItems.FUSED_DIAMOND, 0.04f, id, tableBuilder);
			addItem(LootTables.ANCIENT_CITY_CHEST, EDItems.FUSED_DIAMOND, 0.2f, id, tableBuilder);
			addItem(LootTables.VILLAGE_ARMORER_CHEST, EDItems.FUSED_DIAMOND, 0.06f, id, tableBuilder);
			addItem(LootTables.VILLAGE_BUTCHER_CHEST, EDItems.FUSED_DIAMOND, 0.05f, id, tableBuilder);
			addItem(LootTables.VILLAGE_TEMPLE_CHEST, EDItems.FUSED_DIAMOND, 0.06f, id, tableBuilder);

//			addItem();
			LootPool.Builder poolBuilder = LootPool.builder()
				.rolls(ConstantLootNumberProvider.create(1))
				.conditionally(RandomChanceLootCondition.builder(0.2f))
				.with(ItemEntry.builder(EDItems.FUSED_DIAMOND))
				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

			(poolBuilder);
		});

		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			lootTableIDs.stream().filter(lootTableID -> lootTableID.equals(key)).forEach((lootTableID) -> {
				tableBuilder.withPool(LootPool.lootPool().setRolls(range).add(entryBuilder));
			});
		});
	}

//	public static void addItem(Identifier target, Item item, float chance, Identifier id, FabricLootTableBuilder tableBuilder) {
//		if (!target.equals(id)) return;
//
//		LootPool.Builder poolBuilder = LootPool.builder()
//			.rolls(ConstantLootNumberProvider.create(1))
//			.conditionally(RandomChanceLootCondition.builder(chance))
//			.with(ItemEntry.builder(item))
//			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
//
//		tableBuilder.pool(poolBuilder.build());
//	}

	public static void addRoll(List<ResourceKey<LootTable>> lootTableIDs, NumberProvider range, LootTable.Builder<?> entryBuilder) {
		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			lootTableIDs.stream().filter(lootTableID -> lootTableID.equals(key)).forEach((lootTableID) -> {
				tableBuilder.withPool(LootPool.lootPool().setRolls(range).add(entryBuilder));
			});
		});
	}
}
