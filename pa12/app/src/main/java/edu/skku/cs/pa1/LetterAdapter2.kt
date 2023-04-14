package edu.skku.cs.pa1

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class LetterAdapter2(private val duplicateCorrectSet: Set<Char>, private val context: Context): BaseAdapter() {
    override fun getCount(): Int {
        return duplicateCorrectSet.size
    }

    override fun getItem(p0: Int): Any {
        return duplicateCorrectSet.toCharArray()[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val generatedView = inflater.inflate(R.layout.letter_list, null)

        val letterTextView = generatedView.findViewById<TextView>(R.id.text6)
        val letter = duplicateCorrectSet.toCharArray()[p0]

        letterTextView.text = letter.toString()
        letterTextView.setBackgroundColor(Color.parseColor("#FFE46F"))
        letterTextView.setTextColor(Color.parseColor("#000000"))

        return generatedView
    }
}