package com.example.taskwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.taskwork.adapter.MainAdapter
import com.example.taskwork.dao.ItemDao
import com.example.taskwork.database.ItemDatabase
import com.example.taskwork.database.MainViewModel
import com.example.taskwork.database.MainViewModelFactory
import com.example.taskwork.databinding.ActivityMainBinding
import com.example.taskwork.pagination.MainLoadStateAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dao: ItemDao
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(dao) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dao = ItemDatabase.getInstance(this).itemDao()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MainAdapter()
        binding.recyclerView.adapter = adapter.withLoadStateFooter(
            MainLoadStateAdapter()
        )

        lifecycleScope.launch {
            viewModel.data.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}