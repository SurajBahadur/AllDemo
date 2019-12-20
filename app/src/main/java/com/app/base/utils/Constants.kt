package com.app.base.utils

/**
 * Created by android on 2/11/17.
 */
object Constants {



    const val REQUEST_CAMERA = 1
    const val REQUEST_VIDEO = 132
    const val REQUEST_GALLERY = 291
    const val RECORD_VIDEO = 292

    const val IS_LOGGED_IN = "is_logged_in"
    const val BASE_URL = "http://ec2-18-225-33-244.us-east-2.compute.amazonaws.com/hitmelocal/public/api/"
    const val LOGIN = "login"
    const val TOKEN = "token"
    const val PERMISSION_READ_EXTERNAL_STORAGE = 123
    const val PERMISSION_REQUEST_CODE = 98
    const val LOCATION_PERMISSION_REQUEST_CODE = 101


    const val HANDLER_DELAY_TIME: Long = 2000


    const val APP_HIDDEN_FOLDER = "/.besttyme"



    internal interface httpcodes {
        companion object {
            val STATUS_OK = 200
            val STATUS_BAD_REQUEST = 400
            val STATUS_SESSION_EXPIRED = 401
            val STATUS_PLAN_EXPIRED = 403
            val STATUS_VALIDATION_ERROR = 404
            val STATUS_SERVER_ERROR = 500
            val STATUS_UNKNOWN_ERROR = 503
            val STATUS_API_VALIDATION_ERROR = 422

        }
    }


    const val IS_LOGOUT = "is_logout"
    //FAILURE MESSAGES
    const val SOMETHING_WENT_WRONG = "Something went wrong please try again later!"
    const val FAILURE_TIME_OUT_ERROR = "Request time out!"
    const val FAILURE_SOMETHING_WENT_WRONG = "Something went wrong please try again later!"
    const val FAILURE_SERVER_NOT_RESPONDING = "Oops! looks like we are having internal problems. Please try again later."
    const val FAILURE_INTERNET_CONNECTION = "Internet connection appears to be offline. Please check your network settings."
    const val SESSION_EXPIRED = "Sorry, looks like you are logged in another device with the same user."


    //doctor appointment type enum
    enum class TYPE(val type: Int) {
        SIMPLE(0), BREAKFAST(1), LUNCH(2), TASK(3), UNVERIFIEDOCTOR(4)
    }

    enum class WEEK(val type: Int) {
        MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6)
    }


}