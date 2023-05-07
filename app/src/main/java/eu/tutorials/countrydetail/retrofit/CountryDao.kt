package eu.tutorials.countrydetail.retrofit


import eu.tutorials.countrydetail.data.entity.CountryAnswer
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface CountryDao {
    //http://192.168.1.33:3001/countries
    @GET("countries")
    fun allCountries(): Call<CountryAnswer>

}