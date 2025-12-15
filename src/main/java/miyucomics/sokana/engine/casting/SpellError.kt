package miyucomics.sokana.engine.casting

import net.minecraft.text.Text

abstract class SpellError : RuntimeException() {
	abstract fun createMessage(): Text
}