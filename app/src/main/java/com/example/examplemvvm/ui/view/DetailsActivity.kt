package com.example.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examplemvvm.R
import com.example.examplemvvm.databinding.ActivityDetailsBinding
import com.example.examplemvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_details)

        binding.btnSave.setOnClickListener {
            saveName()
        }
    }

    private fun saveName() {
        var name = binding.etName.text.toString()
        Toast.makeText(this, "$name saved to storage", Toast.LENGTH_SHORT).show()
    }
}