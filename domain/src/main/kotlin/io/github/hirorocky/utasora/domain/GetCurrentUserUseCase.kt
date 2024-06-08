package io.github.hirorocky.utasora.domain

import io.github.hirorocky.utasora.data.AccountService
import io.github.hirorocky.utasora.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val accountService: AccountService
) {
    operator fun invoke(): Flow<User?> {
        return accountService.currentUser
    }
}