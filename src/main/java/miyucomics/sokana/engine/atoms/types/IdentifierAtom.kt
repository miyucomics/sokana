package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier

data class IdentifierAtom(val identifier: Identifier) : Atom(TYPE) {
	override fun display(): Text = Text.literal(identifier.toString()).formatted(Formatting.GOLD)

	companion object {
		val CODEC: Codec<IdentifierAtom> = Identifier.CODEC.xmap(::IdentifierAtom, IdentifierAtom::identifier)
		val TYPE: AtomType<IdentifierAtom> = object : AtomType<IdentifierAtom>(CODEC) {
			override fun getParser(): StackParser<Identifier> = AtomParser(TYPE, IdentifierAtom::identifier)
		}
	}
}