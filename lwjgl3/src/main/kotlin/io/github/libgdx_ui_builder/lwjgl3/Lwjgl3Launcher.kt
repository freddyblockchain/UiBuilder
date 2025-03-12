@file:JvmName("Lwjgl3Launcher")

package io.github.libgdx_ui_builder.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import io.github.libgdx_ui_builder.Main
import io.github.libgdx_ui_builder.TestScreen.TestMain

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.

    val main = Main()
    val testApp = TestMain()
    var startupApplication = main
    if (StartupHelper.startNewJvmIfRequired())
      return
    Lwjgl3Application(startupApplication, Lwjgl3ApplicationConfiguration().apply {
        setTitle("LibgdxUIBuilder")
        val displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode()


        setWindowedMode(displayMode.width, displayMode.height)
        // Optionally, remove window decorations for a cleaner look
        println("Display Mode: " + displayMode.width + "x" + displayMode.height)
        setResizable(false)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
