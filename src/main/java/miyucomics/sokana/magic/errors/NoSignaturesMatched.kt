package miyucomics.sokana.magic.errors

import miyucomics.sokana.magic.casting.SpellError
import net.minecraft.text.Text

class NoSignaturesMatched : SpellError() {
	override fun createMessage(): Text = Text.translatable("errors.sokana.no_signatures_matched")
}