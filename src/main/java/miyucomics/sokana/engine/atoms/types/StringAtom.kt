package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.actions.ActionRegistry
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.casting.AtomResult
import miyucomics.sokana.engine.casting.SpellEngine
import miyucomics.sokana.engine.continuations.SpellContinuation
import miyucomics.sokana.engine.errors.NotAnIncantation
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.util.Formatting

class StringAtom(val string: String) : Atom(TYPE) {
	override fun display(): Text = Text.literal(string).formatted(Formatting.GRAY)

	override fun execute(engine: SpellEngine, world: ServerWorld, continuation: SpellContinuation): AtomResult {
		val action = ActionRegistry.getAction(this.string) ?: throw NotAnIncantation()
		return action.execute(engine, world, continuation)
	}

	companion object {
		val CODEC: Codec<StringAtom> = Codec.STRING.xmap(::StringAtom, StringAtom::string)
		val TYPE: AtomType<StringAtom> = object : AtomType<StringAtom>(CODEC) {
			override fun getParser(): StackParser<String> = AtomParser(TYPE, StringAtom::string)
		}
	}
}