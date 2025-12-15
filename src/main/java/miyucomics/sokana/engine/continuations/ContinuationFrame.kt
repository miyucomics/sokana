package miyucomics.sokana.engine.continuations

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.casting.CastResult
import miyucomics.sokana.engine.casting.SpellEngine
import net.minecraft.server.world.ServerWorld

abstract class ContinuationFrame(val type: ContinuationFrameType<*>) {
	abstract fun breakThrough(): Boolean
	open fun step(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): CastResult = CastResult(engine.image, continuation)

	companion object {
		var CODEC: Codec<ContinuationFrame> = ContinuationFrameTypes.REGISTRY.getCodec().dispatch("type", ContinuationFrame::type, ContinuationFrameType<*>::mapCodec)
	}
}