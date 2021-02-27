package com.segunfrancis.privy.presentation.di

import androidx.room.Room
import com.segunfrancis.privy.data.source.LocalSource
import com.segunfrancis.privy.framework.db.SecretDatabase
import com.segunfrancis.privy.framework.source.LocalSourceImpl
import com.segunfrancis.privy.presentation.ui.MainViewModel
import com.segunfrancis.privy.presentation.ui.add.AddSecretViewModel
import com.segunfrancis.privy.presentation.ui.secret.SecretListViewModel
import com.segunfrancis.privy.presentation.util.AppConstants.DATABASE_NAME
import com.segunfrancis.privy.usecase.AddSecretUseCase
import com.segunfrancis.privy.usecase.GetAllSecretsUseCase
import com.segunfrancis.privy.usecase.RemoveAllSecretsUseCase
import com.segunfrancis.privy.usecase.RemoveSecretUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single { Dispatchers.IO }
    single {
        Room.databaseBuilder(androidApplication(), SecretDatabase::class.java, DATABASE_NAME).build()
    }
    single<LocalSource> { LocalSourceImpl(get()) }
    single { AddSecretUseCase(get(), get()) }
    single { RemoveSecretUseCase(get(), get()) }
    single { RemoveAllSecretsUseCase(get(), get()) }
    single { GetAllSecretsUseCase(get(), get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { AddSecretViewModel(get()) }
    viewModel { SecretListViewModel(get(), get(), get()) }
}
