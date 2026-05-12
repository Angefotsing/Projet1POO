/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {    
        System.out.println("===== IPPlan-Manager : TP8 - Recommandations =====");  
        ArrayList<BesoinReseau> besoins = new ArrayList<>();    
        besoins.add(new BesoinReseau("ADMINISTRATION", 50));
besoins.add(new BesoinReseau("WIFI_INVITES", 120));
besoins.add(new BesoinReseau("SERVEURS", 20));
besoins.add(new BesoinReseau("CAMERAS", 80));
besoins.add(new BesoinReseau("VOIP", 60));
        Moteur_VLSM moteurVLSM = new Moteur_VLSM();      
        ArrayList<ResultatVLSM> resultats = moteurVLSM.genererPlan("10.10.0.0", besoins); 
        GestionnaireVLAN gestionnaireVLAN = new GestionnaireVLAN();   
        int numeroVLAN = 10;  
        try {       
            
            
            for (ResultatVLSM resultat : resultats) {         
                VLAN vlan = new VLAN(numeroVLAN, resultat.getNomBesoin(), resultat, "VLAN " + resultat.getNomBesoin());  
                gestionnaireVLAN.ajouterVLAN(vlan);       
                numeroVLAN += 10;         
            }  
        } catch (ConflitVLANException e) {     
            System.out.println("Erreur VLAN : " + e.getMessage());   
        }       
        System.out.println();    
        System.out.println("Plan VLAN généré :"); 
        gestionnaireVLAN.afficherTousLesVLANs();    
        MoteurRecommandation moteurRecommandation = new MoteurRecommandation();   
        moteurRecommandation.ajouterRegle(new RecommandationWifiInvite());      
        moteurRecommandation.ajouterRegle(new RecommandationsServeurs());     
        moteurRecommandation.ajouterRegle(new RecommandationGrandVLAN());
        ArrayList<Recommandation> recommandations = moteurRecommandation.analyserVLANs(gestionnaireVLAN.getVlans());    
        System.out.println();     
        System.out.println("Recommandations proposées :"); 
        moteurRecommandation.afficherRecommandations(recommandations); 
    } 
} 

    