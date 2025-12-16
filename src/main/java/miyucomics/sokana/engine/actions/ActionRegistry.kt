package miyucomics.sokana.engine.actions

import miyucomics.sokana.operators.OpConstant
import miyucomics.sokana.operators.OpPrint
import miyucomics.sokana.operators.getters.OpBlockGetter
import miyucomics.sokana.operators.math.OpAdd
import miyucomics.sokana.operators.math.OpLength
import miyucomics.sokana.operators.math.OpSubtract
import miyucomics.sokana.operators.meta.OpEval
import miyucomics.sokana.utils.asActionResult
import net.minecraft.util.math.Vec3d

object ActionRegistry {
	val lookup = hashMapOf<String, Action>()

	fun init() {
		"toki" += OpPrint
		"usawi" += OpEval

		"wan" += constant(1.0)
		"tu" += constant(2.0)
		"sin" += OpAdd
		"weka" += OpSubtract
		"enko nanpa" += OpLength

		"lawa ala" += constant(Vec3d.ZERO)
		"lawa anpa" += constant(Vec3d(0.0, -1.0, 0.0))
		"lawa sewi" += constant(Vec3d(0.0, 1.0, 0.0))
		"lawa sinpin" += constant(Vec3d(0.0, 0.0, -1.0))
		"lawa monsi" += constant(Vec3d(0.0, 0.0, 1.0))
		"lawa soto" += constant(Vec3d(-1.0, 0.0, 0.0))
		"lawa teje" += constant(Vec3d(1.0, 0.0, 0.0))

		"leko telo" += OpBlockGetter { it.slipperiness.asActionResult() }
		"leko wawa" += OpBlockGetter { it.blastResistance.asActionResult() }
		"leko kiwen" += OpBlockGetter { it.hardness.asActionResult() }
	}

	private operator fun String.plusAssign(action: Action) {
		lookup[this] = action
	}

	private fun constant(value: Double) = OpConstant { value.asActionResult() }
	private fun constant(vector: Vec3d) = OpConstant { vector.asActionResult() }

	fun getAction(incantation: String) = lookup.get(incantation)
}