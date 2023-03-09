package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment(), View.OnClickListener {
 lateinit var floatin: FloatingActionButton;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)
        floatin=view.findViewById(R.id.floatingActionButton2);
        floatin.setOnClickListener(this)
        return view;
    }

    override fun onClick(p0: View?) {
      findNavController().navigate(R.id.action_listFragment_to_addFragment)
    }


}