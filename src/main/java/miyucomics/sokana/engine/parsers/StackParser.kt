package miyucomics.sokana.engine.parsers

import miyucomics.sokana.engine.atoms.Atom
import net.minecraft.server.world.ServerWorld

// Parsers sit between the stack of raw atoms and actions that want to use them. They transform stack data
// into the specific types that action handlers need.
interface StackParser<T> {
	fun parse(stack: List<Atom>, startIdx: Int, world: ServerWorld): ParseResult<T>?
}