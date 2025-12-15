package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.util.math.Vec3d

class Vec3dAtom(val vector: Vec3d) : Atom(TYPE) {
	companion object {
		val CODEC: Codec<Vec3dAtom> = Vec3d.CODEC.xmap(::Vec3dAtom, Vec3dAtom::vector)
		val TYPE: AtomType<Vec3dAtom> = object : AtomType<Vec3dAtom>(CODEC) {
			override fun getParser(): StackParser<Vec3d> = AtomParser(TYPE, Vec3dAtom::vector)
		}
	}
}