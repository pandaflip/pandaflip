
package net.mcreator.pandisflip.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.pandisflip.item.LegendarySwordShardItem;
import net.mcreator.pandisflip.PandisflipModElements;

@PandisflipModElements.ModElement.Tag
public class PandisflipItemGroup extends PandisflipModElements.ModElement {
	public PandisflipItemGroup(PandisflipModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabpandisflip") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LegendarySwordShardItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
