package io.github.libgdx_ui_builder

import io.github.libgdx_ui_builder.UiElement.UiElement
import io.github.libgdx_ui_builder.UiElement.UiElements.Button
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.libgdx_ui_builder.UiElement.UiElements.NavButton
import io.github.libgdx_ui_builder.UiElement.UiElements.PlaceHolder


/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
lateinit var uiElements: MutableList<UiElement>
class Main : ApplicationAdapter(){
    lateinit var texture: Texture
    lateinit var sprite: Sprite
    lateinit var spriteBatch: SpriteBatch
    override fun create() {
        spriteBatch = SpriteBatch()
        texture =  Texture(Gdx.files.internal("Screenshot.png"))
        sprite = Sprite(texture)

        Gdx.input.inputProcessor = UiProcessor()
        val navButton = NavButton(buttonX = 5f, buttonY = 29f, text = "Status")
        val navButton2 = NavButton(buttonX = 12f, buttonY = 29f, text = "Abilities")
        val navButton3 = NavButton(buttonX = 19f, buttonY = 29f, text = "Inventory")
        val placeHolder = PlaceHolder(buttonX = 4f, buttonY = 2f, name = "tablePlaceHolder")

        uiElements = mutableListOf(navButton, navButton2, navButton3, placeHolder)
        FontManager.initFonts()
    }
    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
        spriteBatch.begin()
        uiElements.forEach {
            it.render(spriteBatch)
        }
        spriteBatch.end()
    }
}
