package com.example.androidtest;

import android.content.Intent
import android.os.Bundle;
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

public class CalcActivity : ComponentActivity() {

    private lateinit var display: TextView
    private var firstTmpNumber : Number = 0;
    private var secondTmpNumber : Number = 0;
    private var tmpOperator : String = "";
    private var isNewNumber : Boolean = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)


        val mainButton : Button = findViewById(R.id.mainButton)
        display = findViewById(R.id.display);

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
        val displayText : String = display.text.toString();
        Log.i("CalcActivity",displayText)
        val buttonText = button.text.toString()
        val buttonTag = button.tag.toString()
        when (buttonTag) {
            "number" -> addNumber(buttonText)
            "operator" -> addOperator(buttonText)
            "calculation" -> operation()
            "clear" -> clearDisplay()
        }

    }
    private fun addNumber(buttonText: String){
        val displayText : String = display.text.toString();
        display.text = buildString {
            append( if(isNewNumber) "" else displayText)
            append(buttonText)
        };
        isNewNumber = false;
    }
    private fun addOperator(buttonText: String) {
        val displayText : String = display.text.toString();
        firstTmpNumber = displayText.toInt();
        tmpOperator = buttonText;
        isNewNumber = true;
    }

    private fun clearDisplay(){
        display.text = buildString {
            append("0")
        };
        firstTmpNumber = 0;
        tmpOperator = buildString {
            append("")
        }
        isNewNumber = true;
    }
    private fun operation(){
        val displayText : String = display.text.toString();
        var result : Number = 0;
        if(isNewNumber){
            when(tmpOperator) {
                "+" -> result = firstTmpNumber.toInt() + secondTmpNumber.toInt();
                "-" -> result = firstTmpNumber.toInt() - secondTmpNumber.toInt();
                "*" -> result = firstTmpNumber.toInt() * secondTmpNumber.toInt();
                "/" -> result = firstTmpNumber.toInt() / secondTmpNumber.toInt();
            }
            Log.d("operation", ("$firstTmpNumber$tmpOperator$secondTmpNumber = $result"))
        }else{
            when(tmpOperator) {
                "+" -> result = firstTmpNumber.toInt() + displayText.toInt();
                "-" -> result = firstTmpNumber.toInt() - displayText.toInt();
                "*" -> result = firstTmpNumber.toInt() * displayText.toInt();
                "/" -> result = firstTmpNumber.toInt() / displayText.toInt();
            }
            Log.d("operation", ("$firstTmpNumber$tmpOperator$displayText = $result"))
            secondTmpNumber = displayText.toInt();
        }
        firstTmpNumber = result;
        display.text = result.toString();
        isNewNumber = true;
    }
}
