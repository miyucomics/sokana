package miyucomics.sokana.magic.casting

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import miyucomics.sokana.magic.atoms.Atom
import miyucomics.sokana.magic.continuations.ContinuationStack

// A frozen snapshot of the current state of casting, independent of things like mana or incantation limits
// A spell can be paused, its image serialized; and then later unserialized and executed, hopefully seamlessly
// Useful construct for say, passing around ownership of a spell since the image is decoupled from caster or environment
// Or having a spell stop casting after a given number of incantations are executed as to not strain the server, and resuming it next tick
data class SpellImage(val minorStack: List<Atom>, val majorStack: List<Atom>, val continuationStack: ContinuationStack) {
	companion object {
		val CODEC: Codec<SpellImage> = RecordCodecBuilder.create { it.group(
			Atom.CODEC.listOf().fieldOf("minor_stack").forGetter(SpellImage::minorStack),
			Atom.CODEC.listOf().fieldOf("major_stack").forGetter(SpellImage::majorStack),
			ContinuationStack.CODEC.fieldOf("continuation_stack").forGetter(SpellImage::continuationStack)
		).apply(it, ::SpellImage) }
	}
}