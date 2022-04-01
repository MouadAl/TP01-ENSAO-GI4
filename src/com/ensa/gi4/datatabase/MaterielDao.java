package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

import java.util.ArrayList;
import java.util.List;

public class MaterielDao {
    private static MaterielDao singleton = new MaterielDao();

    private MaterielDao(){

    }

    public static MaterielDao getInstance(){
        return singleton;
    }
    private List<Materiel> listMateriel = new ArrayList<>();

    public List<Materiel> getListMateriel () {
        return listMateriel;
    }

    public void ajouterMateriel ( Materiel materiel){
        listMateriel.add(materiel);
    }

    public Materiel getMateriel(String nomMateriel){
        for (Materiel m : listMateriel){
            if(m.getName().equals(nomMateriel)) {
                return m;
            }
        }
        return null;
    }
    public  int getIndexOfMateriel (String nomMateriel){
        for (int i=0;i<listMateriel.size();i++){

            if(listMateriel.get(i).getName().equals(nomMateriel)){
                return i;
            }
        }
        return -1;
    }

    public int  updateMateriels (String oldMaterielName,Materiel newMateriel){
        int index = this.getIndexOfMateriel(oldMaterielName);
        if (index >=0){
            listMateriel.set(index,newMateriel);
                    return 1;
        }else {
            return -1;
        }
    }
    public void removeMateriel(Materiel materiel){
        int index= this.getIndexOfMateriel(materiel.getName());
        listMateriel.remove(index);
    }
    public static void main (String args []){
        /* Test Dao functions

        MaterielDao materiels = new MaterielDao();
       Materiel m1 = new Livre();
       m1.setName("livre1");
       Materiel m2 = new Livre();
       m2.setName("Livre2");
       Materiel m3 = new Livre();
       m3.setName("livre3");
       Materiel m4 = new Livre();
       m4.setName("livre4");
       Materiel m5 = new Livre();
       m5.setName("livre5");
       materiels.ajouterMateriel(m1);
       materiels.ajouterMateriel(m2);
       materiels.ajouterMateriel(m3);
       materiels.ajouterMateriel(m4);
       materiels.ajouterMateriel(m5);

        for (Materiel m : materiels.listMateriel){
           System.out.println( materiels.listMateriel.indexOf(m)+" "+m.getName());
       }
        Materiel newMateriel = new Livre();
        newMateriel.setName("livre777");

        materiels.updateMateriels("livre3",newMateriel);
        System.out.println("\n");
        for (Materiel m : materiels.listMateriel){
            System.out.println( materiels.listMateriel.indexOf(m)+" "+m.getName());
        }
        materiels.removeMateriel(m4);
        System.out.println("\n");
        for (Materiel m : materiels.listMateriel){
            System.out.println( materiels.listMateriel.indexOf(m)+" "+m.getName());
        }

         */

    }



}
