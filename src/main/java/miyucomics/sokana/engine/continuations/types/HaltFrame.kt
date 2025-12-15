package miyucomics.sokana.engine.continuations.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.continuations.ContinuationFrame
import miyucomics.sokana.engine.continuations.ContinuationFrameType

// Exists to tell break statements when to stop
val FinishEvalFrameType: ContinuationFrameType<FinishEvalFrame> = object : ContinuationFrameType<FinishEvalFrame>(Codec.lazyInitialized { Codec.unit(FinishEvalFrame) }) {}
object FinishEvalFrame : ContinuationFrame(FinishEvalFrameType) {
	override fun breakThrough() = false
}