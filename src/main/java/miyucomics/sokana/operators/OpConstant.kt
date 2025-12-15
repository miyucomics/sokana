package miyucomics.sokana.operators

import miyucomics.sokana.engine.actions.Signature
import miyucomics.sokana.engine.actions.impls.SignedAction
import miyucomics.sokana.engine.atoms.Atom

class OpConstant(val producer: () -> List<Atom>) : SignedAction() {
	init {
		addSignature(Signature()) { _, _ -> producer() }
	}
}