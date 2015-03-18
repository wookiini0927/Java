#Projet JAVA 2014-2015

**Vendredi 13 Fevrier**

- Création package : model, controller, view, Resources
- Création classe :
	model :
		- Client
		- Compte
		- FichierClients
	controller :
		- testMain
	view :
		- AffichagePad
		- PadPass
		- SaisieClient

**Dimanche 15 Février**

- Client :
	- Constructeur
	- get/set
	- toString
- FichierClient
	- lecture d'un fichier
	- verification des numeroclient
-Comptes
	- constructeur
	- get/set
	- toString
	- versement :
		- debit normal
		- debit superieur au solde actuel
		- debit si decouvert
		- ca depasse pas le decouvert (ou créer en plus une fonction taxe) fonction a part
		- verifier que le montant du versement est inferieur au compte

**Lundi 16 mars**

- fenetre de connexion
- bouton reset
- actionlistener des chiffres


===

Idée :
	au lancement du programme, verification du fichier csv : clients (**numeroclient identique**)
	class creation coptes : rajouter un bouton dans la fenetre connexion, puis de là a la création ecrire dans le fichier csv

	generer un numero aleatoire dans le cas ou un numero client existe deja -> fonction a faire
	-> pareil pour le numero compte mais le faire tout le temps pour celui la
	verifier qu'un numero de compte n'existe pas deja


	dans creationCompte il faut recuperer l'objet du client, pour pouvoir relier le nouveau compte au client

