package eu.tutorials.countrydetail.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import eu.tutorials.countrydetail.R
import eu.tutorials.countrydetail.databinding.FragmentMainScreenBinding
import eu.tutorials.countrydetail.ui.viewmodel.MainScreenViewModel

class MainScreenFragment : Fragment() {

    private lateinit var binding:FragmentMainScreenBinding
    private lateinit var viewModel:MainScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_main_screen,container,false)

        binding.mainScreenFragment=this
        binding.toolbarMainScreenTitle="Countries"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:MainScreenViewModel by viewModels()
        viewModel=tempViewModel
    }

}
