package com.sd.demo.kmp.compose_active

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sd.lib.kmp.compose_active.FActiveContent
import com.sd.lib.kmp.compose_active.FSetActive

@Composable
fun RouteSampleActiveContent(
  modifier: Modifier = Modifier,
  onClickBack: () -> Unit,
) {
  RouteScaffold(
    modifier = modifier,
    title = "SampleActiveContent",
    onClickBack = onClickBack,
  ) {
    var active by remember { mutableStateOf(false) }
    Switch(
      checked = active,
      onCheckedChange = { active = it },
    )
    FSetActive(active) {
      ActiveColumn()
    }
  }
}

@Composable
private fun ActiveColumn(
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    FActiveContent(
      timeout = 3000,
      default = { Text(text = "default") },
      content = { Text(text = "content timeout 3000") },
    )

    FActiveContent(
      timeout = 0,
      default = { Text(text = "default") },
      content = { Text(text = "content timeout 0") },
    )

    FActiveContent(
      timeout = -1,
      default = { Text(text = "default") },
      content = { Text(text = "content timeout -1") },
    )
  }
}