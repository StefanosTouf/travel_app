package com.steft.travel_app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.steft.travel_app.R
import com.steft.travel_app.databinding.FragmentCustomerInfoBinding


class CustomerInfo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bind = FragmentCustomerInfoBinding.inflate(layoutInflater)

        //Traveller Book bundle
        bind.bookBundleCustInfoButton.setOnClickListener {
            Toast.makeText(requireContext(), "Bundle Booked!", Toast.LENGTH_LONG)
            findNavController().navigate(R.id.action_customerInfo_to_locations)
        }

        return bind.root
    }


}