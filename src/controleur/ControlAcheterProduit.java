package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import frontiere.BoundaryAfficherMarche;
import personnages.*;

public class ControlAcheterProduit {
	private Village village;
	private BoundaryAfficherMarche boundaryAfficherMarche;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isResident(String nomAcheteur) {
		if (village.trouverHabitant(nomAcheteur) == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void afficherMarche(String nomAcheteur) {
		boundaryAfficherMarche.afficherMarche(nomAcheteur);
	}
	
	public boolean isVendeur(String nomVendeur) {
		Gaulois gauloisTrouve = village.trouverHabitant(nomVendeur);
		
		if (gauloisTrouve == null) {
			return false;
		}
		
		else if (village.rechercherEtal(gauloisTrouve) == null) {
			return false;
		}
		
		else {
			return true;
		}
		
	}
	
	
	public boolean procederAchat(String nomVendeur, int nb) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		Etal etal = village.rechercherEtal(vendeur);
		if (nb > etal.getQuantite()) {
			return false;
		}
		else {
			etal.acheterProduit(nb);
			return true;
		}
	}
}
