package miyucomics.sokana.engine.parsers.impls

import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.types.MuAtom
import miyucomics.sokana.engine.parsers.ParseResult
import miyucomics.sokana.engine.parsers.StackParser

class SequenceParser<T>(val elementParser: StackParser<T>) : StackParser<List<T>> {
	override fun parse(stack: List<Atom>, startIdx: Int): ParseResult<List<T>>? {
		if (startIdx > 0) {
			// Find mu boundary
			var muIdx = startIdx - 1
			while (muIdx > 0 && stack[muIdx] !is MuAtom)
				muIdx--
			if (muIdx > 0) {
				// Found mu - consume from mu + 1 to startIdx
				val actualStart = muIdx + 1
				val results = mutableListOf<T>()
				var i = actualStart
				while (i <= startIdx) {
					val result = elementParser.parse(stack, i) ?: return null
					results.add(result.value)
					i += result.consumed
				}
				// +2 due to including the mu atom
				return ParseResult(results, startIdx - actualStart + 2)
			}
		}

		// No mu - consume just one element
		if (startIdx < 0) return null
		val result = elementParser.parse(stack, startIdx) ?: return null
		return ParseResult(listOf(result.value), result.consumed)
	}
}