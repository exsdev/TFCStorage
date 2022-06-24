package com.lumintorious.tfcstorage.compat.waila

import mcjty.theoneprobe.api.ITheOneProbe
import net.dries007.tfc.compat.waila.interfaces.TOPBlockInterface

class TOPPlugin extends java.util.function.Function[ITheOneProbe, Void]
{
  override def apply(probe: ITheOneProbe): Void =
    {
      val TOP_BLOCK_INTERFACES = List(
        new TOPBlockInterface(GrainPileProvider),
        new TOPBlockInterface(HangerProvider),
        new TOPBlockInterface(ShelfProvider),
        new TOPBlockInterface(JarProvider)
      )
      for (blockInterface <- TOP_BLOCK_INTERFACES) {
        probe.registerProvider(blockInterface)
        if (blockInterface.overridesHeadInfo) probe.registerBlockDisplayOverride(blockInterface)
      }
      null
    }
}
