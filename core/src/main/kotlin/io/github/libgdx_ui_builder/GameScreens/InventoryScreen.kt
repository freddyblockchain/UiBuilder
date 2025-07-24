package io.github.libgdx_ui_builder.GameScreens

import com.badlogic.gdx.math.Vector2
import io.github.libgdx_ui_builder.ScreenManager
import io.github.libgdx_ui_builder.UiElement.UiElement
import io.github.libgdx_ui_builder.UiFileHandler
import kotlin.collections.forEach

class InventoryScreen: GameScreen {
    override var uiElements: MutableList<UiElement> = mutableListOf()
    override val widthUnit = ScreenManager.widthUnit.toFloat()
    override val heightUnit = ScreenManager.heightUnit.toFloat()

    override fun loadScreens() {
        uiElements = UiFileHandler.getScreenFromFile("InventoryScreen")
        uiElements.forEach {
            it.calculatePosition(ScreenManager.widthUnit.toFloat(), ScreenManager.heightUnit.toFloat(), Vector2(0f,0f))
        }
    }
}
