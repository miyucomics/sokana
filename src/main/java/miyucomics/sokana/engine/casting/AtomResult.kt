package miyucomics.sokana.engine.casting

import miyucomics.sokana.engine.continuations.SpellContinuation

// The effects from an atom being executed
data class AtomResult(val image: SpellImage, val continuation: SpellContinuation)