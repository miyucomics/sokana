package miyucomics.sokana.engine.errors

import miyucomics.sokana.engine.casting.SpellError
import net.minecraft.text.Text

class AtomCanNotBeExecuted : SpellError() {
	override fun createMessage(): Text = Text.translatable("errors.sokana.atom_can_not_execute")
}