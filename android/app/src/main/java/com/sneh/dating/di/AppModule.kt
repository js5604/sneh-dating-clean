package com.sneh.dating.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.sneh.dating.data.repository.*
import com.sneh.dating.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: FirebaseAuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindDiscoveryRepository(impl: FirestoreDiscoveryRepositoryImpl): DiscoveryRepository

    @Binds
    @Singleton
    abstract fun bindSafetyRepository(impl: FirestoreSafetyRepositoryImpl): SafetyRepository

    @Binds
    @Singleton
    abstract fun bindChatRepository(impl: FirestoreChatRepositoryImpl): ChatRepository

    @Binds
    @Singleton
    abstract fun bindProfileRepository(impl: FirestoreProfileRepositoryImpl): ProfileRepository

    @Binds
    @Singleton
    abstract fun bindPrivacyRepository(impl: FirestorePrivacyRepositoryImpl): PrivacyRepository
}
