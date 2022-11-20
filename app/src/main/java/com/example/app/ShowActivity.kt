package com.example.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val intent = intent


        plan.adapter = PlanAdapter(this, createContacts())
        plan.layoutManager = LinearLayoutManager(this)
    }

    private fun createContacts(): List<Plan> {
        val contacts = mutableListOf<Plan>()

        contacts.add(Plan("India","AM Lake",  "From $200", R.drawable.india))
        contacts.add(Plan("France","Eiffel Tower","From $300",R.drawable.image1))
        contacts.add(Plan("Denmark","AM Lake",  "From $400", R.drawable.denmark))
        contacts.add(Plan("Italy","Nilgiri Hills","From $500",R.drawable.filanda))
        contacts.add(Plan("Morocco","hassan mosque 2",  "Free", R.drawable.hassan2))


        return contacts
    }
}