package com.sd.demo.kmp.compose_active

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.sd.lib.kmp.compose_active.FSetActivePager
import com.sd.lib.kmp.compose_active.fIsActive
import kotlin.math.roundToInt

@Composable
fun RouteSampleActivePager(
  modifier: Modifier = Modifier,
  onClickBack: () -> Unit,
) {
  RouteScaffold(
    modifier = modifier,
    title = "SampleActivePager",
    onClickBack = onClickBack,
  ) {
    val state = rememberPagerState { 100 }
    HorizontalPager(
      modifier = Modifier.fillMaxSize(),
      state = state,
      pageSpacing = 10.dp,
      pageSize = CustomPageSize,
      snapPosition = SnapPosition.Center,
    ) { page ->
      FSetActivePager(state, page) {
        PageContent()
      }
    }
  }
}

@Composable
private fun PageContent(
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .background(if (fIsActive()) Color.Red else Color.Gray)
      .fillMaxWidth()
      .aspectRatio(1f),
  )
}

private val CustomPageSize = object : PageSize {
  override fun Density.calculateMainAxisPageSize(availableSpace: Int, pageSpacing: Int): Int {
    return (availableSpace * 0.8f).roundToInt()
  }
}