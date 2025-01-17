package com.sd.demo.kmp.compose_active

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
  MaterialTheme {
    val navController = rememberNavController()
    NavHost(
      navController = navController,
      startDestination = AppRoute.Home,
    ) {
      composable<AppRoute.Home> {
        RouteHome(
          onClickSampleActive = { navController.navigate(AppRoute.SampleActive) },
          onClickSampleActiveContent = { navController.navigate(AppRoute.SampleActiveContent) },
          onClickSampleActivePager = { navController.navigate(AppRoute.SampleActivePager) },
          onClickSampleActiveFlow = { navController.navigate(AppRoute.SampleActiveFlow) },
        )
      }
      composable<AppRoute.SampleActive> {
        RouteSampleActive(onClickBack = { navController.popBackStack() })
      }
      composable<AppRoute.SampleActiveContent> {
        RouteSampleActiveContent(onClickBack = { navController.popBackStack() })
      }
      composable<AppRoute.SampleActivePager> {
        RouteSampleActivePager(onClickBack = { navController.popBackStack() })
      }
      composable<AppRoute.SampleActiveFlow> {
        RouteSampleActiveFlow(onClickBack = { navController.popBackStack() })
      }
    }
  }
}

expect fun logMsg(tag: String = "kmp-compose-active", block: () -> String)