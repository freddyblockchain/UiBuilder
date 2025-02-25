package io.github.libgdx_ui_builder.UiElement

import io.github.libgdx_ui_builder.UiElement.UiElement
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.libgdx_ui_builder.FontManager
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class NavButton(var buttonX: Float, var buttonY: Float, var text: String) : UiElement(xPos = buttonX, yPos = buttonY, w = 7f, h = 3f) {

    @Transient // Exclude the 'sprite' field from serialization
    override val sprite: Sprite = Sprite(Texture("black-box.png"))

    override fun render(batch: SpriteBatch) {
        super.render(batch)
        FontManager.SmallFont.draw(batch,text,this.screenX + this.width / 4,  this.screenY + (this.height / 1.5f))
    }

}

