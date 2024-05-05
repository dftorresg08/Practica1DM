package com.example.practica1dm

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etResultado= findViewById<TextView>(R.id.txtResultado)
        val etNotalFinal= findViewById<TextView>(R.id.txtNotaFinal)

        val notalFinal = intent.getStringExtra("notaFinal")
        val resultado = intent.getStringExtra("resultado")

        etNotalFinal.text = notalFinal.toString();
        etResultado.text = resultado.toString();


    }
}