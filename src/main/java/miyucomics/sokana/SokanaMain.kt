package miyucomics.sokana

import miyucomics.sokana.engine.actions.ActionRegistry
import miyucomics.sokana.engine.atoms.AtomTypes
import miyucomics.sokana.engine.continuations.ContinuationFrameTypes
import miyucomics.sokana.items.DummyItem
import net.fabricmc.api.ModInitializer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object SokanaMain : ModInitializer {
	override fun onInitialize() {
		ActionRegistry.init()
		AtomTypes.init()
		ContinuationFrameTypes.init()

		Registry.register(Registries.ITEM, id("dummy"), DummyItem())
	}

    private const val MOD_ID = "sokana"
	fun id(path: String): Identifier = Identifier.of(MOD_ID, path)
}