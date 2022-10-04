package com.lumintorious.tfcstorage.food

import com.lumintorious.tfcstorage.registry.Initializable
import net.dries007.tfc.api.capability.food.{CapabilityFood, FoodTrait}
import net.minecraft.item.ItemStack

object StoredTrait extends Enumeration with Initializable {
  val COOL = new StoredTrait("cool", 0.50f)
  val SHELVED = new StoredTrait("shelved", 0.80f)
  val HUNG = new StoredTrait("hung", 0.60f)
  val JAR = new StoredTrait("jar", 0.09f)
  val SHELTERED = new StoredTrait("sheltered", 0.40f)
}

class StoredTrait(name: String, modifier: Float)
    extends FoodTrait(name, modifier) {
  FoodTrait.getTraits().put(name, this)
  def >>(stack: ItemStack) = CapabilityFood.applyTrait(stack, this)
  def <<(stack: ItemStack) = CapabilityFood.removeTrait(stack, this)
}
