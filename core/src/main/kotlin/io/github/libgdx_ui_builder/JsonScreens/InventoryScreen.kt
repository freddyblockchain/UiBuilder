package io.github.libgdx_ui_builder.JsonScreens

import io.github.libgdx_ui_builder.FontType
import io.github.libgdx_ui_builder.Screen
import io.github.libgdx_ui_builder.UiElement.Label
import io.github.libgdx_ui_builder.UiElement.PlaceHolder
import io.github.libgdx_ui_builder.UiElement.UiElement

class InventoryScreen: Screen {
    override val name = "InventoryScreen"
    val inventoryLabel: UiElement = Label(x = 12f, y = 27.37777f, labelText = "Inventory", fontType = FontType.CHAPTERFONT)

    val inventoryBox : UiElement = PlaceHolder(buttonX = 18f, buttonY = 16f, name = "inventoryBox", width = 12f, height = 16f)

    override var uiElements = mutableListOf(inventoryLabel,inventoryBox)
}
