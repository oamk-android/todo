package fi.oamk.todo

import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Declare a string array having size 10 and initialize it with empty strings.
    private val todos: ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Loop through array and add test data.
       /* for (i in 0..19) {
            todos.add("Task $i")
        }*/

        // Set layout manager and adater for RecyclerView.
        todolist.layoutManager = LinearLayoutManager(this)
        todolist.adapter = MyAdapter(todos)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.app_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_add -> {
            addTaskDialog()
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun addTaskDialog() {
        val builder = AlertDialog.Builder(this)

        with (builder) {
            setTitle("Add new task")
            val input: EditText = EditText(this@MainActivity)
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)

            builder.setPositiveButton("OK") { dialog, which ->
                val newTask: String = input.text.toString()
                todos.add(newTask)
                todolist.adapter?.notifyDataSetChanged()
            }

            builder.setNegativeButton("CANCEL") { dialog, which ->
              // Do nothinc, cancel is pressed.
            }

        }.show()
    }

}
