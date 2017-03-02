### Hackman - The new pac-man

**Aihe:** Pac-man mallinen peli omalla sävyllään. Pelaaja pyrkii keräämään kaikki pelialustan "bitit" samalla vältellen vihollisia. Vihollisilla on kaikilla oma tekoälynsä, ja pelaaja joutuu oppimaan vihollisten käyttäytymisen selviytyäkseen. Pelissä on viisi karttaa ja paikallinen highscore-lista.

**Käyttäjän toiminnot:**

- Kirjaudu nimelläsi
- Aloita uusi peli/jatka peliä
- Pysäytä peli
- Määrää suunta pelihahmollesi
- aseta vaikeustaso
- tarkastele huipputuloksia


**Tekoälyn toiminnot:**

- Muuta suuntaa pelaajan sijainnista riippuen tai satunnaisesti

**Rakennekuvaus:**
Main-luokka luo uuden Käyttöliittymä-olion ja käynnistää sen. Käyttöliittymä, käyttäen MenunUlkoasua hyödykseen, käynnistää kirjautumisikkunan. Napinkuuntelija antaa käyttöliittymän kautta pelin highscore-oliolle pelaajan nimen. Piirtäjä-luokka piirtää grafiikat pelissä ja MenunPiirtäjä piirtää valikot. NappaimistonKuuntelija toimittaa pelaajan antamat näppäimistökomennot pelilogiikalle ja käyttöliittymälle. Piirtäjä pyytää pelin highscore-oliolta ulkoisessa tekstitiedostossa säilytettäviä huipputuloksia.

![Luokkakaavio](http://i1259.photobucket.com/albums/ii553/Oce43/HackmanLuokkakaavio_zpsz22v6wra.png?t=1488386346"Luokkakaavio")
![Sekvenssikaavio-PeliinKirjautuminen](http://i1259.photobucket.com/albums/ii553/Oce43/Peliin%20kirjautuminen_zpsuwyqgaw6.png?t=1488393289"SekvenssikaavioPeliinKirjautuminen")
![Sekvenssikaavio-SuunnanMuuttaminen](http://i1259.photobucket.com/albums/ii553/Oce43/Suunnan%20Muuttaminen_zpsiing56hj.png?t=1487163268"SekvenssikaavioSuunnanMuuttaminen")
![Sekvenssikaavio-MustanVihollisenSuunnanMuuttaminen](http://i1259.photobucket.com/albums/ii553/Oce43/MustanVihollisenSuunnanMuuttaminen_zpskotedrm8.png?t=1487163807"SekvenssikaavioMustanVihollisenSuunnanMuuttaminen")