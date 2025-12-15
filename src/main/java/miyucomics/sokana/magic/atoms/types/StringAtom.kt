package miyucomics.sokana.magic.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.magic.atoms.Atom
import miyucomics.sokana.magic.atoms.AtomType
import miyucomics.sokana.magic.casting.SpellImage
import miyucomics.sokana.magic.continuations.types.EvalFrame

class StringAtom(val string: String) : Atom(TYPE) {
	override fun executable() = true
	override fun execute(image: SpellImage): SpellImage {
		return image.copy(continuationStack = image.continuationStack.pushFrame(EvalFrame(listOf(this))))
	}

	companion object {
		val CODEC: Codec<StringAtom> = Codec.STRING.xmap(::StringAtom, StringAtom::string)
		val TYPE: AtomType<StringAtom> = object : AtomType<StringAtom>(CODEC) {}
	}
}