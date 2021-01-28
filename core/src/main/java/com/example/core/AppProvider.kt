package com.example.core

import android.content.Context
import android.content.Intent
import com.example.domain.models.AppDomain
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppProvider @Inject constructor(
    @ApplicationContext val context: Context
) {

//    fun getInstalledApps() : Flow<List<AppDomain>> {
//        val intent = Intent(Intent.ACTION_MAIN, null).apply {
//            addCategory(Intent.CATEGORY_LAUNCHER)
//        }
//        val appList = mutableListOf<AppDomain>()
//        val packageList = context.packageManager.queryIntentActivities(intent, 0)
//        packageList.forEach { appInfo ->
//            val appData = AppDomain(
//
//            )
//        }
//    }
}