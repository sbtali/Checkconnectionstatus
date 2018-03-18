package com.alisabet.checkconnectionstatus

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Ali on 3/18/2018.
 */
class CheckNetwork {
    companion object {
        val TYPE_WIFI = 1
        val TYPE_MOBILE = 2
        val TYPE_NOT_CONNECTED = 0
        fun getConnectivityStatus(context: Context): Int {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            if (null != activeNetwork) {
                if (activeNetwork.type == ConnectivityManager.TYPE_WIFI)
                    return TYPE_WIFI
                if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
                    return TYPE_MOBILE
            }
            return TYPE_NOT_CONNECTED
        }
        fun getConnectivityStatusString(context: Context): String? {
            val conn = getConnectivityStatus(context)
            var status: String? = null
            if (conn == TYPE_WIFI) {
                status = "Wifi enabled"
            } else if (conn == TYPE_MOBILE) {
                status = "Mobile data enabled"
            } else if (conn == TYPE_NOT_CONNECTED) {
                status = "Not connected to Internet"
            }
            return status
        }
    }
}