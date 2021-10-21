package com.example.homework1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.homework1.databinding.FragmentBBinding
import com.example.homework1.model.FakeObject


class BFragment : Fragment() {

    private lateinit var binding: FragmentBBinding
    private val fake: FakeObject
        get() = requireArguments().getSerializable(ARG_FAKE) as FakeObject

    companion object {
        private const val ARG_FAKE = "ARG_FAKE"
        fun newInstance(fakeObject: FakeObject): BFragment {
            val fragment = BFragment()
            fragment.arguments = bundleOf(ARG_FAKE to fakeObject)
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        binding.firstName.text = fake.firstName
        binding.lastName.text = fake.lastName
        return binding.root
    }
}