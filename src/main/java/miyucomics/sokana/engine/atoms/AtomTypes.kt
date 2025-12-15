package miyucomics.sokana.engine.atoms

import com.mojang.serialization.Lifecycle
import miyucomics.sokana.SokanaMain
import miyucomics.sokana.engine.atoms.types.*
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.SimpleRegistry

object AtomTypes {
	val REGISTRY: Registry<AtomType<*>> = SimpleRegistry(RegistryKey.ofRegistry(SokanaMain.id("atom_types")), Lifecycle.stable())

	fun init() {
		register("mu", MuType)
		register("double", DoubleAtom.TYPE)
		register("identifier", IdentifierAtom.TYPE)
		register("string", StringAtom.TYPE)
		register("vec3d", Vec3dAtom.TYPE)
	}

	private fun <T : Atom> register(namespace: String, type: AtomType<T>): AtomType<T> {
		return Registry.register(REGISTRY, SokanaMain.id(namespace), type)
	}
}