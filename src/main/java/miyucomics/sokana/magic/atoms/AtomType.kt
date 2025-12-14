package miyucomics.sokana.magic.atoms

import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec

abstract class AtomType<T : Atom>(val codec: Codec<T>) {
	val mapCodec: MapCodec<T> = codec.fieldOf("data")
}