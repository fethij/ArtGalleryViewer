package com.example.artGalleryViewer.feature.arts

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import com.example.artGalleryViewer.core.testing.repository.TestArtsRepository.Companion.testArts
import com.example.artGalleryViewer.feature.arts.gallery.ArtsScreen
import com.example.artGalleryViewer.feature.arts.gallery.model.ArtsUiState
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
class ArtScreenTest {
    private val context get() = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val composeTestRule = createComposeRule()
    private var uiState: ArtsUiState = ArtsUiState.Empty

    @Test
    fun `arts screen when uiState is Empty`() {
        uiState = ArtsUiState.Empty
        composeTestRule.setContent {
            ArtsScreen(uiState = uiState, onNavigateToCollection = {})
        }

        val articleScreen = context.getString(R.string.arts_screen)
        val noArts = context.getString(R.string.no_arts)

        composeTestRule.onNodeWithTag(articleScreen).assertExists()
        composeTestRule.onNodeWithText(noArts).assertExists()
    }

    @Test
    fun `arts screen when state is Loading`() {
        uiState = ArtsUiState.Loading
        composeTestRule.setContent {
            ArtsScreen(uiState = uiState, onNavigateToCollection = {})
        }

        val artsScreen = context.getString(R.string.arts_screen)
        val loading = context.getString(R.string.arts_loading)

        composeTestRule.onNodeWithTag(artsScreen).assertExists()
        composeTestRule.onNodeWithTag(loading).assertExists()
    }

    @Test
    fun `articles screen when state is Success`() {
        uiState = ArtsUiState.Success(testArts)
        composeTestRule.setContent {
            ArtsScreen(uiState = uiState, onNavigateToCollection = {})
        }
        composeTestRule.waitForIdle()
        val articleScreen = context.getString(R.string.arts_screen)

        composeTestRule.onNodeWithTag(articleScreen).assertExists()
    }
}

