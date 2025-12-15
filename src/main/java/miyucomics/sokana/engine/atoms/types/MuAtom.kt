package miyucomics.sokana.engine.atoms.types

import com.mojang.serialization.Codec
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.AtomType
import miyucomics.sokana.engine.parsers.StackParser
import miyucomics.sokana.engine.parsers.impls.AtomParser
import net.minecraft.text.Text
import net.minecraft.util.Formatting

// An instance of a singleton atom. All mus are the same.
val MuType: AtomType<MuAtom> = object : AtomType<MuAtom>(Codec.lazyInitialized { Codec.unit(MuAtom) }) {
	override fun getParser(): StackParser<MuAtom> = AtomParser(MuType) { it }
}
object MuAtom : Atom(MuType) {
	override fun display(): Text = Text.literal("get stickbugged lmao").formatted(Formatting.OBFUSCATED)
}