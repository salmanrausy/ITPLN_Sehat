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
        fun insertData (user: User, tgl : String) {
            val db = this.writableDatabase
            val cv = ContentValues()
            cv.put("nama", user.nama)
            cv.put("nomor", user.nomor)
            cv.put("tglLahir" , tgl)
            cv.put("password",user.password)
            val result = db.insert("user", null, cv)
            if (result == -1.toLong())
                Toast.makeText(context, "FAILED", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show()
        }
    }