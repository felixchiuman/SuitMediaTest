package com.felix.suitmedia.di

import com.felix.suitmedia.ui.third.ThirdPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::ThirdPageViewModel)
}