package io.github.libgdx_ui_builder

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.input.GestureDetector

class ScreenManager {
    companion object{
        var maxWidth = 32
        var maxHeight = 32
        val widthUnit = Gdx.graphics.displayMode.width / this.maxWidth
        val heightUnit = Gdx.graphics.displayMode.height / this.maxWidth

        fun snapToGrid(value: Float, unitSize: Float): Float {
            return Math.round(value / unitSize) * unitSize
        }

        fun checkBounds(x: Float, y:Float, width: Float, height: Float): Boolean{
            return x >= 0 && x <= Gdx.graphics.displayMode.width - width&& y >= 0 && y <= Gdx.graphics.displayMode.height - height
        }
    }
}
