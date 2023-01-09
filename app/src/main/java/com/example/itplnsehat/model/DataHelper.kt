package com.example.itplnsehat.model


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class DataHelper (var context: Context) : SQLiteOpenHelper(context,
    "rumah_sakit", null,1)
    {
        private  val db = this.writableDatabase
        override fun onCreate(db: SQLiteDatabase?) {
            val createTableUser = "CREATE TABLE user ( "+
                        " id_user INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " nama VARCHAR(50), " +
                        " email VARCHAR(50), " +
                        " nomor VARCHAR(15), " +
                        " tglLahir DATE, " +
                        " password VARCHAR(50)); "
            val createTableDokter =  " CREATE TABLE dokter ( "+
                        " id_dokter INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        " nama VARCHAR(50), " +
                        " spesialis VARCHAR(50)); "
            val createTableJadwal   = " CREATE TABLE jadwal ( "+
                        " id_jadwal INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        " id_user INTEGER, " +
                        " id_dokter INTEGER, "+
                        " kunjungan DATETIME, " +
                        " keterangan VARCHAR(100)," +
                        " FOREIGN KEY(id_user) references user(id_user)," +
                        " FOREIGN KEY(id_dokter) references dokter(id_dokter)); "
            val insertdata = "INSERT INTO dokter (nama,spesialis)VALUES " +
                    "('Dr. Banner ','Jantung')," +
                    "('Dr. Kamaludin ','Paru')," +
                    "('Dr. Kehfa ','Otak dan Sistem Saraf')," +
                    "('Dr. Lucille' ,'Mata')," +
                    "('Dr. Meisya ','Anak')," +
                    "('Dr. Strange' ,'Tulang'); "
            val insertdatauser = "INSERT INTO user (nama,email,nomor,tglLahir,password)VALUES ('Admin','admin','0834637322' ,'2001-12-09','admin'); "
            val insertDataJadwal = "INSERT INTO jadwal (id_user,id_dokter,kunjungan,keterangan) VALUES (1,1,'2022-11-19','cek kesehatan jantung');"
            db?.execSQL(createTableUser)
            db?.execSQL(createTableDokter)
            db?.execSQL(createTableJadwal)
            db?.execSQL(insertdata)
            db?.execSQL(insertdatauser)
            db?.execSQL(insertDataJadwal)
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
                Toast.makeText(context, "ADD ACCOUNT SUCCESS", Toast.LENGTH_SHORT).show()
        }

        fun insertJadwal (jadwal: Jadwal, idUser: String?) {
            val cv = ContentValues()
            cv.put("id_dokter", jadwal.id_dokter)
            cv.put("kunjungan",jadwal.kunjungan)
            cv.put("keterangan",jadwal.keterangan)
            cv.put("id_user", idUser)
            val result = db.insert("jadwal", null, cv)
            if (result == -1.toLong())
                Toast.makeText(context, "FAILED", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context, "ADD ACCOUNT SUCCESS", Toast.LENGTH_SHORT).show()
        }

        @SuppressLint("Range")
        fun checkUser(email: String, password: String): Int {
            val query = "SELECT * FROM user WHERE email='$email' AND password='$password'"
            val rs = db.rawQuery(query, null)
            if (rs.moveToFirst()) {
                val idUser = rs.getInt(rs.getColumnIndex("id_user"))
                rs.close()

                return idUser
            }
            return -1
        }

        fun getJadwal(id: Int): List<Jadwal>{
            val lsJadwal: MutableList<Jadwal> = ArrayList<Jadwal>()
            val sql = "SELECT dokter.nama, jadwal.kunjungan, jadwal.keterangan FROM jadwal INNER JOIN dokter ON dokter.id_dokter = jadwal.id_dokter WHERE jadwal.id_user = $id"
            val cursor = db.rawQuery(sql, null)
            if(cursor.moveToFirst()) {
                do {
                    val jadwal1 = Jadwal(cursor.getString(0),cursor.getString(1),  cursor.getString(2))
                    lsJadwal.add(jadwal1)

                } while (cursor.moveToNext())
            }
            cursor.close()
            return lsJadwal
        }

        @SuppressLint("Range")
        fun profile(id: Int) : Array<String>{
            val query = "SELECT nama,email,nomor,tglLahir FROM user WHERE id_user=$id"
            val rs = db.rawQuery(query,null)
            if(rs.moveToFirst()) {
                val nama = rs.getString(rs.getColumnIndex("nama"))
                val email = rs.getString(rs.getColumnIndex("email"))
                val nomor = rs.getString(rs.getColumnIndex("nomor"))
                val tgl_lahir = rs.getString(rs.getColumnIndex("tglLahir"))
                val parser = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
                val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.UK)
                val date = parser.parse(tgl_lahir)?.let { formatter.format(it) }
                rs.close()
                return arrayOf(nama,email,nomor,date.toString())
            }
            return arrayOf("","","","","")
        }
    }