package com.juniorkekod.disneyplusclonekekod.presentation.tracing.models

import android.graphics.drawable.Drawable

abstract class DownloadableVideos {

    open val image: Drawable? = null
    open val name: String? = null
    open val size: Int? = null
    open val watchProgress: Int? = null
    open val time: Int? = null

}

