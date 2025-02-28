package io.github.libgdx_ui_builder

import io.github.libgdx_ui_builder.UiElement.UiElement
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.libgdx_ui_builder.JsonScreens.AbilityScreen


/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
lateinit var uiElements: MutableList<UiElement>
lateinit var mainScreen: Screen
class Main : ApplicationAdapter(){
    lateinit var texture: Texture
    lateinit var sprite: Sprite
    lateinit var spriteBatch: SpriteBatch
    override fun create() {
        spriteBatch = SpriteBatch()
        texture =  Texture(Gdx.files.internal("Screenshot.png"))
        sprite = Sprite(texture)

        Gdx.input.inputProcessor = UiProcessor()
        mainScreen = AbilityScreen()
        uiElements = mainScreen.uiElements

        FontManager.initFonts()
    }
    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
        spriteBatch.begin()
        mainScreen.uiElements.forEach {
            it.render(spriteBatch)
        }
        spriteBatch.end()
    }
}
