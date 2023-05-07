package eu.tutorials.countrydetail.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.countrydetail.R
import eu.tutorials.countrydetail.data.entity.Country
import eu.tutorials.countrydetail.databinding.CardDesignBinding
import eu.tutorials.countrydetail.ui.fragment.MainScreenFragmentDirections
import eu.tutorials.countrydetail.ui.viewmodel.MainScreenViewModel
import eu.tutorials.countrydetail.util.transition

class CountryAdapter(var context:Context, var countryList:List<Country>, var viewModel:MainScreenViewModel)
    :RecyclerView.Adapter<CountryAdapter.mViewHolder>() {
    inner class mViewHolder(binding:CardDesignBinding) : RecyclerView.ViewHolder(binding.root){
        var binding:CardDesignBinding
        init {
            this.binding=binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding:CardDesignBinding=DataBindingUtil.inflate(layoutInflater, R.layout.card_design, parent,false)
        return mViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val country=countryList[position]
        val b = holder.binding

        if(position%2==0){
            b.cardLine.setBackgroundColor(Color.parseColor("#C0C0C0"))
        }

        b.country=country


        b.cardLine.setOnClickListener { view->
            val transition = MainScreenFragmentDirections.detailTransition(country = country)
            Navigation.transition(view, transition)
        }
    }
}