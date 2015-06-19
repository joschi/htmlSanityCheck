package org.aim42.htmlSanityCheck.suggest;

import net.ricecode.similarity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Document some features of the StringSimilarity package from Ralph Allan Rice.
 * Based upon code from Ralph Allan Rice ralph.rice@gmail.com
 **/

public class StringSimilarityTest {

    SimilarityStrategy strategy;
    StringSimilarityService service;
    List<String> features;

    @Before
    public void setup() {
        strategy = new JaroWinklerStrategy();
        service = new StringSimilarityServiceImpl(strategy);

        features = new ArrayList<String>();
    }

    @Test
    public void testFindTopInShortList() {
        String target = "McDonalds";

        String c1 = "MacMahons";
        String c2 = "McPherson";
        String c3 = "McDonaldz";


        features.add(c1);
        features.add(c2);
        features.add(c3);

        List<SimilarityScore> scores = service.scoreAll(features, target);

        assertEquals(3, scores.size());

        assertEquals( "McDonaldz is expected to be the best match", "McDonaldz",
                service.findTop(features, target).getKey());

    }


    @Test
    public void testFindSuggestionInLongList() {
        String target = "Bröncohr";
        String bestMatch = "Broncor";

        features = Arrays.asList(
                "Abomasnow", "Abra", "Absol", "Accelgor", "Aerodactyl", "Aggron",
                "Aipom", "Alakazam", "Alomomola", "Altaria", "Ambipom", "Amoonguss",
                "Ampharos", "Anorith", "Arbok", "Arcanine", "Arceus", "Archen", "Archeops",
                "Ariados", "Armaldo", "Aron", "Articuno", "Audino", "Axew", "Azelf",
                "Azumarill", "Azurill", "Bagon", "Baltoy", "Banette", "Barboach",
                "Basculin", "Bastiodon", "Bayleef", "Beartic", "Beautifly", "Beedrill",
                "Beheeyem", "Beldum", "Bellossom", "Bellsprout", "Bibarel", "Bidoof",
                "Bisharp", "Blastoise", "Blaziken", "Blissey", "Blitzle", "Boldore",
                "Bonsly", "Bouffalant", "Braviary", "Breloom", "Bronzong", bestMatch,
                "Budew", "Buizel", "Bulbasaur", "Buneary", "Burmy", "Butterfree", "Cacnea",
                "Cacturne", "Camerupt", "Carnivine", "Carracosta", "Carvanha", "Cascoon",
                "Castform", "Caterpie", "Celebi", "Chandelure", "Chansey", "Charizard",
                "Charmander", "Charmeleon", "Chatot", "Cherrim", "Cherubi", "Chikorita",
                "Chimchar", "Chimecho", "Chinchou", "Chingling", "Cinccino", "Clamperl",
                "Claydol", "Clefable", "Clefairy", "Cleffa", "Cloyster", "Cobalion",
                "Cofagrigus", "Combee", "Combusken", "Conkeldurr", "Corphish", "Corsola",
                "Cottonee", "Cradily", "Cranidos", "Crawdaunt", "Cresselia", "Croagunk",
                "Crobat", "Croconaw", "Crustle", "Cryogonal", "Cubchoo", "Cubone",
                "Cyndaquil", "Darkrai", "Darmanitan", "Darumaka", "Deerling", "Deino",
                "Delcatty", "Delibird", "Deoxys", "Dewgong", "Dewott", "Dialga", "Diglett",
                "Ditto", "Dodrio", "Doduo", "Donphan", "Dragonair", "Dragonite", "Drapion",
                "Dratini", "Drifblim", "Drifloon", "Drilbur", "Drowzee", "Druddigon",
                "Ducklett", "Dugtrio", "Dunsparce", "Duosion", "Durant", "Dusclops",
                "Dusknoir", "Duskull", "Dustox", "Dwebble", "Eelektrik", "Eelektross",
                "Eevee", "Ekans", "Electabuzz", "Electivire", "Electrike", "Electrode",
                "Elekid", "Elgyem", "Emboar", "Emolga", "Empoleon", "Entei", "Escavalier",
                "Espeon", "Excadrill", "Exeggcute", "Exeggutor", "Exploud", "Farfetch'd",
                "Fearow", "Feebas", "Feraligatr", "Ferroseed", "Ferrothorn", "Finneon",
                "Flaaffy", "Flareon", "Floatzel", "Flygon", "Foongus", "Forretress",
                "Fraxure", "Frillish", "Froslass", "Furret", "Gabite", "Gallade",
                "Galvantula", "Garbodor", "Garchomp", "Gardevoir", "Gastly", "Gastrodon",
                "Gengar", "Geodude", "Gible", "Gigalith", "Girafarig", "Giratina", "Glaceon",
                "Glalie", "Glameow", "Gligar", "Gliscor", "Gloom", "Golbat", "Goldeen",
                "Golduck", "Golem", "Golett", "Golurk", "Gorebyss", "Gothita", "Gothitelle",
                "Gothorita", "Granbull", "Graveler", "Grimer", "Grotle", "Groudon",
                "Grovyle", "Growlithe", "Grumpig", "Gulpin", "Gurdurr", "Gyarados",
                "Happiny", "Hariyama", "Haunter", "Haxorus", "Heatmor", "Heatran",
                "Heracross", "Herdier", "Hippopotas", "Hippowdon", "Hitmonchan",
                "Hitmonlee", "Hitmontop", "Ho-Oh", "Honchkrow", "Hoothoot", "Hoppip",
                "Horsea", "Houndoom", "Houndour", "Huntail", "Hydreigon", "Hypno",
                "Igglybuff", "Illumise", "Infernape", "Ivysaur", "Jellicent", "Jigglypuff",
                "Jirachi", "Jolteon", "Joltik", "Jumpluff", "Jynx", "Kabuto", "Kabutops",
                "Kadabra", "Kakuna", "Kangaskhan", "Karrablast", "Kecleon", "Kingdra"
                );

        List<SimilarityScore> scores = service.scoreAll(features, target);

        assertEquals(267, scores.size());

        assertEquals( bestMatch + " is expected to be the best match", bestMatch,
                service.findTop(features, target).getKey());

    }
}



/************************************************************************
 * This is free software - without ANY guarantee!
 * <p/>
 * <p/>
 * Copyright Dr. Gernot Starke, arc42.org
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * **********************************************************************
 */

