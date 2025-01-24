package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel
import javax.inject.Inject

// preparar casos de uso para que se puedan inyectar
class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository,
) {
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}