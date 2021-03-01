package fi.oamk.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declare a string array having size 10 and initialize it with empty strings.
        val todos: Array<String> = Array<String>(20) {""}

        // Loop through array and add test data.
        for (i in 0..19) {
            todos[i] = "Task $i"
        }

        // Set layout manager and adater for RecyclerView.
        todolist.layoutManager = LinearLayoutManager(this)
        todolist.adapter = MyAdapter(todos)
    }
}
