package io.github.libgdx_ui_builder

interface Draggable {
    var isDragging: Boolean
    fun onDragStart(screenX: Float, screenY: Float)
    fun onDrag(screenX: Float, screenY: Float)
    fun onDragEnd()
}
