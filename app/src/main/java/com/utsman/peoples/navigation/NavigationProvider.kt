package com.utsman.peoples.navigation

import androidx.compose.runtime.compositionLocalOf
import com.utsman.peoples.data.model.People

interface NavigationProvider {
    fun back()
    fun navigateToDetail(people: People)
}

val LocalNavigationProvider =
    compositionLocalOf<NavigationProvider> { error("navigation") }