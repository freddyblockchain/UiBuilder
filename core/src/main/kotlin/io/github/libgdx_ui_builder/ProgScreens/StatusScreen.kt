package io.github.libgdx_ui_builder.ProgScreens

import io.github.libgdx_ui_builder.Screen
import io.github.libgdx_ui_builder.UiElement.Image
import io.github.libgdx_ui_builder.UiElement.Label
import io.github.libgdx_ui_builder.UiElement.NavButton
import io.github.libgdx_ui_builder.UiElement.PlaceHolder

class StatusScreen(): Screen {
    override val name = "StatusScreen"
    val image = Image(x = 2f, y = 2f)
    val StatusLabel = Label(x = 18f, y = 2f, width = 8f, height = 4f, labelText = "Status")
    val label = Label(x = 4f, y = 2f, labelText = "Name: ")
    val label2 = Label(x = 6f, y = 2f, labelText = "Stage: ")
    val label3 = Label(x = 8f, y = 2f, labelText = "Types: ")
    val label4 = Label(x = 10f, y = 2f, labelText = "TrainingPoints: ")
    val label5 = Label(x = 12f, y = 2f, labelText = "Offence: ")
    val label6 = Label(x = 14f, y = 2f, labelText = "Defence: ")
    val label7 = Label(x = 16f, y = 2f, labelText = "Intelligence: ")

    override val uiElements = mutableListOf(image,StatusLabel,label,label2, label3, label4, label5, label6, label7)
}
