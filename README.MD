### GAME UI API

Implémentation de GAME UI API

### Lancer le projet

Via un IDE ou via cmd 
```
mvn clean install && mvn spring-boot:run
```

Port par défaut : 9000

### Routes

Liste des routes dispo sur le swagger (/swagger-ui.html)

GET /fight/{opponent} -> battle
GET / -> index
POST /registerTrainer -> register new trainer
GET /trainers -> getAllTrainers
GET /pokedex -> pokedex
GET /profile -> profile

####Security

J'ai mis une couche de base de sécurité 
voici les identifiants (exemple): 

NDC :``Ash``

PWD:``ash_password``

###Notes

J'ai mis de base les urls en local dans mes applications.properties
