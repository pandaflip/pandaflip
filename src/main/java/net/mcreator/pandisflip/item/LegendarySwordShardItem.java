
package net.mcreator.pandisflip.item;

import net.minecraftforge.registries.ObjectHolder;

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
public class LegendarySwordShardItem extends PandisflipModElements.ModElement {
	@ObjectHolder("pandisflip:legendary_sword_shard")
	public static final Item block = null;
	public LegendarySwordShardItem(PandisflipModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PandisflipItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("legendary_sword_shard");
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
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A75Ce morceaux d'arme provient d'un des \u00A7d\u00A7lnombreux artefact rare de ce monde."));
		}
	}
}
