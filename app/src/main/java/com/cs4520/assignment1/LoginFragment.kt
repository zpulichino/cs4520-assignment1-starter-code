package com.cs4520.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment() {
    private lateinit var userNameET : EditText
    private lateinit var passwordET : EditText
    private lateinit var loginButton : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        userNameET = view.findViewById(R.id.etUsername)
        passwordET = view.findViewById(R.id.etPassword)
        loginButton = view.findViewById(R.id.btnLogin)

        loginButton.setOnClickListener {
            val username = userNameET.text.toString()
            val password = passwordET.text.toString()

            if (username == "admin" && password == "admin") {
                userNameET.text.clear()
                passwordET.text.clear()

                findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
            } else {
                Toast.makeText(activity, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}