# Formation Pratique Git et GitHub - Guide Pas à Pas

**Auteur:** Mohamed Yassine Derbel  
**Date:** Décembre 2025

---

## 🎯 Objectif de cette Formation

Cette formation vous guide **étape par étape** dans l'utilisation de Git et GitHub avec un **projet Spring Boot réel**. Vous allez :
- Faire des modifications de code
- Les commiter avec Git
- Créer des branches
- Fusionner des branches
- Gérer des conflits
- Travailler avec GitHub

**Prérequis :** Git installé sur votre machine

---

## 📋 Table des Matières

1. [Configuration Initiale](#configuration-initiale)
2. [Exercice 1 : Premier Commit](#exercice-1--premier-commit)
3. [Exercice 2 : Travailler sur une Branche Feature](#exercice-2--travailler-sur-une-branche-feature)
4. [Exercice 3 : Créer une Autre Feature en Parallèle](#exercice-3--créer-une-autre-feature-en-parallèle)
5. [Exercice 4 : Merge des Branches](#exercice-4--merge-des-branches)
6. [Exercice 5 : Gérer un Conflit](#exercice-5--gérer-un-conflit)
7. [Exercice 6 : Hotfix sur Main](#exercice-6--hotfix-sur-main)
8. [Exercice 7 : Annuler des Modifications](#exercice-7--annuler-des-modifications)
9. [Exercice 8 : Utiliser Stash](#exercice-8--utiliser-stash)
10. [Exercice 9 : Tags et Releases](#exercice-9--tags-et-releases)
11. [Récapitulatif des Commandes](#récapitulatif-des-commandes)

---

## Configuration Initiale

### Étape 1 : Vérifier Git

```powershell
# Vérifier que Git est installé
git --version

# Si pas installé, télécharger depuis https://git-scm.com
```

### Étape 2 : Configuration de Base

```powershell
# Configurer votre nom
git config --global user.name "Mohamed Yassine Derbel"

# Configurer votre email
git config --global user.email "votre.email@example.com"

# Vérifier
git config --list
```

### Étape 3 : Se Positionner dans le Projet

```powershell
# Aller dans le dossier du projet
cd c:\Users\derbe\OneDrive\Bureau\gitgithub

# Vérifier l'état de Git
git status

# Voir les branches
git branch
```

**✅ Vous êtes prêt à commencer !**

## Exercice 1 : Premier Commit

### 🎯 Objectif
Modifier le fichier `file1.java` et faire votre premier commit.

### 📝 Étapes

**1. Ouvrir et modifier `file1.java`**

Allez dans : `src/main/java/com/example/gitgithub/file1.java`

Modifiez le code comme suit :

```java
package com.example.gitgithub;

public class file1 {
    private String message = "Hello, GitHub!";
    private String author = "Mohamed Yassine Derbel";

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
}
```

**2. Vérifier les changements**

```powershell
# Voir l'état des fichiers
git status

# Voir les modifications en détail
git diff
```

**3. Ajouter à la staging area**

```powershell
# Ajouter le fichier modifié
git add src/main/java/com/example/gitgithub/file1.java

# Ou ajouter tous les fichiers modifiés
git add .

# Vérifier
git status
```

**4. Faire le commit**

```powershell
# Commit avec message
git commit -m "feat: ajouter propriété author dans file1"

# Voir l'historique
git log --oneline
```

**5. Push vers GitHub**

```powershell
# Push sur la branche main
git push origin main
```

**✅ Résultat attendu :**
- Le fichier `file1.java` a été modifié
- Un commit a été créé localement
- Le commit a été envoyé sur GitHub

## Exercice 2 : Travailler sur une Branche Feature

### 🎯 Objectif
Créer une nouvelle classe `User.java` sur une branche séparée.

### 📝 Étapes

**1. Créer une nouvelle branche**

```powershell
# Créer et basculer sur la branche feature-user
git checkout -b feature-user

# Vérifier la branche actuelle
git branch
```

**2. Créer le fichier `User.java`**

Créez : `src/main/java/com/example/gitgithub/User.java`

```java
package com.example.gitgithub;

public class User {
    private Long id;
    private String username;
    private String email;

    public User() {
    }

    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', email='" + email + "'}";
    }
}
```

**3. Vérifier et ajouter**

```powershell
# Voir les changements
git status

# Ajouter le nouveau fichier
git add src/main/java/com/example/gitgithub/User.java
```

**4. Commit**

```powershell
# Commit
git commit -m "feat: créer la classe User"

# Voir l'historique
git log --oneline --graph --all
```

**5. Push de la branche**

```powershell
# Push de la nouvelle branche vers GitHub
git push -u origin feature-user
```

**6. Vérifier sur GitHub**

Allez sur GitHub → Votre repo → Vous devriez voir la branche `feature-user`

**✅ Résultat attendu :**
- Branche `feature-user` créée
- Nouveau fichier `User.java` créé et commité
- Branche pushée sur GitHub

## Exercice 3 : Créer une Autre Feature en Parallèle

### 🎯 Objectif
Pendant que `feature-user` existe, créer une autre fonctionnalité sur une nouvelle branche.

### 📝 Étapes

**1. Retourner sur main**

```powershell
# Basculer sur main
git checkout main

# Vérifier qu'on est bien sur main
git branch
```

**2. Créer une nouvelle branche pour Product**

```powershell
# Créer et basculer sur feature-product
git checkout -b feature-product
```

**3. Créer le fichier `Product.java`**

Créez : `src/main/java/com/example/gitgithub/Product.java`

```java
package com.example.gitgithub;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;

    public Product() {
    }

    public Product(Long id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + ", stock=" + stock + "}";
    }
}
```

**4. Ajouter et commiter**

```powershell
# Ajouter
git add src/main/java/com/example/gitgithub/Product.java

# Commit
git commit -m "feat: créer la classe Product"
```

**5. Push de la branche**

```powershell
# Push
git push -u origin feature-product
```

**6. Voir toutes les branches**

```powershell
# Branches locales
git branch

# Branches locales et distantes
git branch -a

# Historique graphique
git log --oneline --graph --all
```

**✅ Résultat attendu :**
- Vous avez maintenant 3 branches : `main`, `feature-user`, `feature-product`
- Chaque branche a son propre contenu

## Exercice 4 : Merge des Branches

### 🎯 Objectif
Fusionner les branches features dans main.

### 📝 Étapes

**1. Merger feature-user dans main**

```powershell
# Basculer sur main
git checkout main

# Vérifier l'état
git status

# Merger feature-user
git merge feature-user

# Voir le log
git log --oneline --graph
```

**2. Push main**

```powershell
# Push les changements de main
git push origin main
```

**3. Merger feature-product dans main**

```powershell
# Toujours sur main
git merge feature-product

# Push
git push origin main
```

**4. Vérifier le contenu de main**

```powershell
# Liste des fichiers
ls src/main/java/com/example/gitgithub/

# Vous devriez voir :
# - GitgithubApplication.java
# - file1.java
# - User.java
# - Product.java
```

**5. Supprimer les branches fusionnées (optionnel)**

```powershell
# Supprimer les branches locales
git branch -d feature-user
git branch -d feature-product

# Supprimer les branches distantes
git push origin --delete feature-user
git push origin --delete feature-product

# Vérifier
git branch -a
```

**✅ Résultat attendu :**
- `main` contient maintenant `User.java` et `Product.java`
- Historique propre avec les merges
- Branches features supprimées (si vous avez choisi de le faire)

## Exercice 5 : Gérer un Conflit

### 🎯 Objectif
Créer volontairement un conflit et le résoudre.

### 📝 Étapes

**1. Modifier file1.java sur main**

```powershell
# S'assurer d'être sur main
git checkout main
```

Modifiez `src/main/java/com/example/gitgithub/file1.java` :

```java
package com.example.gitgithub;

public class file1 {
    private String message = "Hello, GitHub! - Version Main";
    private String author = "Mohamed Yassine Derbel";
    private String version = "1.0.0";  // NOUVEAU
    
    // ... rest du code
}
```

```powershell
# Commit sur main
git add .
git commit -m "feat: ajouter version 1.0.0 dans file1"
```

**2. Créer une branche et modifier le même fichier**

```powershell
# Créer une nouvelle branche DEPUIS le commit précédent
git checkout HEAD~1
git checkout -b feature-update-message
```

Modifiez `file1.java` :

```java
package com.example.gitgithub;

public class file1 {
    private String message = "Bonjour GitHub! - Version Feature";
    private String author = "Mohamed Yassine Derbel";
    private String description = "Formation Git";  // DIFFÉRENT
    
    // ... rest du code
}
```

```powershell
# Commit sur la branche
git add .
git commit -m "feat: modifier message et ajouter description"
```

**3. Tenter le merge : CONFLIT !**

```powershell
# Retour sur main
git checkout main

# Tenter de merger
git merge feature-update-message

# Vous verrez :
# CONFLICT (content): Merge conflict in src/main/java/com/example/gitgithub/file1.java
# Automatic merge failed; fix conflicts and then commit the result.
```

**4. Voir le conflit**

```powershell
# Voir les fichiers en conflit
git status
```

Ouvrez `file1.java`, vous verrez :

```java
<<<<<<< HEAD
    private String message = "Hello, GitHub! - Version Main";
    private String author = "Mohamed Yassine Derbel";
    private String version = "1.0.0";
=======
    private String message = "Bonjour GitHub! - Version Feature";
    private String author = "Mohamed Yassine Derbel";
    private String description = "Formation Git";
>>>>>>> feature-update-message
```

**5. Résoudre le conflit**

Éditez le fichier pour garder les deux modifications :

```java
package com.example.gitgithub;

public class file1 {
    private String message = "Bonjour GitHub!";
    private String author = "Mohamed Yassine Derbel";
    private String version = "1.0.0";
    private String description = "Formation Git";

    // Getters et Setters pour tous les champs...
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
```

**6. Finaliser le merge**

```powershell
# Ajouter le fichier résolu
git add src/main/java/com/example/gitgithub/file1.java

# Vérifier qu'il n'y a plus de conflits
git status

# Commiter la résolution
git commit -m "fix: résoudre conflit entre main et feature-update-message"

# Push
git push origin main
```

**7. Nettoyer**

```powershell
# Supprimer la branche
git branch -d feature-update-message
```

**✅ Résultat attendu :**
- Conflit créé et résolu manuellement
- Fichier final contient les modifications des deux branches
- Commit de merge créé

## Exercice 6 : Hotfix sur Main

### 🎯 Objectif
Corriger un bug urgent directement sur main (scénario réel).

### 📝 Étapes

**1. Simuler un bug dans GitgithubApplication.java**

```powershell
# S'assurer d'être sur main
git checkout main
```

Modifiez `src/main/java/com/example/gitgithub/GitgithubApplication.java` :

```java
package com.example.gitgithub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitgithubApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitgithubApplication.class, args);
        
        // BUG SIMULÉ
        file1 file = new file1();
        System.out.println("Message: " + file.getMessage());
        System.out.println("Author: " + file.getAuthor());
        
        User user = new User(1L, "yassine", "yassine@example.com");
        System.out.println("User créé: " + user);
        
        Product product = new Product(1L, "Laptop", 999.99, 10);
        System.out.println("Product créé: " + product);
    }
}
```

```powershell
# Commit le "bug"
git add .
git commit -m "feat: afficher User et Product au démarrage"
git push origin main
```

**2. Créer une branche hotfix**

```powershell
# Créer branche hotfix
git checkout -b hotfix-null-check
```

**3. Corriger le bug**

Modifiez `GitgithubApplication.java` :

```java
package com.example.gitgithub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitgithubApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitgithubApplication.class, args);
        
        // Correction avec vérification null
        try {
            file1 file = new file1();
            if (file != null && file.getMessage() != null) {
                System.out.println("Message: " + file.getMessage());
                System.out.println("Author: " + file.getAuthor());
            }
            
            User user = new User(1L, "yassine", "yassine@example.com");
            if (user != null) {
                System.out.println("User créé: " + user);
            }
            
            Product product = new Product(1L, "Laptop", 999.99, 10);
            if (product != null) {
                System.out.println("Product créé: " + product);
            }
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }
}
```

```powershell
# Commit la correction
git add .
git commit -m "fix: ajouter vérification null et gestion erreurs"
```

**4. Push et merger rapidement**

```powershell
# Push hotfix
git push -u origin hotfix-null-check

# Retour sur main
git checkout main

# Merge immédiat (hotfix urgent)
git merge hotfix-null-check

# Push main
git push origin main

# Supprimer la branche hotfix
git branch -d hotfix-null-check
git push origin --delete hotfix-null-check
```

**✅ Résultat attendu :**
- Bug corrigé rapidement via hotfix
- Main mis à jour immédiatement
- Process d'urgence maîtrisé

## Exercice 7 : Annuler des Modifications

### 🎯 Objectif
Apprendre à annuler des changements avec différentes méthodes.

### 📝 Étapes

**Scénario 1 : Annuler avant add (Working Directory)**

```powershell
# Modifier un fichier
echo "Test temporaire" >> README.md

# Voir le changement
git status
git diff

# Annuler la modification
git checkout -- README.md

# Ou avec la nouvelle syntaxe
git restore README.md

# Vérifier
git status
```

**Scénario 2 : Annuler après add (Staging Area)**

```powershell
# Modifier et ajouter
echo "Test temporaire" >> README.md
git add README.md

# Voir le statut
git status

# Retirer du staging
git reset HEAD README.md

# Ou avec la nouvelle syntaxe
git restore --staged README.md

# Le fichier est toujours modifié, mais pas staged
git status

# Annuler complètement
git restore README.md
```

**Scénario 3 : Modifier le dernier commit**

```powershell
# Faire un commit
echo "Version 1" > test.txt
git add test.txt
git commit -m "feat: ajouter test"

# Oups, j'ai oublié quelque chose !
echo "Version 2" >> test.txt
git add test.txt

# Modifier le dernier commit (sans créer un nouveau commit)
git commit --amend -m "feat: ajouter test complet"

# Vérifier
git log --oneline -1
```

**Scénario 4 : Annuler un commit (Reset)**

```powershell
# Voir l'historique
git log --oneline

# Reset soft (garde les modifications en staging)
git reset --soft HEAD~1

# Reset mixed (garde les modifications hors staging) - DEFAULT
git reset HEAD~1

# Reset hard (SUPPRIME TOUT) - ATTENTION !
git reset --hard HEAD~1
```

**Scénario 5 : Annuler un commit public (Revert)**

```powershell
# Créer un commit à annuler
echo "Mauvaise feature" > bad.txt
git add bad.txt
git commit -m "feat: mauvaise idée"
git push origin main

# Annuler avec revert (crée un nouveau commit)
git revert HEAD

# Éditer le message si nécessaire
# Push
git push origin main

# L'historique garde les deux commits
git log --oneline
```

**✅ Résultat attendu :**
- Maîtrise de `restore`, `reset`, `revert`
- Comprendre quand utiliser chaque méthode
- Savoir annuler en toute sécurité

## Exercice 8 : Utiliser Stash

### 🎯 Objectif
Mettre de côté du travail en cours pour traiter une urgence.

### 📝 Étapes

**1. Commencer à travailler sur une nouvelle feature**

```powershell
# Créer une branche
git checkout -b feature-order

# Créer Order.java (ne pas terminer)
```

Créez partiellement : `src/main/java/com/example/gitgithub/Order.java`

```java
package com.example.gitgithub;

public class Order {
    private Long id;
    private User user;
    // TODO: finir plus tard
}
```

```powershell
# Ajouter au staging
git add src/main/java/com/example/gitgithub/Order.java
```

**2. Urgence : bug critique à corriger !**

```powershell
# Mettre le travail de côté
git stash save "WIP: Order class en cours"

# Vérifier que le working directory est propre
git status

# Voir la liste des stash
git stash list
```

**3. Corriger le bug urgent**

```powershell
# Basculer sur main
git checkout main

# Créer branche hotfix
git checkout -b hotfix-critical-bug

# Faire la correction (exemple dans README.md)
echo "\n## Bugs corrigés\n- Fix critique appliqué" >> README.md

# Commit et merge
git add .
git commit -m "fix: correction bug critique"
git checkout main
git merge hotfix-critical-bug
git push origin main

# Nettoyer
git branch -d hotfix-critical-bug
```

**4. Reprendre le travail en cours**

```powershell
# Retourner sur la branche feature
git checkout feature-order

# Récupérer le stash
git stash pop

# Vérifier
git status

# Continuer le travail - compléter Order.java
```

```java
package com.example.gitgithub;

import java.util.Date;

public class Order {
    private Long id;
    private User user;
    private Product product;
    private Integer quantity;
    private Double totalPrice;
    private Date orderDate;

    // Constructeurs, getters, setters...
    
    public Order() {
        this.orderDate = new Date();
    }

    public Order(Long id, User user, Product product, Integer quantity) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
        this.orderDate = new Date();
    }

    // Getters et setters...
}
```

```powershell
# Finir et commiter
git add .
git commit -m "feat: créer classe Order complète"
git push -u origin feature-order

# Merger dans main
git checkout main
git merge feature-order
git push origin main

# Nettoyer
git branch -d feature-order
git push origin --delete feature-order
```

**✅ Résultat attendu :**
- Travail mis de côté avec stash
- Bug urgent corrigé
- Travail repris et terminé
- Workflow d'urgence maîtrisé

---



## Récapitulatif des Commandes

### 📌 Configuration

```powershell
# Identité
git config --global user.name "Votre Nom"
git config --global user.email "votre@email.com"

# Vérifier
git config --list
```

### 📌 Commandes de Base

```powershell
# État du dépôt
git status

# Voir les modifications
git diff

# Ajouter des fichiers
git add fichier.txt
git add .

# Commiter
git commit -m "message"

# Historique
git log --oneline --graph --all
```

### 📌 Branches

```powershell
# Lister les branches
git branch
git branch -a

# Créer une branche
git branch nom-branche

# Basculer vers une branche
git checkout nom-branche

# Créer et basculer (raccourci)
git checkout -b nom-branche

# Merger une branche
git checkout main
git merge nom-branche

# Supprimer une branche
git branch -d nom-branche
git push origin --delete nom-branche
```

### 📌 Synchronisation avec GitHub

```powershell
# Ajouter un remote
git remote add origin https://github.com/user/repo.git

# Voir les remotes
git remote -v

# Push
git push origin main
git push -u origin branche

# Pull
git pull origin main

# Fetch
git fetch origin
```

### 📌 Annulation

```powershell
# Annuler modifications non staged
git restore fichier.txt

# Retirer du staging
git restore --staged fichier.txt

# Modifier le dernier commit
git commit --amend -m "nouveau message"

# Reset (annuler commits)
git reset --soft HEAD~1   # Garde les modifs en staging
git reset HEAD~1          # Garde les modifs hors staging
git reset --hard HEAD~1   # SUPPRIME TOUT

# Revert (annuler avec nouveau commit)
git revert HEAD
```

### 📌 Stash

```powershell
# Mettre de côté
git stash
git stash save "message"

# Lister les stash
git stash list

# Réappliquer
git stash apply
git stash pop

# Supprimer
git stash drop
git stash clear
```

### 📌 Tags

```powershell
# Créer un tag
git tag v1.0.0
git tag -a v1.0.0 -m "Version 1.0"

# Lister
git tag

# Push
git push origin v1.0.0
git push --tags

# Supprimer
git tag -d v1.0.0
git push origin --delete v1.0.0
```

### 📌 Informations et Recherche

```powershell
# Voir qui a modifié chaque ligne
git blame fichier.txt

# Rechercher dans l'historique
git log --grep="mot-clé"
git log --author="nom"

# Différences
git diff main..branche
git diff commit1 commit2

# Voir un commit spécifique
git show abc1234
```

---

## 🎓 Workflow Complet d'un Projet

### Démarrage d'une nouvelle fonctionnalité

```powershell
# 1. S'assurer d'être à jour sur main
git checkout main
git pull origin main

# 2. Créer une branche
git checkout -b feature-nouvelle-fonction

# 3. Développer et commiter régulièrement
# ... modifier les fichiers ...
git add .
git commit -m "feat: ajouter fonction X"
# ... continuer à développer ...
git add .
git commit -m "feat: améliorer fonction X"

# 4. Push de la branche
git push -u origin feature-nouvelle-fonction

# 5. Créer une Pull Request sur GitHub
# (Interface web GitHub)

# 6. Après approbation, merger
git checkout main
git pull origin main
git merge feature-nouvelle-fonction
git push origin main

# 7. Nettoyer
git branch -d feature-nouvelle-fonction
git push origin --delete feature-nouvelle-fonction
```

### Correction d'un bug urgent

```powershell
# 1. Créer un hotfix depuis main
git checkout main
git checkout -b hotfix-bug-critique

# 2. Corriger le bug
# ... modifications ...
git add .
git commit -m "fix: corriger bug critique"

# 3. Merger immédiatement
git checkout main
git merge hotfix-bug-critique
git push origin main

# 4. Nettoyer
git branch -d hotfix-bug-critique
```

### Gestion d'une interruption

```powershell
# 1. Mettre le travail de côté
git stash save "WIP: feature en cours"

# 2. Traiter l'urgence
git checkout main
# ... corrections urgentes ...
git add .
git commit -m "fix: urgence"
git push origin main

# 3. Reprendre le travail
git checkout feature-branch
git stash pop
# ... continuer ...
```

---

## 🚨 Erreurs Courantes et Solutions

### "Your branch is behind 'origin/main'"

```powershell
git pull origin main
```

### "Please commit your changes or stash them"

```powershell
# Option 1 : Commit
git add .
git commit -m "WIP: travail en cours"

# Option 2 : Stash
git stash
```

### "Merge conflict"

```powershell
# 1. Voir les fichiers en conflit
git status

# 2. Éditer les fichiers et résoudre les conflits
# (supprimer les marqueurs <<<<, ====, >>>>)

# 3. Ajouter et commiter
git add .
git commit -m "fix: résoudre conflits"
```

### "fatal: remote origin already exists"

```powershell
# Voir les remotes
git remote -v

# Changer l'URL
git remote set-url origin nouvelle-url

# Ou supprimer et recréer
git remote remove origin
git remote add origin url
```

### Annuler un push (DANGEREUX)

```powershell
# Annuler le dernier commit et forcer le push
git reset --hard HEAD~1
git push --force-with-lease origin main

# ⚠️ À utiliser UNIQUEMENT si personne n'a pull depuis !
```

---

## 📚 Conventions de Commit

### Format

```
<type>(<scope>): <description courte>

<description détaillée optionnelle>

<footer optionnel>
```

### Types

- **feat**: Nouvelle fonctionnalité
- **fix**: Correction de bug
- **docs**: Documentation
- **style**: Formatage, style
- **refactor**: Refactorisation
- **test**: Ajout/modification de tests
- **chore**: Tâches de maintenance
- **perf**: Amélioration de performance

### Exemples

```powershell
git commit -m "feat(user): ajouter validation email"
git commit -m "fix(order): corriger calcul du total"
git commit -m "docs: mettre à jour README avec exemples"
git commit -m "refactor(product): simplifier la logique de pricing"
git commit -m "test(user): ajouter tests unitaires"
```

---

## 🎯 Bonnes Pratiques

### ✅ À FAIRE

1. **Commiter souvent** avec des messages clairs
2. **Une branche = une fonctionnalité**
3. **Pull avant de push** pour éviter les conflits
4. **Tester avant de commiter** sur main
5. **Utiliser .gitignore** pour les fichiers sensibles
6. **Créer des Pull Requests** pour review de code
7. **Tag les versions** importantes

### ❌ À ÉVITER

1. Commiter directement sur main (sauf hotfix)
2. Messages de commit vagues ("update", "fix")
3. Commiter des fichiers sensibles (mots de passe, clés API)
4. Force push sur des branches partagées
5. Commits trop gros (difficiles à reviewer)
6. Ne pas tester avant de push

---

## 🎉 Conclusion

Vous avez maintenant parcouru **tous les cas pratiques essentiels** de Git et GitHub :

✅ Modifications et commits  
✅ Création et gestion de branches  
✅ Merge de branches  
✅ Résolution de conflits  
✅ Hotfix urgents  
✅ Annulation de modifications  
✅ Utilisation du stash  
✅ Versioning avec tags  


---

## 📞 Support

**Auteur:** Mohamed Yassine Derbel  
**GitHub:** [MOHAMED-YASSIN-DERBEL/gitgithub](https://github.com/MOHAMED-YASSIN-DERBEL/gitgithub)  
**Projet:** Formation pratique Git & GitHub

---

### 💡 Aide Rapide

```powershell
# Documentation Git
git --help
git <commande> --help

# Exemples
git commit --help
git branch --help
```

---

**🚀 Happy Coding !**

*N'oubliez pas : La meilleure façon d'apprendre Git est de le pratiquer !*
