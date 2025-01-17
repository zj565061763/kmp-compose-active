package com.sd.demo.kmp.compose_active

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RouteHome(
  modifier: Modifier = Modifier,
  onClickSampleActive: () -> Unit,
  onClickSampleActiveContent: () -> Unit,
  onClickSampleActivePager: () -> Unit,
  onClickSampleActiveFlow: () -> Unit,
) {
  Scaffold(modifier = modifier.fillMaxSize()) { padding ->
    Column(
      modifier = Modifier.fillMaxSize().padding(padding),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Button(onClick = onClickSampleActive) { Text(text = "SampleActive") }
      Button(onClick = onClickSampleActiveContent) { Text(text = "SampleActiveContent") }
      Button(onClick = onClickSampleActivePager) { Text(text = "SampleActivePager") }
      Button(onClick = onClickSampleActiveFlow) { Text(text = "SampleActiveFlow") }
    }
  }
}