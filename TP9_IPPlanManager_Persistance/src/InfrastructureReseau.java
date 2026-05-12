/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author ANGELA
 */
public class InfrastructureReseau {
    private String nom;
    private ArrayList<Equipement> equipements;  
    private ArrayList<SousReseau> sousReseaux; 
    public InfrastructureReseau(String nom) {    
        this.nom = nom;     
        equipements = new ArrayList<>();        
        sousReseaux = new ArrayList<>();   
    }
    public void ajouterEquipement(Equipement equipement) {  
        equipements.add(equipement);  
    }    
    public void ajouterSousReseau(SousReseau sousReseau) {  
        sousReseaux.add(sousReseau); 
    }
    public void afficherEquipements() {     
        for (Equipement equipement : equipements) {
            equipement.afficher();          
            System.out.println();     
        }    
    }     
    public void afficherSousReseaux() { 
         for (SousReseau sousReseau : sousReseaux) {      
            sousReseau.afficher();       
            System.out.println(); 

        }   
    }  
    public void afficher() {   
        System.out.println("Infrastructure : " + nom); 
        System.out.println();     
        System.out.println("===== SOUS-RÉSEAUX =====");    
        afficherSousReseaux();        
        System.out.println();      
        System.out.println("===== ÉQUIPEMENTS =====");     
        afficherEquipements();   
        }
    public void rechercheEquipement(String nom) {
        boolean trouve = false;
        for (Equipement e : equipements) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                e.afficher();
                trouve = true;
                break;
            }
        }
        if (!trouve) {
            System.out.println("Equipement introuvable.");
        }
    }
    }

    
