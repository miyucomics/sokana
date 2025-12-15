package miyucomics.sokana.operators.math

import miyucomics.sokana.engine.actions.Signature
import miyucomics.sokana.engine.actions.arg
import miyucomics.sokana.engine.actions.impls.SignedAction
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.types.DoubleAtom
import miyucomics.sokana.engine.atoms.types.ListAtom
import miyucomics.sokana.engine.atoms.types.StringAtom
import miyucomics.sokana.engine.atoms.types.Vec3dAtom
import miyucomics.sokana.utils.asActionResult
import net.minecraft.util.math.Vec3d
import kotlin.math.abs

object OpLength : SignedAction() {
	init {
		addSignature(Signature(DoubleAtom.TYPE.getParser())) { _, list -> abs(list.arg<Double>(0)).asActionResult() }
		addSignature(Signature(ListAtom.TYPE.getParser())) { _, list -> list.arg<List<Atom>>(0).size.asActionResult() }
		addSignature(Signature(StringAtom.TYPE.getParser())) { _, list -> list.arg<String>(0).length.asActionResult() }
		addSignature(Signature(Vec3dAtom.TYPE.getParser())) { _, list -> list.arg<Vec3d>(0).length().asActionResult() }
	}
}