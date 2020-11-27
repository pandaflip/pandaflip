
package net.mcreator.pandisflip.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.pandisflip.itemgroup.PandisflipItemGroup;
import net.mcreator.pandisflip.PandisflipModElements;

@PandisflipModElements.ModElement.Tag
public class KHKeybladeItem extends PandisflipModElements.ModElement {
	@ObjectHolder("pandisflip:kh_keyblade")
	public static final Item block = null;
	public KHKeybladeItem(PandisflipModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2200;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LegendarySwordShardItem.block, (int) (1)));
			}
		}, 3, -2.4f, new Item.Properties().group(PandisflipItemGroup.tab)) {
		}.setRegistryName("kh_keyblade"));
	}
}
