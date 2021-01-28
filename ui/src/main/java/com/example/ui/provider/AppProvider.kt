package com.example.ui.provider

import android.content.Context
import android.content.Intent
import com.example.ui.model.AppModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AppProvider @Inject constructor(@ApplicationContext val context: Context) {

    fun getInstalledApps(): Flow<List<AppModel>> {
        return flow {
            val intent = Intent(Intent.ACTION_MAIN, null).apply {
                addCategory(Intent.CATEGORY_LAUNCHER)
            }
            val appList = mutableListOf<AppModel>()
            val packageList = context.packageManager.queryIntentActivities(intent, 0)
            packageList.forEach { appInfo ->
                val appData = AppModel(
                    appName = appInfo.loadLabel(context.packageManager) as String,
                    appIcon = appInfo.loadIcon(context.packageManager)
                )
                appList.add(appData)
            }
            emit(appList)

        }
    }
}