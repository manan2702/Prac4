package com.example.prac4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var btn_ref_browser:Button
    lateinit var btn_ref_map:Button
    lateinit var btn_ref_sendmsg:Button
    lateinit var btn_ref_openalarm:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ref_browser=findViewById(R.id.btn_browser)
        btn_ref_map=findViewById(R.id.btn_map)
        btn_ref_sendmsg=findViewById(R.id.btn_sendmessage)
        btn_ref_openalarm=findViewById(R.id.btn_alarm)
        implicit_intent()
    }
    fun implicit_intent(){
        btn_ref_browser.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ganpatuniversity.ac.in/")).also { startActivity(it) }
        }
        btn_ref_map.setOnClickListener{
            val adrress_uri:Uri=Uri.parse("geo:0,0?q="+"Ahmedabad")
            val i1=Intent(Intent.ACTION_VIEW, adrress_uri)
            startActivity(i1)
        }
        btn_ref_sendmsg.setOnClickListener {
            val msgIntent = Intent(Intent.ACTION_VIEW)
            msgIntent.type = "vnd.android-dir/mms-sms"
            msgIntent.putExtra("address", "12125551212")
            msgIntent.putExtra("sms_body", "Body of Message")
            startActivity(msgIntent)
        }

    }

}