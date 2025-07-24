package io.github.libgdx_ui_builder.JsonScreens

import io.github.libgdx_ui_builder.FontType
import io.github.libgdx_ui_builder.Screen
import io.github.libgdx_ui_builder.UiElement.Label
import io.github.libgdx_ui_builder.UiElement.UiElement

class AbilityScreen: Screen {
    override val name = "AbilityScreen"
    val abilityLabel: UiElement = Label(x = 18f, y = 2f, labelText = "Abilities", fontType = FontType.CHAPTERFONT)

    override var uiElements = mutableListOf(abilityLabel)
}
