package com.javigigante.feedbackud2countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import com.bumptech.glide.Glide
import com.javigigante.feedbackud2countries.databinding.ActivityDetailBinding
import com.javigigante.feedbackud2countries.model.Country

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var country: Country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        country = intent.extras!!.getSerializable("country") as Country

        binding.countryName.text = country.countryName
        binding.countryPopulation.text = country.population.toString()

        Glide.with(applicationContext)
            .load(country.img)
            .placeholder(R.drawable.placeholder)
            .into(binding.countryImg)

        //binding.countryImg.setImageResource(country.img)

        val backButton: Button = binding.backButton

        backButton.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}