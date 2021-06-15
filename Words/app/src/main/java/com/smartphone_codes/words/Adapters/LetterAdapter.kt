package com.smartphone_codes.words.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.smartphone_codes.words.DetailActivity
import com.smartphone_codes.words.R

class LetterAdapter(val dataset: List<Char>,val context:Context): RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    inner class LetterViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val btn:Button=view.findViewById(R.id.resbtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterAdapter.LetterViewHolder {
        val adapter=LayoutInflater.from(parent.context).inflate(R.layout.reccard,parent,false)
        return LetterViewHolder(adapter)
    }

    override fun onBindViewHolder(holder: LetterAdapter.LetterViewHolder, position: Int) {
        holder.btn.text= dataset[position].toString()
        holder.btn.setOnClickListener {
            val context = holder.view.context
            val intent=Intent(context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.LETTER,holder.btn.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size   }
}