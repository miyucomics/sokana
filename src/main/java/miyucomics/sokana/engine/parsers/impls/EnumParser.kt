package miyucomics.sokana.engine.parsers.impls

import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.types.DoubleAtom
import miyucomics.sokana.engine.atoms.types.StringAtom
import miyucomics.sokana.engine.parsers.ParseResult
import miyucomics.sokana.engine.parsers.StackParser

class EnumParser<E : Enum<E>>(val enumClass: Class<E>) : StackParser<E> {
	override fun parse(stack: List<Atom>, startIdx: Int): ParseResult<E>? {
		val atom = stack.getOrNull(startIdx) ?: return null

		val value = when (atom) {
			is StringAtom -> {
				try {
					java.lang.Enum.valueOf(enumClass, atom.string.uppercase())
				} catch (_: IllegalArgumentException) {
					null
				}
			}
			is DoubleAtom -> {
				val ordinal = atom.number.toInt()
				enumClass.enumConstants.getOrNull(ordinal)
			}
			else -> null
		} ?: return null

		return ParseResult(value, 1)
	}
}