package eu.tutorials.countrydetail.data.entity

import android.os.Parcel
import android.os.Parcelable

data class Country(var id:Int, var country_name:String, var capital_name:String, var country_flag:String, var country_description:String):Parcelable {
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