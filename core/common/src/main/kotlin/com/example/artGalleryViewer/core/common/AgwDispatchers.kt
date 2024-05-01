package com.example.artGalleryViewer.core.common

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val agwDispatchers: AgwDispatchers)

enum class AgwDispatchers {
    Default,
    IO,
}
