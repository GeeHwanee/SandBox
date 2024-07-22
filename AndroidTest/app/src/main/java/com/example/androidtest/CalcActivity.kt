package com.example.androidtest;

import android.content.Intent
import android.os.Bundle;
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity;

public class CalcActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)


        val mainButton : Button = findViewById(R.id.mainButton)

        mainButton.setOnClickListener {
            // 클릭 시 Intent 생성 및 액티비티 시작
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val calcButtons = arrayOf(R.id.Button0, R.id.Button1, R.id.Button2, R.id.Button3, R.id.Button4, R.id.Button5, R.id.Button6, R.id.Button7, R.id.Button8, R.id.Button9,
                                R.id.ButtonAdd, R.id.ButtonMin, R.id.ButtonMulti, R.id.ButtonDiv, R.id.ButtonClear, R.id.ButtonEqual)
        calcButtons.forEach { id -> findViewById<Button>(id).setOnClickListener{ button -> onButtonClick(button as Button) } }

    }

    private fun onButtonClick(button: Button){


    }

}
