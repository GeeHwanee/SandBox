package com.example.androidtest

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidtest.ui.theme.AndroidTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val calcButton : Button = findViewById(R.id.calcButton)
        val exitButton : Button = findViewById(R.id.exitButton)

        calcButton.setOnClickListener {
            // 클릭 시 Intent 생성 및 액티비티 시작
            val intent = Intent(this, CalcActivity::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener{

            val builder = AlertDialog.Builder(this)
                .setTitle("종료")
                .setMessage("종료하시겠습니까?")
                .setPositiveButton("확인") { dialog, which ->
                    // 긍정 버튼 클릭 시 수행할 작업
                    finishAffinity()
                }
                .setNegativeButton("취소") { dialog, which ->
                    // 부정 버튼 클릭 시 수행할 작업
                }

            // AlertDialog 생성 및 표시
            val dialog = builder.create()
            dialog.show()
        }


    }
}

