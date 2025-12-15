package miyucomics.sokana.utils

import miyucomics.sokana.engine.atoms.types.DoubleAtom
import miyucomics.sokana.engine.atoms.types.IdentifierAtom
import miyucomics.sokana.engine.atoms.types.StringAtom
import miyucomics.sokana.engine.atoms.types.Vec3dAtom
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.SequenceParser
import net.minecraft.util.Identifier
import net.minecraft.util.math.Vec3d

fun Double.asActionResult() = listOf(DoubleAtom(this))
fun Identifier.asActionResult() = listOf(IdentifierAtom(this))
fun Int.asActionResult() = listOf(DoubleAtom(this.toDouble()))
fun String.asActionResult() = listOf(StringAtom(this))
fun Vec3d.asActionResult() = listOf(Vec3dAtom(this))

fun <T> StackParser<T>.listOf(): StackParser<List<T>> = SequenceParser(this)