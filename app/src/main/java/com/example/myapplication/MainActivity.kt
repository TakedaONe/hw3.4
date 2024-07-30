package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ContinentsFragment())
                .commit()
        }
    }

    fun showCountriesFragment(continent: Continent) {
        val countriesFragment = CountriesFragment.newInstance(continent)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, countriesFragment)
            .addToBackStack(null) // Добавляем в backstack для возможности вернуться назад
            .commit()
    }
}
data class Continent(val name: String)

data class Country(val name: String, val continent: String)

