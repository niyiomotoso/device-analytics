package com.analytics.device.utils import android.app.usage.UsageEvents import android.app.usage.UsageStatsManager import android.content.Context import android.util.Log import androidx.appcompat.app.AppCompatActivity import com.analytics.device.helpers.DateTimeHelper import com.analytics.device.migrations.AppUsageDatabase import com.analytics.device.models.AppDetails import com.analytics.device.models.AppStats import com.analytics.device.models.AppUsage import com.analytics.device.models.CustomActivityMap import java.time.ZonedDateTime class Helper (var context: Context) { val appUsageDatabase by lazy { AppUsageDatabase.getDatabase(context).appUsageDao() } inner class Helper { suspend fun syncAnalyticsOperation(appDetails: AppDetails) { val currentSystemTimeNow = DateTimeHelper.getSystemCurrentTimeNow() val newUsageInstance = AppUsage( appName = appDetails.appName, packageName = appDetails.packageName, frequency = 0, lastOpenTime = appDetails.lastTimeUsed, createdAt = currentSystemTimeNow ) } } 28
