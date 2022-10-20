package com.utsman.peoples.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class NavigationRoute(
    val route: String = "",
    val keyArg: String = "",
    val namedNavArgs: List<NamedNavArgument> = emptyList()
) {

    companion object {
        val routeMain: NavigationRoute
            get() = NavigationRoute(
                route = "main"
            )

        val routeDetail: NavigationRoute
            get() = NavigationRoute(
                route = "detail/",
                keyArg = "contact",
                namedNavArgs = listOf(
                    navArgument("contact") {
                        type = NavType.StringType
                    }
                )
            )
    }
}

val NavigationRoute.routeArg: String
    get() {
        return if (keyArg.isNotEmpty()) {
            "$route{$keyArg}"
        } else {
            route
        }
    }

inline fun<reified T> NavigationRoute.generateRouteWithDataArg(data: T): String {
    val type = object : TypeToken<T>() {}.type
    val jsonData = Gson().toJson(data, type)
    val jsonUri = Uri.encode(jsonData)
    return "$route$jsonUri"
}

inline fun <reified T> NavigationRoute.generateRouteWithJsonArg(arguments: Bundle?): T {
    val type = object : TypeToken<T>() {}.type
    val json = arguments?.getString(keyArg).orEmpty()
    return Gson().fromJson(json, type)
}