/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author ANGELA
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP1 =====");
        System.out.println("Découverte des premières classes du projet");
        System.out.println();
        AdresseIP ipRouteur = new AdresseIP("192.168.1.1");
        AdresseIP ipServeur = new AdresseIP("192.168.1.10");
        AdresseIP ipClient = new AdresseIP("192.168.1.50");
        InterfaceReseau interfaceRouteur = new InterfaceReseau("eth0", ipRouteur);
        InterfaceReseau interfaceServeur = new InterfaceReseau("eth0", ipServeur);
        InterfaceReseau interfaceClient = new InterfaceReseau("wlan",ipClient);
        interfaceRouteur.activer();
        interfaceServeur.activer();
        Equipement routeur = new Equipement("R1_EDGE","Routeur", interfaceRouteur);
        Equipement serveur = new Equipement("SRV_DNS", "Serveur", interfaceServeur);
        Equipement client = new Equipement("PC_ADMIN", "=Poste client", interfaceClient);
        ReseauIP reseauPrincipal = new ReseauIP("192.169.1.0", 24, "Réseau principal du laboratoire IRT");        System.out.println("----- Réseau crée -----");
        reseauPrincipal.afficher();
        System.out.println();
        System.out.println("-----Équipement crée-----");
        System.out.println();
        routeur.afficher();
        System.out.println();
        serveur.afficher();
        System.out.println();
        client.afficher();
        ReseauIP r2 = new ReseauIP("10.0.0.0", 8, "Réseau de gestion(Management)");
        r2.afficher();
        System.out.println();
        System.out.println("Nom de l'équipement : SW_COEUR");
        System.out.println("Type d'équipement : Switch");
        InterfaceReseau vlan1 = new InterfaceReseau("VLAN1", new AdresseIP("10.0.0.1"));
        vlan1.activer();
        vlan1.afficher();
        System.out.println();
        System.out.println("Nom de l'équipement : PC_USER1");
        System.out.println("Type d'équipement : Poste client");
        InterfaceReseau eth_pc = new InterfaceReseau("eth0", new AdresseIP("192.168.1.50"));
        eth_pc.afficher();
        System.out.println();
        InterfaceReseau interfaceSansIP = new InterfaceReseau("eth1", null);
        interfaceSansIP.afficher();
        
        
        
        
        
        
       
        
        
    }
    
}
