package io.github.libgdx_ui_builder.GameScreens

import com.badlogic.gdx.math.Vector2
import io.github.libgdx_ui_builder.JsonScreens.AbilityScreen
import io.github.libgdx_ui_builder.ScreenManager
import io.github.libgdx_ui_builder.UiElement.NavButton
import io.github.libgdx_ui_builder.UiElement.PlaceHolder
import io.github.libgdx_ui_builder.UiElement.UiElement
import io.github.libgdx_ui_builder.UiFileHandler

class PauseScreen: GameScreen {
    override var uiElements: MutableList<UiElement> = mutableListOf()
    override val widthUnit = ScreenManager.widthUnit.toFloat()
    override val heightUnit = ScreenManager.heightUnit.toFloat()

    var statusElements: MutableList<UiElement> = mutableListOf()
    var inventoryElements: MutableList<UiElement> = mutableListOf()
    var animeliaElements: MutableList<UiElement> = mutableListOf()

    var currentElements: MutableList<UiElement> = mutableListOf()

    fun initSubScreen(name: String): MutableList<UiElement>{
        val placeHolder = uiElements.find { it is PlaceHolder }

        val startPos = Vector2(placeHolder!!.screenX, placeHolder!!.screenY)
        val placeholderWidthUnit = placeHolder.screenWidth / ScreenManager.maxWidth
        val placeholderHeightUnit = placeHolder.screenHeight / ScreenManager.maxHeight

        val screenObjects = UiFileHandler.getScreenFromFile(name)

        screenObjects.forEach {
            it.calculatePosition(placeholderWidthUnit,placeholderHeightUnit,startPos)
        }
        return screenObjects
    }

    override fun loadScreens() {
        uiElements = UiFileHandler.getScreenFromFile("PauseMainScreen")
        uiElements.forEach {
            it.calculatePosition(ScreenManager.widthUnit.toFloat(), ScreenManager.heightUnit.toFloat(), Vector2(0f,0f))
        }
        inventoryElements = initSubScreen(name = "InventoryScreen")
        animeliaElements = initSubScreen(name = "AnimeliaScreen")

        currentElements = statusElements

        val inventoryButton = uiElements.find { it is NavButton && it.text == "Inventory" } as NavButton
        val animeliaButton = uiElements.find { it is NavButton && it.text == "Animelia" } as NavButton

        inventoryButton.onPressAction = {
            uiElements.removeAll(currentElements)
            currentElements = inventoryElements
            uiElements.addAll(currentElements)
        }

        animeliaButton.onPressAction = {
            uiElements.removeAll(currentElements)
            currentElements = animeliaElements
            uiElements.addAll(currentElements)
        }
        uiElements.addAll(currentElements)
    }
}
