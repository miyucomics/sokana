package miyucomics.sokana.magic.continuations

import com.mojang.serialization.Lifecycle
import miyucomics.sokana.SokanaMain
import miyucomics.sokana.magic.continuations.types.EvalFrame
import miyucomics.sokana.magic.continuations.types.HaltFrame
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.SimpleRegistry

object ContinuationFrameTypes {
	val REGISTRY: Registry<ContinuationFrameType<*>> = SimpleRegistry(RegistryKey.ofRegistry(SokanaMain.id("continuation_frame_types")), Lifecycle.stable());

	fun init() {
		register("barrier", HaltFrame.TYPE)
		register("eval", EvalFrame.TYPE)
	}

	private fun <T : ContinuationFrame> register(namespace: String, type: ContinuationFrameType<T>): ContinuationFrameType<T> {
		return Registry.register(REGISTRY, SokanaMain.id(namespace), type)
	}
}