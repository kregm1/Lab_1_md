package com.example.lab_1
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.util.Patterns
import android.widget.Toast
import com.example.lab_1.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val confirmPassword = findViewById<EditText>(R.id.confirmPassword)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val usernameInput = username.text.toString().trim()
            val emailInput = email.text.toString().trim()
            val passwordInput = password.text.toString()
            val confirmPasswordInput = confirmPassword.text.toString()

            if (validateInput(usernameInput, emailInput, passwordInput, confirmPasswordInput)) {
                // Регистрация пользователя
                Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInput(username: String, email: String, password: String, confirmPassword: String): Boolean {
        when {
            username.isEmpty() -> {
                Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show()
                return false
            }
            email.isEmpty() -> {
                Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
                return false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
                return false
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
                return false
            }
            confirmPassword.isEmpty() -> {
                Toast.makeText(this, "Please confirm your password", Toast.LENGTH_SHORT).show()
                return false
            }
            password != confirmPassword -> {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> return true
        }
    }
}