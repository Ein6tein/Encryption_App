package com.chernishenko.encryptionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chernishenko.encryptionapp.databinding.ActivityMainBinding
import com.chernishenko.encryptionapp.fragment.DigitsOnlyFragment

@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fl_container, DigitsOnlyFragment(), DigitsOnlyFragment.TAG)
            .commit()
    }
}