package com.example.walmartcodingexercise

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray

object CountryFetcher {
    private const val URL =
        "https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"

    suspend fun fetchCountries(): JSONArray? {
        val client = OkHttpClient()
        val request = Request.Builder().url(URL).build()

        return withContext(Dispatchers.IO) {
            try {
                val response: Response = client.newCall(request).execute()
                val responseBody = response.body?.string()
                responseBody?.let { JSONArray(it) }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}