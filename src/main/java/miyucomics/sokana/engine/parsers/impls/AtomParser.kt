package miyucomics.sokana.engine.parsers.impls

import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.ParseResult
import miyucomics.sokana.engine.parsers.StackParser

// Parses for a specific atom type, has a purifier function that lets it transform that atom into the data it contains for ease
class AtomParser<T : Atom, A : Any>(val type: AtomType<T>, val purifier: (T) -> A) : StackParser<A> {
	override fun parse(stack: List<Atom>, startIdx: Int): ParseResult<A>? {
		val atom = stack.getOrNull(startIdx) ?: return null
		if (atom.type == type) {
			@Suppress("UNCHECKED_CAST")
			return ParseResult(purifier(atom as T), 1)
		}
		return null
	}
}