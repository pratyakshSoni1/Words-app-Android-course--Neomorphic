package com.smartphone_codes.words

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartphone_codes.words.Adapters.wordsAdapter
import com.smartphone_codes.words.DataSources.DataSource

class DetailActivity : AppCompatActivity() {

    companion object{
        const val LETTER = "letter"
        const val SEARCHprefix = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        //make fully Android Transparent Status bar
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        val letterId = intent?.extras?.getString(LETTER).toString()
        findViewById<TextView>(R.id.letterDetail).setText("Letter : $letterId")
        val context = this
        val recViewDetail=findViewById<RecyclerView>(R.id.detailRecycler)
        val dataset=DataSource().loadWords( context.resources.getStringArray(R.array.words))

        recViewDetail.layoutManager= GridLayoutManager(this,2)
        recViewDetail.adapter=wordsAdapter(letterId,dataset,this)

    }
    fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
        val win: Window = activity.window
        val winParams: WindowManager.LayoutParams = win.getAttributes()
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.setAttributes(winParams)
    }

    fun bcktoActivity(view:View){
        onBackPressed()
    }

}