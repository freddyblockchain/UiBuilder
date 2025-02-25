package io.github.libgdx_ui_builder.UiElement

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import io.github.libgdx_ui_builder.Draggable
import io.github.libgdx_ui_builder.RenderManager
import io.github.libgdx_ui_builder.ScreenManager
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
sealed class UiElement(var xPos:Float = 0f, var yPos:Float = 0f, var w: Float, var h: Float): Draggable {
    val width = w * ScreenManager.widthUnit
    val height = h * ScreenManager.heightUnit
    var screenX: Float = ScreenManager.widthUnit * xPos
    var screenY: Float = ScreenManager.heightUnit * yPos
    abstract val sprite: Sprite

    @Transient
    private var dragOffsetX = 0f
    @Transient
    private var dragOffsetY = 0f

    @Transient
    override var isDragging = false

    @Transient
    var selected = false

    open fun render(batch: SpriteBatch){
        sprite.setPosition(screenX, screenY)
        sprite.setSize(width, height)
        sprite.draw(batch)

        // Draw border if selected
        if (selected) {
            batch.end() // End sprite batch before using ShapeRenderer
            val shapeRenderer = RenderManager.shapeRenderer
            shapeRenderer.projectionMatrix = batch.projectionMatrix
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
            shapeRenderer.color = Color.GREEN
            shapeRenderer.rect(screenX, screenY, width, height)
            shapeRenderer.end()

            batch.begin() // Restart batch
        }
    }

    override fun onDragStart(dragX: Float, dragY: Float) {
        selected = true
        isDragging = true
        dragOffsetX = dragX - this.screenX
        dragOffsetY = (Gdx.graphics.displayMode.height - dragY) - this.screenY
    }

    override fun onDrag(dragX: Float, dragY: Float) {
        if (isDragging && ScreenManager.checkBounds(sprite.x,sprite.y, sprite.width, sprite.height)) {
            this.screenX = dragX - dragOffsetX
            this.screenY = (Gdx.graphics.displayMode.height - dragY) - dragOffsetY

            sprite.setPosition(this.screenX * ScreenManager.maxWidth, this.screenY * ScreenManager.maxHeight)
        }
    }

    override fun onDragEnd() {
        isDragging = false
        this.screenX = ScreenManager.snapToGrid(this.screenX, ScreenManager.widthUnit.toFloat())
        this.screenY = ScreenManager.snapToGrid(this.screenY, ScreenManager.heightUnit.toFloat())

        sprite.setPosition(this.screenX, this.screenY)
    }

    fun isTouching(touchX: Float,touchY: Float): Boolean{
        val transX = touchX / ScreenManager.maxWidth
        val transY = (Gdx.graphics.displayMode.height - touchY) / ScreenManager.maxHeight

        val originalX = screenX / ScreenManager.maxWidth
        val originalY = screenY / ScreenManager.maxHeight

        val withinX = transX >= originalX && transX <= originalX + (width / ScreenManager.maxWidth)
        val withinY = transY >= originalY && transY <= originalY + (height  / ScreenManager.maxHeight)

        return isDragging || (withinX && withinY)
    }
}
