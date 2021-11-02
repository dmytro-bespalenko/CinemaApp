package com.bignerdranch.android.cinemaapp.data.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["id"])
data class MovieEntity(
    @SerializedName("id")
    val id: Long,

    @SerializedName(value = "header", alternate = ["title", "name"])
    val header: String?,

    @SerializedName("poster_path")
    var posterPath: String?,

    @SerializedName(value = "description", alternate = ["overview", "synopsis"])
    var description: String?,

    @SerializedName("release_date")
    var releaseDate: String?,

    @SerializedName("runtime")
    var runTime: Long,
    var status: String?
) : Parcelable {

    fun getFormattedPosterPath(): String? {
        if (posterPath != null && !posterPath!!.startsWith("http")) {
            posterPath = String.format("https://image.tmdb.org/t/p/w500%s", posterPath)
        }
        return posterPath
    }

    constructor(source: Parcel) : this(
        source.readLong(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readLong(),
        source.readString()
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(header)
        parcel.writeString(posterPath)
        parcel.writeString(description)
        parcel.writeString(releaseDate)
        parcel.writeLong(runTime)
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieEntity> {
        override fun createFromParcel(parcel: Parcel): MovieEntity {
            return MovieEntity(parcel)
        }

        override fun newArray(size: Int): Array<MovieEntity?> {
            return arrayOfNulls(size)
        }
    }
}
