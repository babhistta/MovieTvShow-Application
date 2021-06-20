package com.briliantino.movietvshowapp.core.utils

import com.briliantino.movietvshowapp.core.data.local.entity.MovieEntity
import com.briliantino.movietvshowapp.core.data.local.entity.TvShowEntity

object  DataDummy {

    fun generateDummyMovies() : List<MovieEntity>{

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                    460465,
                    "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Mortal Kombat",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                7.8,
                    2120,
            )

        )
        movies.add(
            MovieEntity(
                399566,
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Godzilla vs. Kong",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                8.1,
                5285,
            )
        )
        movies.add(
            MovieEntity(
                615457,
                    "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "Nobody",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                8.5,
                1181 ,
            )
        )
        movies.add(
            MovieEntity(
                804435,
                    "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                    "Vanquish",
                "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                6.2,
                    58,
            )
        )
        movies.add(
            MovieEntity(
                635302,
                    "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                8.3,
                828
            )
        )
        movies.add(
            MovieEntity(
                726684,
                    "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                "Miraculous World: Shanghai – The Legend of Ladydragon",
                "/xt2EwFW5cxcmbDnVmH8izSftUtE.jpg",
                7.8,
                253
            )
        )
        movies.add(
            MovieEntity(
                632357,
                    "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "The Unholy",
                "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                5.8,
                69
            )
        )
        movies.add(
            MovieEntity(
                791373,
                    "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "Zack Snyder's Justice League",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                8.5,
                5313
            )
        )
        movies.add(
            MovieEntity(
                615678,
                    "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "Thunder Force",
                "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                5.8,
                518
            )
        )
        movies.add(
            MovieEntity(
                634528,
                    "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "The Marksman",
                "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                7.5,
                374
            )
        )
        movies.add(
            MovieEntity(
                527774,
                    "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "Raya and the Last Dragon",
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                8.2,
                2652
            )
        )
        movies.add(
            MovieEntity(
                567189,
                    "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                7.2,
                538
            )
        )
        movies.add(
            MovieEntity(
                736069,
                    "While speeding off to help in an impromptu battle, The Flash blazes and rips through time, only to find himself dropped into the middle of World War II. It’s here that The Flash meets Wonder Woman and her top secret team, known as the Justice Society of America. Amidst the raging tides of war, gripping combat and the velocity of valor, The Flash must fight to return to his own timeline.",
                "Justice Society: World War II",
                "/e4REOC6CZW8J6FslA4nRvdQXFXR.jpg",
                8.3,
                142
            )
        )
        movies.add(
            MovieEntity(
                412656,
                    "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                "Chaos Walking",
                "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                7.3,
                522
            )
        )
        movies.add(
            MovieEntity(
                458576,
                    "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "Monster Hunter",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                7.1,
                1588
            )
        )
        movies.add(
            MovieEntity(
                587807,
                    "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                "Tom & Jerry",
                "/yMoMlJo2msoVwmuf6k1C78MrB3H.jpg",
                7.3,
                1303
            )
        )
        movies.add(
            MovieEntity(
                464052,
                    "A botched store robbery places Wonder Woman in a global battle against a powerful and mysterious ancient force that puts her powers in jeopardy.",
                "Wonder Woman 1984",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                6.8,
                5050
            )
        )
        movies.add(
            MovieEntity(
                793723,
                    "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                "Sentinelle",
                "/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
                6.0,
                364
            )
        )
        movies.add(
            MovieEntity(
                663558,
                    "3000 years after the boy-god Nezha conquers the Dragon King then disappears in mythological times, he returns as an ordinary man to find his own path to becoming a true hero.",
                "New Gods: Nezha Reborn",
                "/6goDkAD6J3br81YMQf0Gat8Bqjy.jpg",
                8.8,
                125
            )
        )
        movies.add(
            MovieEntity(
                775996,
                    "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                "Outside the Wire",
                "/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg",
                6.5,
                1049
            )
        )
        return movies
    }

    fun generateDummyTvShows() : List<TvShowEntity>{
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                88396,
                    "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                5286
            )
        )
        tvShows.add(
            TvShowEntity(
                95557,
                    "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Invincible",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                8.9,
                1283
            )
        )
        tvShows.add(
            TvShowEntity(
                71712,
                    "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "The Good Doctor",
                "/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
                8.6,
                8268
            )
        )
        tvShows.add(
            TvShowEntity(
                60735,
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7,
                7519
            )
        )
        tvShows.add(
            TvShowEntity(
                79008,
                    "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "Luis Miguel: The Series",
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                8.1,
                368
            )
        )
        tvShows.add(
            TvShowEntity(
                1416,
                    "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "Grey's Anatomy ",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                8.2,
                5979
            )
        )
        tvShows.add(
            TvShowEntity(
                63174,
                    "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "Lucifer",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                8.5,
                8456
            )
        )
        tvShows.add(
            TvShowEntity(
                120587,
                    "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                "Haunted: Latin America",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                7.5,
                202
            )
        )
        tvShows.add(
            TvShowEntity(
                69050,
                    "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Riverdale",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                7.8,
                11168
            )
        )
        tvShows.add(
            TvShowEntity(
                65820,
                    "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "Van Helsing",
                "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                6.9,
                534
            )
        )
        tvShows.add(
            TvShowEntity(
                1399,
                    "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "Game of Thrones",
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                8.4,
                14235
            )
        )
        tvShows.add(
            TvShowEntity(
                1402,
                    "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "The Walking Dead",
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                8.1,
                10711
            )
        )
        tvShows.add(
            TvShowEntity(
                62286,
                    "What did the world look like as it was transforming into the horrifying apocalypse depicted in The Walking Dead? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "Fear the Walking Dead",
                "/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg",
                7.6,
                3463
            )
        )
        tvShows.add(
            TvShowEntity(
                85271,
                    "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "WandaVision",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                8.4,
                8365
            )
        )
        tvShows.add(
            TvShowEntity(
                120168,
                    "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "Who Killed Sara?",
                "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                7.8,
                461
            )
        )
        tvShows.add(
            TvShowEntity(
                95057,
                    "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "Superman & Lois",
                8.3,
                787
            )
        )
        tvShows.add(
            TvShowEntity(
                79460,
                    "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                "Legacies",
                "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                8.6,
                1836
            )
        )
        tvShows.add(
            TvShowEntity(
                18165   ,
                    "The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.",
                "The Vampire Diaries",
                "/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg",
                8.3,
                5794
            )
        )
        tvShows.add(
            TvShowEntity(
                77169,
                    "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "Cobra Kai",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                8.1,
                3037
            )
        )
        tvShows.add(
            TvShowEntity(
                460465,
                    "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "Vikings",
                "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                8.0,
                4423
            )
        )
        return tvShows
    }

    fun generateMovieRemoteDummyDetail(): MovieEntity {
        return MovieEntity(
                2120,
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Mortal Kombat",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                7.8,
                460465
        )
    }

    fun generateTvRemoteDummyDetail(): TvShowEntity {
        return TvShowEntity(
                5286,
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                88396
        )
    }
}