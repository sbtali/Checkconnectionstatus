package com.alisabet.checkconnectionstatus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //1.get permissions
    //2.make check network static class to check network status
    //3.make NetworkChangeReceiver class to easily handle the changes in network state
    //+ introduce receiver in manifest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val string = CheckNetwork.getConnectivityStatusString(this)
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }
}
