package miyucomics.sokana.magic.continuations

import com.mojang.serialization.Codec

abstract class ContinuationFrame(val type: ContinuationFrameType<*>) {
	companion object {
		var CODEC: Codec<ContinuationFrame> = ContinuationFrameTypes.REGISTRY.getCodec().dispatch("type", ContinuationFrame::type, ContinuationFrameType<*>::mapCodec)
	}
}