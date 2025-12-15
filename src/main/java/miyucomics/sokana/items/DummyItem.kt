package miyucomics.sokana.items

import miyucomics.sokana.engine.atoms.types.StringAtom
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.casting.SpellImage
import miyucomics.sokana.engine.environments.PlayerEnvironment
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class DummyItem : Item(Settings()) {
	override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
		if (world.isClient)
			return TypedActionResult.success(user.getStackInHand(hand))

		val image = SpellImage(stack = listOf(), stash = listOf())
		val env = PlayerEnvironment(world as ServerWorld, user)
		val engine = SpellEngine(image, env)
		engine.executeAtoms(listOf("tu", "tu", "sin", "toki").map(::StringAtom))

		return super.use(world, user, hand)
	}
}