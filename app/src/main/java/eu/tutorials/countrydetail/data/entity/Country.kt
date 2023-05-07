package eu.tutorials.countrydetail.data.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Country(@SerializedName("id")var id:Int,
                   @SerializedName("country_name")var country_name:String,
                   @SerializedName("capital_name")var capital_name:String,
                   @SerializedName("country_flag")var country_flag:String,
                   @SerializedName("country_description")var country_description:String)
    :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(country_name)
        parcel.writeString(capital_name)
        parcel.writeString(country_flag)
        parcel.writeString(country_description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }
    }

}