package edu.skku.cs.pa1

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class WordAdapter(val dataList: MutableList<String>, val context: Context, val selectedWord: String): BaseAdapter() {
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
        val enteredWordAlphabets = data.toCharArray().toSet()
        val commonAlphabets = selectedWordAlphabets.intersect(enteredWordAlphabets)
        val uncommonAlphabets = enteredWordAlphabets.subtract(commonAlphabets)

        text1.setTextColor(if (commonAlphabets.contains(data[0])) Color.parseColor("#000000") else Color.parseColor("#FFFFFF"))
        text2.setTextColor(if (commonAlphabets.contains(data[1])) Color.parseColor("#000000") else Color.parseColor("#FFFFFF"))
        text3.setTextColor(if (commonAlphabets.contains(data[2])) Color.parseColor("#000000") else Color.parseColor("#FFFFFF"))
        text4.setTextColor(if (commonAlphabets.contains(data[3])) Color.parseColor("#000000") else Color.parseColor("#FFFFFF"))
        text5.setTextColor(if (commonAlphabets.contains(data[4])) Color.parseColor("#000000") else Color.parseColor("#FFFFFF"))

        text1.setBackgroundColor(if (uncommonAlphabets.contains(data[0])) Color.parseColor("#787C7E") else {
            if (data[0] == selectedWord[0]) {
                Color.parseColor("#99F691")
            } else {
                Color.parseColor("#FFE46F")
            }
        })
        text2.setBackgroundColor(if (uncommonAlphabets.contains(data[1])) Color.parseColor("#787C7E") else {
            if (data[1] == selectedWord[1]) {
                Color.parseColor("#99F691")
            } else {
                Color.parseColor("#FFE46F")
            }
        })
        text3.setBackgroundColor(if (uncommonAlphabets.contains(data[2])) Color.parseColor("#787C7E") else {
            if (data[2] == selectedWord[2]) {
                Color.parseColor("#99F691")
            } else {
                Color.parseColor("#FFE46F")
            }
        })
        text4.setBackgroundColor(if (uncommonAlphabets.contains(data[3])) Color.parseColor("#787C7E") else {
            if (data[3] == selectedWord[3]) {
                Color.parseColor("#99F691")
            } else {
                Color.parseColor("#FFE46F")
            }
        })
        text5.setBackgroundColor(if (uncommonAlphabets.contains(data[4])) Color.parseColor("#787C7E") else {
            if (data[4] == selectedWord[4]) {
                Color.parseColor("#99F691")
            } else {
                Color.parseColor("#FFE46F")
            }
        })

        return generatedView
    }
}