package com.example.android.sample.rssreader

import java.io.BufferedInputStream
import java.io.InputStream
import javax.net.ssl.HttpsURLConnection

fun httpGet(url: String): InputStream? {

    //通信用のオブジェクトを作る
    val con = URL(url).openConnection() as HttpsURLConnection

    //接続の設定を行う
    con.apply {
        requestMethod = "GET"
        connectTimeout = 3000
        readTimeout = 5000
        instanceFollowRedirects = true //リダイレクトの許可
    }

    //接続する
    con.connect()

    //ステータスコードの確認
    if(con.responseCode in 200..299) {
        return BufferedInputStream(con.inputStream)
    }

    //失敗
    return null
}