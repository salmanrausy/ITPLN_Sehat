package com.example.itplnsehat.model

class Jadwal {
    var id_user : Int = 0
    var id_dokter : Int = 0
    var keterangan : String = ""
    var kunjungan : String = ""
    constructor(idUser : Int , idDokter : Int , keterangan : String, kunjungan :String){
         this.id_user = idUser
         this.id_dokter = idDokter
         this.keterangan = keterangan
        this.kunjungan = kunjungan
     }
}