package com.example.artGalleyViewer.core.designsystem.navigation

/**
 * Destinations used in the [AgwNavGraph].
 */
/* app module may be better suited to host the nav destinations */
sealed class NavDestination(val route: String) {
    data object Gallery : NavDestination("gallery")
    data object ArtsScreen : NavDestination("arts")
    data object DetailScreen : NavDestination("detail/{id}")
    data object CollectionScreen : NavDestination("collection")
}