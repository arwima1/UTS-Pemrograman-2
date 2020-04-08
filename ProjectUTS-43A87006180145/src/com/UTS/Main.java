/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTS;

import Koneksi.KoneksiSparePart;
import com.spare.part.SparePart;
/**
 *
 * @author Parzival
 */
public class Main {
    public static void main(String[] args) {
        KoneksiSparePart koneksi = new KoneksiSparePart();
        
        koneksi.connect();
        
        SparePart part = new SparePart();
        
        part.setIdPart("A0001");
        part.setNama("Ban luar");
        part.setMerk("IRC 3000");
        part.setHarga(300000);
        part.setJumlah(10);
        
        SparePartSource ctrl = new SparePartSource(part);
        
        ctrl.saveData();
        
    }
}
