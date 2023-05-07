package eu.tutorials.countrydetail.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dagger.hilt.android.AndroidEntryPoint
import eu.tutorials.countrydetail.R
import eu.tutorials.countrydetail.databinding.FragmentMainScreenBinding
import eu.tutorials.countrydetail.ui.adapter.CountryAdapter
import eu.tutorials.countrydetail.ui.viewmodel.MainScreenViewModel

//when using hilt, we have to add AndroidEntryPoint to activities and fragments
@AndroidEntryPoint
class MainScreenFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var binding:FragmentMainScreenBinding
    private lateinit var viewModel:MainScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)

        binding.toolbarMainScreenTitle="Countries"
        binding.mainScreenFragment=this
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMainScreen)

        viewModel.countryList.observe(viewLifecycleOwner){ countryList->
            val adapter = CountryAdapter(requireContext(),countryList,viewModel)
            binding.countryAdapter=adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_main_screen_menu,menu)

                val item=menu.findItem(R.id.action_search)
                val searchView=item.actionView as SearchView

                searchView.setOnQueryTextListener(this@MainScreenFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:MainScreenViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }
    //refresh main screen
    /*override fun onResume() {
        super.onResume()
        viewModel.uploadCountries()
    }*/

}