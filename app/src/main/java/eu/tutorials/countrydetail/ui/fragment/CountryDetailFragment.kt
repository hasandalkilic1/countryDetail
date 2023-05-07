package eu.tutorials.countrydetail.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import eu.tutorials.countrydetail.R
import eu.tutorials.countrydetail.databinding.FragmentCountryDetailBinding
import eu.tutorials.countrydetail.ui.viewmodel.CountryDetailViewModel

//when using hilt, we have to add AndroidEntryPoint to activities and fragments
@AndroidEntryPoint
class CountryDetailFragment : Fragment() {

    private lateinit var binding:FragmentCountryDetailBinding
    private lateinit var viewModel:CountryDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_country_detail,container,false)

        val bundle:CountryDetailFragmentArgs by navArgs()

        val country=bundle.country

        binding.countryDetailFragment=this
        binding.toolbarCountryDetailTitle=country.country_name
        binding.country=country

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:CountryDetailViewModel by viewModels()
        viewModel=tempViewModel
    }
}