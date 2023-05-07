package eu.tutorials.countrydetail.data.entity

import com.google.gson.annotations.SerializedName

data class CountryAnswer(@SerializedName("countries")var countries:List<Country>,
                    @SerializedName("success")var success:Int) {
}