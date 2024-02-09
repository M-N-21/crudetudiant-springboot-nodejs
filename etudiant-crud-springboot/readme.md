# Projet CRUD Etudiant avec Spring Boot

Ce projet est une application de gestion des étudiants avec des opérations CRUD (Create, Read, Update, Delete) développée avec Spring Boot.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants :

- Java Development Kit (JDK) 17 ou supérieur
- Apache Maven
- MySQL

## Architecture du Projet

Le projet suit une architecture standard de projet Spring Boot avec les composants suivants :

- **Controller** : Les contrôleurs exposent les endpoints de l'API REST pour effectuer les opérations CRUD sur les étudiants.
- **Service** : Les services contiennent la logique métier de l'application, telle que la manipulation des données des étudiants.
- **Repository** : Les repositories sont des interfaces qui étendent JpaRepository et gèrent les opérations de base de données pour l'entité Etudiant.
- **Entity** : L'entité Etudiant représente la structure des données stockées en base de données.
- **DTO (Data Transfer Object)** : Les DTO sont des objets utilisés pour transférer des données entre le client et le serveur, permettant de séparer les modèles de données internes des objets exposés via l'API REST. (Bonne pratique)

## Dépendances

Ce projet utilise les dépendances suivantes :

- **spring-boot-starter-data-jpa** : Pour l'intégration de Spring Data JPA et Hibernate.
- **spring-boot-starter-web** : Pour le développement d'applications web, y compris la création d'API REST avec Spring MVC.
- **mysql-connector-java** : Le pilote JDBC pour MySQL.
- **spring-boot-starter-test** : Pour l'écriture de tests unitaires et d'intégration avec Spring Boot.
- **mapstruct** : Pour la conversion entre les entités Etudiant et les DTO.

## Configuration de la base de données

Ce projet utilise une base de données MySQL. Assurez-vous de configurer les paramètres de connexion dans le fichier `application.yaml` situé dans le répertoire `src/main/resources`. Vous pouvez y définir l'URL de la base de données, le nom d'utilisateur et le mot de passe.

```
server:
  port: 9091

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/etudiantcrud-db?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    username: root
    password:
    driverClassName: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
      dialect: org.hibernate.dialect.MySQL8Dialect
    show-sql: true
    properties:
      hibernate:
        format_sql: true


info:
  application:
    name: test
    version: '@project.version@'
```
Ne vous inquiétez pas une fois que cette configuration est prete, vous n'avez pas besoin d'aller creer la base de données manuellement cette annotation au niveau de l'url de la BD 
va nous permettre de creer la base de données si elle n'existe pas: `createDatabaseIfNotExist=true`.

## Lancement de l'application

Pour lancer l'application, exécutez la commande suivante dans le répertoire racine du projet :
`mvn spring-boot:run`
Cela démarrera l'application Spring Boot sur le port défini un peu plus haut dans le fichier `application.yaml` qui est le `9091`.

