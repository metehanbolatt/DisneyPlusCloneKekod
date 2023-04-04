package com.juniorkekod.disneyplusclonekekod.presentation.tracing.models

import android.graphics.drawable.Drawable

data class DownloadedMovies(
    override val image: Drawable? = null,
    override val name: String? = null,
    override val size: Int? = null,
    override val watchProgress: Int? = null,
    override val time: Int? = null
) : DownloadableVideos()