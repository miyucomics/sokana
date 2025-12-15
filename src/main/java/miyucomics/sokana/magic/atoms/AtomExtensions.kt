package miyucomics.sokana.magic.atoms

import miyucomics.sokana.magic.atoms.types.DoubleAtom
import miyucomics.sokana.magic.atoms.types.StringAtom
import miyucomics.sokana.magic.atoms.types.Vec3dAtom
import net.minecraft.util.math.Vec3d

fun Double.asActionResult() = listOf(DoubleAtom(this))
fun String.asActionResult() = listOf(StringAtom(this))
fun Vec3d.asActionResult() = listOf(Vec3dAtom(this))