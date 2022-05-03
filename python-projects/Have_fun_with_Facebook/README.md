# Have_fun_with_Facebook
Utils per facebook

<h2>Requisiti</h2>
<ul>
<li>Database postgres</li>
<li>Tabella post con i seguenti campi:
  <table>
  <tr>
  <td><b>id</b></td><td>                        character varying</td></tr>
  <tr><td><b>created_time</b></td><td>          character varying</td></tr>
  <tr><td><b>object_id</b></td><td>             character varying</td></tr>
  <tr><td><b>message</b></td><td>               character varying</td></tr> 
  <tr><td><b>pic</b></td><td>                   character varying</td></tr>
  <tr><td><b>link</b> </td><td>                 character varying</td></tr>
  </table>
  </li>
  <li>Python 2.x</li>
  <li>PsycoPg2</li>
  <li>Account su facebook developers</li>
  </ul>
  
  <h2>Prima di iniziare</h2>
  Prima di eseguire i vari script devi prima compilare i vari file di configurazione.
  <table>
  <tr><th>Nome</th><th>Descrizione</th><th>Serve per</th></tr>
  <tr><td>tempToken</td><td>Ti basta inserire qui il token temporaneo senza spazi e ritorni a capo</td><td>autoLike e autoPost</td></tr>
  <tr><td>connectDB.py</td><td>Inserisci i dati nella stringa accanto ai relativi nomi. Ti basta solo modificare il primo file e gli altri verranno modificati in automatico<br>( sono collegamenti )</td><td>tutti gli script python che si connettono al database</td></tr>
  <tr><td>credentialToken.sh</td><td>Inserisci i dati per richiedere l'access token<br>(ti serve un app che puoi creare sulla pagina facebook developer)</td><td>tutti gli script sh che richiedono post a facebook</td>
  </table>
  
  <h2>Run</h2>
  <h3>Script principale</h3>
  `./watchFB.sh id_pagina_facebook`<br>Richiede un solo argomento: l' <b>id della pagina di facebook</b> o il <b>nome</b><br>
  Esempio: `./watchFB.sh SessoDrogaPastorizia`
<br><br>
Dopo l'esecuzione dello script principale troverai nella tabella gli ultimi 100 post della pagina che hai scelto.<br>
Se sono presenti post doppi ti basta eseguire il file distinctTable.py `./distinctTable.py` e verranno eliminati i post in più.<br><br>
<h3>AutoLike</h3>
Questo script mette like a tutti i post presenti nella tabella post che verrà riempita con l'esecuzione dello script precedente.<br>
Per seguire questo script basta il comando `./autoLike.py`

<h3>AutoPost</h3>
Questo script prende gli ultimi post presenti nella tabella post e li condivide.<br>
Per eseguire lo script basta lanciare il comando `./autoPost.py numero_post`<br>
Richiede un argomento: <b>numero di post da condividere</b>, se non passato ne il numero di post sarà impostato a 10
<br>( per evitare di essere bloccati per spam !)
<br>
