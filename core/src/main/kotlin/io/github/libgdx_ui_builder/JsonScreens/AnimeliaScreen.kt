package io.github.libgdx_ui_builder.JsonScreens

import io.github.libgdx_ui_builder.FontType
import io.github.libgdx_ui_builder.Screen
import io.github.libgdx_ui_builder.UiElement.Image
import io.github.libgdx_ui_builder.UiElement.Label
import io.github.libgdx_ui_builder.UiElement.PlaceHolder
import io.github.libgdx_ui_builder.UiElement.UiElement

class AnimeliaScreen(): Screen {
    override val name = "AnimeliaScreen"
    //val AnimeliaLabel: UiElement = Label(x = 12f, y = 26f, labelText = "Animelias", fontType = FontType.CHAPTERFONT)

    val row1: UiElement = PlaceHolder(buttonX = 4f, buttonY = 28f, name = "animeliaRow1", width = 2f, height = 3f)
    val row2 = PlaceHolder(buttonX = 4f, buttonY = 20f, name = "animeliaRow2", width = 2f, height = 3f)
    val row3 = PlaceHolder(buttonX = 4f, buttonY = 12f, name = "animeliaRow3", width = 2f, height = 3f)
    val row4 = PlaceHolder(buttonX = 4f, buttonY = 4f, name = "animeliaRow4", width = 2f, height = 3f)
    /*val image = Image(x = 2f, y = 2f)
    val label = Label(x = 4f, y = 4f, labelText = "Name: ")
    val label2 = Label(x = 6f, y = 2f, labelText = "Stage: ")
    val label3 = Label(x = 8f, y = 2f, labelText = "Types: ")
    val label4 = Label(x = 10f, y = 2f, labelText = "TrainingPoints: ")
    val label5 = Label(x = 12f, y = 2f, labelText = "Offence: ")
    val label6 = Label(x = 14f, y = 2f, labelText = "Defence: ")
    val label7 = Label(x = 16f, y = 2f, labelText = "Intelligence: ")*/

    override var uiElements = mutableListOf(row1,row2,row3,row4)
}
