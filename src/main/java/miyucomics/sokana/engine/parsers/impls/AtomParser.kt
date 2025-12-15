package miyucomics.sokana.engine.parsers.impls

import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.ParseResult
import miyucomics.sokana.engine.parsers.StackParser
import net.minecraft.server.world.ServerWorld

// Parses for a specific atom type, has a purifier function that lets it transform that atom into the data it contains for ease
class AtomParser<T : Atom, A : Any>(val type: AtomType<T>, val purifier: (T, ServerWorld) -> A?) : StackParser<A> {
	constructor(type: AtomType<T>, purifier: (T) -> A?) : this(type, { atom, world -> purifier(atom) })

	override fun parse(stack: List<Atom>, startIdx: Int, world: ServerWorld): ParseResult<A>? {
		val atom = stack.getOrNull(startIdx) ?: return null
		if (atom.type == type) {
			@Suppress("UNCHECKED_CAST")
			val returnValue = purifier(atom as T, world) ?: return null
			return ParseResult(returnValue, 1)
		}
		return null
	}
}