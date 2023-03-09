package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String infosMarche[] = controlAfficherMarche.donnerInfosMarche();
		
		if (infosMarche.length == 0) {
			StringBuilder reponse = new StringBuilder();
			reponse.append("Le marché est vide, revenez plus tard");
		}
		
		else {
			StringBuilder reponse = new StringBuilder();
			reponse.append(nomAcheteur + ", vous trouverez au marché : \n");
			
			int i = 0;
			
			System.out.println(infosMarche.length);
			
			while (i < infosMarche.length - 1) {
				reponse.append("- " + infosMarche[i] + " qui vend ");
				i++;
				reponse.append(infosMarche[i] + " ");
				i++;
				reponse.append(infosMarche[i] + "\n");
			}
			
			System.out.println(reponse.toString());
		}
	}

}