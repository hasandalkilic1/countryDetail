package eu.tutorials.countrydetail.ui.fragment

import android.os.Bundle
import android.util.Log
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
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import eu.tutorials.countrydetail.R
import eu.tutorials.countrydetail.data.entity.Country
import eu.tutorials.countrydetail.databinding.FragmentMainScreenBinding
import eu.tutorials.countrydetail.ui.adapter.CountryAdapter

class MainScreenFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var binding:FragmentMainScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)

        binding.toolbarMainScreenTitle="Countries"
        binding.mainScreenFragment=this
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMainScreen)


        val countryList=ArrayList<Country>()

        val c1=Country(1,"Turkey","Ankara","turkey_flag.png","best country")
        val c2=Country(2,"France","Paris","france_flag.png","a country")
        val c3=Country(3,"Greece","Athena","greece_flag.png","a country")

        countryList.add(c1)
        countryList.add(c2)
        countryList.add(c3)

        val adapter = CountryAdapter(requireContext(),countryList)
        binding.countryAdapter=adapter

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

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(searchWord:String){
        Log.e("Kişi Ara",searchWord)

    }
}