package com.example.test.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.test.R
import com.example.test.databinding.FragmentJokesBinding
import com.example.test.databinding.JokeItemBinding
import com.example.test.network.ApiClient
import kotlinx.coroutines.launch

class RandomJokeFragment : Fragment() {
    private var _binding: JokeItemBinding? = null
    private val binding get() = _binding!!
    private val viewModel: JokeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = JokeItemBinding.inflate(inflater, container, false)
        viewModel.getJokeList()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val data = ApiClient.getRandomJoke()
            binding.jokeSetUp.text = data.setup
            binding.jokePunchline.text = data.punchline
        }
    }

}
