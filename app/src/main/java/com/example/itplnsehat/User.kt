package com.example.itplnsehat

import android.provider.ContactsContract.CommonDataKinds.Email

class User {
    var nama : String = ""
    var email : String = ""
    var nomor : String = ""
    var password : String = ""

    constructor(nama : String, email: String, nomor : String , password : String ){
        this.nama = nama
        this.email = email
        this.nomor = nomor
        this.password = password
    }
}