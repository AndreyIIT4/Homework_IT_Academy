package com.example.homework1

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.homework1.databinding.FragmentABinding
import com.example.homework1.model.contract
import kotlin.contracts.contract

class AFragment : Fragment() {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        val fakes = contract().fakeService.fakes
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, fakes)
        binding.listFake.adapter = adapter
        binding.listFake.setOnItemClickListener { _, _, position, _ ->
            val currentFake = adapter.getItem(position)
            contract().fakeLastName(currentFake!!)
        }

        return binding.root
    }

}