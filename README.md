# LileInterdite
PROJET DE L2 JAVA (réalisé seul)

Ce projet consiste en créer le jeu "L'île Interdite" en JAVA. On utilisera JavaSwing, et le projet s'articulera autour du modèle MVC (Modele Vue Controlleur). Il est conseillé de le résaliser par groupes de deux à trois. 

Règles du jeu :

Les joueurs doivent récupérer 4 artefacts, chacun lié à un élément (air, terre, eau, feu). L'^le est formée par un ensemble de zones disposées en grille. Outre les zones ordinaires, on a les cas particuliers suivants :  un héliport, d'où les joueurs doivent s'envoler à l'issue de la partie
                                                  des zones associées à chacun des éléments, qui permettent de récupérer l'artefact correspondant.
Chaque zone est dans l'une des situations suivantes : "normale", "inondée" ou "submergé". Une zone innondée peut être asséchée et revenir à la situation "normale". Une zone "submergée" a définitivement disparu. Un joueur peut avoir en main des clés, chacune associée à un élément, et qui permettent de récupérer l'artefact correspondant. Le tour d'un joueur se déroule comme suit : 
                    I. Effectuer jusqu'à trois actions à choisir parmi :
                              - se déplacer vers une zone adjacente non submergée
                              - assécher la zone sur laquelle il se trouve ou une zone adjacente si la zone visée est innondée, mais pas submergée, ou
                              - récupérer un artefact s'il se trouve sur une zeone d'artefact et possède la clé correspondante.
                    II. Chercher une clé, ce qui peut soit ne rien donner, soit donner une clé associée à un élément
                    III. Inonder trois zones tirées au hasard, avec deux cas à considérer : 
                        - si la sone correspondante est dans la situation "normale", elle devient "innondée". Cette zone est alors en sursis, mais elle peut toujours être traversée ou utilisée normalement par les joueurs
                        - si la zone correspondante est déjà dans l'état "innondée" ou "submergée", elle devient ou reste "submergée". Elle ne peut alors plus être traversée. Si un joueur est présent sur cette case à cet instant, il se noie.
                        
La partie est gagnée lorsque les 4 artefacts sont récupérés et que les joueurs sont regroupés à l'héliport. La partie est perdue dès qu'il n'est plus possible de gagner (un joueur est mort avec en main une clé ou un artefact...).

                                                
