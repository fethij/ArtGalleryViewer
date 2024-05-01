package com.example.artGalleryViewer.feature.arts.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.artGalleryViewer.feature.arts.gallery.ArtsScreenRoute
import com.example.artGalleryViewer.feature.arts.gallery.CollectionScreenRoute
import com.example.artGalleryViewer.feature.arts.gallery.GalleryViewModel
import com.example.artGalleyViewer.core.designsystem.navigation.NavDestination

/**
 * Defines the navigation graph for the gallery feature.
 */
fun NavGraphBuilder.galleryGraph(
    navController: NavHostController
) {
    navigation(
        route = NavDestination.Gallery.route,
        startDestination = NavDestination.ArtsScreen.route
    ) {
        composable(NavDestination.ArtsScreen.route) { entry ->
            val viewModel = entry.sharedViewModel<GalleryViewModel>(navController)
            ArtsScreenRoute(viewModel) {
                navController.navigate(NavDestination.CollectionScreen.route)
            }
        }

        composable(NavDestination.CollectionScreen.route) { entry ->
            val viewModel = entry.sharedViewModel<GalleryViewModel>(navController)
            CollectionScreenRoute(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onArtClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }
    }
}

/**
 * Returns a [ViewModel] scoped to the parent of the current [NavBackStackEntry].
 * This is useful when you want to share a ViewModel between multiple destinations in a navigation graph.
 */
@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}