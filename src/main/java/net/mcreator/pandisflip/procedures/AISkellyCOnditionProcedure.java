package net.mcreator.pandisflip.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.pandisflip.PandisflipModVariables;
import net.mcreator.pandisflip.PandisflipModElements;

import java.util.Map;

@PandisflipModElements.ModElement.Tag
public class AISkellyCOnditionProcedure extends PandisflipModElements.ModElement {
	public AISkellyCOnditionProcedure(PandisflipModElements instance) {
		super(instance, 8);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AISkellyCOndition!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AISkellyCOndition!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		PandisflipModVariables.MapVariables.get(world).skellyxpos = (double) (entity.getPosX());
		PandisflipModVariables.MapVariables.get(world).syncData(world);
		PandisflipModVariables.MapVariables.get(world).skellyypos = (double) (entity.getPosY());
		PandisflipModVariables.MapVariables.get(world).syncData(world);
		PandisflipModVariables.MapVariables.get(world).skellyzpos = (double) (entity.getPosZ());
		PandisflipModVariables.MapVariables.get(world).syncData(world);
	}
}
