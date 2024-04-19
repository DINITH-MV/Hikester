package com.example.hikester

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class homeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dropdown = view.findViewById<Spinner>(R.id.spinner1)
        val items = resources.getStringArray(R.array.distance)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items)
        dropdown.adapter = adapter

        val dropdown1 = view.findViewById<Spinner>(R.id.spinner2)
        val items1 = resources.getStringArray(R.array.Activity)
        val adapter1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items1)
        dropdown1.adapter = adapter1

        val dropdown2 = view.findViewById<Spinner>(R.id.spinner3)
        val items2 = resources.getStringArray(R.array.Difficulty)
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items2)
        dropdown2.adapter = adapter2

        dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = items[position]
                // Handle the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }
    }

}