package me.chen_wei.recyclerview.samples

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.diff_util).setOnClickListener {
            this.startActivity(Intent(this, DiffUtilActivity::class.java))
        }
    }
}
