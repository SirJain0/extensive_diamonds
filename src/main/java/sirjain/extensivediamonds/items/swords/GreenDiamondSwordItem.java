package sirjain.extensivediamonds.items.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class GreenDiamondSwordItem extends SwordItem {
	public GreenDiamondSwordItem(ToolMaterial toolMaterial, Item.Settings settings) {
		super(toolMaterial, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 2), attacker);
		return super.postHit(stack, target, attacker);
	}
}

