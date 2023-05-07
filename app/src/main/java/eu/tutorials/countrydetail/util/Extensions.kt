package eu.tutorials.countrydetail.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
// for transitions
fun Navigation.transition(view:View, id:Int){
    findNavController(view).navigate(id)
}

fun Navigation.transition(view:View, id:NavDirections){
    findNavController(view).navigate(id)
}