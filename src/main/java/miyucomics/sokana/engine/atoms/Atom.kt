package miyucomics.sokana.engine.atoms

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.casting.CastResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.SpellContinuation
import miyucomics.sokana.engine.errors.AtomCanNotBeExecuted
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text

// An atom of information on a stack, can be a string, a number, a vector, etc...
abstract class Atom(val type: AtomType<*>) {
	abstract fun display(): Text
	open fun execute(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): CastResult {
		throw AtomCanNotBeExecuted()
	}
	companion object {
		var CODEC: Codec<Atom> = AtomTypes.REGISTRY.getCodec().dispatch("type", Atom::type, AtomType<*>::mapCodec)
	}
}