package com.example.fakebook

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class HomeFragment : Fragment(R.layout.activity_home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = Navigation.findNavController(view)
        val action =
        HomeFragmentDirections.actionHomeFragmentToProfileFragment()

        controller.navigate(action)

    }


}