package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			StringBuilder reponse = new StringBuilder();
			reponse.append("Mais vous n'etes pas inscrit sur notre marché aujourd'hui !");
			System.out.println(reponse.toString());
		}
		
		else {
			String donneesEtal[] = controlLibererEtal.libererEtal(nomVendeur);
			
			if (donneesEtal[0] == "true") {
				StringBuilder reponse = new StringBuilder();
				reponse.append("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ". \nAu revoir " + donneesEtal[1] + ", passez un bonne journee.");
				System.out.println(reponse.toString());
			}
		}
	}

}
