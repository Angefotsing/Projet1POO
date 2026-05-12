/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.main;
import ipplanmanager.exception.ConflitVLANException; 
import ipplanmanager.model.BesoinReseau; 
import ipplanmanager.model.Recommandation; 
import ipplanmanager.model.ResultatVLSM; 
import ipplanmanager.model.VLAN; 
import ipplanmanager.repository.BesoinRepository; 
import ipplanmanager.repository.FichierPlanRepository; 
import ipplanmanager.service.GestionnaireVLAN;
import ipplanmanager.service.MoteurRecommandation; 
import ipplanmanager.service.Moteur_VLSM; 
import ipplanmanager.service.RapportService;
import ipplanmanager.service.RecommandationGrandVLAN;
import ipplanmanager.service.RecommandationServeurs; 
import ipplanmanager.service.RecommandationWifiInvite;
import java.io.IOException; 
import java.util.ArrayList; 
public class Main {
     public static void main(String[] args) {  
         System.out.println("===== IPPlan-Manager : TP9 - Persistance ====="); 
          // 1. DÉCLARATION DES CHEMINS DE FICHIERS (Strings)
    String fichierBesoins = "besoins.csv"; // Le fichier d'entrée
    String fichierVlans = "exports/liste_vlans.csv";
    String fichierRecommandations = "exports/recommandations.csv";
    String fichierRapport = "exports/rapport_complet.txt";

    // 2. CRÉATION DES OBJETS (Instanciation)
    // Ces lignes enlèveront les traits rouges sur les noms soulignés
    BesoinRepository besoinRepository = new BesoinRepository();
    MoteurVLSM moteurVLSM = new MoteurVLSM();
    GestionnaireVLAN gestionnaireVLAN = new GestionnaireVLAN();
    MoteurRecommandation moteurRecommandation = new MoteurRecommandation();
    FichierPlanRepository fichierPlanRepository = new FichierPlanRepository();
    RapportService rapportService = new RapportService();

    // 3. LOGIQUE DU PROGRAMME
    try {
        // Chargement et génération
        ArrayList<BesoinReseau> besoins = besoinRepository.chargerBesoins(fichierBesoins);
        ArrayList<ResultatVLSM> resultats = moteurVLSM.genererPlan("10.10.0.0", besoins);
        
        // ... suite de ton code pour remplir le gestionnaireVLAN et analyser ...
        
        // Sauvegardes (Utilisation des objets créés plus haut)
        fichierPlanRepository.sauvegarderVLANsCSV(gestionnaireVLAN.getVlans(), fichierVlans);
        
        ArrayList<Recommandation> recommandations = moteurRecommandation.analyserVLANs(gestionnaireVLAN.getVlans());
        rapportService.genererRapportComplet(besoins, resultats, recommandations, fichierRapport);

        System.out.println("Traitement terminé avec succès. Vérifiez le dossier /exports.");

    } catch (IOException e) {
        System.err.println("Erreur de fichier : " + e.getMessage());
    }
}
         String fichierBesoins = "exports/besoins.csv";       
         String fichierPlan = "exports/plan_adressage.csv";    
         String fichierVlans = "exports/vlans.csv";    
         String fichierRecommandations = "exports/recommandations.txt";    
         String fichierRapport = "exports/rapport_complet.txt";        
         BesoinRepository besoinRepository = new BesoinRepository();    
         FichierPlanRepository fichierPlanRepository = new FichierPlanRepository();     
         RapportService rapportService = new RapportService();    
         try {
         
            ArrayList<BesoinReseau> besoins = besoinRepository.chargerBesoins(fichierBesoins);  
            Moteur_VLSM moteurVLSM = new Moteur_VLSM();  
            ArrayList<ResultatVLSM> resultats = moteurVLSM.genererPlan("10.10.0.0", besoins); 
            GestionnaireVLAN gestionnaireVLAN = new GestionnaireVLAN();    
            int numeroVLAN = 10;            
            for (ResultatVLSM resultat : resultats) {        
                VLAN vlan = new VLAN(numeroVLAN, resultat.getNomBesoin(), resultat, "VLAN " + resultat.getNomBesoin());                 gestionnaireVLAN.ajouterVLAN(vlan);                 numeroVLAN += 10;      
            }           
            MoteurRecommandation moteurRecommandation = new MoteurRecommandation();   
            moteurRecommandation.ajouterRegle(new RecommandationWifiInvite());    
            moteurRecommandation.ajouterRegle(new RecommandationServeurs());       
            moteurRecommandation.ajouterRegle(new RecommandationGrandVLAN());          
                ArrayList<Recommandation> recommandations = moteurRecommandation.analyserVLANs(gestionnaireVLAN.getVlans());              fichierPlanRepository.sauvegarderPlanCSV(resultats, fichierPlan);   
                fichierPlanRepository.sauvegarderVLANsCSV(gestionnaireVLAN.getVlans(), fichierVlans);   
                fichierPlanRepository.sauvegarderRecommandations(recommandations, fichierRecommandations);
                rapportService.genererRapportComplet(                     besoins,                     resultats,                     gestionnaireVLAN.getVlans(),                     recommandations,                     fichierRapport             );  
                System.out.println("Traitement terminé avec succès.");          
                System.out.println("Fichiers générés dans le dossier exports.");      
         } catch (IOException e) {        
             System.out.println("Erreur de fichier : " + e.getMessage());      
         } catch (ConflitVLANException e) {          
             System.out.println("Erreur VLAN : " + e.getMessage()); 
 
        }    
     }
 
    

