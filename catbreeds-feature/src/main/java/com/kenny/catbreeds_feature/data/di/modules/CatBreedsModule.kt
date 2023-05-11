package com.kenny.catbreeds_feature.data.di.modules

import com.kenny.catbreeds_feature.data.remote.api.CatBreedsService
import com.kenny.catbreeds_feature.data.repository.CatBreedsRepositoryImpl
import com.kenny.catbreeds_feature.domain.repository.CatBreedsRepository
import com.kenny.catbreeds_feature.domain.usecase.GetCatBreedsUseCase
import com.kenny.catbreeds_feature.domain.usecase.getCatBreeds
import com.kenny.core.network.qualifers.RetrofitBasic
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [CatBreedsModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object CatBreedsModule {

    @Provides
    fun provideGetCatBreedsUseCase(
        catBreedsRepository: CatBreedsRepository
    ): GetCatBreedsUseCase {
        return GetCatBreedsUseCase {
            getCatBreeds(catBreedsRepository)
        }
    }

    @Provides
    fun provideCatBreedsService(@RetrofitBasic retrofit: Retrofit): CatBreedsService {
        return retrofit.create(CatBreedsService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindCatBreedsRepository(impl: CatBreedsRepositoryImpl): CatBreedsRepository
    }
}