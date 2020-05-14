package com.sagagroup.greedy.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.sagagroup.greedy.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtforgetpswd = findViewById(R.id.txtforgetpswd) as TextView

        val register = findViewById(R.id.register) as TextView
        val btnlogin = findViewById(R.id.btnlogin) as Button


        btnlogin.setOnClickListener {


            val i = Intent(this@LoginActivity, HomeActivity::class.java)

            startActivity(i)
        }


        txtforgetpswd.setOnClickListener {
            // your code to perform when the user clicks on the TextView
            val i = Intent(this@LoginActivity, ForgetPassActivity::class.java)
            startActivity(i)
        }
        register.setOnClickListener {
            // your code to perform when the user clicks on the TextView
            val i = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(i)
        }

    }
}