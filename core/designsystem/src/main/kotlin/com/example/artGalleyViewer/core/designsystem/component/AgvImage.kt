package com.example.artGalleyViewer.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.artGalleyViewer.core.designsystem.R

/**
 * [AgvImage] displays an image from a URL.
 * @param modifier Modifier to be applied to the image.
 * @param imageUrl URL of the image to be displayed.
 * @param placeholder Placeholder image to be displayed while the image is loading.
 * @param contentDescription Description of the image for accessibility.
 *
 */
@Composable
fun AgvImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    placeholder: Int = R.drawable.baseline_image,
    contentDescription: String = "",
    id: String? = null,
    contentScale: ContentScale = ContentScale.Crop
) {
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                .apply(block = fun ImageRequest.Builder.() {
                    id?.let {
                        placeholderMemoryCacheKey(id)
                    }
                    error(placeholder)
                }).build()
        ),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
    )
}