package eu.tutorials.countrydetail.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.tutorials.countrydetail.data.repo.CountryDaoRepository
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor (var cRepo:CountryDaoRepository):ViewModel() {

}