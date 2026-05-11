#   TP1 - IPPlan-Manager
##  Objectifs du TP 
Ce TP permet de decouvrir les premières classes Java du projet IPPlan-Manager.
##  Classes crées
- AdresseIP
- ReseauIP
- InterfaceReseau
- Equipement
- Main

##  Travail réalisé
J'ai crée un système de gestion d'adresse IP. Le programme permet d'instantier des réseaux, des adresses IP, 
et de configurer des interfaces reseaux (actives ou inactives)
 ##  Questions de compréhension

 # 1. Pourquoi une adresse IP est-elle représentée par une classe au lieu d'une simple variable String ?
L'utilisation d'une classe permet de traiter l'adresse IP comme un objet intelligent plutôt que comme du simple 
texte. Cela permet de :
 -  Valider les données : S'assurer que l'adresse contient bien 4 nombres entre 0 et 255.
 -  Ajouter des fonctionnalités : Créer des méthodes pour identifier la classe de l'IP (A, B, C) ou tester si elle 
appartient à un sous-réseau spécifique.
 -  Éviter les erreurs : Empêcher de mélanger une chaîne de caractères quelconque avec une véritable adresse réseau 
dans le code.


 
# 2. Quelle est la différence entre une classe et un objet ?
 -  La Classe : C'est le "moule", le plan de fabrication ou la définition théorique. Elle définit quels attributs 
(données) et quelles méthodes (actions) les futurs objets auront.
 -  L'Objet : C'est la réalisation concrète (l'instance) issue de la classe. Par exemple, InterfaceReseau est une 
classe, mais eth0 est un objet réel avec son propre nom et sa propre adresse IP en mémoire.

# 3. Quel est le rôle du constructeur dans une classe Java ?
Le constructeur est une méthode spéciale qui est appelée automatiquement lors de la création d'un objet avec 
le mot-clé new. Son rôle est :
 -  D'initialiser les attributs de l'objet dès sa naissance.
 -  De garantir que l'objet est créé dans un état valide (par exemple, forcer l'attribution d'un nom à une interface dès sa création).

# 4. Pourquoi la classe InterfaceReseau contient-elle un objet de type AdresseIP ?
C'est le concept de composition (ou relation "a un"). Une interface réseau physique possède intrinsèquement une 
adresse IP pour communiquer. En programmation, on traduit cela en intégrant l'objet AdresseIP comme un attribut 
de InterfaceReseau.

# 5. Pourquoi la classe Equipement contient-elle un objet de type InterfaceReseau ?
De la même manière, un équipement (comme un routeur ou un serveur) "possède" des interfaces de communication. 
Cette structure permet de lier logiquement l'équipement aux interfaces qu'il contrôle.

# 6. Quelle est la limite actuelle de la classe Equipement dans ce TP ?
La limite principale est qu'un équipement ne semble pouvoir posséder qu'*une seule interface* à la fois 
(car c'est un attribut simple). Dans la réalité, un équipement comme un routeur possède plusieurs interfaces
(eth0, eth1, etc.). Il faudrait utiliser une List ou un tableau d'objets InterfaceReseau pour être plus réaliste.

# 7 Pourquoi cette version n'est-elle pas encore suffisante pour produire un plan d'adressage IP ?
Pour produire un plan d'adressage complet, il manque plusieurs mécanismes automatiques :
 -   La gestion des masques de sous-réseau pour définir la taille des réseaux.
 -   Un algorithme pour calculer la plage d'IP disponibles (de la première à la dernière IP).
 -   Un système de vérification des conflits (doublons d'adresses) sur un même réseau.

# TP2 – Encapsulation.
 ## Objectif: Introduction de l'encapsulation et des validations.
 ## Notions étudiées* :
     private, getters, setters, validation, this. Nous avons tester la création d'adresses IP vides, de réseaux 
avec des masques invalides (comme 55) et d'équipements sans nom pour vérifier que vos "setters" corrigent bien les
données..
 ## Tests réalisés: 
     Nous avons testés les cas invalides (adresses vides, masques CIDR > 32) et le programme a réagi.
 ## Difficultés rencontrées: 
     Nous avons l'erreur de compilation au début (méthode non reconnue) ou la configuration du jeton (token)
 GitHub.
 ## Réponses aux questions: 
  
   1.private: Pour protéger les données contre des modifications directes et incohérentes.
   2. *Public vs Privé* : Un attribut public est accessible partout ; un attribut privé n'est accessible que dans sa propre classe.
   3. *Getters/Setters* : Pour lire et modifier les données tout en appliquant des règles de validation.
   4. *Validations réseau* : Cruciales pour éviter des erreurs de configuration (ex: masque CIDR 55) qui feraient planter un vrai système.
   5. *this* : Désigne l'attribut de l'objet actuel pour le différencier d'un paramètre du même nom.
   6. *Constructeur et Setters* : Pour valider les données dès la création de l'objet.
   7. *Validation CIDR* : Un masque doit obligatoirement être entre 0 et 32.
   8. *Sécurité* : L'encapsulation empêche l'injection de données corrompues dans les objets.

###  Réponses aux questions de compréhension
 # 1.Pourquoi utilise-t-on private dans les classes ?
   L'utilisation du mot-clé private permet de restreindre l'accès direct aux attributs d'une classe depuis 
l'extérieur. Cela garantit que les données ne peuvent pas être modifiées de manière arbitraire ou dangereus
par d'autres parties du programme.

  # 2.Quelle différence existe entre un attribut public et un attribut privé ?
   Un attribut *public* est accessible et modifiable directement par n'importe quelle autre classe, ce qui peut 
entraîner des configurations invalides (ex: une adresse IP vide). Un attribut *privé* est caché ; il ne peut être
consulté ou modifié que via des méthodes spécifiques (getters et setters), ce qui permet de garder le contrôle sur 
la donnée.

 # 3. Pourquoi utilise-t-on des getters et setters ?
   Les getters permettent de lire la valeur d'un attribut privé de manière sécurisée. Les setters permettent de
 modifier la valeur tout en intégrant des mécanismes de contrôle et de validation avant l'affectation.

 # 4.Pourquoi les validations sont-elles importantes dans un logiciel réseau ?
   Dans une application réseau, des données incorrectes (comme un masque CIDR invalide ou une adresse IP vide) 
peuvent provoquer des erreurs de calcul, des incohérences de configuration ou des pannes logiques du système. 
Les validations garantissent la robustesse et la fiabilité du logiciel.

 # 5.Quel est le rôle du mot-clé this ?
   Le mot-clé this fait référence à l'instance courante de la classe. Il est principalement utilisé dans les 
constructeurs ou les setters pour lever l'ambiguïté entre les attributs de la classe et les paramètres de la 
méthode lorsqu'ils portent le même nom (ex: this.valeur = valeur).

  # 6.Pourquoi le constructeur appelle-t-il les setters ?
   Le constructeur appelle les setters pour réutiliser la logique de validation déjà définie dans ces derniers. 
Cela évite de dupliquer le code de contrôle et assure que même lors de la création de l'objet, les données fournies 
sont valides.

  # 7.Pourquoi la validation du masque CIDR est-elle importante ?
   Un masque CIDR doit impérativement être compris entre 0 et 32 pour être techniquement correct. Sans cette 
validation, le programme pourrait tenter de traiter des réseaux inexistants ou provoquer des erreurs lors de 
calculs de sous-réseaux.

  # 8.Pourquoi l'encapsulation améliore-t-elle la sécurité logicielle ?
   L'encapsulation protège l'intégrité des données en empêchant leur manipulation directe. En forçant le passage 
par des méthodes de contrôle, on s'assure que l'objet reste toujours dans un état cohérent, ce qui limite les
comportements imprévisibles et les vulnérabilités liées à des données mal formées.


# TP3 - Collections et composition

## Objectif
L'objectif de ce TP était d'introduire la notion de collections (via ArrayList) et de gérer les relations 
entre objets (composition) pour rendre l'architecture du projet IPPlanManager plus réaliste et évolutive.

## Notions étudiées
-  Composition : Relation où une classe est composée d'objets d'autres classes.
-  ArrayList : Utilisation d'une liste dynamique pour stocker plusieurs objets.
-  Parcours de listes : Utilisation de la boucle for-each pour afficher ou traiter les données.
-  Recherche : Implémentation d'un algorithme de recherche d'objet dans une collection par son nom.

## Tests réalisés
1. Création d'une infrastructure réseau complète.
2. Ajout de plusieurs sous-réseaux (ADMIN, TECH, WIFI).
3. Configuration d'un routeur et d'un serveur possédant chacun plusieurs interfaces réseau.
4. Test de la méthode rechercherEquipement pour vérifier si un matériel est présent dans l'infrastructure.

## Difficultés rencontrées
-  Gestion des erreurs de compilation liées aux imports (java.util.ArrayList).
-  Compréhension de la portée des méthodes (placer la recherche dans la classe InfrastructureReseau et non 
InterfaceReseau).
-  Résolution des erreurs d'exécution NoClassDefFoundError en utilisant le "Clean and Build".

## Réponses aux questions
1.  Composition : C'est quand une classe possède des attributs qui sont des objets d'autres classes 
(ex: l'Infrastructure a des Sous-réseaux).

2.  ArrayList: On l'utilise car elle permet d'ajouter ou supprimer des équipements dynamiquement, contrairement 
à un tableau fixe.

3.  Variable vs Collection : Une variable stocke une seule donnée ; une collection en stocke une liste 
(une multitude).

4.  Interfaces multiples : Pour qu'un équipement puisse communiquer avec différents réseaux
 (ex: WAN et LAN sur un routeur).

5.  Sous-réseaux multiples : Pour segmenter le trafic, améliorer la sécurité et organiser le plan d'adressage IP.

6.  Boucle for-each* : Elle sert à parcourir chaque élément d'une liste du début à la fin de manière simple.

7.  InfrastructureReseau : Elle devient la classe "chef d'orchestre" qui centralise toute la logique de gestion
 du parc réseau.

8. *Applications 
professionnelles* : Les collections permettent de gérer des volumes de données massifs 
(milliers de serveurs, utilisateurs, etc.) de façon fluide.


