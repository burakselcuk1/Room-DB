package com.example.myapplicationbvbv.fragments.add

import android.os.Bundle
import android.os.UserHandle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplicationbvbv.R
import com.example.myapplicationbvbv.data.User
import com.example.myapplicationbvbv.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mUserviewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserviewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        view.add_btn.setOnClickListener {

            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
    val firstName = addFirstName_et.text.toString()
    val lastName = addLastName_et.text.toString()
    val age = addAge_et.text

    if (InputCheck(firstName, lastName, age)){
        //Create new user
        val user = User(0,firstName,lastName,Integer.parseInt(age.toString()) )
        // Add to databse
        mUserviewModel.addUser(user)
        Toast.makeText(requireContext()," Successfully added!", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }else{
        Toast.makeText(requireContext()," NOTHING HAPPEN!", Toast.LENGTH_SHORT).show()

    }

    }

    private fun InputCheck(firstName: String, lastName: String, age: Editable): Boolean{

        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}