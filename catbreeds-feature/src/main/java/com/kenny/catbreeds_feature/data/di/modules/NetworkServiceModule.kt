package com.kenny.catbreeds_feature.data.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object NetworkServiceModule {

   /* @Provides
    fun provideUsersService(@RetrofitBasic retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }*/
}