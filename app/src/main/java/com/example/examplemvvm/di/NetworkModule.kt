package com.example.examplemvvm.di

import com.example.examplemvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
Los módulos sirven para proveer dependencias que no son tan fáciles de obtener
(dependencias de librerías y de clases)
Cuando se crea un módulo se define el alcance que tendrá (por ejemplo, a nivel de una Activity)
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit {
        // función para inyectar retrofit2
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit):QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
    
}