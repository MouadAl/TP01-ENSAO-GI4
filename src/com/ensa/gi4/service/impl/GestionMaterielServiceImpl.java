package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.List;

public class GestionMaterielServiceImpl implements GestionMaterielService {
    private MaterielDao dao = MaterielDao.getInstance();

    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        List<Materiel> myMaterials =dao.getListMateriel();
        System.out.println(myMaterials.size());
        for (int i=0;i<myMaterials.size();i++){
            Materiel m =myMaterials.get(i);
            System.out.println(m.getName());
        }

        /*System.out.println("Liste de matériel :\n 3 Livres \n 4 chaises"); */
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        //System.out.println("L'ajout du matériel " + materiel.getName() + " effectué avec succès !");

        dao.ajouterMateriel(materiel);
    }
    @Override
    public void modifierMateriel(String oldMaterielName, Materiel materiel){
        dao.updateMateriels(oldMaterielName, materiel);

    }
}
