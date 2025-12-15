package miyucomics.sokana.engine.errors

import miyucomics.sokana.engine.casting.SpellError
import net.minecraft.text.Text

class NotAnIncantation : SpellError() {
	override fun createMessage(): Text = Text.translatable("errors.sokana.not_incantation")
}