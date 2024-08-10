package sirjain.extensivediamonds.items.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class DarkDiamondSwordItem extends SwordItem {
	public DarkDiamondSwordItem(ToolMaterial toolMaterial, Item.Settings settings) {
		super(toolMaterial, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 3 * 20, 1), attacker);
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 6 * 20, 0), attacker);

		return super.postHit(stack, target, attacker);
	}
}

