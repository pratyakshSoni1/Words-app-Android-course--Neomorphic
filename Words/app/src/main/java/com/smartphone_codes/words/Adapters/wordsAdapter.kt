package com.smartphone_codes.words.Adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.smartphone_codes.words.DetailActivity
import com.smartphone_codes.words.R

class wordsAdapter(private val letterId:String, private val dataword:Array<String>, val context:Context): RecyclerView.Adapter<wordsAdapter.WordsViewHolder>() {

    private val filteredwords :List<String> = dataword.filter { it.startsWith(letterId,true) }.shuffled().take(5).sorted()

    class WordsViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        val txtCard:Button=view.findViewById(R.id.wordCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val adapter2= LayoutInflater.from(parent.context).inflate(R.layout.wrodlayout,parent,false)
        return WordsViewHolder(adapter2)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.txtCard.text=filteredwords[position].capitalize()
        val queryUrl: Uri =Uri.parse("${DetailActivity.SEARCHprefix}meaning+of+${holder.txtCard.text}")
        holder.txtCard.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW,queryUrl)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return filteredwords.size
    }
}
