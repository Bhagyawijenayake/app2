package com.example.myapp2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        saveBtn.setOnClickListener{

            val string1 = stringEt.text.toString().trim()
            val bool1 = switch1.isChecked
            val editor=sharedPreferences.edit()

            editor.putString("String",string1)
            editor.putBoolean("Boolean_value",bool1)
            editor.apply()
        }

        showDataBtn.setOnClickListener{

            val string1 = sharedPreferences.getString("String : ","")
            val switch1 = sharedPreferences.getBoolean("Boolean_value : ",false)

            InfoTv.text="String : $string1 \nBoolean value : $switch1"

        }

    }
}