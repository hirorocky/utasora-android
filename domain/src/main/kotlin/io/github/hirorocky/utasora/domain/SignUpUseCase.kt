package io.github.hirorocky.utasora.domain

import io.github.hirorocky.utasora.data.AccountService
import io.github.hirorocky.utasora.data.StorageService
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val accountService: AccountService,
    private val storageService: StorageService,
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ) {
        val userId = accountService.signUp(
            email = email,
            password = password,
        )
        // FIXME: エラー処理
        if (userId.isNotEmpty()) {
            storageService.createUser(userId = userId)
            // FIXME: エラー処理
        }
        accountService.signIn(
            email = email,
            password = password,
        )
    }
}