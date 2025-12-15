package miyucomics.sokana.magic.actions

import miyucomics.sokana.magic.atoms.types.DoubleAtom
import miyucomics.sokana.magic.atoms.types.Vec3dAtom
import miyucomics.sokana.magic.atoms.types.asActionResult
import miyucomics.sokana.magic.casting.Action
import miyucomics.sokana.magic.casting.Signature
import kotlin.math.abs

object OpLength : Action() {
	init {
		addSignature(Signature.of(DoubleAtom.TYPE) { _, a -> abs(a.number).asActionResult() })
		addSignature(Signature.of(Vec3dAtom.TYPE) { _, a -> a.vector.length().asActionResult() })
	}
}