package miyucomics.sokana.engine.actions

import miyucomics.sokana.engine.casting.CastResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.SpellContinuation
import net.minecraft.server.world.ServerWorld

// An action is really just a collection of signatures, bound under an incantation
// When invoked, the handlers are stepped through one by one and whatever succeeds first gets to modify the image
abstract class Action {
	abstract fun execute(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): CastResult
}