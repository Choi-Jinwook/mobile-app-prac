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
    private val duplicateExactCorrectSet = mutableSetOf<Char>()
    private val duplicateCorrectSet = mutableSetOf<Char>()
    private val duplicateInCorrectSet = mutableSetOf<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordInput = findViewById<EditText>(R.id.wordInput)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val listView1 = findViewById<ListView>(R.id.wordContainer)
        val listView2 = findViewById<ListView>(R.id.letterContainer1)
        val listView3 = findViewById<ListView>(R.id.letterContainer2)
        val listView4 = findViewById<ListView>(R.id.letterContainer3)

        val inputStream: InputStream = applicationContext.assets.open("lib.txt")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val wordList = bufferedReader.useLines { lines ->
            lines.toList()
        }

        var selectedWord = ""

        if (wordList.isNotEmpty()) {
            val randomIndex = (wordList.indices).random()
            selectedWord = wordList[randomIndex].uppercase()
        }

        Log.e("Answer", selectedWord)

        val adapter1 = WordAdapter(dataList, applicationContext, selectedWord)
        listView1.adapter = adapter1

        val adapter2 = LetterAdapter(duplicateExactCorrectSet, applicationContext)
        val adapter3 = LetterAdapter2(duplicateCorrectSet, applicationContext)
        val adapter4 = LetterAdapter3(duplicateInCorrectSet, applicationContext)
        listView2.adapter = adapter4
        listView3.adapter = adapter3
        listView4.adapter = adapter2

        submitBtn.setOnClickListener {
            val enteredWord = wordInput.text.toString().trim().uppercase()
            val selectedLetters = selectedWord.uppercase().toCharArray()

            if (wordList.contains(enteredWord.lowercase())) {
                for ((index, letter) in enteredWord.uppercase().toCharArray().withIndex()) {
                    if (selectedLetters.contains(letter)) {
                        if (selectedWord[index] == enteredWord[index]) {
                            duplicateExactCorrectSet.add(letter)
                        } else {
                            duplicateCorrectSet.add(letter)
                        }
                    } else {
                        duplicateInCorrectSet.add(letter)
                    }
                }
                Log.e("exact", "$duplicateExactCorrectSet")
                Log.v("correct", "$duplicateCorrectSet")
                Log.i("incorrect", "$duplicateInCorrectSet")

                dataList.add(wordInput.text.toString().uppercase())
                wordInput.text.clear()
                listView1.setSelection(adapter1.count - 1)
                listView2.setSelection(adapter4.count - 1)
                listView3.setSelection(adapter3.count - 1)
                listView4.setSelection(adapter2.count - 1)
            } else {
                Toast.makeText(applicationContext, "Word $enteredWord not in dictionary!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}