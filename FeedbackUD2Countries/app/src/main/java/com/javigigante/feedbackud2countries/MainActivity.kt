package com.javigigante.feedbackud2countries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.javigigante.feedbackud2countries.databinding.ActivityMainBinding
import com.javigigante.feedbackud2countries.model.Country

private lateinit var binding: ActivityMainBinding

private lateinit var adapterList: ArrayAdapter<Country>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryName: TextView = binding.countryName

        val countryList: ArrayList<Country> = ArrayList();
        countryList.add(Country("España", 47.42, "https://hips.hearstapps.com/hmg-prod/images/jose-maria-gutierrez-guti-of-real-madrid-looks-on-prior-to-news-photo-1696326366.jpg"));
        countryList.add(Country("Alemania", 83.20, "https://images.ecestaticos.com/ypwRfg0SEQ4fkF2O0MaQS1CfqOs=/0x0:2272x1515/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F690%2F1dd%2Fa8d%2F6901dda8d147b4719ef2c9dc214f0adf.jpg"));
        countryList.add(Country("Italia", 59.11, "https://fotografias.lasexta.com/clipping/cmsimages01/2020/04/05/18C38B7C-4488-4537-9C4A-AB7D58350559/98.jpg?crop=1200,675,x0,y18&width=1900&height=1069&optimize=low&format=webply"));
        countryList.add(Country("Grecia", 10.64, "https://3.bp.blogspot.com/-GTi7Jwaqd6w/Vb9FSg6A9sI/AAAAAAAADbw/SYMei4L-etA/s1600/Bourousis.jpg"));
        countryList.add(Country("Croacia", 3.90, "https://piks.eldesmarque.com/bin/2022/12/17/celebracion_de_modric.jpg"));
        countryList.add(Country("Portugal", 10.33, "https://imgresizer.eurosport.com/unsafe/1200x0/filters:format(jpeg)/origin-imgresizer.eurosport.com/2017/12/09/2226190-46422630-2560-1440.jpg"));
        countryList.add(Country("Eslovenia", 2.11, "https://www.gigantes.com/wp-content/uploads/2023/12/GettyImages-1836548494-2.jpg"));
        countryList.add(Country("Serbia", 6.83, "https://www.republica.com/wp-content/uploads/2022/10/Predrag-Spasic.jpg"));
        countryList.add(Country("Islandia", 0.37, "https://pbs.twimg.com/media/DliBEagXsAAzE28.jpg"));
        countryList.add(Country("Irlanda", 5.03, "https://ds-images.bolavip.com/news/image/1200/740/?src=https://images.juanfutbol.com/webp/JFB_20220318_JFB_122250_1647565367.webp"));

        adapterList = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, countryList);

        binding.countryListview.adapter = adapterList

        binding.countryListview.setOnItemLongClickListener { _, _, position, _ ->

            countryName.text = countryList[position].toString()
            true
        }

        binding.countryListview.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("country", countryList[position])
            startActivity(intent)
        }

    }
}