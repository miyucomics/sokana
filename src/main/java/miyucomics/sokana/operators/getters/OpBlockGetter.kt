package miyucomics.sokana.operators.getters

import miyucomics.sokana.engine.actions.Signature
import miyucomics.sokana.engine.actions.arg
import miyucomics.sokana.engine.actions.impls.SignedAction
import miyucomics.sokana.engine.atoms.Atom
import miyucomics.sokana.engine.atoms.types.Vec3dAtom
import miyucomics.sokana.engine.parsers.impls.RegistryParser
import net.minecraft.block.Block
import net.minecraft.registry.Registries
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d

class OpBlockGetter(val getter: (Block) -> List<Atom>) : SignedAction() {
	init {
		addSignature(Signature(RegistryParser(Registries.BLOCK))) { _, list -> getter(list.arg<Block>(0)) }
		addSignature(Signature(Vec3dAtom.TYPE.getParser())) { engine, list ->
			val targetPos = list.arg<Vec3d>(0)
			engine.env.assertVectorInRange(targetPos)
			getter(engine.env.world.getBlockState(BlockPos.ofFloored(targetPos)).block)
		}
	}
}