package kr.ac.kopo.lmplicitlnetenttest

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCall =findViewById<Button>(R.id.btn_call)
        var btnHome =findViewById<Button>(R.id.btn_home)
        var btnMap =findViewById<Button>(R.id.btn_map)
        var btnSearch =findViewById<Button>(R.id.btn_search)
        var btnSms =findViewById<Button>(R.id.btn_sms)
        var btnCamera =findViewById<Button>(R.id.btn_camera)

        btnCall.setOnClickListener(btnListenter)
        btnHome.setOnClickListener(btnListenter)
        btnMap.setOnClickListener(btnListenter)
        btnSearch.setOnClickListener(btnListenter)
        btnSms.setOnClickListener(btnListenter)
        btnCamera.setOnClickListener(btnListenter)

    }

    val btnListenter = View.OnClickListener {
        var uri = Uri.parse("tel:/010-3333-5555")
        var intent =Intent(Intent.ACTION_DIAL, uri)

        when(it.id){
            R.id.btn_call -> {
                uri = Uri.parse("tel:/010-3333-5555")
                intent = Intent(Intent.ACTION_DIAL, uri)
            }
            R.id.btn_home -> {
                uri = Uri.parse("https://www.kopo.ac.kr")
                intent = Intent(Intent.ACTION_VIEW, uri)
            }
            R.id.btn_map -> {
                uri = Uri.parse("https://maps.google.com?q=37.5290615,126.996542")
                intent = Intent(Intent.ACTION_VIEW, uri)
            }
            R.id.btn_search -> {
                intent = Intent(Intent.ACTION_WEB_SEARCH)
                intent.putExtra(SearchManager.QUERY, "한국폴리텍대학 인공지능소프트웨어")
            }
            R.id.btn_sms -> {

                intent = Intent(Intent.ACTION_SENDTO)
                intent.putExtra("sms_body", "한국폴리텍대학 인공지능소프트웨어")
                intent.data= Uri.parse("smsto:" + Uri.encode("010-3333-1111"))
            }
            R.id.btn_camera -> {
                intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            }

        }

        startActivity(intent)
    }
}