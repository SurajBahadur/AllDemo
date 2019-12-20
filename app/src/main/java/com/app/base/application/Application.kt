package com.app.base.application

import Preferences
import android.app.Application
import android.content.Context

/**
 * Created by android on 3/11/17.
 */
class Application : Application() {

    var mContext: Context? = null


    companion object AppContext {
        lateinit var instance: com.app.base.application.Application
         fun getContext(): Context {
            return instance
        }
    }

    init {
        instance = this
    }


    override fun onCreate() {
        super.onCreate()
        Preferences.initPreferences(this)
        mContext = applicationContext
    }


}
