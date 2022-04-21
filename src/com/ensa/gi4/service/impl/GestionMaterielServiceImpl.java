package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("gestionMaterielService")
public class GestionMaterielServiceImpl implements GestionMaterielService {
    //private MaterielDao dao = MaterielDao.getInstance();
    //Injection par annotation
    @Autowired
    private MaterielDao dao;

//Injection par XML
  /*  public void setMaterielDao(MaterielDao materielDao) {
        // injection par accesseur
        this.dao = materielDao;
    }*/

    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        List<Materiel> myMaterials = dao.getListMateriel();
        if (myMaterials.size() > 0) {
            for (int i = 0; i < myMaterials.size(); i++) {
                Materiel m = myMaterials.get(i);
                System.out.println(i + " ** " + m.getName());
            }
        } else {
            System.out.println("pas de matériel  disponible ,pensez à en ajouter");
        }
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        dao.ajouterMateriel(materiel);
    }

    @Override
    public void modifierMateriel(String oldMaterielName, Materiel materiel) {
        int isUpdated = dao.updateMateriels(oldMaterielName, materiel);
        if (isUpdated < 0) {
            System.out.println("Materiel doesn't exist");
        }
    }

    public void removeMateriel(String materielName) {
        try {
            Materiel m = dao.getMateriel(materielName);
            dao.removeMateriel(m);
        } catch (Exception e) {
            System.out.println("le materiel n'existe pas ");
        }
    }
}
