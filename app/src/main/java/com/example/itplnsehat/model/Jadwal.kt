package com.example.itplnsehat.model

class Jadwal {
    var id_dokter : String = ""
    var keterangan : String = ""
    var kunjungan : String = ""
    constructor( idDokter : String , keterangan : String, kunjungan :String){
         this.id_dokter = idDokter
         this.keterangan = keterangan
        this.kunjungan = kunjungan
     }
}