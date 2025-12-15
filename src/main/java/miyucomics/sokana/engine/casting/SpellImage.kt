package miyucomics.sokana.engine.casting

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import miyucomics.sokana.engine.atoms.Atom

// A frozen snapshot of the current state of casting, independent of things like mana or incantations to run
// Ideally, this should contain *everything* that distinguishes one state of a spell from another
// A spell can be paused, its image serialized; and then later unserialized to contain everything the spell was at time of pausing
// Useful construct for say, passing around ownership of a spell since the image is decoupled from caster or environment
// Or having a spell stop casting after a given number of incantations are executed as to not strain the server, and resuming it next tick
data class SpellImage(val stack: List<Atom>, val stash: List<Atom>) {
	companion object {
		val CODEC: Codec<SpellImage> = RecordCodecBuilder.create { it.group(
			Atom.CODEC.listOf().fieldOf("stack").forGetter(SpellImage::stack),
			Atom.CODEC.listOf().fieldOf("stash").forGetter(SpellImage::stash),
		).apply(it, ::SpellImage) }
	}
}