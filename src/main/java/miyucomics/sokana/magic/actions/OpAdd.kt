package miyucomics.sokana.magic.actions

import miyucomics.sokana.magic.atoms.types.DoubleAtom
import miyucomics.sokana.magic.atoms.types.Vec3dAtom
import miyucomics.sokana.magic.atoms.types.asActionResult
import miyucomics.sokana.magic.casting.Action
import miyucomics.sokana.magic.casting.Signature

object OpAdd : Action() {
	init {
		addSignature(Signature.of(DoubleAtom.TYPE, DoubleAtom.TYPE) { _, a, b -> (a.number + b.number).asActionResult() })
		addSignature(Signature.of(Vec3dAtom.TYPE, Vec3dAtom.TYPE) { _, a, b -> a.vector.add(b.vector).asActionResult() })
	}
}