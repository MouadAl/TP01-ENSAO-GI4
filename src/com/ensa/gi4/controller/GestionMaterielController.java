package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component("controller")
public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }
    public void ajouterMateriel(Materiel m) { gestionMaterielService.ajouterNouveauMateriel(m);}
    public void modifierMateriel(String oldNameMateriel,Materiel m){ gestionMaterielService.modifierMateriel(oldNameMateriel,m);}
    public void supprimerMateriel(String nomMateriel){ gestionMaterielService.removeMateriel(nomMateriel);}

    public void afficherMenu() {
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour modifier un  matériel existant , entrer 3");
        System.out.println("4- pour supprimer un  matériel existant , entrer 4");


        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            scanner.nextLine();
            System.out.println("Donner le nom du materiel:");
            String name= scanner.nextLine();
            Materiel m = new Materiel();
            m.setName(name);
            ajouterMateriel(m);


        } else if ("3".equals(next)){
            scanner.nextLine();
            System.out.println("donner le nom du materiel à modifier  ");
            String oldName = scanner.nextLine();
            System.out.println("donner le nom du materiel à ajouter  ");
            String newMateriel = scanner.nextLine();
            Materiel m = new Livre();
            m.setName(newMateriel);
            modifierMateriel(oldName,m);

        }else if ("4".equals(next)){
            scanner.nextLine();
            System.out.println("Donner le nom du matériel à supprimer");
            String name = scanner.nextLine();
            supprimerMateriel(name);


        } else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }
}
