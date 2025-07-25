package io.github.libgdx_ui_builder.TestScreen


import com.badlogic.gdx.InputAdapter
import io.github.libgdx_ui_builder.UiElement.UiElement

class TestProcessor(val uiElements: MutableList<UiElement>) : InputAdapter() {
    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val elem = uiElements.firstOrNull { it.isTouching(screenX.toFloat(),screenY.toFloat()) }
        uiElements.forEach { it.selected = it == elem }
        elem?.onPress()
        return true
    }

}
