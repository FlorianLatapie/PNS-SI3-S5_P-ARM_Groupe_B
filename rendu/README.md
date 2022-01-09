# 💻 Projet Polytech-ARM 
# Équipe : Groupe B

## Membres de l'équipe 
* Florian Latapie
* Loïc Le Bris 
* Marius Lesaulnier
* Thomas Paul


## Fichiers présentés durant la soutenance  
* Les diapositives de présentation : à la racine du dossier sous le nom `P-ARM Groupe B.pdf` 
* Tests d'intégration : https://bitbucket.org/edge-team-leat/parm_public/src/master/
* Tests unitaires : dans le sous dossier `tests`
* Programme d'exemple final : 
  * main.c : dans le sous dossier `assembleur/C_Files`
  * main.s : dans les sous dossiers `assembleur/C_Files` et `assembleur/files`
  * main.bin : dans le sous dossier `assembleur/files`

## Comment utiliser l'assembleur ? 
Compilez et lancez le main contenu dans le fichier `Assembleur.java`
Il est situé dans le répertoire `assembleur/src/groupe_b`

On recommande d'utiliser IntelliJ IDEA pour exécuter le programme car 

Le programme lira les fichiers .s dans le un répertoire nommé `files` à l'endroit de l'exécution du programme  (```System.getProperty("user.dir") + "\\files\\";```)

Il suffit donc de mettre 1 à n fichiers `.s` dans ce dossier `files` pour qu'il assemble ces fichiers vers un code hexadécimal compréhensible par notre processeur. 
Autant de fichiers `.bin` seront générés que de fichiers `.s` présents avant l'exécution du programme.

## Comment utiliser le programme main.bin ? 
Pour lancer le programme il faut le charger dans la ROM de la Facade puis choisir la fréquence maximale pour les ticks d'horloge (2048 kHz) puis activer les ticks. 

Une fois qu'il est ecrit dans le tty "lancement du jeu", il suffit d'utiliser les touches `z`, `q`, `s`, `d` du clavier pour faire bouger son pixel en direction de l'objectif. 