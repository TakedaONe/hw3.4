package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContinentsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContinentsAdapter

    private val continents = listOf(
        Continent("Африка"),
        Continent("Азия"),
        Continent("Европа"),
        Continent("Северная Америка"),
        Continent("Южная Америка"),
        Continent("Австралия"),
        Continent("Антарктида")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_continents, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewContinents)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ContinentsAdapter(continents) { continent ->
            (activity as MainActivity).showCountriesFragment(continent)
        }
        recyclerView.adapter = adapter

        return view
    }
}
