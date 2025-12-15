package miyucomics.sokana.engine.casting

import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.continuations.SpellContinuation
import miyucomics.sokana.engine.continuations.types.EvalFrame
import net.minecraft.server.world.ServerWorld

// Temporary construct, does not ever get serialized
// Steps through a spell image to tick it forwards
class SpellEngine(var image: SpellImage, val world: ServerWorld) {
	fun executeAtoms(spell: List<Atom>) {
		var continuation = SpellContinuation.Done.pushFrame(EvalFrame(spell))

		try {
			while (continuation is SpellContinuation.NotDone) {
				val frame = continuation.frame
				val result = frame.step(this, world, continuation.next)
				continuation = result.continuation
				image = result.image
			}
		} catch (error: SpellError) {
			println(error.createMessage())
		}
	}
}