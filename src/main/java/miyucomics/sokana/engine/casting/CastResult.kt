package miyucomics.sokana.engine.casting

import miyucomics.sokana.engine.continuations.SpellContinuation

// Holds a new image and continuation
data class CastResult(val image: SpellImage, val continuation: SpellContinuation)