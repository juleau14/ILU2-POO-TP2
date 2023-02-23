package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean vendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if (!vendeurConnu) {
			System.out.println("Je suis d�sol�e " + nomVendeur + " il faut etre du village pour avoir un �tal");
		} 
		else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un �tal");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			
			if (!etalDisponible) {
				System.out.println("D�sol� " + nomVendeur + " je n'ai plus d'�tal libre.");	
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		
		System.out.println("C'est parfaut, il me reste un �tal pour vous.");
		System.out.println("Il me faut quelques renseignements.");
		System.out.println("Quel produit souhaitez vous vendre ?");
		String produit = scan.next();
		StringBuilder question = new StringBuilder();
		question.append("Combien souhaitez vous en vendre ?");
		int nbVente = Clavier.entrerEntier(question.toString());
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbVente);
		
		if (numeroEtal != -1) {
			System.out.println("Le vendeur "+ nomVendeur + " s'est install� � l'�tal numero " + numeroEtal);
		}
		
	}
}
