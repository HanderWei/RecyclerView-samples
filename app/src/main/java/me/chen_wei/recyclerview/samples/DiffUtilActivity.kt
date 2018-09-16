package me.chen_wei.recyclerview.samples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import me.chen_wei.recyclerview.samples.data.Repository

/**
 * Created by Hander on 18/9/16.
 *
 * Email : hander_wei@163.com
 */
class DiffUtilActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.diff_util_activity)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = ItemAdapter(Repository.getItems())
        rv.adapter = adapter

        findViewById<Button>(R.id.add_item).setOnClickListener {
            adapter.swap(Repository.addItem())
        }

        findViewById<Button>(R.id.remove_item).setOnClickListener {
            adapter.swap(Repository.removeItem())
        }

        findViewById<Button>(R.id.modify_item).setOnClickListener {
            adapter.swap(Repository.changeItem())
        }

        findViewById<Button>(R.id.insert_item).setOnClickListener {
            adapter.swap(Repository.insertItem())
        }
    }
}
