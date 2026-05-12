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


# TP6 - VLAN et segmentation logique

 ### Objectif
L'objectif de ce TP est de mettre en place une *segmentation logique* du réseau au sein de l'application 
IPPlan-Manager. Il s'agit de modéliser des VLANs (Virtual Local Area Networks) et de les associer automatiquement
 aux résultats d'adressage IP calculés par le moteur VLSM.

### Notions étudiées
 * *Segmentation réseau (Couche 2)* : Compréhension de l'isolation des domaines de diffusion.
 * *Encapsulation et Association* : Création d'une relation entre un objet VLAN et un objet ResultatVLSM.
 * *Gestion de collections complexes* : Utilisation de ArrayList pour stocker et manipuler des listes dynamiques 
de VLANs.
 * *Détection de criticité* : Implémentation d'algorithmes de recherche pour identifier les réseaux dépassant une 
certaine capacité (ex: > 100 hôtes).

### Scénarios testés
 * *Scénario Entreprise Classique* : Génération de 4 VLANs standards (Technique, WiFi, Administration, Serveurs) 
avec des IDs allant de 10 en 10.
 * *Scénario Campus Universitaire* : Test de montée en charge avec des besoins importants 
(ex: 500 hôtes pour les étudiants) pour valider l'affichage des VLANs critiques.
 * *Recherche Unitaire* : Vérification de la méthode de recherche par ID de VLAN pour s'assurer que l'application 
retrouve correctement les informations d'un segment spécifique.

### Résultats obtenus
L'application produit désormais un inventaire réseau détaillé où chaque segment est identifié par :
 1. *Son ID VLAN* (ex: 10, 20).
 2. *Son Nom de service* (ex: TECHNIQUE).
 3. *Ses paramètres IP* (Adresse réseau, Masque CIDR, Plage d'adresses utilisables).
 4. *Son statut de criticité* (Alerte si la capacité > 100 hôtes).

### ### Difficultés rencontrées
 * *Incohérence des Getters* : Ajustement des méthodes getIdVlan() et getNomVlan() pour correspondre aux noms des
 variables réelles dans la classe VLAN.
 * *Portée des variables* : Résolution des erreurs de compilation liées à l'utilisation de variables locales en 
dehors de la méthode main.
 * *Logique de boucle* : Synchronisation du nom de la liste vlans entre sa déclaration et son utilisation dans 
les boucles de traitement du gestionnaire.

### ### Réponses aux questions

    1. *Pourquoi les VLANs sont-ils importants dans les réseaux modernes ?*
   Ils permettent de segmenter un réseau physique unique en plusieurs réseaux logiques indépendants. Cela réduit 
la taille des domaines de diffusion (broadcast), améliore les performances globales et permet d'isoler les flux 
de données par département.

 2. *Pourquoi un VLAN est-il souvent associé à un sous-réseau spécifique ?*
   Chaque VLAN forme un domaine de diffusion séparé au niveau de la couche 2. Pour que les équipements d'un VLAN 
communiquent entre eux et avec l'extérieur, ils doivent appartenir à un plan d'adressage IP (sous-réseau) cohérent
 qui leur est propre.

 3. *Pourquoi la séparation logique améliore-t-elle la sécurité ?*
   Elle empêche les utilisateurs d'un VLAN d'accéder aux données d'un autre VLAN sans passer par un routeur ou un
 pare-feu. Par exemple, le VLAN "WIFI_INVITÉS" ne peut pas voir les données du VLAN "SERVEURS".

 4. *Quel est le rôle de la classe GestionnaireVLAN ?*
   Cette classe agit comme un service métier qui centralise la gestion de tous les VLANs de l'infrastructure.
 Elle permet d'ajouter des VLANs, de les lister, d'effectuer des recherches par ID et d'analyser la criticité du 
réseau.

 5. *Pourquoi la classe VLAN contient-elle un objet ResultatVLSM ?*
   C'est une association qui permet de lier directement l'identifiant logique du VLAN aux informations techniques 
de son adressage IP (adresse réseau, masque, passerelle) calculées précédemment.

 6. *Pourquoi utilise-t-on encore ArrayList dans ce TP ?*
   ArrayList est une collection dynamique idéale pour stocker un nombre variable de VLANs. Elle facilite le 
parcours des données avec des boucles for-each pour les affichages et les recherches.

 7. *Pourquoi les responsabilités des classes doivent-elles être séparées ?*
   Cela suit le principe de responsabilité unique (SOLID) : la classe VLAN ne fait que stocker des données, 
tandis que GestionnaireVLAN s'occupe de la logique de gestion. Cela rend le code plus facile à maintenir et à 
faire évoluer.

 8. *Pourquoi le projet commence-t-il maintenant à ressembler à une véritable application professionnelle ?*
   L'application gère désormais des scénarios complexes mêlant calculs algorithmiques (VLSM) et organisation 
d'infrastructure (VLAN). L'utilisation d'une architecture en couches et d'objets métier interconnectés reflète 
les standards de développement logiciel.


# TP7 – Validations avancées et détection des conflits

## ## Objectif
L'objectif de ce TP est de renforcer la robustesse de l'application *IPPlan-Manager* en ajoutant une couche de
 validation métier. Il s'agit de détecter les incohérences lors de la saisie des données réseau 
(adresses invalides, doublons d'identifiants VLAN ou chevauchements de plages IP) et de les gérer via un système
 d'exceptions personnalisées.

## ## Notions étudiées
 * *Exceptions personnalisées* : Création de classes héritant de Exception pour des erreurs spécifiques au 
domaine réseau.
 * *Gestion des erreurs (Try/Catch/Throw)* : Mise en place d'une structure de contrôle pour capturer les anomalies
 sans arrêter brutalement le programme.
 * *Algorithmique de détection de chevauchement* : Comparaison de plages d'adresses IP converties en entiers longs.
 * *Validation de cohérence* : Vérification de l'unicité des attributs critiques (ID de VLAN).
 * *Robustesse logicielle* : Séparation de la logique de calcul (moteur) et de la logique de validation.

## ## Scénarios testés
 1. *Test d'adresse IP invalide* : Tentative de création d'un réseau avec une adresse hors limites 
(ex: 192.168.300.0), déclenchant une AdresseIPInvalideException.

 2. *Test de conflit d'ID VLAN* : Ajout de deux VLANs avec le même identifiant (ID 20) dans une liste, déclenchant
 une ConflitVLANException.

 3. *Test de chevauchement de réseaux (Overlap)* : Simulation de deux réseaux (192.168.1.0/25 et 192.168.1.64/26) 
occupant la même plage d'adresses, déclenchant une ChevauchementReseauException.

 4. *Test de capacité insuffisante* : Vérification que les besoins cumulés ne dépassent pas la capacité du réseau
 de départ (ReseauInsuffisantException).

## ## Résultats obtenus
 * *Validation réussie* : Les scénarios de tests affichent désormais des messages d'erreurs clairs et explicites
 au lieu de simples codes d'erreur ou de plantages.
 * *Journalisation des erreurs* : Utilisation de System.err pour distinguer visuellement les erreurs capturées 
des sorties standards dans la console NetBeans.
 * *Plan d'adressage fiable* : Seuls les plans respectant toutes les contraintes de sécurité et de logique réseau 
sont validés pour l'export.

## ## Difficultés rencontrées
 * *Conversion des IP* : La manipulation des masques CIDR pour calculer les bornes de début et de fin de réseau
 a nécessité une attention particulière sur les calculs binaires.
 * *Intégration dans le Main* : Harmoniser les constructeurs des classes (comme ResultatVLSM) avec les nouveaux 
besoins de validation a nécessité quelques corrections sur les signatures de méthodes.
 * *Gestion des flux* : S'assurer que chaque bloc try est indépendant pour tester plusieurs erreurs à la suite
 dans le même fichier Main.java.

## ## Réponses aux questions

1. *Pourquoi les validations avancées sont-elles indispensables dans un outil IPAM ?*
   Dans un outil de gestion d'adresses IP (IPAM), la moindre erreur de saisie ou de calcul peut paralyser un 
réseau entier. Les validations avancées garantissent qu'aucune configuration incohérente 
(comme une IP hors plage ou un conflit de VLAN) ne soit déployée, assurant ainsi la stabilité et la sécurité 
de l'infrastructure.

 2. *Quelle est la différence entre une erreur simple et une exception en Java ?*
   Une erreur simple (souvent gérée par des if/else) est un traitement local qui oblige l'appelant à vérifier
 manuellement si une opération a réussi (ex: tester si une méthode retourne null). Une *exception* est un mécanisme
 plus puissant qui interrompt le flux normal du programme et force le développeur à traiter l'anomalie dans un bloc
 dédié (try-catch), rendant le code plus robuste et plus facile à déboguer.

 3. *Pourquoi crée-t-on des exceptions personnalisées ?*
   Les exceptions personnalisées (comme ConflitVLANException) permettent de nommer précisément le problème rencontré.
 Cela facilite la maintenance car le message d'erreur est explicite et propre au métier du réseau, contrairement aux
 exceptions génériques de Java (comme IllegalArgumentException) qui sont trop vagues.

 4. *Quel est le rôle du bloc try/catch ?*
   * *Le bloc try* : Il entoure le code "suspect" qui pourrait générer une erreur (ex: le calcul VLSM ou la 
validation d'une IP).
   * *Le bloc catch* : Il "attrape" l'exception si elle se produit et exécute un code de secours
 (affichage d'un message d'alerte) pour éviter que l'application ne s'arrête brutalement.

 5. *Pourquoi deux VLANs ne doivent-ils pas avoir le même identifiant dans une même infrastructure ?*
   L'ID de VLAN (identifiant numérique) sert à marquer les trames Ethernet pour les séparer logiquement sur
 les équipements réseau (switches). Si deux VLANs partagent le même ID, le switch ne pourra plus distinguer
 les trafics, ce qui provoquera des fuites de données entre services et des dysfonctionnements majeurs.

 6. *Pourquoi deux sous-réseaux ne doivent-ils pas se chevaucher ?*
   Le chevauchement (overlap) signifie qu'une même adresse IP appartient à deux réseaux différents.
 Pour un routeur, cela crée une ambiguïté : il ne saura pas vers quel segment réseau acheminer les paquets,
 entraînant des pertes de connexion et des conflits d'adressage.

 7. *Pourquoi transforme-t-on les adresses IP en entiers pour comparer des plages réseau ?*
   Comparer des adresses IP sous forme de texte ("192.168.1.5") est complexe et lent. En les convertissant 
en *entiers 32 bits*, on peut utiliser des opérateurs mathématiques simples (<, >, <=, >=) pour vérifier 
instantanément si une adresse se situe entre la borne de début et la borne de fin d'un réseau.

 8. *Pourquoi la classe ValidateurPlanAdressage doit-elle être séparée du moteur VLSM ?*
   Cela respecte le principe de *responsabilité unique* (SOLID). Le moteur VLSM est responsable uniquement
 du calcul des plages IP, tandis que le validateur est responsable de la vérification de la cohérence globale.
 Cette séparation rend le code plus modulaire, plus facile à tester et à faire évoluer.
    


# # TP8 – Moteur de recommandations

## ## Objectif
L'objectif de ce TP est de concevoir et d'intégrer un *système expert d'analyse réseau* capable de parcourir
 un plan d'adressage VLAN existant pour proposer des conseils techniques automatisés. Ce moteur permet
 d'améliorer la sécurité, l'organisation et la performance de l'infrastructure en identifiant des 
configurations sous-optimales.

## ## Notions étudiées
 * *Interfaces Java* : Utilisation de l'interface RegleRecommandation pour définir un contrat standard pour
 toutes les règles métier.
 * *Polymorphisme* : Capacité du moteur à traiter différentes règles de manière générique via une liste unique.
 * *Séparation des responsabilités* : Découplage entre la logique de stockage (Gestionnaire) et la logique 
d'analyse (Moteur).
 * *Extensibilité logicielle* : Architecture permettant d'ajouter de nouvelles règles (comme RecommandationAdministration) sans modifier le code central du moteur.
 * *Règles métier* : Implémentation de conditions logiques basées sur des standards de réseaux réels
 (isolation WiFi, surveillance des serveurs).

## ## Scénarios testés
 1. *Détection de VLAN WiFi Invité* : Vérification que les réseaux destinés aux invités sont bien isolés des
 ressources internes critiques.
 2. *Surveillance des VLANs Serveurs* : Identification des zones contenant des serveurs pour recommander des 
politiques de sauvegarde et de sécurité renforcées.
 3. *Analyse de taille (Grand VLAN)* : Détection des VLANs ayant un nombre d'hôtes très élevé pour suggérer
 une segmentation afin de limiter les domaines de broadcast.
 4. *Règle d'Administration* : Scan des noms de VLAN pour identifier les segments sensibles (contenant "ADMIN") et préconiser une restriction d'accès.
 5. *Analyse de la marge d'adressage* : Calcul de la différence entre la capacité du sous-réseau et le besoin
 initial pour alerter sur un manque futur d'évolutivité.

## ## Recommandations obtenues
 * *Alertes de sécurité* : Des messages clairs s'affichent désormais pour les VLANs d'administration,
 conseillant de limiter l'accès aux seuls administrateurs réseau.
 * *Conseils d'évolutivité* : Pour les réseaux trop denses (ex: besoin de 120 hôtes sur une capacité de 126),
 le système recommande de prévoir une marge plus confortable.
 * *Optimisation de performance* : Suggestion de découpage pour les VLANs de grande taille afin d'améliorer
 la fluidité du trafic.

## ## Difficultés rencontrées
 * *Gestion des types de retour* : S'assurer que la méthode analyser() retourne null lorsqu'une règle ne
 s'applique pas, pour éviter les erreurs dans la boucle de traitement du moteur.
 * *Enrichissement des données* : Nécessité de modifier la classe ResultatVLSM pour y inclure le nombre 
d'hôtes demandés au départ, afin de permettre le calcul de la marge d'adresse.
 * *Cohérence des noms* : Synchronisation entre le Main et les noms de classes de règles (ex:
 RecommandationServeurs) pour éviter les erreurs de compilation "Symbol not found".

## ## Réponses aux questions

 1. *Quel est le rôle d’un moteur de recommandations dans un outil IPAM ?*
   Le moteur de recommandations agit comme un système expert. Son rôle est d'analyser automatiquement les 
données du plan d'adressage (VLANs, sous-réseaux) pour identifier des erreurs potentielles, des risques de
 sécurité ou des optimisations possibles que l'administrateur réseau pourrait ne pas voir immédiatement.

 2. *Pourquoi utilise-t-on une interface pour les règles de recommandation ?*
   L'utilisation d'une interface (comme RegleRecommandation) permet d'imposer un contrat standard à toutes
 les règles. Cela garantit que chaque règle possédera la méthode analyser(), ce qui permet au moteur de les
 manipuler de façon uniforme sans connaître le détail interne de chaque règle.

 3. *Quelle est la différence entre une classe concrète et une interface ?*
   Une *interface* est un modèle purement abstrait qui définit ce que les classes doivent faire (les 
signatures des méthodes) sans fournir le code. Une *classe concrète* est une implémentation réelle qui 
définit comment l'action est réalisée (le code source) et qui peut être instanciée pour créer des objets.

 4. *Pourquoi la méthode analyser() peut-elle retourner null ?*
   Elle retourne null lorsqu'une règle ne s'applique pas au VLAN analysé. Par exemple, si la règle cherche 
des VLANs "ADMIN" et qu'elle analyse un VLAN "ETUDIANTS", elle renvoie null pour signifier qu'il n'y a aucune
 recommandation à générer pour ce cas précis.

 5. *Pourquoi le moteur de recommandations illustre-t-il le polymorphisme ?*
   Le polymorphisme est illustré car le moteur manipule une liste d'objets de type RegleRecommandation.
 Bien que chaque objet soit différent (RecommandationWifi, RecommandationServeurs, etc.), le moteur appelle 
la même méthode analyser() sur chacun d'eux, et chaque objet réagit selon sa propre logique interne.

 6. *Pourquoi est-il préférable de créer une classe par règle au lieu de mettre tous les tests dans le Main ?*
   Cela respecte le principe de *responsabilité unique* et d'*extensibilité* (Open/Closed Principle). 
On peut ajouter, supprimer ou modifier une règle simplement en créant ou supprimant une classe, sans risquer
 de casser le code principal du Main ou du moteur. Le code est ainsi beaucoup plus propre et maintenable.

 7. *Pourquoi un VLAN WiFi invité doit-il être isolé des réseaux internes ?*
   Pour des raisons de *sécurité*. Les invités ne sont pas des utilisateurs de confiance. Les isoler dans 
un VLAN spécifique empêche un utilisateur externe d'accéder aux serveurs sensibles, aux bases de données ou 
aux dossiers partagés de l'entreprise en cas d'attaque ou de malware sur son appareil.

 8. *Pourquoi les VLANs de grande taille doivent-ils être surveillés ?*
   Les VLANs trop grands (contenant beaucoup d'hôtes) génèrent un trafic de *broadcast* important (diffusion)
 qui peut saturer la bande passante et ralentir les performances de tous les appareils du réseau. 
La surveillance permet de décider s'il est temps de segmenter le réseau en plusieurs petits VLANs plus
 efficaces.

# TP9 - Persistance et organisation professionnelle

## Objectif
L'objectif de ce TP est d'ajouter une couche de persistance à l'application en mettant en œuvre la lecture
 et l'écriture de fichiers. Cela permet de sauvegarder durablement les besoins, les plans, les VLANs, les 
recommandations et les rapports générés par le système.

## Notions étudiées
* *Persistance des données* : Capacité à conserver les informations après la fermeture du programme.
* *Fichiers CSV* : Utilisation d'un format structuré pour l'importation et l'exportation de données.
* *Architecture Professionnelle* : Organisation du code en couches via les packages repository et service.
* *Entrées/Sorties (I/O)* : Manipulation des flux de données en Java.

## Fichiers utilisés
* *Fichiers d'entrée* : besoins.csv (contenant les données brutes à traiter).
* *Fichiers générés* : rapport_technique.txt, sauvegarde_plans.csv.

## Scénarios testés
1.  Lecture et chargement automatique des équipements depuis le fichier CSV.
2.  Modification des données en mémoire et sauvegarde dans un nouveau fichier.
3.  Génération d'un rapport textuel après analyse des besoins réseaux.
4.  Vérification de l'intégrité des données après redémarrage de l'application.

## Difficultés rencontrées
* Gestion des exceptions lors de l'accès aux fichiers (FileNotFoundException, IOException).
* Parsing des lignes du fichier CSV pour transformer du texte en objets Java.
* Respect de la séparation des responsabilités entre le stockage (Repository) et la logique (Service).

## Réponses aux questions

1.  *Qu'est-ce que la persistance des données ?*
    C'est la caractéristique des données qui survivent à l'arrêt du processus qui les a créées. Sans 
persistance, les données sont stockées uniquement en RAM et disparaissent à la fermeture du logiciel.
2.  *Pourquoi une application professionnelle doit-elle sauvegarder ses résultats ?*

    Pour garantir la continuité du travail, permettre l'audit des actions passées, partager des informations
 entre différents utilisateurs et éviter la perte de données critiques en cas de panne.

3.  *Quelle est la différence entre un fichier CSV et un rapport texte ?*
    Un fichier CSV est un format *structuré* (données séparées par des délimiteurs) destiné à être lu par une
 machine ou un tableur. Un rapport texte est un format *non structuré* destiné à être lu par un humain.

4.  *Pourquoi a-t-on créé un package repository ?*
    Il sert à isoler toute la logique d'accès aux données (lecture/écriture fichiers, base de données).
 C'est la couche qui gère le stockage.

5.  *Pourquoi a-t-on créé un package service ?*
    Il contient la "logique métier" de l'application. Il fait le lien entre les données brutes du repository 
et les besoins de l'utilisateur (calculs, vérifications).

6.  *Pourquoi ne faut-il pas écrire tout le code dans la classe Main ?*
    Pour éviter le code "spaghetti". Une classe Main trop chargée est difficile à lire, impossible à 
 unitairement et très complexe à maintenir ou à faire évoluer.

7.  *Pourquoi le fichier besoins.csv rend-il l'application plus flexible ?*
    Parce qu'il permet de modifier les données d'entrée sans avoir à modifier ou à recompiler le code source
 Java.

8.  *Pourquoi la séparation en packages améliore-t-elle la maintenabilité du projet ?*
    Elle permet de localiser rapidement une erreur (ex: un problème de calcul est dans service, un problème 
de fichier est dans repository) et permet à plusieurs développeurs de travailler sur des couches différentes
 sans se gêner.