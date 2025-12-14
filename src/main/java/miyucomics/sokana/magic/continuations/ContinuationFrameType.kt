package miyucomics.sokana.magic.continuations

import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec

abstract class ContinuationFrameType<T : ContinuationFrame>(val codec: Codec<T>) {
	val mapCodec: MapCodec<T> = codec.fieldOf("data")
}