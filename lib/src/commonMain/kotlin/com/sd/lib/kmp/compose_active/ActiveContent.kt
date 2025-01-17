package com.sd.lib.kmp.compose_active

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

/**
 * 激活状态显示[content]，当状态由激活转为非激活时，
 * 根据[timeout]参数决定显示逻辑：
 *
 * - 大于0时，例如100，表示100毫秒后显示[default]
 * - 等于0时，表示立即显示[default]
 * - 小于0时，表示不显示[default]，即只要激活过一次就一直显示[content]
 */
@Composable
fun FActiveContent(
  timeout: Long = -1L,
  default: @Composable () -> Unit = {},
  content: @Composable () -> Unit,
) {
  val isActive = fIsActive()
  var hasActive by remember { mutableStateOf(isActive) }

  if (isActive) {
    hasActive = true
  } else {
    when {
      timeout < 0L -> {}
      timeout == 0L -> hasActive = false
      timeout > 0L -> {
        if (hasActive) {
          LaunchedEffect(Unit) {
            delay(timeout)
            hasActive = false
          }
        }
      }
    }
  }

  if (hasActive) {
    content()
  } else {
    default()
  }
}