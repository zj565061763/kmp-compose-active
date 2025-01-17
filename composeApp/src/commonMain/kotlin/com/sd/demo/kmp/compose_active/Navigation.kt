package com.sd.demo.kmp.compose_active

import kotlinx.serialization.Serializable

sealed interface AppRoute {
  @Serializable
  data object Home : AppRoute

  @Serializable
  data object SampleActive : AppRoute

  @Serializable
  data object SampleActiveContent : AppRoute

  @Serializable
  data object SampleActivePager : AppRoute

  @Serializable
  data object SampleActiveFlow : AppRoute
}