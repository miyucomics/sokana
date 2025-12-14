package miyucomics.sokana

import miyucomics.sokana.magic.atoms.AtomTypes
import miyucomics.sokana.magic.continuations.ContinuationFrameTypes
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier

object SokanaMain : ModInitializer {
    private const val MOD_ID = "sokana"
	fun id(path: String): Identifier = Identifier.of(MOD_ID, path)

	override fun onInitialize() {
		AtomTypes.init()
		ContinuationFrameTypes.init()
	}
}