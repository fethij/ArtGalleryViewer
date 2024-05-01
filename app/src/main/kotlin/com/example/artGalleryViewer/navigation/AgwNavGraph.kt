package com.example.artGalleryViewer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.artGalleryViewer.feature.arts.detail.DetailScreenRoute
import com.example.artGalleryViewer.feature.arts.navigation.galleryGraph
import com.example.artGalleyViewer.core.designsystem.navigation.NavDestination

/**
 * Main navigation graph for the Art Gallery Viewer app.
 * @param modifier Modifier to be applied to the NavHost.
 * @param startDestination The starting destination of the NavHost.
 * @param navController The NavController to be used by the NavHost.
 */
@Composable
fun AgwNavGraph(
    modifier: Modifier = Modifier,
    startDestination: NavDestination = NavDestination.Gallery,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = Modifier.then(modifier),
        startDestination = startDestination.route,
        navController = navController,
    ) {
        galleryGraph(navController)
        composable(NavDestination.DetailScreen.route) { entry ->
            val id = entry.arguments
                ?.getString("id")
                ?.let(::requireNotNull)
                .orEmpty()
            DetailScreenRoute(
                objectId = id,
                viewModel = hiltViewModel(),
                onBackClick = navController::popBackStack
            )
        }
    }
}
