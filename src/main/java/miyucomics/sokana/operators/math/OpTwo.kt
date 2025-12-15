package miyucomics.sokana.operators.math

import miyucomics.sokana.engine.actions.Signature
import miyucomics.sokana.engine.actions.impls.SignedAction
import miyucomics.sokana.utils.asActionResult

object OpTwo : SignedAction() {
	init {
		addSignature(Signature()) { _, _ -> 2.asActionResult() }
	}
}