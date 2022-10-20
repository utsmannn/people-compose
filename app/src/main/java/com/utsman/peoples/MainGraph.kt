package com.utsman.peoples

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.utsman.peoples.data.model.People
import com.utsman.peoples.navigation.NavigationRoute
import com.utsman.peoples.navigation.generateRouteWithJsonArg
import com.utsman.peoples.navigation.routeArg
import com.utsman.peoples.ui.screen.DetailScreen
import com.utsman.peoples.ui.screen.HomeScreen

@Composable
fun MainGraph(
    navHostController: NavHostController
) {
    val routeMain = NavigationRoute.routeMain
    val routeDetail = NavigationRoute.routeDetail

    NavHost(navController = navHostController, startDestination = routeMain.routeArg) {
        composable(route = routeMain.route) {
            HomeScreen()
        }

        composable(route = routeDetail.routeArg, arguments = routeDetail.namedNavArgs) {
            val people = routeDetail.generateRouteWithJsonArg<People>(it.arguments)
            DetailScreen(people = people)
        }
    }
}