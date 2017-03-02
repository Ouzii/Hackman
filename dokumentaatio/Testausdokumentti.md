**Testausdokumentti**

**Peli-luokassa** ActionEvent-metodiin ei ole kirjoitettu automaattisia testejä, sillä se ei onnistu ilman ulkoista apukirjastoa. Metodin toimivuus on kuitenkin testattu useasti pelaamalla peliä. Metodin luonteen vuoksi olisi selkeästi nähtävissä, jos metodi ei toimisi (peli ei liikkuisi).

**Highscore-luokassa** automaattinen testaaminen ei onnistu ilman "testMode" booleania, joten luokasta on testattu vain testattava osa. Luokkaan on kuitenkin tehty identtiset testausosat, kuin normaalissa käytössä (highscore-tietojen tallennuspaikkaa lukuunottamatta), joten testeistä saa kuitenkin käsityksen toimivista osista. Myöskään Scannerin ja Writerien metodeja ei ole testattu, eikä muitakaan javan valmiita metodeja.

**PeliLogiikka-luokassa** on testattu automaattisesti kaikki, mikä on mahdollista testata. Random-muuttujaa askelLuku-metodissa ei voitu testata automaattisesti, mutta vihollisten vaihdaSuunta-metodia,jolle random-muuttuja annetaan on testattu hyvin. Jostain syystä myöskään liikuPelaaja-metodissa ei täydellisesti testit toimi, mutta peliä pelaamalla todettu toimivuus.

**Käyttöliittymä-paketin** metodeja ei ole testattu automaattisesti, mutta pelissä kokeiltu kaikki mahdolliset tapahtumat. Yritetty myös käsin kaataa ohjelmaa, siinä kuitenkaan onnistumatta.

**Rakennuspalat-paketin** luokat testattu automaattisesti, mutta esimerkiksi eri vihollisten kääntymismetodeja ei mutaatioilla ole mahdollista testata. Pelissä todettu vihollisten käyttäytyvän, kuten on toivottu. Vihollinen-luokan kaannaVihollinen-metodia ei ole testattu, koska kyseessä metodi joka on tarkoitettu overridettavaksi muissa vihollis-luokissa. Lisäksi kyseinen metodi kutsuu vain toista metodia random-muuttuja parametrinaan.

**Kartat-paketti** testattu laajasti automaattisesti, mutta Kartta5:n luoSeinat-metodia ei automaattisesti onnistuttu testaamaan, koska metodi luo random-generaattoria hyväksikäyttäen seiniä. Myöskään karttojen muita luomismetodeja ei ole voitu tehokkaasti testata automaattisesti (josta johtuen pit-raportin luonnissa useita TIMED OUT-kohtia), mutta pelissä tarkistettu seinien ja bittien paikat.

**Enumit-pakettia** ei ole testattu, mutta ei ole nähty tarpeelliseksi.