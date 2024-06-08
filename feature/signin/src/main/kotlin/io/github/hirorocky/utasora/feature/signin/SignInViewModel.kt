package io.github.hirorocky.utasora.feature.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hirorocky.utasora.domain.SignInUseCase
import io.github.hirorocky.utasora.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
@Inject
constructor(
    private val signInUseCase: SignInUseCase,
) : BaseViewModel() {
    var state by mutableStateOf(SignInState())
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
            signInUseCase(
                email = state.email,
                password = state.password,
            )
            // FIXME: エラー処理
            onSuccess()
        }
    }
}
