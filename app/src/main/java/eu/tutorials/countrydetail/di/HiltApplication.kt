package eu.tutorials.countrydetail.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//used for send a class to viewModels
@HiltAndroidApp
class HiltApplication:Application() {
}