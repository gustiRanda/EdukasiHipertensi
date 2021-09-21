package com.gmind.listtutorial

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmind.listtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var Senjata: RecyclerView
    private val list: ArrayList<Senjata> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        Senjata = activityMainBinding.rvSenjata
        Senjata.setHasFixedSize(true)

        list.addAll(DataSenjata.listData)
        showRecyclerList()

        activityMainBinding.btnProfil.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showRecyclerList() {
        Senjata.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(list)
        Senjata.adapter = listAdapter

        listAdapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback{
            override fun onItemClicked(senjata: Senjata) {

            }

        })
    }
}