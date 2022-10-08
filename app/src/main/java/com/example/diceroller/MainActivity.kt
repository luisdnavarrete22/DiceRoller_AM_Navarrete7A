package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/*
   APP DICE ROLLER DESARROLLADA EN KOTLIN
   Realizado por: Luis David Navarrete Cevallos el 08/10/2022.
   Curso: 7mo Nivel, Paralelo "A"
   Asignatura: Aplicaciones Móviles
   Docente: Ing. Joffre Edgardo Panchana Flores
 */

/*
    Esta actividad permite al usuario lanzar el dado y
    ver el resultado en la pantalla.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* Agregamos las siguientes líneas de código para hacer
           funcionar al botón "Lanzar" de la app Dice Roller.
         */
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener() { rollDice() }
    }

    // Hacemos privada a la función de lanzar el dado.
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Encuentra el 'ImageView' en el 'layout'.
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determina que ID de la imagen será usado basado en el lanzamiento del dado.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Actualiza 'ImageView' con el ID correcto de las imágenes.
        diceImage.setImageResource(drawableResource)

        // Actualiza la descripción de contenido.
        diceImage.contentDescription = diceRoll.toString()
    }
}

/* Creamos la clase Dado mediante la cual realizamos la lógica
   de los números aleatorios.
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}