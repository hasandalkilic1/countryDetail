package eu.tutorials.countrydetail.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import eu.tutorials.countrydetail.data.entity.Country
import eu.tutorials.countrydetail.data.entity.CountryAnswer
import eu.tutorials.countrydetail.retrofit.CountryDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryDaoRepository(var cDao:CountryDao) {
    var countryList:MutableLiveData<List<Country>>
    init {
        countryList=MutableLiveData()
    }
    // connect data and viewModel
    fun getCountries():MutableLiveData<List<Country>>{
        return countryList
    }

    fun countrySearch(searchWord:String){
        Log.e("Ülke Ara",searchWord)
    }
    //create a country list and connect it with live data
    fun getAllCountries(){
        cDao.allCountries().enqueue(object :Callback<CountryAnswer>{
            override fun onResponse(call: Call<CountryAnswer>?, response: Response<CountryAnswer>) {
                val list=response.body().countries
                countryList.value=list
            }

            override fun onFailure(call: Call<CountryAnswer>?, t: Throwable?) {
                Log.e("Ülke",t.toString())
            }
        })
    }
}