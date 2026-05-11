/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
     System.out.println("===== IPPlan-Manager : TP6 - VLANs =====");    
     ArrayList<BesoinReseau> besoins = new ArrayList<>(); 
     besoins.add(new BesoinReseau("TECHNIQUE", 120));     
     besoins.add(new BesoinReseau("WIFI", 80));       
     besoins.add(new BesoinReseau("ADMINISTRATION", 50));     
     besoins.add(new BesoinReseau("SERVEURS", 20));         
     Moteur_VLSM moteur = new Moteur_VLSM();         
     ArrayList<ResultatVLSM> resultats =                 moteur.genererPlan("192.168.1.0", besoins);    
     GestionnaireVLAN gestionnaire = new GestionnaireVLAN();     
     int numeroVLAN = 10;       
     for (ResultatVLSM resultat : resultats) {   
           VLAN vlan = new VLAN(                     numeroVLAN,                     resultat.getNomBesoin(),                     resultat,                     "VLAN du service " + resultat.getNomBesoin()             );         
           gestionnaire.ajouterVLAN(vlan);   
           numeroVLAN += 10;     
}     
    System.out.println();      
    System.out.println("===== VLANS GÉNÉRÉS =====");  
    gestionnaire.afficherTousLesVLANs();  
    System.out.println();       
    System.out.println("===== TEST DE RECHERCHE VLAN =====");      
    VLAN vlanRecherche = gestionnaire.rechercherVLAN(20);  
    if (vlanRecherche != null) {      
        vlanRecherche.afficher();       
    } else {         
        System.out.println("VLAN introuvable.");       
}   
    }
}
