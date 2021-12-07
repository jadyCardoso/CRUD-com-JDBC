/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.lojainformatica.Model;

/**
 *
 * @author jadycardoso
 */
public class ComputadorModel {
    public int id;
    public String processador;
    public static String marca = "JadyCardoso";
    public String hd;


    public ComputadorModel() {
    }
    
     public ComputadorModel(int id,String marca,String hd,String processador) {
         this.id = id;
         this.processador = processador;
         this.marca = marca;
         this.hd = hd;        
    }

    public int getId() {
        return id;
    }
    
    public String getMarca() {
        return marca;
    }
    
     public String getProcessador() {
        return processador;
    }
    
    public String getHd() {
        return hd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }
}
