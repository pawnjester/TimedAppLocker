package com.example.domain.repository

import com.example.domain.models.AppDomain
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getInstalledApps() : Flow<List<AppDomain>>
}