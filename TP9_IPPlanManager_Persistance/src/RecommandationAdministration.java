/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ANGELA
 */
public class RecommandationAdministration  implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        String nom = vlan.getNomVlan().toUpperCase();
        if (nom.contains("ADMIN") || nom.contains("ADMINISTRATION")) {
            return new Recommandation("Sécurité Administration",
                "VLAN sensible détecté (" + vlan.getNomVlan() + "). Limitez l'accès aux administrateurs réseau uniquement.");
        }
        return null;
    }
}
