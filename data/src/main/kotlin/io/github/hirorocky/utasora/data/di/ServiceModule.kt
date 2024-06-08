package io.github.hirorocky.utasora.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hirorocky.utasora.data.AccountService
import io.github.hirorocky.utasora.data.StorageService
import io.github.hirorocky.utasora.data.impl.AccountServiceImpl
import io.github.hirorocky.utasora.data.impl.StorageServiceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun bindAccountService(impl: AccountServiceImpl): AccountService

    @Binds
    abstract fun bindStorageService(impl: StorageServiceImpl): StorageService
}
