Exécution de l'application : 

   1-Cloner le projet backend :
	git clone https://github.com/AymenBH52/Task_Management_Spring_Boot.git
	
   2-Installation des dépendances :
  
    mvn install
	
   3-Configuration de la base de données :
     Configurez la connexion à la base de données dans le fichier application.properties :
	
		spring.datasource.url=jdbc:mysql://localhost:3306/task_management?useSSL=false&createDatabaseIfNotExist=true
		spring.datasource.username=root
		spring.jpa.show-sql=true
		spring.jpa.hibernate.ddl-auto=update
		server.port=9000
	
  4-Démarrer le serveur backend avec Maven : 
   
    mvn spring-boot:run
	
  5- Accéder à l'API Backend :

   http://localhost:9000.	
   
API Backend Implémentées : 

1- Ajouter une tâche :
	Méthode: POST
	URL: http://localhost:9000/tasks
	Body (JSON format):
	{
    "name": "Learning Python",
    "status": false
    }
	
2- Récupérer toutes les tâches :
   Méthode: GET
   URL: http://localhost:9000/tasks
   
3- Récupérer les tâches filtrées par statut (GET /tasks?status=true)
   Méthode: GET
   URL: http://localhost:9000/tasks?status=true
   
4- Récupérer les tâches triées par date de création dans l'ordre descendant : 
   Méthode: GET
   URL: http://localhost:9000/tasks?sort=desc

5- Récupérer les tâches triées par date de création dans l'ordre ascendant : 
   Méthode: GET
   URL: http://localhost:9000/tasks?sort=asc
   
6-Modifier une tâche : 
   Méthode: PUT (/tasks/{id}) 
   URL: http://localhost:9000/tasks/1
   
7-Supprimer une tâche :
   Méthode: DELETE (/tasks/{id})
   URL: http://localhost:9000/tasks/1

   
	
   