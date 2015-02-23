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

===

Idée :

	generer un numero aleatoire dans le cas ou un numero client existe deja -> fonction a faire
	-> pareil pour le numero compte mais le faire tout le temps pour celui la


	versement :
		- debit normal
		- debit superieur au solde actuel
		- debit si decouvert
		- ca depasse pas le decouvert (ou créer en plus une fonction taxe) fonction a part
		- verifier que le montant du versement est inferieur au compte

