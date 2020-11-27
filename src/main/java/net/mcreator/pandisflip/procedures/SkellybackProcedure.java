package net.mcreator.pandisflip.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.pandisflip.PandisflipModVariables;
import net.mcreator.pandisflip.PandisflipModElements;

import java.util.Map;
import java.util.Collections;

@PandisflipModElements.ModElement.Tag
public class SkellybackProcedure extends PandisflipModElements.ModElement {
	public SkellybackProcedure(PandisflipModElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Skellyback!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Skellyback!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.getPosX()) > ((PandisflipModVariables.MapVariables.get(world).skellyxpos) + 20))) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((PandisflipModVariables.MapVariables.get(world).skellyxpos),
						(PandisflipModVariables.MapVariables.get(world).skellyypos), (PandisflipModVariables.MapVariables.get(world).skellyzpos));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((PandisflipModVariables.MapVariables.get(world).skellyxpos),
							(PandisflipModVariables.MapVariables.get(world).skellyypos), (PandisflipModVariables.MapVariables.get(world).skellyzpos),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) 100);
		} else if (((entity.getPosZ()) > ((PandisflipModVariables.MapVariables.get(world).skellyzpos) + 20))) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((PandisflipModVariables.MapVariables.get(world).skellyxpos),
						(PandisflipModVariables.MapVariables.get(world).skellyypos), (PandisflipModVariables.MapVariables.get(world).skellyzpos));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((PandisflipModVariables.MapVariables.get(world).skellyxpos),
							(PandisflipModVariables.MapVariables.get(world).skellyypos), (PandisflipModVariables.MapVariables.get(world).skellyzpos),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) 100);
		}
		if (((entity.getPosY()) > ((PandisflipModVariables.MapVariables.get(world).skellyypos) + 10))) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((PandisflipModVariables.MapVariables.get(world).skellyxpos),
						(PandisflipModVariables.MapVariables.get(world).skellyypos), (PandisflipModVariables.MapVariables.get(world).skellyzpos));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((PandisflipModVariables.MapVariables.get(world).skellyxpos),
							(PandisflipModVariables.MapVariables.get(world).skellyypos), (PandisflipModVariables.MapVariables.get(world).skellyzpos),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) 100);
		}
	}
}
