package io.github.hirorocky.utasora.domain

import io.github.hirorocky.utasora.data.AccountService
import javax.inject.Inject

class CheckHasUserUseCase @Inject constructor(
    private val accountService: AccountService
) {
    operator fun invoke(): Boolean = accountService.hasUser()
}