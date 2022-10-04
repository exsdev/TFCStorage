package com.lumintorious.tfcstorage.registry

import com.lumintorious.tfcstorage.food.StoredTrait
import com.lumintorious.tfcstorage.tile._

trait Initializable {
  def initialize(): Unit = {}
}

object Initializable extends Initializable {
  StoredTrait.initialize()
  TileShelf.initialize()
  TileJar.initialize()
  TileHanger.initialize()
  TileGrainPile.initialize()
}
