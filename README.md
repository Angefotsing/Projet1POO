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
   2. *Public vs Privé* : Un attribut public est accessible partout ; un attribut privé n'est accessible que dans sa propre
 classe.
   3. *Getters/Setters* : Pour lire et modifier les données tout en appliquant des règles de validation.
   4. *Validations réseau* : Cruciales pour éviter des erreurs de configuration (ex: masque CIDR 55) qui feraient planter 
       un vrai système.
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

8. Applications 
professionnelles* : Les collections permettent de gérer des volumes de données massifs 
(milliers de serveurs, utilisateurs, etc.) de façon fluide.

 
###  TP4- Calculs réseau automatiques

## Objectifs
    Introduire des calculs automatisees pour la gesion des adresses IP(IPAM) afin d'enrichir le donnees reseauxsans saisie 
manuelle.

## Notions etudiees:
     - Methode statique : utlisation de la classe CalculateurReseau.
     - Calcul Reseau : nombre d'hote, masque decimaux, dection de classe.
     - CIDR : manipulation des prefixes reseau.
     - Logique algorithmique : detection des plages d'adresses privees.

## Tests realisees :
  1- Creation d'un reseau Admin (192.168.1.0/24) qui donne un Resultat : classe C 254 hots, Prive.
  2- Creation d'un reseau WiFi (10.0.0.0/8) --> Resultat : classe A 16 777 214 hotes, Prive.
  3- Creation d'un reseau Public (8.8.8.8/24) --> Resultat : Public.

## Difficultes rencontrees :
  - Gestions des parentheses dans les expressions ternaires complexes
  - Manipulation des chaines de characteres avec "split("\\.");

## Reponses aux questions de comprehensions

# 1- Pourquoi une classse Utilitaire?
     pour regrouper des fonctions de calculs pure qui n'ont pas besoin de stocker un etat (pas d'attributs d'instance).cela 
evite de dupliquer le code.

# 2- Role du mot cle static?
     Il permet d'acceder aux methodes sans creer d'object avec new. la methode appartient a la classe elle-meme.

# 3- Importance des calculs dans un outil IPAM?
     Ils garantissent l'exactitude technique (eviter les chevauchements d'IP) et font gagner du temps a l'administrateur
systeme.

# 4- Utlite du CIDR?
     Plus flexible que les anciennes classes (A,B,C), il permet de decouper les reseaux exactement a la taille voulue.

# 5- Pourquoi le nombre d'hote depend du masque?
     Le masque determine combien de bites sont reserves a l'adresse des machines. Formule : 2(32-masque)-2.

# 6- Pourquoi certaines adresses IP sont-elles privees?
     pour economiser les adresses publiquesnmondiales et securiser les reseaux internes 
(non joignable directement depuis Internet).

# 7- Separateur logique metier / calcul ?
     cela rend le projet modulaire. Si on veut changer la facon de calculer, on ne touche qu'a une seule classe sans 
risquer de casser l'affichage.

# 8- Pourquoi automatiser ?
     Pour eleminer l'erreur humaine. un administrateur peut se tromper dans un calcul binaire, mais un algorithme bien code 
ne se trompe jamais.

###      TP5 - Moteur VLSM

## Objectif
L'objectif de ce TP est de développer un *moteur VLSM* (Variable Length Subnet Mask) capable de générer automatiquement
 un plan d'adressage IP optimisé à partir d'une liste de besoins en hôtes exprimés par l'utilisateur.

## Notions étudiées
 * *VLSM* : Attribution de masques de sous-réseau de tailles variables pour optimiser l'espace d'adressage.
 * *Tri de collections* : Utilisation de Collections.sort avec un Comparator personnalisé pour traiter les besoins par 
ordre décroissant.
 * *Classe de service métier* : Création d'une classe MoteurVLSM dédiée à la logique algorithmique du projet.
 * *Manipulation d'IP* : Conversion d'adresses IP en entiers pour faciliter les calculs mathématiques de plages d'adresses.

## Scénarios testés
 1. *Scénario Initial* : Réseau standard avec 5 services (TECH, WIFI, ADMIN, SERVEURS, DIRECTION).
 2. *Petite Entreprise* : Test sur 4 services avec des besoins plus restreints (ADMIN : 25, COMPTA : 12, WIFI_INVITES : 40, SERVEURS : 8).
 3. *Campus Universitaire* : Test à grande échelle incluant des besoins importants (ETUDIANTS : 500, PERSONNEL : 120, etc.).

## Résultats obtenus
Les plans d'adressage générés respectent la hiérarchie des besoins. Par exemple, pour un besoin de 120 hôtes, le moteur 
propose un masque */25* offrant 126 adresses utilisables. Les plages d'adresses utilisables (première et dernière IP)
 sont calculées dynamiquement pour chaque sous-réseau.

## Difficultés rencontrées
 * *Gestion du tri* : Comprendre pourquoi le tri décroissant est vital pour éviter la fragmentation de l'espace d'adressage.
 * *Calcul des plages* : La conversion mathématique entre les formats "Pointed Decimal" et "Integer" pour ne pas chevaucher
 les sous-réseaux.

## Réponses aux questions de compréhension
 1. *Économie d'adresses* : Le VLSM évite le gaspillage en adaptant la taille du masque au besoin réel plutôt que d'utiliser 
un masque fixe pour tous.

 2. *Tri décroissant* : On traite les plus grands besoins en premier pour garantir qu'un bloc d'adresses contiguës suffisant
 soit disponible avant que l'espace ne soit fragmenté par de petits réseaux.

 3. *Besoin vs Résultat* : Un BesoinReseau est une exigence utilisateur (nom, nombre d'hôtes), tandis qu'un ResultatVLSM est
 la solution technique calculée (IP, CIDR, Masque, Plage).

 4. *Classe de service* : MoteurVLSM est une classe de service car elle porte la logique "métier" (le calcul) sans stocker de
 données de manière permanente.

 5. *Conversion en entier* : Transformer l'IP en entier simplifie les calculs de sauts d'adresses (ex: Adresse + Taille du
 bloc).

 6. *Rôle de calculerCidrPourHotes* : Elle détermine automatiquement le préfixe réseau le plus petit capable de contenir le
 nombre d'hôtes demandé.

 7. *Adresses réservées* : L'adresse de réseau et l'adresse de broadcast sont réservées par le protocole IP pour 
l'identification et la diffusion ; elles ne peuvent donc pas être assignées à des hôtes.

 8. *Importance du moteur* : Ce moteur automatise une tâche complexe et sujette aux erreurs humaines, rendant l'application
 IPPlan-Manager professionnelle et fiable.
    




