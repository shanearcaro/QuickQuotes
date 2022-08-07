package com.shane.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // We connect our recycler view widget to the layout manager and attach an adapter
        // for the data to be displayed.
        layoutManager = GridLayoutManager(this, 1)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context, DividerItemDecoration.VERTICAL
            )
        )

        adapter = QuoteAdapter(arrayListOf(
            "Do all the good you can in the world",
            "God is most glorified in us when we are the most satisfied in Him",
            "Faith does not eliminate questions. But faith knows where to take them.",
            "True faith means holding nothing back.",
            "Worrying is arrogant because God knows what He's doing."
        ))
        recyclerView.adapter = adapter
    }

    // Original ListView was used to display lists of data but RecyclerView is the
    // updated version specifically designed to be used on long lists of data.
}