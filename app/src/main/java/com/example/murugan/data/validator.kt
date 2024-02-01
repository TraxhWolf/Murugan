package com.example.murugan.data

object Validator {
    fun validateUsername(username: String) : ValidationResult{
        return ValidationResult(
            (username.isNotEmpty())
        )
    }
    fun validatePassword(password: String) : ValidationResult{
        return ValidationResult(
            (password.isNotEmpty())
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)