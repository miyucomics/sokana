package miyucomics.sokana.engine.errors

import miyucomics.sokana.engine.casting.SpellError
import net.minecraft.text.Text

class EntityOutOfRange : SpellError() {
	override fun createMessage(): Text = Text.translatable("errors.sokana.entity_out_of_range")
}