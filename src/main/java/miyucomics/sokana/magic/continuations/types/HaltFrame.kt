package miyucomics.sokana.magic.continuations.types

import com.mojang.serialization.Codec
import miyucomics.sokana.magic.continuations.ContinuationFrame
import miyucomics.sokana.magic.continuations.ContinuationFrameType

// Exists to tell break statements when to stop
class HaltFrame : ContinuationFrame(TYPE) {
	companion object {
		val CODEC: Codec<HaltFrame> = Codec.unit(HaltFrame())
		val TYPE: ContinuationFrameType<HaltFrame> = object : ContinuationFrameType<HaltFrame>(CODEC) {}
	}
}