package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.ListAdapter
import com.example.myapplication.R
import com.example.myapplication.Viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment(), View.OnClickListener {
 lateinit var floatin: FloatingActionButton;
    lateinit var recyclerView: RecyclerView
    lateinit var userViewModel: UserViewModel
    val adapter=ListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)
        floatin=view.findViewById(R.id.floatingActionButton2);
        floatin.setOnClickListener(this)
        recyclerView=view.findViewById(R.id.recyler)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.readAllData.observe(viewLifecycleOwner,Observer{
            user->
             adapter.setData(user)
        })
        return view;
    }

    override fun onClick(p0: View?) {
      findNavController().navigate(R.id.action_listFragment_to_addFragment)
    }


}