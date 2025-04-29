# PRÀCTICA JDBC

> [!NOTE]
> En Jordi i en Miquel, dos escaladors de nivell i propietaris de l’empresa Pillam Ltd. Co., necessiten una aplicació per a gestionar les diferents vies d'escalada que es troben arreu. Abans de demanar-nos els requeriments, ens fan 5 cèntims de les terminologies necessàries:

## 1. Sobre les Vies:

> [!IMPORTANT]
> En el món de l’escalada trobem diferents modalitats, nosaltres contemplarem 3 tipus de via (Esportiva, Clàssica i Gel),
> <br>Les àrees o zones que hi ha vies d’escalada es coneixen com a Escoles i solen tenir un nom propi que les caracteritza.
> <br><br>Cadascuna de les vies te, entre d’altres característiques, un nom propi i un grau de dificultat diferent que va des del 4 al 9c+ (a esportiva i clàssica) i de WI1 a WI7 (en gel).
> Entrem al detall dels 3 tipus diferents de vies que ens demanen a l’aplicació:

## 1.1.- Vies esportives:

> [!IMPORTANT]
> Vies d'entre 5 i 30 metres de llarg on disposem de tot el material d'ancoratge i només ens cal la corda i cintes exprés que aniran sobre els spits, parabolts o químics.

- `Nom:` [nom de la via]
- `Llargada:` [de 5 a 30m]
- `Grau de dificultat:` [4,4+,5,5+,6a,6a+,6b,6b+,6c,6c+,7a,7a+,7b,7b+,7c,7c+,8a,8a+,8b,8b+,8c,8c+,9a,9a+,9b,9b+,9c,9c+] (es recomana fer expressió regular)
- `Orientació:` [N,NE,NO,SE,SO,E,O,S] (es recomana fer expressió regular)
- `Estat:` [Apte, construcció, tancada]
- `Lloc:` [Ciutat,Població,Regió]
- `Escola:` [nom de la Escola]
- `Sector:` [nom del Sector]
- `Coordenades:` [Latitud, Longitud]
- `Ancoratges:` [spits, parabolts, químics]
- `Tipus de roca:` [conglomerat, granit, calcaria, arenisca, altres]
- `Creada per:` [nom de l’escalador que va crear la via. Aquest escalador ha d’aparèixer a la BDD o sinó donar d’alta]

## 1.2.- Vies clàssiques:

> [!IMPORTANT]
> Les vies clàssiques són aquelles vies d’escalada que, a diferència de les esportives, no tenen ancoratges fixos al llarg del recorregut, sinó que l’escalador ha d’anar col·locant el seu propi material de
> protecció mentre avança. Aquest tipus d’escalada requereix més experiència i un coneixement profund del material i la seguretat en parets.
> <br><br>A més, les vies clàssiques es componen de diversos llargs (L1, L2, L3, ...), ja que solen superar els 50 metres de llargada i requereixen diverses reunions per progressar.
> <br>Cada llarg tindrà les següents característiques:

- `Nom:` [nom de la via, els llargs no tenen nom]
- `Llargada:` [de 15 a 30m]
- `Grau de dificultat:` [4,4+,5,5+,6a,6a+,6b,6b+,6c,6c+,7a,7a+,7b,7b+,7c,7c+,8a,8a+,8b] (es recomana fer expressió regular)
- `Orientació:` [N,NE,NO,SE,SO,E,O,S] (es recomana fer expressió regular)
- `Estat:` [Apte, construcció, tancada]
- `Lloc:` [Ciutat,Població,Regió]
- `Escola:` [nom de la Escola]
- `Sector:` [nom del Sector]
- `Coordenades:` [Latitud, Longitud]
- `Ancoratges:` [friends, tascons, bagues, pitons, Tricams, BigBros]
- `Tipus de roca:` [conglomerat, granit, calcaria, arenisca, altres]
- `Creada per:` [nom de l’escalador que va crear la via. Aquest escalador ha d’aparèixer a la BDD o sinó donar d’alta]

## 1.3.- Vies Gel:

> [!IMPORTANT]
> Les vies d'escalada en gel comparteixen algunes característiques amb les vies clàssiques, ja que també poden estar compostes per diversos llargs. No obstant això, la diferència principal rau en el fet que el
> suport sobre el qual s’escala no és roca sinó gel, i per tant, es requereix material específic.
> <br><br>Aquest tipus d’escalada es practica en cascades de gel congelades, parets alpines i corredors de neu-gel, i el seu estat pot variar segons la temperatura i les condicions meteorològiques.
> <br>Cada llarg tindrà les següents característiques:

- `Nom:` [nom de la via, els llargs no tenen nom]
- `Llargada:` [de 15 a 30m]
- `Grau de dificultat:` [4,4+,5,5+,6a,6a+,6b,6b+,6c,6c+,7a,7a+,7b,7b+,7c,7c+,8a,8a+,8b] (es recomana fer expressió regular)
- `Orientació:` [N,NE,NO,SE,SO,E,O,S] (es recomana fer expressió regular)
- `Estat:` [Apte, construcció, tancada]
- `Lloc:` [Ciutat,Població,Regió]
- `Escola:` [nom de la Escola]
- `Sector:` [nom del Sector]
- `Coordenades:` [Latitud, Longitud]
- `Ancoratges:` [friends, tascons, bagues, pitons, Tricams, BigBros]
- `Tipus de roca:` [conglomerat, granit, calcaria, arenisca, altres]
- `Creada per:` [nom de l’escalador que va crear la via. Aquest escalador ha d’aparèixer a la BDD o sinó donar d’alta]

## 2.- Sobre les Escoles:

> [!IMPORTANT]
> Cada escola tindrà quatre atributs (nom, població i número de vies), per tant una escola serà un llistat d’una o més vies on cada via tindrà l’atribut estat (apte, construccio, tancada) i els següents elements:

- `Nom:` [nom de l’Escola]
- `Lloc:` [Ciutat,Població,Regió]
- `Coordenades:` [Latitud, Longitud]
Aproximació: [breu descripció de com arribar]
Número de vies: [número total de vies]
Popularitat: [baixa, mitjana, alta]
Restriccions: [prohibicions durant certes èpoques de l’any, per exemple per nidificació d’aus]


## 3.- Sobre els Sectors:

Nom: [nom del Sector]

Coordenades: [Latitud, Longitud]

Aproximació: [breu descripció de com arribar]

Número de vies: [número total de vies]

Popularitat: [baixa, mitjana, alta]

Restriccions: [prohibicions durant certes èpoques de l’any, per exemple per nidificació d’aus]



## 4.- Sobre els escaladors:

Nom: [nom de l’escalador]

Àlies: [àlies de l’escalador]

Edat: [edat de l’escalador]

Nivell: [nivell màxim que ha assolit, de 4 a 9c+]

Nom de la via: [nom de la via on ha assolit el nivell màxim]

Estil preferit: [esportiva, clàssica, gel]

Historial: [ToDo]

Fita: [fita més rellevant aconseguida, per exemple Via XXXX, ......]
