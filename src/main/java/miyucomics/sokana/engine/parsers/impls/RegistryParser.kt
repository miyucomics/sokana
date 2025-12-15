package miyucomics.sokana.engine.parsers.impls

import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.types.IdentifierAtom
import miyucomics.sokana.engine.parsers.ParseResult
import miyucomics.sokana.engine.parsers.StackParser
import net.minecraft.registry.Registry
import net.minecraft.server.world.ServerWorld

class RegistryParser<T>(val registry: Registry<T>) : StackParser<T> {
	override fun parse(stack: List<Atom>, startIdx: Int, world: ServerWorld): ParseResult<T>? {
		val id = (stack.getOrNull(startIdx) as? IdentifierAtom)?.identifier ?: return null
		if (registry.containsId(id))
			return ParseResult(registry.get(id)!!, 1)
		return null
	}
}