package com.javigigante.feedbackud4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.javigigante.feedbackud4.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "agenda_contactos")
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var saveButton: Button
    private lateinit var consultButton: Button
    private lateinit var consultContainer : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {

            lifecycleScope.launch(Dispatchers.IO) {
                saveUserData(   binding.nameContainer.text.toString(),
                    binding.phoneContainer.text.toString(),
                    binding.fileNameContainer.text.toString())
            }

        }


        binding.consultButton.setOnClickListener {

            val dataFlow : Flow<String> = dataStore.data.map {

                it[stringPreferencesKey("name")]?:"Nombre no encontrado"
                it[stringPreferencesKey("phone")]?: "Teléfono no encontrado"

                it[stringPreferencesKey("file_name")]?: "Nombre de archivo no encontrado"

            }

            GlobalScope.launch(Dispatchers.Main) {

                val text = withContext(Dispatchers.IO) {
                    applicationContext.dataStore.data.first()
            }
                binding.consultContainer.text = text.toString()

            }
        }

    }

    suspend fun saveUserData(nombre : String, tfno : String, archivo : String) {
        dataStore.edit {
            it[stringPreferencesKey("Nombre: ")] = nombre
            it[stringPreferencesKey("Teléfono: ")] = tfno
            it[stringPreferencesKey("Archivo nº: ")] = archivo
        }
    }

}
