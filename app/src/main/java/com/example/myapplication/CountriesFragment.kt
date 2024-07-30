package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountriesAdapter

    private val countriesMap = mapOf(
        "Африка" to listOf("Египет", "ЮАР", "Нигерия"),
        "Азия" to listOf("Китай", "Индия", "Япония"),
        "Европа" to listOf("Франция", "Германия", "Италия"),
        "Северная Америка" to listOf("США", "Канада", "Мексика"),
        "Южная Америка" to listOf("Бразилия", "Аргентина", "Чили"),
        "Австралия" to listOf("Австралия", "Новая Зеландия"),
        "Антарктида" to listOf()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_countries, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewCountries)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Получаем выбранный континент из аргументов
        val continentName = arguments?.getString("continent") ?: ""
        val countries = countriesMap[continentName]?.map { Country(it, continentName) } ?: emptyList()

        adapter = CountriesAdapter(countries)
        recyclerView.adapter = adapter

        return view
    }

    companion object {
        fun newInstance(continent: Continent): CountriesFragment {
            val fragment = CountriesFragment()
            val args = Bundle()
            args.putString("continent", continent.name)
            fragment.arguments = args
            return fragment
        }
    }
}
