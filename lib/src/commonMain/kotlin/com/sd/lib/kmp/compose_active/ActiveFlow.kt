package com.sd.lib.kmp.compose_active

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun <T> StateFlow<T>.fCollectAsStateWithActive(): State<T> {
  val flow = this
  return remember { mutableStateOf(flow.value) }.also { state ->
    flowToStateWithActive(flow, state)
  }
}

@Composable
fun <T> Flow<T>.fCollectAsStateWithActive(
  initialValue: () -> T,
): State<T> {
  val flow = this
  return remember { mutableStateOf(initialValue()) }.also { state ->
    flowToStateWithActive(flow, state)
  }
}

@Composable
private fun <T> flowToStateWithActive(
  flow: Flow<T>,
  state: MutableState<T>,
) {
  if (fIsActive()) {
    LaunchedEffect(flow, state) {
      flow.collect { state.value = it }
    }
  }
}