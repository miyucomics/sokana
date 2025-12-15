package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.Vec3d

data class Vec3dAtom(val vector: Vec3d) : Atom(TYPE) {
	override fun display(): Text = Text.literal(vector.toString()).formatted(Formatting.GREEN)

	companion object {
		val CODEC: Codec<Vec3dAtom> = Vec3d.CODEC.xmap(::Vec3dAtom, Vec3dAtom::vector)
		val TYPE: AtomType<Vec3dAtom> = object : AtomType<Vec3dAtom>(CODEC) {
			override fun getParser(): StackParser<Vec3d> = AtomParser(TYPE, Vec3dAtom::vector)
		}
	}
}