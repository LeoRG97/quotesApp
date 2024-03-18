package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository,
    private val QuoteProvider: QuoteProvider,
) {
    // no es corrutina porque se tiene almacenado en memoria
    operator fun invoke():QuoteModel? {
        val quotes: List<QuoteModel> = QuoteProvider.quotes // El provider también se inyecta
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}