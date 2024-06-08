package io.github.hirorocky.utasora.domain

import io.github.hirorocky.utasora.data.AccountService
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val accountService: AccountService
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ) {
        accountService.signIn(
            email = email,
            password = password,
        )
    }
}