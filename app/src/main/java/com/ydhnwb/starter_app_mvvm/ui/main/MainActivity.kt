package com.ydhnwb.starter_app_mvvm.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.ydhnwb.starter_app_mvvm.R
import com.ydhnwb.starter_app_mvvm.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setup()
    }

    private fun setup(){
        observe()
        onIncrementClick()
        onDecrementClick()
    }

    //observe means: it will executed when the livedata changes
    private fun observe(){
        mainViewModel.listenToNum().observe(this, { handleNumChanges(it) })
    }

    private fun handleNumChanges(num : Int) {
        binding.content.numTextView.text = num.toString()
    }

    private fun onIncrementClick() = binding.content.incrementButton.setOnClickListener {
        mainViewModel.increment()
    }

    private fun onDecrementClick() = binding.content.decrementButton.setOnClickListener {
        mainViewModel.decrement()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}