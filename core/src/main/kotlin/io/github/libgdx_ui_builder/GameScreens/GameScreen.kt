package io.github.libgdx_ui_builder.GameScreens

import io.github.libgdx_ui_builder.UiElement.UiElement

interface GameScreen {
    var uiElements: MutableList<UiElement>
    val widthUnit: Float
    val heightUnit: Float
    fun loadScreens()
}
