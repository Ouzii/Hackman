### Hackman - The new pac-man

**Aihe:** Pac-man mallinen peli omalla sävyllään. Pelaaja pyrkii keräämään kaikki pelialustan "bitit" samalla vältellen vihollisia. Viholliset liikkuvat satunnaisesti pelialustalla, mahdollisesti laajennetaan jahtaamaan pelaajaa. Laajennuksena myös vaikeustason määrittäminen ja lisää karttoja sekä pac-manista tutut kirsikat. Pyritään paikalliseen high score -listaan.


**Käyttäjän toiminnot:**

- Aloita peli
- Määrää suunta pelihahmollesi
- (aseta vaikeustaso)
- (valitse kartta)
- tarkastele huipputuloksia


**Tekoälyn toiminnot:**

- Aluksi vain satunnaisesti liikkuvia vihollisia
- Päivitetään mahdollisesti viisaammiksi, pelaajaa jahtaaviksi.
- Päivitetään mahdollisesti liikkumaan poispäin pelaajasta, kun pelaaja poimii kirsikan (tms. joka muuttaa pelaajan voittamattomaksi)

**Rakennekuvaus:**
Main-luokka luo uuden Käyttöliittymä-olion ja käynnistää sen. Käyttöliittymä, käyttäen MenunUlkoasua hyödykseen, käynnistää kirjautumisikkunan. Napinkuuntelija antaa käyttöliittymän kautta pelin highscore-oliolle pelaajan nimen. Piirtäjä-luokka piirtää grafiikat pelissä ja MenunPiirtäjä piirtää valikot. NappaimistonKuuntelija toimittaa pelaajan antaman näppäimistökomennot pelilogiikalle ja käyttöliittymälle. Piirtäjä pyytää pelin highscore-oliolta ulkoisessa tekstitiedostossa säilytettäviä huipputuloksia.

![Luokkakaavio](http://i1259.photobucket.com/albums/ii553/Oce43/HackmanLuokkakaavio_zpsyk5dod20.png?t=14877800935"Luokkakaavio")
![Sekvenssikaavio-PelinKaynnistys](http://i1259.photobucket.com/albums/ii553/Oce43/Pelin%20kaynnistys2_zpsjfbyjctr.png?t=1487190867"SekvenssikaavioPelinKaynnistys")
![Sekvenssikaavio-SuunnanMuuttaminen](http://i1259.photobucket.com/albums/ii553/Oce43/Suunnan%20Muuttaminen_zpsiing56hj.png?t=1487163268"SekvenssikaavioSuunnanMuuttaminen")
![Sekvenssikaavio-MustanVihollisenSuunnanMuuttaminen](http://i1259.photobucket.com/albums/ii553/Oce43/MustanVihollisenSuunnanMuuttaminen_zpskotedrm8.png?t=1487163807"SekvenssikaavioMustanVihollisenSuunnanMuuttaminen")