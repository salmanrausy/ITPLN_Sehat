package com.example.itplnsehat

class Jadwal {
    var id_user : Int = 0
    var id_dokter : Int = 0
    var keterangan : String = ""
    constructor(idUser : Int , idDokter : Int , keterangan : String){
         this.id_user = idUser
         this.id_dokter = idDokter
         this.keterangan = keterangan
     }
}