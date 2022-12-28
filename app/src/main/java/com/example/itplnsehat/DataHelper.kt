package com.example.itplnsehat


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataHelper (var context: Context) : SQLiteOpenHelper(context,
    "rumah_sakit", null,1)
    {
        private  val db = this.writableDatabase
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

        @SuppressLint("Range")
        fun checkUser(email: String, password: String): Int {
            val query = "SELECT * FROM user WHERE email='" + email + "' AND password='" + password + "'"
            val rs = db.rawQuery(query, null)
            if (rs.moveToFirst()) {
                val idUser = rs.getInt(rs.getColumnIndex("id_user"))
                rs.close()
                return idUser
            }
            return -1
        }
        @SuppressLint("Range")
        fun selectId(id: Int) : Array<String>{
            val query = "SELECT * FROM user WHERE id_user=$id"
            val rs = db.rawQuery(query,null)
            if(rs.moveToFirst()) {
                val idUser = rs.getInt(rs.getColumnIndex("id_user"))
                val nama = rs.getString(rs.getColumnIndex("nama"))
                val email = rs.getString(rs.getColumnIndex("email"))
                val nomor = rs.getString(rs.getColumnIndex("nomor"))
                val tgl_lahir = rs.getString(rs.getColumnIndex("tglLahir"))
                rs.close()
                return arrayOf(idUser.toString(),nama,email,nomor,tgl_lahir)
            }
            return arrayOf("","","","","","")
        }
    }