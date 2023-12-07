package com.example.lesson35

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson35.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageChoose()
        setupCounter()
        binding.number.text = Counter.count.toString()
    }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { changeImage: Uri? ->
            binding.enterImage.setImageURI(changeImage)
        }

    private fun imageChoose() {
        binding.enterImage.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    private fun setupCounter() = with(binding) {
        buttonPlus.setOnClickListener {
            number.text = (++Counter.count).toString()
            if (Counter.count == 11) {
                val intent1 = Intent(this@MainActivity, SecondActivity::class.java)

                startActivity(intent1)
            }
        }

        binding.buttonMin.setOnClickListener {
            number.text = (--Counter.count).toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.apply {
            val saved = Saved(binding.enterImage)
            putSerializable(SAVE_KEY, saved)
        }
    }

    companion object {
        const val SAVE_KEY = "saved_image"
    }

}