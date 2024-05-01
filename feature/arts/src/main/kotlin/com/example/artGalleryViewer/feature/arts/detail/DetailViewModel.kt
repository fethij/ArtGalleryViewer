package com.example.artGalleryViewer.feature.arts.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artGalleryViewer.core.domain.GetArtDetailUseCase
import com.example.artGalleryViewer.feature.arts.detail.model.DetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    val getArtDetail: GetArtDetailUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = DetailUiState.Loading
        )


    fun getDetail(objectId: String) = viewModelScope.launch {
        val art = getArtDetail(objectId)
        if (art != null) {
            _uiState.update { DetailUiState.Success(art) }
        } else {
            _uiState.update { DetailUiState.Error }
        }
    }
}
