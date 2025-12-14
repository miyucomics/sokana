package miyucomics.sokana.magic.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.magic.atoms.Atom
import miyucomics.sokana.magic.atoms.AtomType

class DoubleAtom(val number: Double) : Atom(TYPE) {
	companion object {
		val CODEC: Codec<DoubleAtom> = Codec.DOUBLE.xmap(::DoubleAtom, DoubleAtom::number)
		val TYPE: AtomType<DoubleAtom> = object : AtomType<DoubleAtom>(CODEC) {}
	}
}