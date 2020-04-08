/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spare.part;

/**
 *
 * @author Parzival
 */
public class SparePart {
    private String idPart = "";
    private String nama = "";
    private String merk = "";
    private double harga = 0;
    private double jumlah = 0;
    
    public SparePart(){
    }
    
    public SparePart(String idPart, String nama, String merk, double harga, double jumlah){
         this.idPart = idPart;
         this.nama = nama;
         this.merk = merk;
         this.harga = harga;
         this.jumlah = jumlah;
    }

    public String getIdPart() {
        return idPart;
    }

    public void setIdPart(String idPart) {
        this.idPart = idPart;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }
    
    
    
    
}
