/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTS;

import Koneksi.KoneksiSparePart;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.spare.part.SparePart;

/**
 *
 * @author Parzival
 */
public class SparePartSource {
    KoneksiSparePart koneksi = new KoneksiSparePart();
    ResultSet rs;
    SparePart part = new SparePart();
    private final String primary_key ="id_part";
    private final String table_name = "spare_part";
    //select * from mahasiswa
    private final String q_select = " select * from "+ table_name;

    SparePartSource(SparePart part) {
        this.part = part;
    }

    

    

    private void SparePartSource() throws SQLException { 
       rs.updateString("id_part", part.getIdPart());
       rs.updateString("nama_part", part.getNama());
       rs.updateString("merk_part", part.getMerk());
       rs.updateDouble("harga", part.getHarga());
       rs.updateInt("jumlah", (int) part.getJumlah());
    }
    
     public void saveData(){
        try {
            KoneksiSparePart koneksi = new KoneksiSparePart();
            if (koneksi.connect()) {
                String q = q_select + " where " + primary_key + " = '"+ part.getIdPart() +"'";
                rs = koneksi.showQuery(q);
                
                if (rs.next()) {
                    this.SparePartSource();
                    rs.updateRow();
                    System.out.println("Data berhasil diupdate");
                }else{
                    rs.moveToInsertRow();
                    this.SparePartSource();
                    rs.insertRow();
                    System.out.println("Data berhasil disimpan");
                    rs.moveToCurrentRow();
                }
            }
                
            
        } catch (Exception e) {
            System.err.println("Pesan error : "+ e.getMessage());
        }finally {
            koneksi.close();
        }
    }
     
        
 public void deleteData() throws SQLException{
     try {
         koneksi = new KoneksiSparePart();
         if (koneksi.connect()) {
         String q = q_select + " where " + primary_key + " = '"+ part.getIdPart() +"'";
         rs = koneksi.showQuery(q);
         
         if (rs.next()) {
             rs.deleteRow();
         }
         
        }
     } catch (Exception e) {
         e.printStackTrace();
     }finally{
         koneksi.close();
     } 
    }
    
    public void dataDiterima(ResultSet rs, SparePart part) throws SQLException{
        part.setIdPart(rs.getString("id_part"));
        part.setNama(rs.getString("nama_part"));
        part.setMerk(rs.getString("merek_part"));
        part.setHarga(rs.getDouble("harga"));
        part.setJumlah(rs.getInt("jumlah"));
        
    }
    
    private List<SparePart> getList(String q){
        List<SparePart> list = new ArrayList<SparePart>();
        try {
            koneksi = new KoneksiSparePart();
            if (koneksi.connect()) {
                rs = koneksi.showQuery(q);
                while (rs.next()) {                    
                    SparePart partList = new SparePart();
                    this.dataDiterima(rs, partList);
                    list.add(partList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           koneksi.close();
        }
        return list;
    }
    
    public List<SparePart> getAllList(){
          return this.getList(q_select); 
    }
}
