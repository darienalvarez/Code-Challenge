package com.darienalvarez.codechallenge.system.di

import com.darienalvarez.codechallenge.R
import com.darienalvarez.codechallenge.ui.features.transaction.TransactionsDestination
import com.darienalvarez.codechallenge.ui.features.transaction.TransactionsDestinationImpl
import com.darienalvarez.codechallenge.ui.navigation.NavCommons
import com.darienalvarez.codechallenge.ui.navigation.NavCommonsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
object NavigationModule {

    @ActivityRetainedScoped
    @Provides
    fun provideNavigationCommons(): NavCommons = NavCommonsImpl(R.id.nav_host_fragment)

    @Provides
    fun provideTransactionsDestination(
        navCommons: NavCommons
    ): TransactionsDestination {
        return TransactionsDestinationImpl(navCommons)
    }
}