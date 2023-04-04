package com.juniorkekod.disneyplusclonekekod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juniorkekod.disneyplusclonekekod.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigationView.getOrCreateBadge(R.id.menuBottomNavigationItemTracing).apply {
            number = 41
            isVisible = true
        }  // TODO (Ahmet) ---> It will be deleted or moved.

    }
}