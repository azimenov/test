package com.example.test.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.test.databinding.FragmentActivityBinding


class ActivityFragment : Fragment() {
    private var _binding: FragmentActivityBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ActivityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivityBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.activity.observe(viewLifecycleOwner){
            binding.activityName.text = it.activity
            binding.activityType.text = it.type
            binding.activityPrice.text = "Price: ${it.price}"
            binding.activityAccess.text = "How easy it is: ${it.accessibility}"
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getRandomActivity()
    }
}
