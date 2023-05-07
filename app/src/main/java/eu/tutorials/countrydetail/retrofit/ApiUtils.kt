package eu.tutorials.countrydetail.retrofit

class ApiUtils {
    companion object{
        val BASE_URL="http://192.168.1.33:3001/"

        fun getCountriesDao():CountryDao{
            return RetrofitClient.getClient(BASE_URL).create(CountryDao::class.java)
        }
    }
}