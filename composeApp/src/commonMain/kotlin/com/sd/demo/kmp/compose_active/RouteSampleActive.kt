package com.sd.demo.kmp.compose_active

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sd.lib.kmp.compose_active.FSetActive
import com.sd.lib.kmp.compose_active.fIsActive

@Composable
fun RouteSampleActive(
  modifier: Modifier = Modifier,
  onClickBack: () -> Unit,
) {
  RouteScaffold(
    modifier = modifier,
    title = "SampleActive",
    onClickBack = onClickBack,
  ) {
    FSetActive(true) {
      Content()
    }
  }
}

@Composable
private fun Content(
  modifier: Modifier = Modifier,
) {
  Box(modifier = modifier.fillMaxSize().padding(10.dp)) {
    StateBox(text = "1") {
      StateBox(text = "2") {
        StateBox(text = "3") {
          Text(
            text = "Hello",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = if (fIsActive()) Color.Red else Color.Gray,
          )
        }
      }
    }
  }
}

@Composable
private fun StateBox(
  modifier: Modifier = Modifier,
  text: String,
  content: (@Composable () -> Unit)? = null,
) {
  var checked by remember { mutableStateOf(false) }

  Box(
    modifier = modifier
      .fillMaxSize()
      .padding(vertical = 48.dp, horizontal = 16.dp),
    contentAlignment = Alignment.Center,
  ) {
    Box(
      modifier = Modifier
        .matchParentSize()
        .border(2.dp, if (fIsActive()) Color.Red else Color.Gray)
    )

    SwitchView(
      modifier = Modifier
        .align(Alignment.TopCenter)
        .offset(y = (-24).dp),
      text = text,
      checked = checked,
      onCheckedChange = { checked = it },
    )

    if (content != null) {
      FSetActive(checked) {
        content()
      }
    }
  }
}

@Composable
private fun SwitchView(
  modifier: Modifier = Modifier,
  text: String,
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(text = text)
    Spacer(Modifier.width(8.dp))
    Switch(
      checked = checked,
      onCheckedChange = onCheckedChange,
    )
  }
}