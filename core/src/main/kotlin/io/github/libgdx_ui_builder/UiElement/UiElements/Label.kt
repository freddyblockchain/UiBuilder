
package io.github.libgdx_ui_builder.UiElement

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class Label(val width: Float = 4f, val height: Float = 2f, val x:Float, val y: Float, var labelText: String): UiElement(w = width, h = height, xPos = x, yPos = y) {
    @Transient
    var labelValue: String = ""
    @Transient
    override var sprite: Sprite = Sprite(Texture("white-box.png"))
}
