package com.example.week6


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.week6.DashboardActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edtuser:EditText
    private lateinit var edtpass:EditText
    private lateinit var btnlogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtuser=findViewById(R.id.edtuser)
        edtpass=findViewById(R.id.edtpass)
        btnlogin=findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener {
            val user=edtuser.text.toString()
            val pass=edtpass.text.toString()
            if (validateLogin()){
                if(user=="softwarica"&&pass=="coventry"){
                    val intent=Intent(this,DashboardActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Invalid Login", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun validateLogin(): Boolean {
        var res= true
        when {
            TextUtils.isEmpty(edtuser.text) -> {
                edtuser.error = "This field should not be empty"
                edtuser.requestFocus()
                res = false
            }
            TextUtils.isEmpty(edtpass.text) -> {
                edtpass.error = "This field should not be empty"
                edtpass.requestFocus()
                res = false
            }
        }
        return res
    }
}