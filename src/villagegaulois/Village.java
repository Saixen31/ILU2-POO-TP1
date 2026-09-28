package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	private class Marche{
		private int nbEtal;
		private Etal[] etals;
		private Marche(int nbEtal){
			this.nbEtal = nbEtal;
			etals = new Etal[nbEtal];
		}
		
		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
				etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
			}
		private int trouverEtalLibre() {
			int etalLibre = -1;
			for (int i = 0;i < nbEtal ;i++) {
				if(!etals[i].isEtalOccupe()) {
					etalLibre = i;
				}
			}
			return etalLibre;
		}
		private Etal[] trouverEtals(String produit) {
			int nbEtalProduit = 0;
			for(int i = 0; i<nbEtal;i++) {
				if(etals[i].contientProduit(produit)) {
					nbEtalProduit ++;
				}
			}
			int indexRemplissage = 0;
			Etal[] etalProduit = new Etal[nbEtalProduit];
			for(int j = 0; j < nbEtal; j++) {
				if(etals[j].contientProduit(produit)) {
					etalProduit[indexRemplissage]= etals[j];
					indexRemplissage++;
				}
			}
			return etalProduit;
		}
		private Etal trouverVendeur(Gaulois gaulois) {
			for(int i = 0; i<nbEtal; i++) {
				if(etals[i].isEtalOccupe() && etals[i].getVendeur()== gaulois) {
					return etals[i];
				}
				return null;
			}
		}
		private String afficherMarche() {
			StringBuilder affichage = new StringBuilder();
			int nbEtalsVides = 0;
			for(int i = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe()){
					affichage.append(etals[i].afficherEtal());
				}
				else {
					nbEtalsVides++;
				}
			}
			if(nbEtalsVides > 0) {
				affichage.append("")
			}
			}
		}
		
	}
}


	
