/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author ANGELA
 */
public class RecommandationMargeAdresse implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        ResultatVLSM res = vlan.getReseauAssocie();
        if (res != null) {
            int marge = res.getCapacite() - res.getHotesDemandes();
            if (marge <= 10) { // Exemple : alerte si moins de 10 IPs libres
                return new Recommandation("Marge Faible", 
                    "Le VLAN " + vlan.getNomVlan() + " n'a que " + marge + " adresses de marge. Prévoyez une plage plus large.");
            }
        }
        return null;
    }
}
    
