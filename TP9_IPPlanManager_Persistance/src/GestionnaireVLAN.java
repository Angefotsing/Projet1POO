/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList; 
public class GestionnaireVLAN {
    private ArrayList<VLAN> vlans;   
    public GestionnaireVLAN() {   
        vlans = new ArrayList<>(); 
    }    
    public void ajouterVLAN(VLAN vlan) throws ConflitVLANException {    
        if (vlan == null) {     
            return;  
        }     for (VLAN v : vlans) {    
            if (v.getId() == vlan.getId()) {    
                throw new ConflitVLANException("Conflit VLAN : l'identifiant " + vlan.getId() + " est déjà utilisé.");        
            }   
        } 
        vlans.add(vlan);
    }
    public void afficherTousLesVLANs() {     
        for (VLAN vlan : vlans) {           
            vlan.afficher();          
            System.out.println();   
        }   
    }   
    public VLAN rechercherVLAN(int id) {   
        for (VLAN vlan : vlans) {  
            if (vlan.getId() == id) {       
                return vlan;            
            }  
            
        }  
        return null;   
    }    
    public int obtenirNombreVLANs() {    
        return vlans.size();   
    }
    public void afficherVLANsCritiques() {
    System.out.println("\n--- Vérification des VLANs Critiques (> 100 hôtes) ---");
    boolean trouve = false;
    
    for (VLAN v : vlans) {
        // On vérifie la capacité du réseau associé au VLAN
        if (v.getReseauAssocie() != null && v.getReseauAssocie().getCapacite() > 100) {
            System.out.println("VLAN critique détecté : ");
            System.out.println("VLAN " + v.getIdVlan() + " - " + v.getNomVlan() + 
                               " - Capacité : " + v.getReseauAssocie().getCapacite() + " hôtes");
            trouve = true;
        }
    }
    
    if (!trouve) {
        System.out.println("Aucun VLAN critique détecté.");
    }
    }
    public ArrayList<VLAN> getVlans() {
        return vlans;
    }
    
}
