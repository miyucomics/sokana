package miyucomics.sokana.engine.actions

import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.parsers.StackParser

class Signature(val reversedParsers: List<StackParser<*>>) {
	constructor(vararg parsers: StackParser<*>) : this(parsers.toList().reversed())

	fun tryParseStack(stack: List<Atom>): SignatureParse? {
		var consumedAtoms = 0
		var currentIdx = stack.size - 1
		val spellArguments = mutableListOf<Any>()

		for (parser in reversedParsers) {
			if (currentIdx < 0)
				return null
			val result = parser.parse(stack, currentIdx) ?: return null
			spellArguments.add(0, result.value!!)
			consumedAtoms += result.consumed
			currentIdx -= result.consumed
		}

		return SignatureParse(spellArguments, consumedAtoms)
	}

	data class SignatureParse(val values: List<Any>, val consumed: Int)
}

inline fun <reified T> List<Any>.arg(index: Int): T = this[index] as T