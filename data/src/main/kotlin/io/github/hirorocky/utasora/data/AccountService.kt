package io.github.hirorocky.utasora.data

import io.github.hirorocky.utasora.model.User
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUser: Flow<User?>
    val currentUserId: String

    fun hasUser(): Boolean

    suspend fun signIn(
        email: String,
        password: String,
    )

    suspend fun signUp(
        email: String,
        password: String,
    ): String

    suspend fun signOut()

    suspend fun deleteAccount()
}
