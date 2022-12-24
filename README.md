# Dating Webapp




## Database : 

##### MySQL : 
made with **MySQL** and **JDBC**.

##### Host process by **ESIEE**: 
*Ne marche pas <!> mais a tester*
1. Visitez https://mvproxy.esiee.fr
2. Entrez votre login ESIEE, et laissez le mot de passe vide
3. Notez le mot de passe mvproxy qui vous sera transmis par mail : ce mot de passe est
   le même donné à tous vous utilisateurs Oracle
4. Reconnectez-vous à https://mvproxy.esiee.fr avec votre mot de passe mvproxy, et
   notez votre hôte et vos utilisateurs Oracle
5. SQL Developer se lance à partir du terminal par /nfs/opt/bdr/sqldeveloper&


##### Host process by **FreeSQL**: 
https://www.freesqldatabase.com/ 
datingwebappjava@gmail.com maven111

Your account number is: 726791
sql7.freesqldatabase.com
sql7583537
SdFXfJAB2n
3306

## React : 

### `npm` Structure : 
> Initialize with `npm Create React App`. 
The structure is compose to a **src>main**:
- java which contain all **java** and **spring boot** framework **files**
- public which contain **assets** and the `index.html`
- scripts which contain basic .js and all react components + linked .css

#### Detail [FR]
Le fichier index dans public nomalement ne sert uniquement a avoir une `<div id='root'></div>` avec aucun contenu dedans. Le contenu est envoyé dans la div via index.js qui lui meme renvoie a app.js (je sais pas trop pourquoi mais c'est toujours comme a sur internet, je pense que c'est pour pouvoir render plusieurs trucs voir ci apres). Le app.js render (retourne) juste les `<contenu/>`. Ces contenu sont des composants (scr>main>scripts>components). Les components sont les differents element du site.L'interet est que dans les .js on peut faire `if(condition) alors on render(a) sinon render(b)` cela permet d'afficher un composant que a ceratain moment, ou en fonction d'un state.
Les components sont aussi liés a des .css (nomale...)
Pour s'instant les composants sont **'Statique dans le sans ou l'affichage est predefinit'** il faut dont mettre un `props` en param des fonction (components) et faire des `propos.name` par exemple. De meme pour le forme. 


# To Do : 
1. **merge index.html and login.html**
   1. They have the same action
   2. think to add all link in the header
   3. thinks to put the <div id="">
2. make a component login
3. make a component discover
   1. page where there is matches 
      1. style carousel / slider ==> Carousel -> use for loop inside jsx
4. **Rendre le jsx dinamique** 
5. add the chat Package <!>
