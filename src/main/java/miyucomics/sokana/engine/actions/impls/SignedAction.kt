package miyucomics.sokana.engine.actions.impls

import miyucomics.sokana.engine.actions.Action
import miyucomics.sokana.engine.actions.Signature
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.casting.AtomResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.SpellContinuation
import miyucomics.sokana.engine.errors.NoSignaturesMatched
import net.minecraft.server.world.ServerWorld

// A signed action has a list of signatures, and whatever matches first, that executes
open class SignedAction : Action() {
	private val handlers = mutableListOf<Pair<Signature, (SpellEngine, List<Any>) -> List<Atom>>>()
	fun addSignature(signature: Signature, handler: (SpellEngine, List<Any>) -> List<Atom>) {
		this.handlers.add(signature to handler)
	}

	override fun execute(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): AtomResult {
		handlers.forEach { (signature, function) ->
			val spellArguments = signature.tryParseStack(engine.image.stack)
			if (spellArguments != null) {
				val stack = engine.image.stack.dropLast(spellArguments.consumed)
				return AtomResult(engine.image.copy(stack = stack.plus(function(engine, spellArguments.values))), continuation)
			}
		}
		throw NoSignaturesMatched()
	}
}