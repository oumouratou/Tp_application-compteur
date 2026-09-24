package com.example.compteurandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var compteur = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // 2. Récupération des composants graphiques par leur identifiant (ID)
        val txtViewCompteur = findViewById<TextView>(R.id.textViewCompteur)
        val btnIncrementer = findViewById<Button>(R.id.buttonIncrementer)
        val btnDecrementer = findViewById<Button>(R.id.buttonDecrementer)
        val btnReinitialiser = findViewById<Button>(R.id.buttonReinitialiser)
        // 3. Initialisation des événements
        btnIncrementer.setOnClickListener {
            compteur++
            txtViewCompteur.text = compteur.toString()
        }
        btnDecrementer.setOnClickListener {
            compteur--
            txtViewCompteur.text = compteur.toString()
        }
        btnReinitialiser.setOnClickListener {
            compteur = 0
            txtViewCompteur.text = compteur.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}