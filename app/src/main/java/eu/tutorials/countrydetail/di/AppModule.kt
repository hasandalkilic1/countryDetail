package eu.tutorials.countrydetail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.tutorials.countrydetail.data.repo.CountryDaoRepository
import eu.tutorials.countrydetail.retrofit.ApiUtils
import eu.tutorials.countrydetail.retrofit.CountryDao
import javax.inject.Singleton

//used for access a class from every viewModel
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun prodiveCountryDaoRepository(cDao:CountryDao):CountryDaoRepository{
        return CountryDaoRepository(cDao)
    }

    @Provides
    @Singleton
    fun prodiveCountryDao():CountryDao{
        return ApiUtils.getCountriesDao()
    }
}