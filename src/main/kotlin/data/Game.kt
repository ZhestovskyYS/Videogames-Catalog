package data

data class Game(
    val name: String,
    val logo: String,
    val genre: String,
    val studio: String,
    val releaseYear: Int,
    val cost: Int,
    val metacritic: Int,
    var possess: Boolean

)

fun gameList() =
    arrayOf(
        Game(
            "Terraria",
            "https://steamcdn-a.akamaihd.net/steam/apps/105600/header.jpg?t=1590092560",
            "Open World Survival Craft",
            "Re-Logic",
            2011,
            249,
            83,
            false
        ),
        Game(
            "Don't Starve",
            "https://steamcdn-a.akamaihd.net/steam/apps/219740/header.jpg?t=1588618326",
            "Open World Survival Craft",
            "Klei Entertainment",
            2013,
            259,
            79,
            false
        ),
        Game(
            "Star Craft",
            "https://upload.wikimedia.org/wikipedia/ru/thumb/0/0f/StarCraft.front_cover.jpg/274px-StarCraft.front_cover.jpg",
            "Real-Time Strategy",
            "Blizzard Entertainment",
            1998,
            0,
            96,
            false
        ),
        Game(
            "Sid Meier’s Civilization® VI",
            "https://steamcdn-a.akamaihd.net/steam/apps/289070/header_russian.jpg?t=1590082071",
            "Turn-Based Strategy",
            "Firaxis Games",
            2016,
            1999,
            88,
            false
        ),
        Game(
            "The Elder Scrolls V: Skyrim",
            "https://upload.wikimedia.org/wikipedia/ru/thumb/3/3a/The_Elder_Scrolls_V_-_Skyrim.jpg/274px-The_Elder_Scrolls_V_-_Skyrim.jpg",
            "Action/RPG ",
            "Bethesda Game Studios",
            2010,
            399,
            94,
            false
        ),
        Game(
            "The Witcher® 3: Wild Hunt",
            "https://steamcdn-a.akamaihd.net/steam/apps/292030/header.jpg?t=1590646979",
            "Action/RPG",
            "CD Projekt RED",
            2015,
            1199,
            93,
            false
        ),
        Game(
            "DARK SOULS™ III",
            "https://steamcdn-a.akamaihd.net/steam/apps/374320/header.jpg?t=1588788422",
            "Action/RPG",
            "FromSoftware",
            2016,
            1999,
            89,
            false
        ),
        Game(
            "Forza Horizon 4",
            "https://store-images.s-microsoft.com/image/apps.36093.14339303838396367.725ab8dd-f8b7-4a29-a351-45ebd5d66edd.ba2a2523-7f32-4f92-a83d-26097b7b6ca1?mode=scale&q=90&h=300&w=200",
            "Racing simulator",
            "Microsoft Studios",
            2012,
            4110,
            88,
            false
        ),
        Game(
            "Dishonored",
            "https://steamcdn-a.akamaihd.net/steam/apps/217980/header.jpg?t=1529533164",
            "Stealth Action",
            "Arkane Studios",
            2012,
            349,
            91,
            false
        ),
        Game(
            "The Legend of Zelda: Breath of the Wild",
            "https://upload.wikimedia.org/wikipedia/ru/thumb/3/34/TLoZ_BotW_boxart.png/274px-TLoZ_BotW_boxart.png",
            "Action-adventure",
            "Nintendo",
            2017,
            4110,
            97,
            false
        ),
        Game(
            "Borderlands 2",
            "https://steamcdn-a.akamaihd.net/steam/apps/49520/header.jpg?t=1590450074",
            "Looter shooter",
            "Gearbox Software,",
            2012,
            999,
            89,
            false
        )
    )