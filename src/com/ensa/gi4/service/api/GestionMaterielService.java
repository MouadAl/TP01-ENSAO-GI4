package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void init();
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void modifierMateriel(String oldMaterielName,Materiel materiel);
    void removeMateriel(String materielName);

}
