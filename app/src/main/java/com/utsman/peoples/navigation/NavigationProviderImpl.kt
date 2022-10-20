package com.utsman.peoples.navigation

import androidx.navigation.NavHostController
import com.utsman.peoples.data.model.People

class NavigationProviderImpl(
    private val navHostController: NavHostController
) : NavigationProvider {
    override fun back() {
        navHostController.popBackStack()
    }

    override fun navigateToDetail(people: People) {
        val route = NavigationRoute.routeDetail
        navigate(route, people)
    }

    private fun navigate(route: NavigationRoute) {
        navHostController.navigate(route.route)
    }

    private inline fun<reified T> navigate(route: NavigationRoute, data: T) {
        val routeArg = route.generateRouteWithDataArg(data)
        navHostController.navigate(routeArg)
    }
}