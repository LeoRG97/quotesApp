package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()
    // no es corrutina porque se tiene almacenado en memoria
    operator fun invoke():QuoteModel? {
        val quotes: List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}