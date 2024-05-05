package com.example.practica1dm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etExamenParcial: EditText = findViewById(R.id.txtParcial)
        val etExamenFinal: EditText = findViewById(R.id.txtFinal)
        val etProm: EditText = findViewById(R.id.txtProm)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener{
            this.sendMessage(etExamenParcial.text.toString(),etExamenFinal.text.toString(),etProm.text.toString())
        }

    }

    private fun sendMessage(examenParcial: String,examenFinal: String,pep: String){
        val porcentajeParcial = 0.20
        val porcentajeFinal = 0.20
        val porcentajePEP = 0.60

        val notaFinal =   (examenParcial.toDouble() * porcentajeParcial) + (examenFinal.toDouble() * porcentajeFinal) + (pep.toDouble() * porcentajePEP)

        var resultado = ""
        if (notaFinal > 10.5){
            resultado = "Aprobado"
        }else{
            resultado = "Desaprobado"
        }

        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("resultado",resultado)
        intent.putExtra("notaFinal",notaFinal.toString())
        startActivity(intent)
    }

}