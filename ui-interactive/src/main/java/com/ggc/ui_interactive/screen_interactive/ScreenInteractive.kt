package com.ggc.ui_interactive.screen_interactive

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.R
import com.ggc.common.R.string.points
import com.ggc.common.theme.grey2
import com.ggc.common.theme.grey3
import com.ggc.common.theme.red
import com.ggc.common.theme.white
import com.ggc.common.ui_elements.AppText
import com.ggc.common.ui_elements.Grid
import com.ggc.ui_interactive.screen_interactive.game_staff.AnimatedFade
import com.ggc.ui_interactive.screen_interactive.game_staff.AnimatedOffset
import com.ggc.ui_interactive.screen_interactive.game_staff.CellsNeighborhood
import com.ggc.ui_interactive.screen_interactive.game_staff.CellsNeighborhood.Direction.BOTTOM
import com.ggc.ui_interactive.screen_interactive.game_staff.CellsNeighborhood.Direction.LEFT
import com.ggc.ui_interactive.screen_interactive.game_staff.CellsNeighborhood.Direction.RIGHT
import com.ggc.ui_interactive.screen_interactive.game_staff.CellsNeighborhood.Direction.TOP

@Composable
fun ScreenInteractive(
    viewModel: ScreenInteractiveViewModel
) {
    val model by viewModel.model.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp)
    ) {
        Column {
            PointsCount(pointsCount = model.pointsCount.toString())

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 30.dp),
                ) {
                    Grid(quantityCellsInWidth = ScreenInteractiveViewModel.quantityCellsInWidth) {
                        model.cells.forEach { cell ->
                            CellBackground(selected = cell.selected)
                        }
                    }

                    Grid(quantityCellsInWidth = ScreenInteractiveViewModel.quantityCellsInWidth) {
                        val localDensity = LocalDensity.current
                        model.cells.forEach { cell ->
                            var offsetForAnimation by remember { mutableStateOf(30.dp) }
                            CellIcon(
                                modifier = Modifier.onGloballyPositioned { coordinates ->
                                    with(localDensity) {
                                        offsetForAnimation = when (cell.offsetDirection) {
                                            LEFT -> coordinates.size.width.toDp()
                                            RIGHT -> coordinates.size.width.toDp()
                                            TOP -> coordinates.size.height.toDp()
                                            BOTTOM -> coordinates.size.height.toDp()
                                        }
                                    }
                                },
                                cellPosition = cell.position.id,
                                selected = cell.selected,
                                drawableId = cell.displayable.iconDrawableId,
                                drawableVisible = cell.playAnimationFade,
                                fadeAnimationFinishedListener =
                                if (cell.lastCellInFadeAnimation) {
                                    {
                                        viewModel.fadeAnimationFinished()
                                    }
                                } else {
                                    null
                                },
                                onClickEnabled = model.cellClickEnabled,
                                onClick = {
                                    viewModel.cellClicked(cell.position.id)
                                },
                                playOffsetAnimation = cell.playAnimationOffset,
                                offsetAnimationDp = offsetForAnimation,
                                offsetAnimationDirection = cell.offsetDirection,
                                offsetAnimationFinishedListener = {
                                    viewModel.cellOffsetAnimationEnded()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PointsCount(
    pointsCount: String
) {
    Box(
        modifier = Modifier
            .padding(start = 30.dp)
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .padding(end = 5.dp)
                .background(color = red, shape = RoundedCornerShape(size = 30.dp))
                .padding(vertical = 8.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText(
                text = "${stringResource(id = points)} $pointsCount",
                fontSize = 15.sp,
                color = white,
                font = R.font.font_inter_extra_bold
            )
        }
    }
}

@Composable
private fun CellBackground(
    modifier: Modifier = Modifier,
    selected: Boolean
) {
    Box(
//        contentAlignment = Alignment.Center,
        modifier = modifier.background(color = grey2)
    )
}

@Composable
private fun CellIcon(
    modifier: Modifier = Modifier,
    cellPosition: Int,
    selected: Boolean,
    @DrawableRes drawableId: Int,
    drawableVisible: Boolean,
    playOffsetAnimation: Boolean,
    offsetAnimationDp: Dp,
    offsetAnimationDirection: CellsNeighborhood.Direction,
    offsetAnimationFinishedListener: ((Dp) -> Unit)?,
    fadeAnimationFinishedListener: ((Float) -> Unit)?,
    drawableOffsetY: Dp = 0.dp,
    onClickEnabled: Boolean,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        AnimatedFade(
            visible = drawableVisible,
            finishedListener = fadeAnimationFinishedListener
        ) {
            AnimatedOffset(
                playAnimation = playOffsetAnimation,
                offsetAnimationDp = offsetAnimationDp,
                animationDirection = offsetAnimationDirection,
                finishedListener = offsetAnimationFinishedListener
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 10.dp)
                        .offset(y = drawableOffsetY)
                        .clickable(
                            onClick = onClick,
                            enabled = onClickEnabled
                        ),
                    painter = painterResource(id = drawableId),
                    contentDescription = "",
                    colorFilter = if (selected) {
                        ColorFilter.tint(color = grey3, blendMode = BlendMode.Darken)
                    } else {
                        null
                    }
                )
            }
        }
    }
}