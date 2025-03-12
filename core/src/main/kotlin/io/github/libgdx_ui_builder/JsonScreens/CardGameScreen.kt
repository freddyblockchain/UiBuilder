package io.github.libgdx_ui_builder.JsonScreens

import io.github.libgdx_ui_builder.Screen
import io.github.libgdx_ui_builder.UiElement.PlaceHolder
import io.github.libgdx_ui_builder.UiElement.UiElement

class CardGameScreen: Screen {
    override val name = "CardGameScreen"

    val ownAnimelia = PlaceHolder(buttonX = 15.5f, buttonY = 13f, name = "ownAnimelia", width = 2f, height = 2f)
    val enemyAnimelia  = PlaceHolder(buttonX = 15.5f, buttonY = 25f, name = "enemyAnimelia", width = 2f, height = 2f)
    val ownBench = PlaceHolder(buttonX = 14.5f, buttonY = 10f, name = "ownBench", width = 4f, height = 1f)
    val enemyBench = PlaceHolder(buttonX = 14.5f, buttonY = 29f, name = "enemyBench", width = 4f, height = 1f)

    val deck = PlaceHolder(buttonX = 28f, buttonY = 3f, name = "deck", width = 2f, height = 3f)
    val enemyDeck = PlaceHolder(buttonX = 28f, buttonY = 28f, name = "enemyDeck", width = 2f, height = 3f)
    val enemyHand = PlaceHolder(buttonX = 6f, buttonY = 28f, name = "enemyHand", width = 3f, height = 2f)
    val myHand = PlaceHolder(buttonX = 8f, buttonY = 0f, name = "myHand", width = 16f, height = 8f)

    override val uiElements = mutableListOf<UiElement>(ownAnimelia, enemyAnimelia, ownBench, enemyBench, deck, enemyDeck, enemyHand, myHand)

}
