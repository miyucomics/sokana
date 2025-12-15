package miyucomics.sokana.engine.errors

import miyucomics.sokana.engine.casting.SpellError
import net.minecraft.text.Text

class VectorOutOfRange : SpellError() {
	override fun createMessage(): Text = Text.translatable("errors.sokana.vector_out_of_range")
}