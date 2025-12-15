package miyucomics.sokana.operators

import miyucomics.sokana.engine.actions.Action
import miyucomics.sokana.engine.casting.CastResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.SpellContinuation
import miyucomics.sokana.engine.errors.NoSignaturesMatched
import net.minecraft.server.world.ServerWorld

object OpPrint : Action() {
	override fun execute(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): CastResult {
		val stack = engine.image.stack
		if (stack.isEmpty())
			throw NoSignaturesMatched()
		engine.env.sendMessage(stack[0].display())
		return CastResult(engine.image.copy(stack = stack.dropLast(1)), continuation)
	}
}