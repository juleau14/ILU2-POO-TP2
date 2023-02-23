package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		Gaulois habitantTrouve = village.trouverHabitant(nomVendeur);
		
		boolean identifie = true;
		
		if (habitantTrouve == null) {
			identifie = false;
		}
		
		return identifie;
	}
}
