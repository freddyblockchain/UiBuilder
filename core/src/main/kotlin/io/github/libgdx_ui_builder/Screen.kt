package io.github.libgdx_ui_builder

import io.github.libgdx_ui_builder.UiElement.UiElement

interface Screen {
    val name: String
    var uiElements: MutableList<UiElement>
}
