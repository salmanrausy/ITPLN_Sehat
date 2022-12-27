package com.example.itplnsehat

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataHelper (var context: Context) : SQLiteOpenHelper(context,
    "rumah_sakit", null,1) {
        override fun onCreate(db: SQLiteDatabase?) {
            val createTable = "CREATE TABLE user ( id_user INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " nama VARCHAR(50), " +
                    " email VARCHAR(50), " +
                    " nomor VARCHAR(15), " +
                    " tglLahir date, " +
                    " password VARCHAR(50));"
            db?.execSQL(createTable)
        }
        override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion:
        Int) {
            TODO("Not implemented")}
        fun insertUser (user: User, tgl : String) {
            val db = this.writableDatabase
            val cv = ContentValues()
            cv.put("nama", user.nama)
            cv.put("nomor", user.nomor)
            cv.put("email",user.email)
            cv.put("tglLahir" , tgl)
            cv.put("password",user.password)
            val result = db.insert("user", null, cv)
            if (result == -1.toLong())
                Toast.makeText(context, "FAILED", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show()
        }

        fun checkUser(email: String, password: String): Boolean {
            // array of columns to fetch
            val columns = arrayOf("id_user")
            val db = this.readableDatabase
            // selection criteria
            val selection = "email= ? AND password = ?"
            // selection arguments
            val selectionArgs = arrayOf(email, password)
            // query user table with conditions
            /**
             * Here query function is used to fetch records from user table this function works like we use sql query.
             * SQL query equivalent to this query function is
             * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
             */
            val cursor = db.query("user",//Table to query
                columns, //columns to return
                selection, //columns for the WHERE clause
                selectionArgs, //The values for the WHERE clause
                null,  //group the rows
                null, //filter by row groups
                null) //The sort order
            val cursorCount = cursor.count
            cursor.close()
            db.close()
            if (cursorCount > 0)
                return true
            return false
        }
    }