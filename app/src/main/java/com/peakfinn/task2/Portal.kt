package com.peakfinn.task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Finn Bon on 25/03/2020.
 */
@Parcelize
data class Portal (
    val name: String,
    val url: String
): Parcelable