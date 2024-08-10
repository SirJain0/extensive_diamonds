package sirjain.extensivediamonds.items.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class FusedDiamondAxeItem extends AxeItem {
	public FusedDiamondAxeItem(ToolMaterial material, Settings settings) {
		super(material, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 3), attacker);
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 18, 1), attacker);
		attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 1));

		return super.postHit(stack, target, attacker);
	}
}
