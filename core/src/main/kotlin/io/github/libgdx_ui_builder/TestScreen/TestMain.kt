package io.github.libgdx_ui_builder.TestScreen

import io.github.libgdx_ui_builder.UiElement.UiElement

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector
import com.badlogic.gdx.math.Vector2
import io.github.libgdx_ui_builder.FontManager
import io.github.libgdx_ui_builder.ScreenManager
import io.github.libgdx_ui_builder.UiElement.PlaceHolder
import io.github.libgdx_ui_builder.UiFileHandler


/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class TestMain : ApplicationAdapter(){
    lateinit var texture: Texture
    lateinit var sprite: Sprite
    lateinit var spriteBatch: SpriteBatch
    lateinit var uiElements: MutableList<UiElement>
    override fun create() {
        spriteBatch = SpriteBatch()
        texture =  Texture(Gdx.files.internal("Screenshot.png"))
        sprite = Sprite(texture)

        uiElements = UiFileHandler.getScreenFromFile("PauseMainScreen")
        val placeHolder = uiElements.find { it is PlaceHolder }

        val startPos = Vector2(placeHolder!!.screenX, placeHolder!!.screenY)
        val placeholderWidthUnit = placeHolder.screenWidth / ScreenManager.maxWidth
        val placeholderHeightUnit = placeHolder.screenHeight / ScreenManager.maxHeight

        val statusObjects = UiFileHandler.getScreenFromFile("StatusScreen")

        statusObjects.forEach {
            it.calculatePosition(placeholderWidthUnit,placeholderHeightUnit,startPos)
        }

        uiElements.addAll(statusObjects)


        Gdx.input.inputProcessor = TestProcessor(uiElements)

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
