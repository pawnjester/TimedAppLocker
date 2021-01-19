package com.example.data.repository

import com.example.domain.models.AppDomain
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl : MainRepository {

    override fun getInstalledApps(): Flow<List<AppDomain>> {
        return flow {

        }
    }
}