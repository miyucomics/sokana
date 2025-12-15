package miyucomics.sokana.items

import miyucomics.sokana.engine.atoms.types.StringAtom
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.casting.SpellImage
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

		val engine = SpellEngine(SpellImage(stack = listOf(), stash = listOf()), world as ServerWorld)
		engine.executeAtoms(listOf("tu", "tu", "sin").map(::StringAtom))

		return super.use(world, user, hand)
	}
}