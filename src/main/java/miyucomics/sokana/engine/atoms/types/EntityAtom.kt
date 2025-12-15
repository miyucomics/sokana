package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.entity.Entity
import net.minecraft.text.Text
import net.minecraft.util.Uuids
import java.util.*

data class EntityAtom(val uuid: UUID) : Atom(TYPE) {
	override fun display(): Text = Text.literal("temporary name")

	companion object {
		val CODEC: Codec<EntityAtom> = Uuids.CODEC.xmap(::EntityAtom, EntityAtom::uuid)
		val TYPE: AtomType<EntityAtom> = object : AtomType<EntityAtom>(CODEC) {
			// special parser that resolves it into an entity in the world
			override fun getParser(): StackParser<Entity> = AtomParser(TYPE) { atom, world -> world.getEntity(atom.uuid) }
		}
	}
}