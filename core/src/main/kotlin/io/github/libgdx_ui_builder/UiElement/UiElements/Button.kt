package io.github.libgdx_ui_builder.UiElement

import io.github.libgdx_ui_builder.UiElement.UiElement
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class Button(var buttonX: Float, var buttonY: Float) : UiElement(xPos = buttonX, yPos = buttonY, w = 6f, h = 3f) {

    @Transient // Exclude the 'sprite' field from serialization
    override val sprite: Sprite = Sprite(Texture("white-box.png"))
}
