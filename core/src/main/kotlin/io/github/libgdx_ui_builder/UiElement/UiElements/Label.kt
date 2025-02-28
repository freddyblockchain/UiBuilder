
package io.github.libgdx_ui_builder.UiElement

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.libgdx_ui_builder.FontManager
import io.github.libgdx_ui_builder.FontType
import io.github.libgdx_ui_builder.ScreenManager
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class Label(val width: Float = 4f, val height: Float = 2f, val x:Float, val y: Float, var labelText: String, val fontType: FontType = FontType.SMALLFONT): UiElement(w = width, h = height, xPos = x, yPos = y) {
    @Transient
    var labelValue: String = ""
    @Transient
    override var sprite: Sprite = Sprite(Texture("white-box.png"))

    @Transient
    override var renderSprite = false

    override fun render(batch: SpriteBatch) {
        super.render(batch)
        val font = FontManager.getFont(fontType)
        font.draw(batch, labelText, screenX, screenY + screenHeight/2)
    }
}
