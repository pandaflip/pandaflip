
package net.mcreator.pandisflip.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.pandisflip.itemgroup.PandisflipItemGroup;
import net.mcreator.pandisflip.PandisflipModElements;

import java.util.List;

@PandisflipModElements.ModElement.Tag
public class SkellyKeyItem extends PandisflipModElements.ModElement {
	@ObjectHolder("pandisflip:skelly_key")
	public static final Item block = null;
	public SkellyKeyItem(PandisflipModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PandisflipItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("skelly_key");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Un clef permettant d'ouvrir les coffres gard\u00E9s par les Skelly Golems"));
		}
	}
}
