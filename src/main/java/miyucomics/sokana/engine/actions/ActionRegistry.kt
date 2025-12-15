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
		register("toki", OpPrint)
		register("usawi", OpEval)

		register("tu", OpConstant { 2.asActionResult() })
		register("sin", OpAdd)
		register("weka", OpSubtract)
		register("enko nanpa", OpLength)

		register("lawa ala", OpConstant { Vec3d.ZERO.asActionResult() })
		register("lawa anpa", OpConstant { Vec3d(0.0, -1.0, 0.0).asActionResult() })
		register("lawa sewi", OpConstant { Vec3d(0.0, 1.0, 0.0).asActionResult() })
		register("lawa sinpin", OpConstant { Vec3d(0.0, 0.0, -1.0).asActionResult() })
		register("lawa monsi", OpConstant { Vec3d(0.0, 0.0, 1.0).asActionResult() })
		register("lawa soto", OpConstant { Vec3d(-1.0, 0.0, 0.0).asActionResult() })
		register("lawa teje", OpConstant { Vec3d(1.0, 0.0, 0.0).asActionResult() })

		register("leko telo", OpBlockGetter { it.slipperiness.asActionResult() })
		register("leko wawa", OpBlockGetter { it.blastResistance.asActionResult() })
		register("leko kiwen", OpBlockGetter { it.hardness.asActionResult() })
	}

	fun register(incantation: String, action: Action) {
		lookup[incantation] = action
	}

	fun getAction(incantation: String) = lookup.get(incantation)
}