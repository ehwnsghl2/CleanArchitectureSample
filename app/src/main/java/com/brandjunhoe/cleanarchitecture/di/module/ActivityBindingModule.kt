package com.brandjunhoe.cleanarchitecture.di.module

import com.brandjunhoe.presentation.ui.repos.ReposActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(includes = [UseCaseModule::class])
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun bindReposActivity(): ReposActivity


}