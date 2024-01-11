/**
 * 
 */
package controleur;

/**
 * Global contient les constantes du programme
 * @author emds
 *
 */
public interface Global {
	
	/**
	 * N� du port d'�coute du serveur
	 */
	int PORT = 6666;
	/**
	 * Nombre de personnages diff�rents
	 */
	int NBPERSOS = 3;
	/**
	 * Caract�re de s�paration dans un chemin de fichiers
	 */
	String CHEMINSEPARATOR = "/";
	/**
	 * Chemin du dossier des images de fonds
	 */
	String CHEMINFONDS = "fonds"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier de l'image de la boule
	 */
	String CHEMINBOULES = "boules"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier de l'image du mur
	 */
	String CHEMINMURS = "murs"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier des images des personnages
	 */
	String CHEMINPERSONNAGES = "personnages"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier des sons
	 */
	String CHEMINSONS = "sons"+CHEMINSEPARATOR;
	/**
	 * Chemin de l'image de fond de la vue ChoixJoueur
	 */
	String FONDCHOIX = CHEMINFONDS+"fondchoix.jpg";
	/**
	 * Chemin de l'image de fond de la vue Arene
	 */
	String FONDARENE = CHEMINFONDS+"fondarene.jpg";
	/**
	 * Extension des fichiers des images des personnages
	 */
	String EXTFICHIERPERSO = ".gif";
	/**
	 * D�but du nom des images des personnages
	 */
	String PERSO = "perso";
	/**
	 * Chemin de l'image de la boule
	 */
	String BOULE = CHEMINBOULES+"boule.gif";
	/**
	 * Chemin de l'image du mur
	 */
	String MUR = CHEMINMURS+"mur.gif";
	/**
	 * �tat marche du personnage
	 */
	String MARCHE = "marche";
	/**
	 * �tat touch� du personnage
	 */
	String TOUCHE = "touche";
	/**
	 * �tat mort du personnage
	 */
	String MORT = "mort";
	/**
	 * Caract�re de s�paration dans les chaines transf�r�es
	 */
	String STRINGSEPARE = "~";
	/**
	 * Message "connexion" envoy� par la classe Connection
	 */
	String CONNEXION = "connexion";
	/**
	 * Message "r�ception" envoy� par la classe Connection
	 */
	String RECEPTION = "r�ception";
	/**
	 * Message "d�connexion" envoy� par la classe Connection
	 */
	String DECONNEXION = "d�connexion";
	/**
	 * Message "pseudo" envoy� pour la cr�ation d'un joueur
	 */
	String PSEUDO = "pseudo";
	/**
	 * vie de d�part pour tous les joueurs
	 */
	int MAXVIE = 10 ;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	int GAIN = 1 ; 
	/**
	 * perte de points de vie lors d'une attaque
	 */
	int PERTE = 2 ; 
	/**
	 * hauteur de la zone de jeu de l'arene 
	 */
	int HAUTEURARENE = 600;
	/**
	 * largeur de la zone de jeu de l'arene
	 */
	int LARGEURARENE = 800;
	/**
	 * hauteur d'un mur
	 */
	int HAUTEURMUR = 35;
	/**
	 * largeur d'un mur 
	 */
	int LARGEURMUR = 34;
	/**
	 * largeur du personnage 
	 */
	int LARGEURPERSO = 39;
	/**
	 * hauteur du personnage
	 */
	int HAUTEURPERSO = 44;
	/**
	 * hauteur du message
	 */
	int HAUTEURMESSAGE = 8;
	/**
	 * nombres de murs dans l'ar�ne 
	 */
	int NBMURS = 20;
	/**
	 * ordre pour ajouter un mur dans l'ar�ne du serveur
	 */
	String AJOUTMUR = "ajout mur";
	/**
	 * ordre pour ajouter le panel de smurs dans l'ar�ne du client 
	 */
	String AJOUTPANELMURS = "ajout panel murs";
	/**
	 * ordre pour ajouter un jLabel dans l'ar�ne du serveur (joueur, message, boule) 
	 */
	String AJOUTJLABELJEU = "ajout jlabel jeu";
	/**
	 * orientation du personnage vers la gauche 
	 */
	int GAUCHE = 0;
	/**
	 * orientation du personnage vers la droite 
	 */
	int DROITE = 1;
	/**
	 * ordre pour modifier le panel du jeu dans l'ar�ne du client 
	 */
	String MODIFPANELJEU = "modif panel jeu";
	/**
	 * ordre pour demander d'ajouter une phrase au tchat 
	 */
	String TCHAT = "tchat";
	/**
	 * Ordre pour ajouter une phrase dans l'ar�ne du serveur
	 */
	String AJOUTPHRASE = "ajout phrase";
	/**
	 * Osrdre pour modifier le contenu du tchat
	 */
	String MODIFTCHAT = "modif tchat";
	/**
	 * Message "serveur" pour la cr�ation d'un serveur
	 */
	String SERVEUR = "serveur";
	/**
	 * Message "client" pour la cr�ation d'un client 
	 */
	String CLIENT = "client";
	/**
	 * ordre pour ex�cuter une action 
	 */
	String ACTION = "action";
	/**
	 * taille du pas quand le personnage avance (nombre de pixels)
	 */
	int PAS = 10;
	/**
	 * Nombre d'�tapes (d'images) pour donner l'impression de la marche 
	 */
	int NBETAPESMARCHE = 4;
}
