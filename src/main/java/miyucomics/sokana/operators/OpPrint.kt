package miyucomics.sokana.operators

import miyucomics.sokana.engine.actions.Action
import miyucomics.sokana.engine.casting.AtomResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.SpellContinuation
import miyucomics.sokana.engine.errors.NoSignaturesMatched
import net.minecraft.server.world.ServerWorld

object OpPrint : Action() {
	override fun execute(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): AtomResult {
		val stack = engine.image.stack
		if (stack.isEmpty())
			throw NoSignaturesMatched()
		engine.env.sendMessage(stack[0].display())
		return AtomResult(engine.image.copy(stack = stack.dropLast(1)), continuation)
	}
}