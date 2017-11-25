- Dans Mysql, créer une table "gestionbanque" et importer le fichier "gestionbanque.sql"

- Pour executer le JAR, executé l'invite de commande et ce positionnant dans le repertoire du fichier jar, puis taper la commande:
java -cp gestionbanquev1-1.0-SNAPSHOT.jar;mysql-connector-java-5.0.5.jar fr.gestionbanquev1.gestionbanque.GestionBanque

- Un nom vous sera demandé pour vous authentifier. Le nom est "DARABID" (en minuscule ou majuscule).
- une fois authentifié, un menu apparaitra :
	- Choix numero "1" pour consulter votre demande.
	_ Choix numero "2" pour retirer de l'argent.
		- vous devrait indiquer un montant de retrait qui soit inférieur à votre solde