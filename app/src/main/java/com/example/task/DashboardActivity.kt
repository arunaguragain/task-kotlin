package com.example.task

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.adapter.BirdsAdapter
import com.example.task.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    lateinit var adapter: BirdsAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = arrayListOf(
            R.drawable.sparrow,
            R.drawable.pigeon,
            R.drawable.crow,
            R.drawable.dove
        )
        val birdsName = arrayListOf("sparrow","pigeon", "crow", "dove")
        val birdsDesc = arrayListOf("this is sparrow","this is pigeon","this is crow","this is dove")

        val fullName : String = intent.getStringExtra("fullName").toString()
        val email : String = intent.getStringExtra("email").toString()
        val password : String = intent.getStringExtra("password").toString()
        val gender : String = intent.getStringExtra("gender").toString()
        val country: String = intent.getStringExtra("country").toString()
        val city : String = intent.getStringExtra("city").toString()

        binding.nameOutput.text = fullName
        binding.nameEmail.text = email
        binding.outputGender.text = gender
        binding.outputCountry.text = country
        binding.outputCity.text = city

        adapter = BirdsAdapter(
            this@DashboardActivity, imageList,birdsName, birdsDesc
        )

        binding.recyclerViewBirds.adapter = adapter
        binding.recyclerViewBirds.layoutManager = LinearLayoutManager(this@DashboardActivity)
//        binding.recyclerViewBirds.layoutManager = GridLayoutManager(this@DashboardActivity,2)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}