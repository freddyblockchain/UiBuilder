package io.github.libgdx_ui_builder.TestScreen

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.InputAdapter
import io.github.libgdx_ui_builder.UiElement.UiElement
import io.github.libgdx_ui_builder.UiFileHandler
import io.github.libgdx_ui_builder.mainScreen

class TestProcessor(val uiElements: MutableList<UiElement>) : InputAdapter() {
    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val elem = uiElements.firstOrNull { it.isTouching(screenX.toFloat(),screenY.toFloat()) }
        uiElements.forEach { it.selected = it == elem }
        return true
    }

}
