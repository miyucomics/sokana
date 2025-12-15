package miyucomics.sokana.engine.atoms

import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec
import miyucomics.sokana.engine.parsers.StackParser

abstract class AtomType<T : Atom>(val codec: Codec<T>) {
	val mapCodec: MapCodec<T> = codec.fieldOf("data")
	abstract fun getParser(): StackParser<*>
}