package miyucomics.sokana.magic.casting

import miyucomics.sokana.magic.errors.NoSignaturesMatched

// An action is really just a collection of signatures, bound under an incantation
// When invoked, the handlers are stepped through one by one and whatever succeeds first gets to modify the image
abstract class Action(val handlers: MutableList<Signature>) {
	constructor() : this(mutableListOf<Signature>())

	fun addSignature(signature: Signature) {
		this.handlers.add(signature)
	}

	fun execute(engine: SpellEngine): SpellImage {
		handlers.forEach { signature ->
			if (signature.matches(engine))
				return signature.execute(engine)
		}
		throw NoSignaturesMatched()
	}
}