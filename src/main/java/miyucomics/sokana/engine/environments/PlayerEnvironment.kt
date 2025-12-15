package miyucomics.sokana.engine.environments

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.util.math.Vec3d

class PlayerEnvironment(override val world: ServerWorld, override val caster: PlayerEntity) : SpellEnvironment() {
	override fun isVectorInRange(vector: Vec3d): Boolean {
		return caster.pos.distanceTo(vector) <= 32.0
	}

	override fun extractMana(amount: Int): Boolean {
//		val available = getManaFromPlayer(caster)
//		if (available < amount) return false
//		consumeManaFromPlayer(caster, amount)
		return true
	}

	override fun getAvailableStacks(): List<ItemStack> {
		return caster.inventory.main.filter { !it.isEmpty }
	}

	override fun sendMessage(text: Text) {
		caster.sendMessage(text)
	}
}