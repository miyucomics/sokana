package miyucomics.sokana.operators.meta

import miyucomics.sokana.engine.actions.Action
import miyucomics.sokana.engine.casting.CastResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.SpellContinuation
import net.minecraft.server.world.ServerWorld

object OpHalt : Action() {
	override fun execute(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): CastResult {
		var newContinuation = continuation
		while (newContinuation is SpellContinuation.NotDone) {
			val shouldStop = newContinuation.frame.breakThrough()
			newContinuation = newContinuation.next
			if (shouldStop)
				break
		}
		return CastResult(engine.image, newContinuation)
	}
}