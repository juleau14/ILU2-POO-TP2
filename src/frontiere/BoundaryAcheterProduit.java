package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean isResident = controlAcheterProduit.isResident(nomAcheteur);
		if (!isResident) {
			System.out.println("Désolé, il faut habiter ici pour acheter quelque chose.");
		}
		else {
			controlAcheterProduit.afficherMarche(nomAcheteur);
			System.out.println("Entrez le nom du marchand qui vous interresse :");
			String nomVendeur = scan.next();
			while (!controlAcheterProduit.isVendeur(nomVendeur)) {
				System.out.println("Mauvais nom, entrez un nouveau :");
				nomVendeur = scan.next();
			}
			
			System.out.println("Combien d'objets voulez vous acheter ?");
			int nb = scan.nextInt();
			
			while (!controlAcheterProduit.procederAchat(nomVendeur, nb)) {
				System.out.println("Le vendeur n'a pas assez de qtt. Entrez un nouveau nombre");
				nb = scan.nextInt();
			}
			
			System.out.println("Achat effectué.");
		}
	}
}
