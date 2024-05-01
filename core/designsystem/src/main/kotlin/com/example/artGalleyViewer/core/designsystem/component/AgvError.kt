package com.example.artGalleyViewer.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.example.artGalleyViewer.core.designsystem.R

/**
 * Displays an error message.
 * @param modifier Modifier to be applied to the error message.
 * @param text Text to be displayed.
 */
@Composable
fun AgvError(
    modifier: Modifier = Modifier,
    text: String = stringResource(R.string.something_went_wrong),
) {
    Box(
        modifier = modifier
            .testTag(stringResource(R.string.error)),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}