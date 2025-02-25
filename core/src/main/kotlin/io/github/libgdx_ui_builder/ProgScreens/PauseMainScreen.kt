package io.github.libgdx_ui_builder.ProgScreens

import io.github.libgdx_ui_builder.Screen
import io.github.libgdx_ui_builder.UiElement.NavButton
import io.github.libgdx_ui_builder.UiElement.PlaceHolder

class PauseMainScreen: Screen {
    override val name = "PauseMainScreen"
    val navButton = NavButton(buttonX = 5f, buttonY = 29f, text = "Status")
    val navButton2 = NavButton(buttonX = 12f, buttonY = 29f, text = "Abilities")
    val navButton3 = NavButton(buttonX = 19f, buttonY = 29f, text = "Inventory")
    val placeHolder = PlaceHolder(buttonX = 4f, buttonY = 2f, name = "tablePlaceHolder")

    override val uiElements = mutableListOf(navButton,navButton2,navButton3,placeHolder)
}
