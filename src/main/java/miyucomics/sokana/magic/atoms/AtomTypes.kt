package miyucomics.sokana.magic.atoms

import com.mojang.serialization.Lifecycle
import miyucomics.sokana.SokanaMain
import miyucomics.sokana.magic.atoms.types.DoubleAtom
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.SimpleRegistry

object AtomTypes {
	val REGISTRY: Registry<AtomType<*>> = SimpleRegistry(RegistryKey.ofRegistry(SokanaMain.id("atom_types")), Lifecycle.stable());

	fun init() {
		register("double", DoubleAtom.TYPE)
	}

	private fun <T : Atom> register(namespace: String, type: AtomType<T>): AtomType<T> {
		return Registry.register(REGISTRY, SokanaMain.id(namespace), type)
	}
}