package miyucomics.sokana.engine.continuations.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.casting.CastResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.ContinuationFrame
import miyucomics.sokana.engine.continuations.ContinuationFrameType
import miyucomics.sokana.engine.continuations.SpellContinuation
import net.minecraft.server.world.ServerWorld

// When casting engine is ticked with this at the top of the continuation stack,
// this attempts to execute the first atom held within its list and if non-empty, it pushes itself back on
class EvalFrame(val atoms: List<Atom>) : ContinuationFrame(TYPE) {
	override fun breakThrough() = true
	override fun step(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): CastResult {
		if (atoms.isEmpty())
			return super.step(engine, world, continuation)

		val remaining = atoms.subList(1, atoms.size)
		val newContinuation = if (remaining.isNotEmpty()) {
			continuation.pushFrame(EvalFrame(remaining))
		} else {
			continuation // Don't push empty frame, tail-call optimization
		}

		return atoms[0].execute(engine, world, newContinuation)
	}

	companion object {
		val CODEC: Codec<EvalFrame> = Atom.CODEC.listOf().xmap(::EvalFrame, EvalFrame::atoms)
		val TYPE: ContinuationFrameType<EvalFrame> = object : ContinuationFrameType<EvalFrame>(CODEC) {}
	}
}