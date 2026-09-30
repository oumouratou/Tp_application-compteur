package com.example.compteurandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var compteur: Int = 0
    private lateinit var textViewCompteur: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        textViewCompteur = findViewById(R.id.textViewCompteur)
        val buttonIncrementer = findViewById<Button>(R.id.buttonIncrementer)
        val buttonDecrementer = findViewById<Button>(R.id.buttonDecrementer)
        val buttonReinitialiser = findViewById<Button>(R.id.buttonReinitialiser)


        if (savedInstanceState != null) {
            compteur = savedInstanceState.getInt("KEY_COMPTEUR", 0)
        }

        actualiserAffichage()


        buttonIncrementer.setOnClickListener {
            compteur++
            actualiserAffichage()
        }


        buttonDecrementer.setOnClickListener {
            compteur--
            actualiserAffichage()
        }


        buttonReinitialiser.setOnClickListener {
            compteur = 0
            actualiserAffichage()
            Toast.makeText(this, getString(R.string.toast_reinitialisation), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("KEY_COMPTEUR", compteur)
    }

    private fun actualiserAffichage() {
        textViewCompteur.text = compteur.toString()

        when {
            compteur > 0 -> textViewCompteur.setTextColor(ContextCompat.getColor(this, R.color.compteur_positif))
            compteur < 0 -> textViewCompteur.setTextColor(ContextCompat.getColor(this, R.color.compteur_negatif))
            else -> textViewCompteur.setTextColor(ContextCompat.getColor(this, R.color.compteur_neutre))
        }
    }
}