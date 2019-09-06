package tikkeulmoa.cimile.org.util

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController  : Application() {
    lateinit var networkService: NetworkService
    private val baseUrl ="http://54.180.21.144:80/"
    companion object {

        lateinit var instance : ApplicationController

    }

    override fun onCreate() {
        super.onCreate()

        instance = this //어느 액티비티에서든지 '나'를 할당 할 수 있도록!! instance에 this를 넣어준다!

        buildNetwork()
    }

    fun buildNetwork() {
        val builder = Retrofit.Builder()
        var retrofit = builder
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())//GSON을 JSON으로 쓸수있도록
            .build()  //베이스 유알엘을 가지고 통신을 할 것

        networkService = retrofit.create(NetworkService::class.java)
    }
}