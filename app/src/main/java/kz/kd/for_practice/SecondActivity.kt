package kz.kd.for_practice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        adb shell am start -a android.intent.action.VIEW -d "www.example.com/auth?email=azat@gmail.com&code=1234"
//        handleDeepLink()
    }

    private fun handleDeepLink() {
        if (intent?.action != Intent.ACTION_VIEW) return //не выполнять нижние строки если условие не выполниться

        val action: String? = intent?.action
        val data: Uri? = intent?.data

        // 1 прямой
        data?.path // /gizmos

        //2 Приводим в data класс
        val helper = DeepLinkHelper
        intent.dataString?.toUri()?.let {
            when (val item = helper.getItemByUri(it)) {
                is DeepLinkItem.AuthDeepLink -> Log.d(
                    "Deeplink",
                    "auth --- email: ${item.email} + code: ${item.code}"
                )
                else -> Log.d("Deeplink", "Is not supported")
            }
        }
    }
}