package com.rafsan.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.rafsan.newsapp.databinding.ActivityLoginBinding
import com.rafsan.newsapp.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var textlogin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        textlogin = binding.textdata
        emailInputLayout = binding.emailInputLayout
        passwordInputLayout = binding.passwordInputLayout
        emailEditText = binding.emailEditText
        passwordEditText = binding.passwordEditText

        val loginButton = binding.loginButton

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty()) {
                emailInputLayout.error = "Email is required"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordInputLayout.error = "Password is required"
                return@setOnClickListener
            }

            // Predefined credentials for testing
            val predefinedEmail = "test@android.com"
            val predefinedPassword = "123456"

            if (email == predefinedEmail && password == predefinedPassword) {
                // Credentials are correct, proceed with login logic
                // For simplicity, let's just display a toast message here
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Invalid credentials, display an error message
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
