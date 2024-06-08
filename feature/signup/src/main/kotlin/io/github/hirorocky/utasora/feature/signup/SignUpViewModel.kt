package io.github.hirorocky.utasora.feature.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hirorocky.utasora.domain.SignUpUseCase
import io.github.hirorocky.utasora.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
@Inject
constructor(
    private val signUpUseCase: SignUpUseCase,
) : BaseViewModel() {
    var state by mutableStateOf(SignUpState())
        private set

    fun onEmailChange(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        state = state.copy(password = password)
    }

    fun onPasswordVisibilityToggle(toggleTo: Boolean) {
        state = state.copy(isPasswordVisible = !state.isPasswordVisible)
    }

    fun submit(onSuccess: () -> Unit) {
        state = state.copy(isLoading = true)
        launchCatching {
            signUpUseCase(
                email = state.email,
                password = state.password,
            )
            onSuccess()
        }
    }
}
