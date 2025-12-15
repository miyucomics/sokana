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
import miyucomics.sokana.utils.listOf
import net.minecraft.util.math.Vec3d

object OpAdd : SignedAction() {
	init {
		addSignature(Signature(DoubleAtom.TYPE.getParser(), DoubleAtom.TYPE.getParser())) { _, list -> (list.arg<Double>(0) + list.arg<Double>(1)).asActionResult() }
		addSignature(Signature(ListAtom.TYPE.getParser(), ListAtom.TYPE.getParser())) { _, list -> list.arg<List<Atom>>(0).plus(list.arg<List<Atom>>(1)).asActionResult() }
		addSignature(Signature(StringAtom.TYPE.getParser(), StringAtom.TYPE.getParser())) { _, list -> (list.arg<String>(0) + list.arg<String>(1)).asActionResult() }
		addSignature(Signature(Vec3dAtom.TYPE.getParser(), Vec3dAtom.TYPE.getParser())) { _, list -> list.arg<Vec3d>(0).add(list.arg<Vec3d>(1)).asActionResult() }

		addSignature(Signature(Vec3dAtom.TYPE.getParser(), DoubleAtom.TYPE.getParser())) { _, list ->
			val constant = list.arg<Double>(1)
			list.arg<Vec3d>(0).add(constant, constant, constant).asActionResult()
		}

		addSignature(Signature(DoubleAtom.TYPE.getParser().listOf())) { _, list -> (list.arg<List<Double>>(0).fold(0.0) { acc, atom -> acc + atom }).asActionResult() }
		addSignature(Signature(ListAtom.TYPE.getParser().listOf())) { _, list -> (list.arg<List<List<Atom>>>(0).fold(listOf<Atom>()) { acc, atom -> acc.plus(atom) }).asActionResult() }
		addSignature(Signature(StringAtom.TYPE.getParser().listOf())) { _, list -> (list.arg<List<String>>(0).fold("") { acc, atom -> acc + atom }).asActionResult() }
		addSignature(Signature(Vec3dAtom.TYPE.getParser().listOf())) { _, list -> (list.arg<List<Vec3d>>(0).fold(Vec3d.ZERO) { acc, atom -> acc.add(atom) }).asActionResult() }
	}
}