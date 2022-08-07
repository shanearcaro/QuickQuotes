package com.shane.myapplication

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.LayoutInflaterCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * QuoteAdapter extends RecyclerView.Adapter() which allows us to create a list of elements
 * RecyclerView.Adapter is of type QuoteViewHolder which extends ViewHolder.
 *
 * A ViewHolder takes in one view and displays information about it.
 *
 * An adapter is a special type of class that understands how the RecyclerView works. The job of
 * the adapter is to connect to and show the data that goes inside each row.
 */

class QuoteAdapter(val quotes: ArrayList<String>) : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    class QuoteViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var view: View = v

        // I'm changing quote to have laneinit because I read it was bad practice to initialize
        // strings as empty before use. laneinit just doesn't initialize the string until its used
        lateinit var quote: String

        fun bindQuote(quote: String) {
            this.quote = quote
            view.findViewById<TextView>(R.id.textView)?.text = quote
        }
    }

    /**
     * called when the layout for a list item is required. In our implementation, LayoutInflater
     * takes the XML provided, i.e. recycler_item_row.xml, and adds (inflates) it to the parent
     * view to get the view ready to be shown on the screen
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_row, parent, false))

    }

    // Position contains the index of the current row, we do not have to change these values
    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        var quote = quotes[position]
        holder.bindQuote(quote)
    }

    // Get the number of items in the list
    override fun getItemCount(): Int {
        return quotes.count()
    }

}