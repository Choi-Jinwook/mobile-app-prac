package edu.skku.cs.pa1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private val dataList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordInput = findViewById<EditText>(R.id.wordInput)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val listView = findViewById<ListView>(R.id.wordContainer)

        val inputStream: InputStream = applicationContext.assets.open("lib.txt")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val wordList = bufferedReader.useLines { lines ->
            lines.toList()
        }

        var selectedWord = ""

        if (wordList.isNotEmpty()) {
            val randomIndex = (0 until wordList.size).random()
            selectedWord = wordList[randomIndex].uppercase()
        }

        Log.e("zz", selectedWord)

        submitBtn.setOnClickListener {
            val enteredWord = wordInput.text.toString().trim().uppercase()

            if (wordList.contains(enteredWord.lowercase())) {
                dataList.add(wordInput.text.toString().uppercase())
                val adapter = WordAdapter(dataList, applicationContext, selectedWord, enteredWord)
                listView.adapter = adapter
            } else {
                Toast.makeText(applicationContext, "Word $enteredWord not in dictionary!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}