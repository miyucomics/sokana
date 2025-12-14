package miyucomics.sokana.magic.atoms

import com.mojang.serialization.Codec

abstract class Atom(val type: AtomType<*>) {
	companion object {
		var CODEC: Codec<Atom> = AtomTypes.REGISTRY.getCodec().dispatch("type", Atom::type, AtomType<*>::mapCodec)
	}
}