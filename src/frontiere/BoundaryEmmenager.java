package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue vilageois " + nomVisiteur);
					question = new StringBuilder();
					question.append("Quelle est votre force ?");
					int force = Clavier.entrerEntier(question.toString()); 
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		StringBuilder question = new StringBuilder();
		question.append("Quelle est votre force ?");
		int choixUtilisateur = Clavier.entrerEntier(question.toString());
		int force = choixUtilisateur;
		int effetPotionMin = 1;
		int effetPotionMax = 0;
		while (effetPotionMin > effetPotionMax) {
			question = new StringBuilder();
			question.append("Quelle est la force de la potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(question.toString());
			question = new StringBuilder();
			question.append("Quelle est la force de la potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(question.toString());
			
			if (effetPotionMin <= effetPotionMax) {
				break;
			}
			
			System.out.println("Attention Druide, vous vous �tes tromp� entre le maximum et le minimum !");
		}
		
		controlEmmenager.ajouterDuide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
