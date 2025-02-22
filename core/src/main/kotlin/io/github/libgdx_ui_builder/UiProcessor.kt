package io.github.libgdx_ui_builder

import io.github.libgdx_ui_builder.UiElement.UiElement
import com.badlogic.gdx.InputAdapter

class UiProcessor() : InputAdapter() {
    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val elem = uiElements.firstOrNull { it.isTouching(screenX.toFloat(),screenY.toFloat()) }
        elem?.onDragStart(screenX.toFloat(), screenY.toFloat())

        uiElements.forEach { if(it != elem){it.selected = false} }
        return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        val elemsTouched = uiElements.filter { it.isTouching(screenX.toFloat(),screenY.toFloat()) }

        val elems = elemsTouched.filter { it.selected }
        val elem = if(elems.isNotEmpty()) elems.first() else elemsTouched.firstOrNull()
        elem?.onDrag(screenX.toFloat(), screenY.toFloat())
        return true
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        uiElements.forEach { it.onDragEnd() }
        return true
    }
}
