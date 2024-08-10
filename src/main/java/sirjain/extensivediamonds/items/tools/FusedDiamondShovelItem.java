package sirjain.extensivediamonds.items.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class FusedDiamondShovelItem extends ShovelItem {
	public FusedDiamondShovelItem(ToolMaterial material, Settings settings) {
		super(material, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 1), attacker);
		return super.postHit(stack, target, attacker);
	}
}
