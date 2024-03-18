package com.example.examplemvvm.data.network

import com.example.examplemvvm.core.RetrofitHelper
import com.example.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api: QuoteApiClient
) {

    // private val retrofit = RetrofitHelper.getRetrofit()
    
    suspend fun getQuotes(): List<QuoteModel> {
        // ejecuta la llamada en un hilo secundario
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
            response.body() ?: emptyList() // si la response es nula, devuelve una lista vacía
        }
    }
}