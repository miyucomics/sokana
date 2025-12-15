package miyucomics.sokana.magic.casting

import miyucomics.sokana.magic.atoms.Atom
import miyucomics.sokana.magic.atoms.AtomType

abstract class Signature(val action: (SpellEngine, List<Atom>) -> List<Atom>) {
	abstract fun matches(engine: SpellEngine): Boolean

	fun execute(engine: SpellEngine): SpellImage {
		val newStack = action(engine, engine.image.minorStack)
		return engine.image.copy(minorStack = newStack)
	}

	companion object {
		fun <T1: Atom> of(
			input1: AtomType<T1>,
			handler: (SpellEngine, T1) -> List<Atom>
		): Signature = object : Signature({ engine, stack ->
			val a = stack[stack.size - 1] as T1
			stack.dropLast(1) + handler(engine, a)
		}) {
			override fun matches(engine: SpellEngine): Boolean {
				val stack = engine.image.minorStack
				return stack.isNotEmpty() &&
					stack[stack.size - 1].type == input1
			}
		}

		fun <T1: Atom, T2: Atom> of(
			input1: AtomType<T1>,
			input2: AtomType<T2>,
			handler: (SpellEngine, T1, T2) -> List<Atom>
		): Signature = object : Signature({ engine, stack ->
			val a = stack[stack.size - 2] as T1
			val b = stack[stack.size - 1] as T2
			stack.dropLast(2) + handler(engine, a, b)
		}) {
			override fun matches(engine: SpellEngine): Boolean {
				val stack = engine.image.minorStack
				return stack.size >= 2 &&
					stack[stack.size - 2].type == input1 &&
					stack[stack.size - 1].type == input2
			}
		}

		fun <T1: Atom, T2: Atom, T3: Atom> of(
			input1: AtomType<T1>,
			input2: AtomType<T2>,
			input3: AtomType<T3>,
			handler: (SpellEngine, T1, T2, T3) -> List<Atom>
		): Signature = object : Signature({ engine, stack ->
			val a = stack[stack.size - 3] as T1
			val b = stack[stack.size - 2] as T2
			val c = stack[stack.size - 1] as T3
			stack.dropLast(2) + handler(engine, a, b, c)
		}) {
			override fun matches(engine: SpellEngine): Boolean {
				val stack = engine.image.minorStack
				return stack.size >= 3 &&
						stack[stack.size - 3].type == input1 &&
						stack[stack.size - 2].type == input2 &&
						stack[stack.size - 1].type == input3
			}
		}
	}
}