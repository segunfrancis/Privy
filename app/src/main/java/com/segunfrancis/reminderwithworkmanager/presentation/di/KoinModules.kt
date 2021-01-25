package com.segunfrancis.reminderwithworkmanager.presentation.di

import androidx.room.Room
import com.segunfrancis.reminderwithworkmanager.data.source.LocalSource
import com.segunfrancis.reminderwithworkmanager.framework.db.SecretDatabase
import com.segunfrancis.reminderwithworkmanager.framework.source.LocalSourceImpl
import com.segunfrancis.reminderwithworkmanager.presentation.ui.MainViewModel
import com.segunfrancis.reminderwithworkmanager.presentation.ui.add.AddSecretViewModel
import com.segunfrancis.reminderwithworkmanager.presentation.ui.secret.SecretListViewModel
import com.segunfrancis.reminderwithworkmanager.presentation.util.AppConstants.DATABASE_NAME
import com.segunfrancis.reminderwithworkmanager.usecase.AddSecretUseCase
import com.segunfrancis.reminderwithworkmanager.usecase.GetAllSecretsUseCase
import com.segunfrancis.reminderwithworkmanager.usecase.RemoveAllSecretsUseCase
import com.segunfrancis.reminderwithworkmanager.usecase.RemoveSecretUseCase
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
