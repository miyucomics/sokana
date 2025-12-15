package miyucomics.sokana.operators.meta

import miyucomics.sokana.engine.actions.Action
import miyucomics.sokana.engine.atoms.types.StringAtom
import miyucomics.sokana.engine.casting.AtomResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.SpellContinuation
import miyucomics.sokana.engine.continuations.types.EvalFrame
import miyucomics.sokana.engine.errors.NoSignaturesMatched
import net.minecraft.server.world.ServerWorld

object OpEval : Action() {
	override fun execute(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): AtomResult {
		val stack = engine.image.stack
		if (stack.isEmpty())
			throw NoSignaturesMatched()
		val newContinuation = when (val atom = stack.last()) {
			is StringAtom -> continuation.pushFrame(EvalFrame(listOf(atom)))
//			is StringAtom -> continuation.pushFrame(FinishEvalFrame).pushFrame(EvalFrame(listOf(atom)))
			else -> throw NoSignaturesMatched()
		}
		return AtomResult(engine.image.copy(stack = stack.dropLast(1)), newContinuation)
	}
}