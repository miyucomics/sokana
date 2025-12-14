package miyucomics.sokana.items

import miyucomics.sokana.magic.atoms.types.DoubleAtom
import miyucomics.sokana.magic.casting.SpellImage
import miyucomics.sokana.magic.continuations.ContinuationStack
import miyucomics.sokana.magic.continuations.types.EvalFrame
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtOps
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class DummyItem : Item(Settings()) {
	override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
		user.sendMessage(Text.literal(
			SpellImage.CODEC.encodeStart(NbtOps.INSTANCE, SpellImage(listOf(DoubleAtom(10.0)), emptyList(), ContinuationStack.Done.pushFrame(EvalFrame(listOf(DoubleAtom(15.2)))))).toString()
		))
		return super.use(world, user, hand)
	}
}