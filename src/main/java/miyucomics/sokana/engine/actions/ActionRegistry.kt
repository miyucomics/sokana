package miyucomics.sokana.engine.actions

import miyucomics.sokana.operators.OpPrint
import miyucomics.sokana.operators.math.OpAdd
import miyucomics.sokana.operators.math.OpLength
import miyucomics.sokana.operators.math.OpTwo
import miyucomics.sokana.operators.meta.OpEval

object ActionRegistry {
	val lookup = hashMapOf<String, Action>()

	fun init() {
		register("toki", OpPrint)
		register("usawi", OpEval)

		register("tu", OpTwo)
		register("sin", OpAdd)
		register("enko nanpa", OpLength)
	}

	fun register(incantation: String, action: Action) {
		lookup[incantation] = action
	}

	fun getAction(incantation: String) = lookup.get(incantation)
}