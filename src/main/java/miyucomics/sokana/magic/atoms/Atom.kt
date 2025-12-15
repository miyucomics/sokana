package miyucomics.sokana.magic.atoms

import com.mojang.serialization.Codec
import miyucomics.sokana.magic.casting.SpellImage

// An atom of information on the stack, can be a string, a number, a vector, etc...
abstract class Atom(val type: AtomType<*>) {
	open fun executable(): Boolean = false
	open fun execute(image: SpellImage): SpellImage = image

	companion object {
		var CODEC: Codec<Atom> = AtomTypes.REGISTRY.getCodec().dispatch("type", Atom::type, AtomType<*>::mapCodec)
	}
}