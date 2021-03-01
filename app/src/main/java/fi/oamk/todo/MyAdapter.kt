package fi.oamk.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter class provides data to RecyclerView. All methods are called by the layout manager when needed (so you
// do not call these by yourself).
class MyAdapter(private val myDataset: Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    // Create new view (rows). This is invoked by layout manager.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val myView = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_row,parent,false)
        return MyViewHolder(myView)
    }

    // Place data to row template (task_row.xml).
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.task.text = myDataset[position]
    }

    // Return size of the dataset providing data for RecyclerView.
    override fun getItemCount()= myDataset.size

    // Provide reference to each view (component) inside row template (tas_row.xml).
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val task: TextView = itemView.findViewById(R.id.task)
    }

}