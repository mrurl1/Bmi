package ir.hghorbani.bmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight:EditText = findViewById(R.id.txt_weight)
        val etHeight:EditText = findViewById(R.id.txt_height)
        val btnBmi:Button = findViewById(R.id.btn_bmi)
        val btnReset:Button = findViewById(R.id.btn_reset)
        val tvResult:TextView = findViewById(R.id.tv_result)

        btnBmi.setOnClickListener {

            if (etWeight.text.isEmpty() or etHeight.text.isEmpty()){
                Toast.makeText(this,"Insert your Weight or Height",Toast.LENGTH_LONG).show()
            }
            else {
                val weight: Double = etWeight.text.toString().toDouble()
                val height: Double = etHeight.text.toString().toDouble() / 100

                val bmi = weight / (height * height)

                when (bmi) {
                    in 0.0..18.5 -> tvResult.text = "Status : " + "Underweight \n" + "BMI = " + bmi.toInt().toString()
                    in 18.6..25.0 -> tvResult.text = "Status : " + "Normal weight \n" + "BMI = " + bmi.toInt().toString()
                    in 25.1..30.0 -> tvResult.text = "Status : " + "Overweight \n" + "BMI = " + bmi.toInt().toString()
                    else -> tvResult.text = "Status : " + "Obese \n" + "BMI = " + bmi.toInt().toString()
                }
            }
        } //  end of setOnClickListener
        btnReset.setOnClickListener {
            etWeight.text.clear()
            etHeight.text.clear()
            tvResult.text = "";
            etWeight.requestFocus()
        }
    } // end of OnCreate
} // end of On class MainActivity