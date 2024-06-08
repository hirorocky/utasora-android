package io.github.hirorocky.utasora.domain

import io.github.hirorocky.utasora.data.AccountService
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val accountService: AccountService
) {
    suspend operator fun invoke() {
        accountService.signOut()
    }
}