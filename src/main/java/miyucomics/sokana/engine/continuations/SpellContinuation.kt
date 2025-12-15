package miyucomics.sokana.engine.continuations

import com.mojang.serialization.Codec

sealed interface SpellContinuation {
	object Done : SpellContinuation
	data class NotDone(val frame: ContinuationFrame, val next: SpellContinuation) : SpellContinuation
	fun pushFrame(frame: ContinuationFrame): SpellContinuation = NotDone(frame, this)

	companion object {
		val CODEC: Codec<SpellContinuation> = ContinuationFrame.CODEC.listOf().xmap(
			{ frames -> frames.foldRight(Done as SpellContinuation) { frame, stack -> NotDone(frame, stack) } },
			{ continuation ->
				val frames = mutableListOf<ContinuationFrame>()
				var current = continuation
				while (current is NotDone) {
					frames.add(current.frame)
					current = current.next
				}
				frames
			}
		)
	}
}