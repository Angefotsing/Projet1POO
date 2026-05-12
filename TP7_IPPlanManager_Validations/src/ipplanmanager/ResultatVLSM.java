/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author ANGELA
 */
public class ResultatVLSM {
    private String nomBesoin;   
    private String adresseReseau;  
    private int cidr;   
    private String masqueDecimal;  
    private int capacite;    
    private String Cidr;
    public ResultatVLSM(String nomBesoin, String adresseReseau, int cidr, String masqueDecimal, int capacite) {        
        this.nomBesoin = nomBesoin;        
        this.adresseReseau = adresseReseau;  
        this.cidr = cidr;        
        this.masqueDecimal = masqueDecimal;   
        this.capacite = capacite;  
    }    
    public String getNomBesoin() { 
        return nomBesoin;     
    }   
     public String getAdresseReseau() {    
        return adresseReseau;   
     }    
     public int getCidr() {      
        return cidr;    
    }   
    public int getCapacite() {     
        return capacite;     }    
    public void afficher() {      
        System.out.println(nomBesoin + " -> " + adresseReseau + "/" + cidr                 + " | Masque : " + masqueDecimal                 + " | Capacité : " + capacite + " hôtes");   
    }
    public ResultatVLSM(String nomBesoin, String adresseReseau, String cidr, int capacite) {
    this.nomBesoin = nomBesoin;
    this.adresseReseau = adresseReseau;
    this.Cidr = cidr;
    this.capacite = capacite;
}
    
}


