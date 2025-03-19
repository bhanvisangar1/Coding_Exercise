package com.example.walmartcodingexercise

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchCountriesData()
    }

    private fun fetchCountriesData() {
        // Launch coroutine on the Main thread (UI thread)
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val countriesJsonArray = CountryFetcher.fetchCountries()

                if (countriesJsonArray != null && countriesJsonArray.length() > 0) {
                    val countries = parseCountries(countriesJsonArray)

                    // Update RecyclerView with the fetched data
                    countryAdapter = CountryAdapter(countries)
                    recyclerView.adapter = countryAdapter
                } else {
                    Log.e("Error", "No countries fetched or empty data.")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("MainActivity", "Error fetching countries", e)
            }
        }
    }

    private fun parseCountries(countriesJsonArray: JSONArray): List<Country> {
        val countryList = mutableListOf<Country>()
        for (i in 0 until countriesJsonArray.length()) {
            try {
                val countryJson = countriesJsonArray.getJSONObject(i)
                val name = countryJson.getString("name")
                val region = countryJson.getString("region")
                val code = countryJson.getString("code")
                val capital = countryJson.optString("capital", "N/A")

                countryList.add(Country(name, region, code, capital))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return countryList
    }
}