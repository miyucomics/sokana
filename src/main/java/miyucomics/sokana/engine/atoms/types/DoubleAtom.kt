package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.text.Text
import net.minecraft.util.Formatting

class DoubleAtom(val number: Double) : Atom(TYPE) {
	override fun display(): Text = Text.literal(number.toString()).formatted(Formatting.RED)

	companion object {
		val CODEC: Codec<DoubleAtom> = Codec.DOUBLE.xmap(::DoubleAtom, DoubleAtom::number)
		val TYPE: AtomType<DoubleAtom> = object : AtomType<DoubleAtom>(CODEC) {
			override fun getParser(): StackParser<Double> = AtomParser(TYPE, DoubleAtom::number)
		}
	}
}