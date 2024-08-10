package sirjain.extensivediamonds.data;

import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class EDLootTableModifier {
	public static void registerLootTableModifiers() {
//		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
//			addItem(LootTables.VILLAGE_DESERT_HOUSE_CHEST.getRegistry(), EDItems.FUSED_DIAMOND, 0.04f, id, tableBuilder);
//			addItem(LootTables.ANCIENT_CITY_CHEST, EDItems.FUSED_DIAMOND, 0.2f, id, tableBuilder);
//			addItem(LootTables.VILLAGE_ARMORER_CHEST, EDItems.FUSED_DIAMOND, 0.06f, id, tableBuilder);
//			addItem(LootTables.VILLAGE_BUTCHER_CHEST, EDItems.FUSED_DIAMOND, 0.05f, id, tableBuilder);
//			addItem(LootTables.VILLAGE_TEMPLE_CHEST, EDItems.FUSED_DIAMOND, 0.06f, id, tableBuilder);
//
////			addItem();
//			LootPool.Builder poolBuilder = LootPool.builder()
//				.rolls(ConstantLootNumberProvider.create(1))
//				.conditionally(RandomChanceLootCondition.builder(0.2f))
//				.with(ItemEntry.builder(EDItems.FUSED_DIAMOND))
//				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
//
//			tableBuilder.
//		});

//		LootTableEvents.MODIFY.register();
	}

	public static void addItem(Identifier target, Item item, float chance, Identifier id, FabricLootTableBuilder tableBuilder) {
		if (!target.equals(id)) return;

		LootPool.Builder poolBuilder = LootPool.builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.conditionally(RandomChanceLootCondition.builder(chance))
			.with(ItemEntry.builder(item))
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

		tableBuilder.pool(poolBuilder.build());
	}
}
