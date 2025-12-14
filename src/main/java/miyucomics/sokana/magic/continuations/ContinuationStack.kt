package miyucomics.sokana.magic.continuations

import com.mojang.serialization.Codec

sealed interface ContinuationStack {
	object Done : ContinuationStack
	data class NotDone(val frame: ContinuationFrame, val next: ContinuationStack) : ContinuationStack
	fun pushFrame(frame: ContinuationFrame): ContinuationStack = NotDone(frame, this)

	companion object {
		val CODEC: Codec<ContinuationStack> = ContinuationFrame.CODEC.listOf().xmap(
			// list -> SpellContinuation
			{ frames -> frames.foldRight(Done as ContinuationStack) { frame, stack -> NotDone(frame, stack) } },
			// SpellContinuation -> list
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