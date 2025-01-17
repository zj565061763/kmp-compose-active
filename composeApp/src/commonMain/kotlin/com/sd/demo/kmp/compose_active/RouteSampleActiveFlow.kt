package com.sd.demo.kmp.compose_active

import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sd.lib.kmp.compose_active.FSetActive
import com.sd.lib.kmp.compose_active.fCollectAsStateWithActive
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach

@Composable
fun RouteSampleActiveFlow(
  modifier: Modifier = Modifier,
  onClickBack: () -> Unit,
) {
  RouteScaffold(
    modifier = modifier,
    title = "SampleActiveFlow",
    onClickBack = onClickBack,
  ) {
    var active by remember { mutableStateOf(false) }
    Switch(
      checked = active,
      onCheckedChange = { active = it },
    )
    FSetActive(active) {
      val count by CountFlow.fCollectAsStateWithActive { 0 }
      Text(text = count.toString())
    }
  }
}

private val CountFlow = (1..Int.MAX_VALUE).asFlow().onEach { delay(500) }