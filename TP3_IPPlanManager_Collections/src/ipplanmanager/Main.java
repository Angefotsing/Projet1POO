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
        InfrastructureReseau infrastructure =                 new InfrastructureReseau("Infrastructure YFY");         ReseauIP reseauAdmin =                 new ReseauIP(                         "192.168.1.0",                         24,                         "Réseau administration"                 );     
        ReseauIP reseauTech =                 new ReseauIP(                         "192.168.2.0",                         24,                         "Réseau technique"                 );      
        SousReseau admin =                 new SousReseau(                         "ADMIN",                         reseauAdmin                 );         SousReseau tech =                 new SousReseau(                         "TECH",                         reseauTech                 );       
        infrastructure.ajouterSousReseau(admin);       
        infrastructure.ajouterSousReseau(tech);        
        AdresseIP ip1 = new AdresseIP("192.168.1.1"); 
        AdresseIP ip2 = new AdresseIP("10.0.0.1");          
        InterfaceReseau eth0 = new InterfaceReseau("eth0", ip1);    
        InterfaceReseau eth1 = new InterfaceReseau("eth1", ip2);   
        eth0.activer();        
        eth1.activer();        
        Equipement routeur = new Equipement(                         "R1_EDGE",                         "Routeur"                 );   
        routeur.ajouterInterface(eth0);   
        routeur.ajouterInterface(eth1);      
        infrastructure.ajouterEquipement(routeur); 
        ReseauIP reseauWiFi = new ReseauIP("192.168.3.0", 24, "Réseau WiFi Invité");
        SousReseau wifi = new SousReseau("WIFI", reseauWiFi);
        infrastructure.ajouterSousReseau(wifi);
        Equipement switchPrincipal = new Equipement("SW_COEUR", "Switch L3");
        infrastructure.ajouterEquipement(switchPrincipal);
        Equipement serveurWeb = new Equipement("SRV_WEB", "Serveur Linux");
        AdresseIP ipSrv1 = new AdresseIP("192.168.1.50");
        AdresseIP ipSrv2 = new AdresseIP("192.168.2.50");
        InterfaceReseau eth0Srv = new InterfaceReseau("eth0", ipSrv1);
        InterfaceReseau eth1Srv = new InterfaceReseau("eth1", ipSrv2);
        eth0Srv.activer();
        eth1Srv.activer();
        serveurWeb.ajouterInterface(eth0Srv);
        serveurWeb.ajouterInterface(eth1Srv);
        infrastructure.ajouterEquipement(serveurWeb);
        infrastructure.afficher();   
    }
}