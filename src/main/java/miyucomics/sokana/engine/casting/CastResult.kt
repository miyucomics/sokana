package miyucomics.sokana.engine.casting

import miyucomics.sokana.engine.continuations.SpellContinuation

// The effects from a continuation frame tick
data class CastResult(val image: SpellImage, val continuation: SpellContinuation)