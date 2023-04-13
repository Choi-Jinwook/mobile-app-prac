package edu.skku.cs.pa1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class WordAdapter(val dataList: MutableList<String>, val context: Context, val selectedWord: String, val enteredWord: String): BaseAdapter() {
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(p0: Int): Any {
        return dataList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val generatedView = inflater.inflate(R.layout.word_history, null)

        val text1 = generatedView.findViewById<TextView>(R.id.text1)
        val text2 = generatedView.findViewById<TextView>(R.id.text2)
        val text3 = generatedView.findViewById<TextView>(R.id.text3)
        val text4 = generatedView.findViewById<TextView>(R.id.text4)
        val text5 = generatedView.findViewById<TextView>(R.id.text5)
        val data = dataList[p0]

        text1.text = data[0].toString()
        text2.text = data[1].toString()
        text3.text = data[2].toString()
        text4.text = data[3].toString()
        text5.text = data[4].toString()

        val selectedWordAlphabets = selectedWord.toCharArray().toSet()
        val enteredWordAlphabets = enteredWord.toCharArray().toSet()
        val commonAlphabets = selectedWordAlphabets.intersect(enteredWordAlphabets)

        if (commonAlphabets.toString().contains(text1.text)) {
            if (selectedWord[0] == enteredWord[0]) {
                text1.setBackgroundColor((Color.parseColor("#99F691")))
                text1.setTextColor((Color.parseColor("#000000")))
            } else {
                text1.setBackgroundColor((Color.parseColor("#FFE46F")))
                text1.setTextColor((Color.parseColor("#000000")))
            }
        } else {
            text1.setBackgroundColor((Color.parseColor(("#787C7E"))))
            text1.setTextColor((Color.parseColor("#FFFFFF")))
        }
        if (commonAlphabets.toString().contains(text2.text)) {
            if (selectedWord[1] == enteredWord[1]) {
                text2.setBackgroundColor((Color.parseColor("#99F691")))
                text2.setTextColor((Color.parseColor("#000000")))
            } else {
                text2.setBackgroundColor((Color.parseColor("#FFE46F")))
                text2.setTextColor((Color.parseColor("#000000")))
            }
        } else {
            text2.setBackgroundColor((Color.parseColor(("#787C7E"))))
            text2.setTextColor((Color.parseColor("#FFFFFF")))
        }
        if (commonAlphabets.toString().contains(text3.text)) {
            if (selectedWord[2] == enteredWord[2]) {
                text3.setBackgroundColor((Color.parseColor("#99F691")))
                text3.setTextColor((Color.parseColor("#000000")))
            } else {
                text3.setBackgroundColor((Color.parseColor("#FFE46F")))
                text3.setTextColor((Color.parseColor("#000000")))
            }
        } else {
            text3.setBackgroundColor((Color.parseColor(("#787C7E"))))
            text3.setTextColor((Color.parseColor("#FFFFFF")))
        }
        if (commonAlphabets.toString().contains(text4.text)) {
            if (selectedWord[3] == enteredWord[3]) {
                text4.setBackgroundColor((Color.parseColor("#99F691")))
                text4.setTextColor((Color.parseColor("#000000")))
            } else {
                text4.setBackgroundColor((Color.parseColor("#FFE46F")))
                text4.setTextColor((Color.parseColor("#000000")))
            }
        } else {
            text4.setBackgroundColor((Color.parseColor(("#787C7E"))))
            text4.setTextColor((Color.parseColor("#FFFFFF")))
        }
        if (commonAlphabets.toString().contains(text5.text)) {
            if (selectedWord[4] == enteredWord[4]) {
                text5.setBackgroundColor((Color.parseColor("#99F691")))
                text5.setTextColor((Color.parseColor("#000000")))
            } else {
                text5.setBackgroundColor((Color.parseColor("#FFE46F")))
                text5.setTextColor((Color.parseColor("#000000")))
            }
        } else {
            text5.setBackgroundColor((Color.parseColor(("#787C7E"))))
            text5.setTextColor((Color.parseColor("#FFFFFF")))
        }

        return generatedView
    }
}