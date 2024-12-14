package com.example.task

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isEmpty
import com.example.task.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val countries = arrayOf("Nepal", "India", "China", "USA", "Canada", "Australia")
    val cities = arrayOf("Kathmandu", "Lalitpur", "Pokhara", "Dharan", "Butwal")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item))
        binding.countryDropDown.adapter = countryAdapter

        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        binding.countryAutoComplete.setAdapter(cityAdapter)
        binding.countryAutoComplete.threshold =1

        binding.btnSubmit.setOnClickListener {
            val fullName: String = binding.fullName.editText?.text.toString()
            val email: String = binding.email.editText?.text.toString()
            val password: String = binding.password.toString()
            val isMale = binding.radioButtonMale.isChecked
            val isFemale = binding.radioButtonFemale.isChecked
            val country =  binding.countryDropDown.selectedItem?.toString() ?:""
            val city = binding.countryAutoComplete.text.toString()
            val agreedTerms = binding.checkBoxTermsAndCondition.isChecked

            val gender = when {
                isMale -> "Male"
                isFemale -> "Female"
                else -> ""
            }

            if (binding.fullName.isEmpty()) {
                binding.fullName.error = "name can't be empty"
            } else if (binding.email.isEmpty()) {
                binding.email.error = "email can't be empty"
            } else if (binding.password.isEmpty()) {
                binding.fullName.error = "password can't be empty"
            }else if(!isMale&& !isFemale) {
                Toast.makeText(this, "please select a gender", Toast.LENGTH_SHORT).show()
            }else if(!agreedTerms){
                Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@MainActivity, DashboardActivity::class.java)
                intent.putExtra("fullName", fullName)
                intent.putExtra("email", email)
                intent.putExtra("gender", gender)
                intent.putExtra("country", country)
                intent.putExtra("city", city)

                startActivity(intent)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}