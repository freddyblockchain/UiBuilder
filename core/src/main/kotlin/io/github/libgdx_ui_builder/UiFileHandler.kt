package io.github.libgdx_ui_builder
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import io.github.libgdx_ui_builder.UiElement.UiElement
import kotlinx.serialization.json.Json
import java.io.BufferedWriter
import java.io.File

class UiFileHandler {
    companion object{

        lateinit var uiHandle: FileHandle
        private lateinit var uiFile: File
        private lateinit var fileWriter: BufferedWriter

        fun readUiFile(): List<String>{
            return uiFile.useLines { it.toList() }
        }

        fun getFileJson(fileName: String): String{
            val handle: FileHandle = Gdx.files.internal(fileName)
            return handle.readString()
        }

        fun writeScreenToFile(mainScreen: Screen){
            initScreen(mainScreen.name)
            val uiHandle = Gdx.files.local("Screens/${mainScreen.name}")
            val uiElementsJson = Json.encodeToString(uiElements)

            uiHandle.writeString(uiElementsJson,false)
        }

        fun getScreenFromFile(name: String): MutableList<UiElement>{
            val uiHandle = Gdx.files.local("Screens/${name}")
            val string = uiHandle.readString()
            return Json.decodeFromString<MutableList<UiElement>>(string)
        }

        fun initScreen(name: String){
            val uiHandle = Gdx.files.local("Screens/$name")
            uiHandle.file().parentFile?.mkdirs()
            if(!uiHandle.exists()){
                uiHandle.file().createNewFile()
            }
        }

        val BASE_PATH = if (Gdx.files.internal("assets/").exists()) {
            "assets/"
        } else {
            ""
        }

    }
}
