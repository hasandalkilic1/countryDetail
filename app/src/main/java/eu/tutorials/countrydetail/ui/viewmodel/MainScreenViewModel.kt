package eu.tutorials.countrydetail.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.tutorials.countrydetail.data.entity.Country
import eu.tutorials.countrydetail.data.repo.CountryDaoRepository
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor (var cRepo:CountryDaoRepository):ViewModel() {
    var countryList=MutableLiveData<List<Country>>()
    init {
        uploadCountries()
        countryList=cRepo.getCountries()
    }

    fun search(searchWord:String){
        cRepo.countrySearch(searchWord)
    }

    fun uploadCountries(){
        cRepo.getAllCountries()
    }
}