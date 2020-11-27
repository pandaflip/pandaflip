package net.mcreator.pandisflip.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.pandisflip.entity.SkellyGolemEntity;
import net.mcreator.pandisflip.PandisflipModElements;

import java.util.Map;

@PandisflipModElements.ModElement.Tag
public class SpawnerSkellyOnBlockRightClickedProcedure extends PandisflipModElements.ModElement {
	public SpawnerSkellyOnBlockRightClickedProcedure(PandisflipModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SpawnerSkellyOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure SpawnerSkellyOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure SpawnerSkellyOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure SpawnerSkellyOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SpawnerSkellyOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.DIAMOND_BLOCK, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Blocks.DIAMOND_BLOCK, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new SkellyGolemEntity.CustomEntity(SkellyGolemEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.ambient")),
						SoundCategory.NEUTRAL, (float) 10, (float) 1);
			} else {
				world.getWorld().playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.ambient")),
						SoundCategory.NEUTRAL, (float) 10, (float) 1, false);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.NAUTILUS, x, y, z, (int) 15, 3, 3, 3, 1);
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Sacrifiez un bloc de Diamant pour faire apparaitre le gardien."),
						(true));
			}
		}
	}
}
