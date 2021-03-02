package fi.oamk.todo.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import fi.oamk.todo.Model.Task

class DBHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER) {
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME ="TodoList.db"
        private val TABLE_NAME = "Task"
        private val COL_ID = "Id"
        private val COL_NAME = "Name"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = ("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_NAME TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    val allTasks: ArrayList<Task>
        get() {
            val items = ArrayList<Task>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db: SQLiteDatabase = this.readableDatabase
            var cursor = db.rawQuery(selectQuery,null)
            if (cursor.moveToFirst()) {
                do {
                    val task = Task(cursor.getInt(cursor.getColumnIndex(COL_ID)),cursor.getString(cursor.getColumnIndex(COL_NAME)))
                    items.add(task)
                } while (cursor.moveToNext())
            }
            return items
        }

        fun addTask(task: Task) {
            val db: SQLiteDatabase = this.writableDatabase
            val values = ContentValues()
            values.put(COL_NAME,task.name)
            db.insert(TABLE_NAME,null,values)
            db.close()
        }

}