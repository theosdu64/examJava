# Application de Vente de Formations

Application console Java permettant la gestion et la vente de formations en ligne.

## Technologies

- Java 17+
  - MariaDB 10.6+
  - JDBC
- Maven

## Architecture

L'application suit une architecture en couches :

        ```
        ├── entities/          Classes métier (Formation, Utilisateur, Client, Commande, ArticleCommande)
├── dao/               Accès aux données (DAO pattern, Helper)
├── business/          Logique métier
└── application/       Interface console
```

        ## Base de données

### Configuration

```properties
URL      : jdbc:mariadb://localhost:3308/formation
User     : formation_user
Password : formation2025
```

        ### Schéma

- **formation** : Catalogue des formations disponibles
- **utilisateur** : Comptes utilisateurs
- **client** : Informations clients bénéficiaires
- **commande** : Commandes passées
- **article_commande** : Détails des commandes (quantité, prix)

### Installation

```bash
# Créer la base et l'utilisateur
mysql -u root -p < scripts/create_database_and_user.sql

# Créer les tables et insérer les données
mysql -u formation_user -p formation < scripts/formation_database.sql
```

        ## Fonctionnalités

### Consultation (tous utilisateurs)
- Afficher toutes les formations
- Rechercher par mot-clé
- Filtrer par type (présentiel/distanciel)

### Gestion du panier
- Ajouter/retirer des formations
- Voir le contenu et le total
- Vider le panier

### Authentification
- Créer un compte
- Se connecter/déconnecter

### Commandes (utilisateurs connectés)
- Passer commande avec informations client
- Consulter l'historique des commandes
  - Voir le détail complet d'une commande

        ## Utilisation

### Compilation et exécution

```bash
# Compiler
mvn clean compile

# Exécuter
mvn exec:java -Dexec.mainClass="org.example.Main"
        ```

        ### Navigation

        Au lancement, un menu principal propose les différentes options disponibles. Les fonctionnalités de panier et commande nécessitent une connexion préalable.

        ## Patterns utilisés

- **DAO** : Séparation de la logique d'accès aux données
        - **Singleton** : Gestion unique de la connexion
- **Factory** : Création centralisée des objets DAO
- **MVC** : Séparation présentation/métier/données

## Règles de gestion

- Email utilisateur unique
- Client identifié par email (réutilisation si existant)
- Prix figé au moment de l'ajout au panier
        - Montant total calculé automatiquement
- Statut initial des commandes : EN_ATTENTE

## Livrables

- Diagrammes UML (cas d'utilisation, classes, séquence)
        - Spécifications fonctionnelles
        - Scripts SQL
        - Code source Java
        - Documentation

        ## Structure du projet

        ```
        src/
        ├── main/
        │   └── java/
        │       └── org/example/
        │           ├── Class/           Entités
        │           ├── Dao/             Accès données
        │           ├── Business/        Logique métier
        │           └── Main.java        Point d'entrée
        └── resources/
        └── sql/                     Scripts base de données
        ```
                  