package modele;

import java.net.URL;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controleur.Global;

/**
 * Gestion de la boule
 *
 */
public class Boule extends Objet implements Global, Runnable{

	/**
	 * instance de JeuServeur pour la communication
	 */
	private JeuServeur jeuServeur ;
	
	/**
	 * collection de murs
	 */
	private Collection lesMurs;

	/**
	 * joueur qui lance la boule
	 */
	private Joueur attaquant;
	
	/**
	 * Constructeur
	 */
	public Boule(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		super.jLabel = new JLabel();
		super.jLabel.setVisible(false);
		URL resource = getClass().getClassLoader().getResource(BOULE);
		super.jLabel.setIcon(new ImageIcon(resource));
		super.jLabel.setBounds(0,0,LARGEURBOULE, HAUTEURBOULE);
	}
	
	/**
	 * Tire d'une boule
	 */
	public void tireBoule(Joueur attaquant, Collection lesMurs) {
		this.lesMurs = lesMurs;
		this.attaquant = attaquant;
		// positionnement de la boule 
		if (attaquant.getOrientation() == GAUCHE) {
			posX = attaquant.getPosX() - LARGEURBOULE - 1;
		}else {
			posX = attaquant.getPosX() + LARGEURPERSO + 1;
		}
		posY = attaquant.getPosY() + HAUTEURPERSO / 2;
		// d�marrer le thread pour g�rer le tir de la boule 
		new Thread(this).start();
	}

	@Override
	public void run() {
		// envoi du son FIGHT 
		this.jeuServeur.envoi(FIGHT);
		// afficher l'attaquant � l'�tape repos de la marche 
		this.attaquant.affiche(MARCHE, 1);
		// rendre la boule visible 
		super.jLabel.setVisible(true);
		// pr�parer la victime (dans le cas o� le joueur est touch�) 
		Joueur victime = null;
		// pas positif ou n�gatif (suivant l'orientation du joueur) pour faire avancer la boule
		int lePas;
		if (attaquant.getOrientation() == GAUCHE) {
			lePas = - PAS;
		} else {
			lePas = PAS;
		}
		// gestion de la trajectoire de la boule 
		do {
			// la boule avance 
			posX += lePas;
			jLabel.setBounds(posX, posY, LARGEURBOULE, HAUTEURBOULE);
			// envoi de la nouvelle zone de jeu � tous (pour que tous voient la boule avancer) 
			this.jeuServeur.envoiJeuATous();
			// r�cup�re la collection actuelle de joueur 
			Collection lesJoueurs = this.jeuServeur.getLesJoueurs();
			// r�cup�ration de l'�ventuelle victime 
			victime = (Joueur)super.toucheCollectionObjets(lesJoueurs);
		}while (posX >= 0 && posX <= LARGEURARENE && this.toucheCollectionObjets(lesMurs)== null && victime==null);
		// v�rifiez s'il y a une victime et qu'elle n'est pas d�j� morte 
		if (victime != null && !victime.estMort()) {
			// envoi du son HURT 
			this.jeuServeur.envoi(HURT);
			// gestion de gain et perte de vie 
			victime.perteVie();
			attaquant.gainVie();
			// joue l'amination de la victime bless�e 
			for (int k = 1 ; k <= NBETAPESTOUCHE; k++) {
				victime.affiche(TOUCHE, k);
				pause(80,0);
			}
			// contr�le si la victime est morte 
			if (victime.estMort()) {
				// envoi du son death
				this.jeuServeur.envoi(DEATH);
				//joue l'animation de la victime morte 
				for (int k = 1 ; k <= NBETAPESMORT; k++) {
					victime.affiche(MORT, k);
					pause(80,0);
				}
			}else {
				victime.affiche(MARCHE, 1);
			}
		}
		// rendre la boule invisible 
		this.jLabel.setVisible(false);
		// envoyer le nouveau jeu � tous
		this.jeuServeur.envoiJeuATous();
	}
	
	private void pause(long millis, int nanos) {
		try {
			Thread.sleep(millis, nanos);
		} catch (InterruptedException e) {
			System.out.println("ereur pause");
		}
	}
	
}
