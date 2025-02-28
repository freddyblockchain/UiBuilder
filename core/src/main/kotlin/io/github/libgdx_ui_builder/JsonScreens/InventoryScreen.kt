package io.github.libgdx_ui_builder.JsonScreens

import io.github.libgdx_ui_builder.FontType
import io.github.libgdx_ui_builder.Screen
import io.github.libgdx_ui_builder.UiElement.Label
import io.github.libgdx_ui_builder.UiElement.UiElement

class InventoryScreen: Screen {
    override val name = "InventoryScreen"
    val inventoryLabel: UiElement = Label(x = 18f, y = 4f, labelText = "Inventory", fontType = FontType.CHAPTERFONT)

    override val uiElements = mutableListOf(inventoryLabel)
}
