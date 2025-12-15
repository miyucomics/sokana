package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.text.Text

class ListAtom(val contents: List<Atom>) : Atom(TYPE) {
	override fun display(): Text {
		val display = Text.literal("[")
		val lastIndex = contents.size - 1
		contents.map(Atom::display).forEachIndexed { index, text ->
			display.append(text)
			if (index < lastIndex)
				display.append(", ")
		}
		display.append("]")
		return display
	}

	companion object {
		val CODEC: Codec<ListAtom> = Atom.CODEC.listOf().xmap(::ListAtom, ListAtom::contents)
		val TYPE: AtomType<ListAtom> = object : AtomType<ListAtom>(CODEC) {
			override fun getParser(): StackParser<List<Atom>> = AtomParser(TYPE, ListAtom::contents)
		}
	}
}