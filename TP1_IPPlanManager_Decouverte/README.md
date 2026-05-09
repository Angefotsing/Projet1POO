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
