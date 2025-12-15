package miyucomics.sokana.engine.errors

import miyucomics.sokana.engine.casting.SpellError
import net.minecraft.text.Text

class NoSignaturesMatched : SpellError() {
	override fun createMessage(): Text = Text.translatable("errors.sokana.no_signatures_matched")
}