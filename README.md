# Travaux pratiques : Gestion Hôtelière

## Pour démarrer :

-  Le sujet du TP dans `docs/TP FINAL - JPA - Doranco.pdf`
-  Editez le fichier `persistence.xml` en y ajoutant les informations de connexion à votre base de donnée.

## 🚀 Fonctionnement du Programme
Ce guide vous aidera à démarrer avec notre programme en quelques étapes simples. Suivez les instructions ci-dessous pour utiliser le programme efficacement.

## 🛠️ Compilation
Pour préparer le programme à l'exécution, commencez par compiler le code source. Ceci préparera l'application pour être exécutée sur votre système.

## 🏃‍♂️ Exécution
Une fois compilé, vous pouvez exécuter le programme. À l'ouverture, l'application vous présentera plusieurs options pour interagir avec les données :

- **Créer (CREATE)** : Ajoutez de nouvelles données dans le système.
- **Lire (READ)** : Consultez les données existantes.
- **Modifier (UPDATE)** : Apportez des modifications aux données sélectionnées.
- **Supprimer (DELETE)** : Retirez les données inutiles ou obsolètes.
## 📊 Types de Données
Vous aurez le choix entre différents types de données pour effectuer votre action :

- **Chambre (BEDROOM)** : Gestion des chambres d'hôtel.
- **Réservation (BOOKING)** : Gestion des réservations.
- **Client (CLIENT)** : Gestion des informations clients.
- **Employé (EMPLOYEE)** : Gestion des employés de l'hôtel.
- **Hôtel (HOTEL)** : Informations sur l'hôtel et sa gestion.
- **Service (SERVICE) (WIP)** : Gestion des services offerts par l'hôtel.
## 📝 Exemple: Réaliser une réservation client complète
Pour réaliser une réservation client complète vous pouriez vous y prendre de cette façon :
1. `CREATE` > `BOOKING` > `<client_id>` : Créer une réservation pour un client
2. `READ` > `BOOKING` > `<client_name> <client_firstname>` : Récupère l'id des réservations du client
3. `UPDATE` > `BEDROOM` > `<id_bedroom_réservé>` > `<id_hotel_of_bedroom>` > `<id_booking_client>` >`<bedroom_number>` > `<bedroom_type>` > `<bedroom_price>`

À la base tout cela devait se retrouver dans une Action pour simplifier les choses, mais je n'ai pas eu le temps.

## 📊 Diagrammes du Projet
Pour une meilleure compréhension de la structure et du fonctionnement de notre base de données, consultez les diagrammes suivants situés dans le dossier `./merise/ du projet` :

### 🗂️ Modèle Conceptuel de Données (MCD)
Le MCD offre une vue d'ensemble des entités et des relations entre elles. Cela vous aide à comprendre comment les données sont organisées au niveau conceptuel.

![MCD](./merise/MCD.svg)


### 📐 Modèle Logique de Données (MLD)
Le MLD traduit le MCD en une structure prête pour l'implémentation, définissant les tables, les clés primaires, les clés étrangères, et les relations entre les tables.

![MLD](./merise/MLD.svg)

### 🛠️ Modèle Physique de Données (MPD)
Le MPD est la dernière étape de la modélisation, où le MLD est transformé en instructions SQL spécifiques pour la création de la base de données. Cela comprend la définition des index, des contraintes, et d'autres éléments nécessaires à l'implémentation physique de la base de données.

![MPD](./merise/MPD.svg)

Ces diagrammes sont essentiels pour comprendre la structure de la base de données de notre projet et pour guider le développement et la maintenance du système.

# ⚠️ Note importante pour William
Ce README a été arrangé par ChatGPT seulement pour le rendre plus jolie 🙂
