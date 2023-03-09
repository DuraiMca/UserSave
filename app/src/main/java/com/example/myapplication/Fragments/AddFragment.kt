package com.example.myapplication.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Model.User
import com.example.myapplication.R
import com.example.myapplication.Viewmodel.UserViewModel


class AddFragment : Fragment(), View.OnClickListener {

  lateinit var submitButton:Button
    lateinit var fName:EditText
    lateinit var lName:EditText
    lateinit var age:EditText
  lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_add, container, false)
        submitButton=view.findViewById(R.id.btnsubmit)
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        fName=view.findViewById(R.id.fname)
        lName=view.findViewById(R.id.Lname)
        age=view.findViewById(R.id.age)
        submitButton.setOnClickListener(this)
         return view;
    }

    override fun onClick(p0: View?) {
        Log.i("TAG", "onClick: "+"ADDED")
   val firstName=fName.text.toString()
   val lastName=lName.text.toString()
   val age =age.text.toString()
        val user=User(0,firstName,lastName,Integer.parseInt(age))
        userViewModel.addUser(user);
        Toast.makeText(requireContext(),"Added",Toast.LENGTH_LONG)
    }


}