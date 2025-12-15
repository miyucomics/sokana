package miyucomics.sokana.engine.environments

import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.util.math.Vec3d

// Handles the physicality of it, pinning it to a thing in the world
// It could be a player casting it, a creeper, or even no entity at all, like in the case of
// say a block that speaks incantations or a spell that just is, and is unbound to any particular
// entity
abstract class SpellEnvironment {
	abstract val world: ServerWorld
	abstract val caster: Entity?

	// defines whether something is in range for a spell
	abstract fun isVectorInRange(vector: Vec3d): Boolean
	open fun isEntityInRange(entity: Entity): Boolean = isVectorInRange(entity.eyePos)

	// attempts to extract that amount of mana, returns whether it has succeeded or not
	abstract fun extractMana(amount: Int): Boolean

	// gets the "inventory" of the caster, used for spells that take things from inventories
	abstract fun getAvailableStacks(): List<ItemStack>

	abstract fun sendMessage(text: Text)
}