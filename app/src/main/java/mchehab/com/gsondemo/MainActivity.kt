package mchehab.com.gsondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val listPersons = createListFromFile()
        val arrayAdapter = ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1,
                listPersons)
        listView.adapter = arrayAdapter
    }

    private fun createListFromFile() : List<Person>{
        val gson = Gson()
        val json = assets.open("persons.txt")
                .bufferedReader()
                .readText()

        return gson.fromJson<List<Person>>(json, object : TypeToken<ArrayList<Person>>() {}.type)
    }
}