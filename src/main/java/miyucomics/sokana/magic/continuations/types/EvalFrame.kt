package miyucomics.sokana.magic.continuations.types

import com.mojang.serialization.Codec
import miyucomics.sokana.magic.atoms.Atom
import miyucomics.sokana.magic.continuations.ContinuationFrame
import miyucomics.sokana.magic.continuations.ContinuationFrameType

class EvalFrame(val atoms: List<Atom>) : ContinuationFrame(TYPE) {
	companion object {
		val CODEC: Codec<EvalFrame> = Atom.CODEC.listOf().xmap(::EvalFrame, EvalFrame::atoms)
		val TYPE: ContinuationFrameType<EvalFrame> = object : ContinuationFrameType<EvalFrame>(CODEC) {}
	}
}