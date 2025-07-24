package io.github.libgdx_ui_builder.JsonScreens

import io.github.libgdx_ui_builder.FontType
import io.github.libgdx_ui_builder.Screen
import io.github.libgdx_ui_builder.UiElement.Label
import io.github.libgdx_ui_builder.UiElement.PlaceHolder
import io.github.libgdx_ui_builder.UiElement.UiElement

class MyDeckScreen: Screen {
    override val name = "MyDeckScreen"
    val myDeckLabel: UiElement = Label(x = 6f, y = 30f, labelText = "MyDeck", fontType = FontType.MEDIUMFONT)
    val myCardsLabel: UiElement = Label(x = 23f, y = 30f, labelText = "MyCards", fontType = FontType.MEDIUMFONT)

    val myCardsBox : UiElement = PlaceHolder(buttonX = 2f, buttonY = 4f, name = "myCardsBox", width = 12f, height = 24f)

    val allCardsBox : UiElement = PlaceHolder(buttonX = 19f, buttonY = 4f, name = "allCardsBox", width = 12f, height = 24f)

    val paginationBox : UiElement = PlaceHolder(buttonX = 19f, buttonY = 2f, name = "paginationBox", width = 6f, height = 2f)

    override var uiElements = mutableListOf(myDeckLabel, myCardsLabel, myCardsBox, allCardsBox, paginationBox)
}
