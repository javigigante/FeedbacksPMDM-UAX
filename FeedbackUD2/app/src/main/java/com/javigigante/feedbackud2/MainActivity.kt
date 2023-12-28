package com.javigigante.feedbackud2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import com.javigigante.feedbackud2.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val flagImg: ImageView = binding.flagImg
        val countriesRG: RadioGroup = binding.radioGroup

        countriesRG.setOnCheckedChangeListener { _, checkedId ->
            val selRB: RadioButton = findViewById(checkedId)
            val selCountry = selRB.text.toString()

            val flagId = getFlagRId(selCountry)
            flagImg.setImageResource(flagId)
        }
    }

    private fun getFlagRId(country: String): Int {
        return when (country) {
            "ESPAÑA" -> R.drawable.esp
            "ALEMANIA" -> R.drawable.ger
            "ITALIA" -> R.drawable.ita
            "GRECIA" -> R.drawable.grc
            "CROACIA" -> R.drawable.hrv
            "PORTUGAL" -> R.drawable.por
            "ESLOVENIA" -> R.drawable.svn
            "SERBIA" -> R.drawable.srb
            "ISLANDIA" -> R.drawable.isl
            "IRLANDA" -> R.drawable.irl

            else -> R.drawable.uax
        }
    }
}
