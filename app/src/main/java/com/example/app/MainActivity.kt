package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.intellij.lang.annotations.Language

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var languages = arrayOf("Morocco", "Croatia", "Denmark", "France", "Canada", "other")
        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        // get reference to button
        val btn_click_me = findViewById(R.id.btn) as Button
        var name = findViewById<EditText>(R.id.full_name).text.toString()
        var email =findViewById<EditText>(R.id.email).text.toString()
        var phone = findViewById<EditText>(R.id.phone).text.toString()


        // set on-click listener
        btn_click_me.setOnClickListener {
            //if(name!="" && email!="" && phone!=""){
                //Toast.makeText(this@MainActivity, findViewById<EditText>(R.id.full_name).text.toString(),Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ShowActivity::class.java)
                val spinn = findViewById<Spinner>(R.id.spinner)
                intent.putExtra("name",findViewById<EditText>(R.id.full_name).text.toString())
                intent.putExtra("email",findViewById<EditText>(R.id.email).text.toString())
                intent.putExtra("phone",findViewById<EditText>(R.id.phone).text.toString())
                intent.putExtra("country",languages.get(spinn.selectedItemPosition))
                startActivity(intent)
            //}
            //else{
              //  Toast.makeText(this@MainActivity, "please enter your information",Toast.LENGTH_SHORT).show()
            //}


        }
    }
}
