package io.github.libgdx_ui_builder

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
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
        uiElements.forEach {
            if(it.isDragging){
                it.onDragEnd()
            }
        }
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        if(keycode == Keys.SPACE){
            //Linear mapping
            uiElements.forEach {
                it.xPos = (it.screenX / Gdx.graphics.width) * ScreenManager.maxWidth
                it.yPos = (it.screenY / Gdx.graphics.height) * ScreenManager.maxHeight
            }
            UiFileHandler.writeScreenToFile(mainScreen)
        }
        return true
    }
}
