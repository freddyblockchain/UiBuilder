package io.github.libgdx_ui_builder

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class RenderManager(){
    companion object {
        val batch = SpriteBatch()
        val shapeRenderer = ShapeRenderer()

        init {
            Gdx.gl.glLineWidth(5f)
        }
    }
}
