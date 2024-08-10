package sirjain.extensivediamonds.items.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class RedDiamondSwordItem extends SwordItem {
	public RedDiamondSwordItem(ToolMaterial toolMaterial, Item.Settings settings) {
		super(toolMaterial, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.setOnFireFor(5);
		return super.postHit(stack, target, attacker);
	}
}

