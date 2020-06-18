package com.example.practica1_punto3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_calcular.setOnClickListener {

            val banda1 = sp1.selectedItem.toString()
            val banda2 = sp2.selectedItem.toString()
            val multiplicador = sp3.selectedItem.toString()
            val tolerancia = sp4.selectedItem.toString()
            var b1 = 0
            var b2 = 0
            var mul = 0.0
            var tol = ""
            var aux = ""
            var resistencia = 0.0

            when (banda1) {
                "Negro" -> b1 = 0
                "Marron" -> b1 = 1
                "Rojo" -> b1 = 2
                "Naranja" -> b1 = 3
                "Amarillo" -> b1 = 4
                "Verde" -> b1 = 5
                "Azul" -> b1 = 6
                "Morado" -> b1 = 7
                "Gris" -> b1 = 8
                "Blanco" -> b1 = 9
            }

            when (banda2) {
                "Negro" -> b2 = 0
                "Marron" -> b2 = 1
                "Rojo" -> b2 = 2
                "Naranja" -> b2 = 3
                "Amarillo" -> b2 = 4
                "Verde" -> b2 = 5
                "Azul" -> b2 = 6
                "Morado" -> b2 = 7
                "Gris" -> b2 = 8
                "Blanco" -> b2 = 9
            }

            when (multiplicador) {
                "Negro" -> mul = 1.0
                "Marron" -> mul = 10.0
                "Rojo" -> mul = 100.0
                "Naranja" -> mul = 1000.0
                "Amarillo" -> mul = 10000.0
                "Verde" -> mul = 100000.0
                "Azul" -> mul = 1000000.0
                "Morado" -> mul = 10000000.0
                "Dorado" -> mul = 0.1
                "Plateado" -> mul = 0.01
            }

            when (tolerancia) {
                "Marron" -> tol = "±1%"
                "Rojo" -> tol = "±2%"
                "Verde" -> tol = "±0.5%"
                "Azul" -> tol = "±0.25%"
                "Morado" -> tol = "±0.10%"
                "Gris" -> tol = "±0.05%"
                "Dorado" -> tol = "±5%"
                "Plateado" -> tol = "±10%"
            }
            aux = b1.toString() + b2.toString()
            resistencia = aux.toDouble() * mul

            if (resistencia / 1000 < 1) {
                tv_resultado.text = "La Resistencia es de : $resistencia Ω " + tol
            } else if (resistencia / 1000 < 1000) {
                resistencia /= 1000
                tv_resultado.text = "La Resistencia es de : $resistencia KΩ " + tol
            } else if (resistencia / 1000000 < 1000000) {
                resistencia /= 1000000
                tv_resultado.text = "La Resistencia es de : $resistencia MΩ " + tol
            } else if (resistencia / 1000000000 < 1000000000) {
                resistencia /= 1000000000
                tv_resultado.text = "La Resistencia es de : $resistencia GΩ " + tol
            }
        }

    }
}