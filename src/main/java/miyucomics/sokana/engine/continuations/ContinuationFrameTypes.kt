package miyucomics.sokana.engine.continuations

import com.mojang.serialization.Lifecycle
import miyucomics.sokana.SokanaMain
import miyucomics.sokana.engine.continuations.types.EvalFrame
import miyucomics.sokana.engine.continuations.types.FinishEvalFrameType
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.SimpleRegistry

object ContinuationFrameTypes {
	val REGISTRY: Registry<ContinuationFrameType<*>> = SimpleRegistry(RegistryKey.ofRegistry(SokanaMain.id("continuation_frame_types")), Lifecycle.stable())

	fun init() {
		register("eval", EvalFrame.TYPE)
		register("finish_eval", FinishEvalFrameType)
	}

	private fun <T : ContinuationFrame> register(namespace: String, type: ContinuationFrameType<T>): ContinuationFrameType<T> {
		return Registry.register(REGISTRY, SokanaMain.id(namespace), type)
	}
}