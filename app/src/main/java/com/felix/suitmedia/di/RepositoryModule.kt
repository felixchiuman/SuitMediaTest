package com.felix.suitmedia.di

import com.felix.suitmedia.data.api.repository.Repository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {

    singleOf(::Repository)
}