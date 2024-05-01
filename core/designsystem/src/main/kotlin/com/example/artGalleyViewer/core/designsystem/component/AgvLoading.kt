package com.example.artGalleyViewer.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.example.artGalleyViewer.core.designsystem.R

/**
 * AgvLoading is a composable that displays a loading indicator.
 * @param modifier Modifier to be applied to the loading indicator.
 */
@Composable
fun AgvLoading(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
            .testTag(stringResource(R.string.loading)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}