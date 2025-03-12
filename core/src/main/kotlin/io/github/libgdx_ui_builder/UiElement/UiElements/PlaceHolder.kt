package io.github.libgdx_ui_builder.UiElement

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.libgdx_ui_builder.FontManager
import io.github.libgdx_ui_builder.UiElement.UiElement
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class PlaceHolder(var buttonX: Float, var buttonY: Float, var name: String, var width: Float = 23f, var height: Float = 27f) : UiElement(xPos = buttonX, yPos = buttonY, w = width, h = height) {

    @Transient // Exclude the 'sprite' field from serialization
    override val sprite: Sprite = Sprite(Texture("white-box.png"))

    override fun render(batch: SpriteBatch) {
        super.render(batch)
    }

}
