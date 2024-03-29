package com.ggc.ui_interactive.screen_interactive.game_staff

data class CellsNeighborhood(
    val firstCell: Cell,
    val firstCellNeighborhoodDirection: Direction,
    val secondCell: Cell,
    val secondCellNeighborhoodDirection: Direction
) {
    enum class Direction {
        TOP,
        LEFT,
        RIGHT,
        BOTTOM
    }
}
