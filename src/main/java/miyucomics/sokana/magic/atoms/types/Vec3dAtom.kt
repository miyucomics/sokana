package miyucomics.sokana.magic.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.magic.atoms.Atom
import miyucomics.sokana.magic.atoms.AtomType
import net.minecraft.util.math.Vec3d

class Vec3dAtom(val vector: Vec3d) : Atom(TYPE) {
	companion object {
		val CODEC: Codec<Vec3dAtom> = Vec3d.CODEC.xmap(::Vec3dAtom, Vec3dAtom::vector)
		val TYPE: AtomType<Vec3dAtom> = object : AtomType<Vec3dAtom>(CODEC) {}
	}
}