package com.example.app

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_plan.view.*

class PlanAdapter (private val context: Context, private val contacts: List<Plan>)
    : RecyclerView.Adapter<PlanAdapter.ViewHolder>() {

    val selected_pos = RecyclerView.NO_POSITION

    private val TAG = "ContactAdapter"

    // Usually involves inflating a layout from XML and returning the holder - THIS IS EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_plan, parent, false))
    }

    // Returns the total count of items in the list
    override fun getItemCount() = contacts.size

    // Involves populating data into the item through holder - NOT expensive
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder at position $position")
        val contact = contacts[position]
        holder.bind(contact)

        holder.itemView.setOnLongClickListener {
            var message = StringBuilder()
            var country = contacts[position].name
            message.append(country).append(" is added to favourite !")
            Toast.makeText(context,message.toString(),Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }

        holder.itemView.setOnClickListener{
            var message = StringBuilder()
            var country = contacts[position].name
            message.append("You choose ").append(country)

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Country Selected:")
            builder.setMessage(country)
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(context,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(context,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
        
        holder.itemView.onTouchEvent{
            
        }


    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(plan: Plan) {
            itemView.place_image.setImageResource(plan.image)
            itemView.place_name.text =plan.age
            itemView.country_name.text=plan.name
            itemView.price.text = plan.text

        }
    }
}

private fun View.onTouchEvent(function: () -> Unit) {

}


