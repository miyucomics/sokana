package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Formatting

class ItemStackAtom(val stack: ItemStack) : Atom(TYPE) {
	override fun display(): Text = Text.literal(stack.toString()).formatted(Formatting.GREEN)

	companion object {
		val CODEC: Codec<ItemStackAtom> = ItemStack.CODEC.xmap(::ItemStackAtom, ItemStackAtom::stack)
		val TYPE: AtomType<ItemStackAtom> = object : AtomType<ItemStackAtom>(CODEC) {
			override fun getParser(): StackParser<ItemStack> = AtomParser(TYPE, ItemStackAtom::stack)
		}
	}
}