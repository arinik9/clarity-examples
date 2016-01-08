
package skadistats.clarity.examples.pdc04;

class Heroes {
   
    public static final int ANTI_MAGE = 2;
    public static final int AXE = 3;
    public static final int BANE = 4;
    public static final int BLOODSEEKER = 5;
    public static final int CRYSTAL_MAIDEN = 6;
    public static final int DROW_RANGER = 7;
    public static final int EARTHSHAKER = 8;
    public static final int JUGGERNAUT = 9;
    public static final int MIRANA = 10;
    public static final int SHADOW_FIEND = 11;
    public static final int MORPHLING = 12;
    public static final int PHANTOM_LANCER = 13;
    public static final int PUCK = 14;
    public static final int PUDGE = 15;
    public static final int RAZOR = 16;
    public static final int SAND_KING = 17;
    public static final int STORM_SPIRIT = 18;
    public static final int SVEN = 19;
    public static final int TINY = 20;
    public static final int VENGEFUL_SPIRIT = 21;
    public static final int WINDRANGER = 22;
    public static final int ZEUS = 23;
    public static final int KUNKKA = 24;
    public static final int LINA = 25;
    public static final int LICH = 26;
    public static final int LION = 27;
    public static final int SHADOW_SHAMAN = 28;
    public static final int SLARDAR = 29;
    public static final int TIDEHUNTER = 30;
    public static final int WITCH_DOCTOR = 31;
    public static final int RIKI = 32;
    public static final int ENIGMA = 33;
    public static final int TINKER = 34;
    public static final int SNIPER = 35;
    public static final int NECROPHOS = 36;
    public static final int WARLOCK = 37;
    public static final int BEASTMASTER = 38;
    public static final int QUEEN_OF_PAIN = 39;
    public static final int VENOMANCER = 40;
    public static final int FACELESS_VOID = 41;
    public static final int WRAITH_KING = 42;
    public static final int DEATH_PROPHET = 43;
    public static final int PHANTOM_ASSASSIN = 44;
    public static final int PUGNA = 45;
    public static final int TEMPLAR_ASSASSIN = 46;
    public static final int VIPER = 47;
    public static final int LUNA = 48;
    public static final int DRAGON_KNIGHT = 49;
    public static final int DAZZLE = 50;
    public static final int CLOCKWERK = 51;
    public static final int LESHRAC = 52;
    public static final int NATURES_PROPHET = 53;
    public static final int LIFESTEALER = 54;
    public static final int DARK_SEER = 55;
    public static final int CLINKZ = 56;
    public static final int OMNIKNIGHT = 57;
    public static final int ENCHANTRESS = 58;
    public static final int HUSKAR = 59;
    public static final int NIGHT_STALKER = 60;
    public static final int BROODMOTHER = 61;
    public static final int BOUNTY_HUNTER = 62;
    public static final int WEAVER = 63;
    public static final int JAKIRO = 64;
    public static final int BATRIDER = 65;
    public static final int CHEN = 66;
    public static final int SPECTRE = 67;
    public static final int ANCIENT_APPARITION = 68;
    public static final int DOOM = 69;
    public static final int URSA = 70;
    public static final int SPIRIT_BREAKER = 71;
    public static final int GYROCOPTER = 72;
    public static final int ALCHEMIST = 73;
    public static final int INVOKER = 74;
    public static final int SILENCER = 75;
    public static final int OUTWORLD_DEVOURER = 76;
    public static final int LYCANTHROPE = 77;
    public static final int BREWMASTER = 78;
    public static final int SHADOW_DEMON = 79;
    public static final int LONE_DRUID = 80;
    public static final int CHAOS_KNIGHT = 81;
    public static final int MEEPO = 82;
    public static final int TREANT_PROTECTOR = 83;
    public static final int OGRE_MAGI = 84;
    public static final int UNDYING = 85;
    public static final int RUBICK = 86;
    public static final int DISRUPTOR = 87;
    public static final int NYX_ASSASSIN = 88;
    public static final int NAGA_SIREN = 89;
    public static final int KEEPER_OF_THE_LIGHT = 90;
    public static final int IO = 91;
    public static final int VISAGE = 92;
    public static final int SLARK = 93;
    public static final int MEDUSA = 94;
    public static final int TROLL_WARLORD = 95;
    public static final int CENTAUR_WARRUNNER = 96;
    public static final int MAGNUS = 97;
    public static final int TIMBERSAW = 98;
    public static final int BRISTLEBACK = 99;
    public static final int TUSK = 100;
    public static final int SKYWRATH_MAGE = 101;
    public static final int ABADDON = 102;
    public static final int ELDER_TITAN = 103;
    public static final int LEGION_COMMANDER = 104;
    public static final int UNKNOWN = 105;  // ???
    public static final int EMBER_SPIRIT = 106;
    public static final int EARTH_SPIRIT = 107;
    public static final int ABYSSAL_UNDERLORD = 108;
    public static final int TERRORBLADE = 109;
   
    public static String getHeroNameById(int heroId) {
        switch(heroId) {
            case ANTI_MAGE: return "Anti-Mage";
            case AXE: return "Axe";
            case BANE: return "Bane";
            case BLOODSEEKER: return "Bloodseeker";
            case CRYSTAL_MAIDEN: return "Crystal Maiden";
            case DROW_RANGER: return "Drow Ranger";
            case EARTHSHAKER: return "Earthshaker";
            case JUGGERNAUT: return "Juggernaut";
            case MIRANA: return "Mirana";
            case SHADOW_FIEND: return "Shadow Fiend";
            case MORPHLING: return "Morphling";
            case PHANTOM_LANCER: return "Phantom Lancer";
            case PUCK: return "Puck";
            case PUDGE: return "Pudge";
            case RAZOR: return "Razor";
            case SAND_KING: return "Sand King";
            case STORM_SPIRIT: return "Storm Spirit";
            case SVEN: return "Sven";
            case TINY: return "Tiny";
            case VENGEFUL_SPIRIT: return "Vengeful Spirit";
            case WINDRANGER: return "Windranger";
            case ZEUS: return "Zeus";
            case KUNKKA: return "Kunkka";
            case LINA: return "Lina";
            case LICH: return "Lich";
            case LION: return "Lion";
            case SHADOW_SHAMAN: return "Shadow Shaman";
            case SLARDAR: return "Slardar";
            case TIDEHUNTER: return "Tidehunter";
            case WITCH_DOCTOR: return "Witch Doctor";
            case RIKI: return "Riki";
            case ENIGMA: return "Enigma";
            case TINKER: return "Tinker";
            case SNIPER: return "Sniper";
            case NECROPHOS: return "Necrophos";
            case WARLOCK: return "Warlock";
            case BEASTMASTER: return "Beastmaster";
            case QUEEN_OF_PAIN: return "Queen Of Pain";
            case VENOMANCER: return "Venomancer";
            case FACELESS_VOID: return "Faceless Void";
            case WRAITH_KING: return "Wraith King";
            case DEATH_PROPHET: return "Death Prophet";
            case PHANTOM_ASSASSIN: return "Phantom Assassin";
            case PUGNA: return "Pugna";
            case TEMPLAR_ASSASSIN: return "Templar Assassin";
            case VIPER: return "Viper";
            case LUNA: return "Luna";
            case DRAGON_KNIGHT: return "Dragon Knight";
            case DAZZLE: return "Dazzle";
            case CLOCKWERK: return "Clockwerk";
            case LESHRAC: return "Leshrac";
            case NATURES_PROPHET: return "Nature's Prophet";
            case LIFESTEALER: return "Lifestealer";
            case DARK_SEER: return "Dark Seer";
            case CLINKZ: return "Clinkz";
            case OMNIKNIGHT: return "Omniknight";
            case ENCHANTRESS: return "Enchantress";
            case HUSKAR: return "Huskar";
            case NIGHT_STALKER: return "Night Stalker";
            case BROODMOTHER: return "Broodmother";
            case BOUNTY_HUNTER: return "Bounty Hunter";
            case WEAVER: return "Weaver";
            case JAKIRO: return "Jakiro";
            case BATRIDER: return "Batrider";
            case CHEN: return "Chen";
            case SPECTRE: return "Spectre";
            case ANCIENT_APPARITION: return "Ancient Apparition";
            case DOOM: return "Doom";
            case URSA: return "Ursa";
            case SPIRIT_BREAKER: return "Spirit Breaker";
            case GYROCOPTER: return "Gyrocopter";
            case ALCHEMIST: return "Alchemist";
            case INVOKER: return "Invoker";
            case SILENCER: return "Silencer";
            case OUTWORLD_DEVOURER: return "Outworld Devourer";
            case LYCANTHROPE: return "Lycanthrope";
            case BREWMASTER: return "Brewmaster";
            case SHADOW_DEMON: return "Shadow Demon";
            case LONE_DRUID: return "Lone Druid";
            case CHAOS_KNIGHT: return "Chaos Knight";
            case MEEPO: return "Meepo";
            case TREANT_PROTECTOR: return "Treant Protector";
            case OGRE_MAGI: return "Ogre Magi";
            case UNDYING: return "Undying";
            case RUBICK: return "Rubick";
            case DISRUPTOR: return "Disruptor";
            case NYX_ASSASSIN: return "Nyx Assassin";
            case NAGA_SIREN: return "Naga Siren";
            case KEEPER_OF_THE_LIGHT: return "Keeper of the Light";
            case IO: return "Io";
            case VISAGE: return "Visage";
            case SLARK: return "Slark";
            case MEDUSA: return "Medusa";
            case TROLL_WARLORD: return "Troll Warlord";
            case CENTAUR_WARRUNNER: return "Centaur Warrunner";
            case MAGNUS: return "Magnus";
            case TIMBERSAW: return "Timbersaw";
            case BRISTLEBACK: return "Bristleback";
            case TUSK: return "Tusk";
            case SKYWRATH_MAGE: return "Skywrath Mage";
            case ABADDON: return "Abaddon";
            case ELDER_TITAN: return "Elder Titan";
            case LEGION_COMMANDER: return "Legion Commander";
            case UNKNOWN: return "Unknown";
            case EMBER_SPIRIT: return "Ember Spirit";
            case EARTH_SPIRIT: return "Earth Spirit";
            case ABYSSAL_UNDERLORD: return "Abyssal Underlord";
            case TERRORBLADE: return "Terrorblade";
            default: return "Unknown";  
        }
    }
   
    public static String getHeroDTClassById(int heroId) {
        switch(heroId) {
            case ANTI_MAGE: return "DT_DOTA_Unit_Hero_AntiMage";
            case AXE: return "DT_DOTA_Unit_Hero_Axe";
            case BANE: return "DT_DOTA_Unit_Hero_Bane";
            case BLOODSEEKER: return "DT_DOTA_Unit_Hero_Bloodseeker";
            case CRYSTAL_MAIDEN: return "DT_DOTA_Unit_Hero_CrystalMaiden";
            case DROW_RANGER: return "DT_DOTA_Unit_Hero_DrowRanger";
            case EARTHSHAKER: return "DT_DOTA_Unit_Hero_Earthshaker";
            case JUGGERNAUT: return "DT_DOTA_Unit_Hero_Juggernaut";
            case MIRANA: return "DT_DOTA_Unit_Hero_Mirana";
            case SHADOW_FIEND: return "DT_DOTA_Unit_Hero_Nevermore";
            case MORPHLING: return "DT_DOTA_Unit_Hero_Morphling";
            case PHANTOM_LANCER: return "DT_DOTA_Unit_Hero_PhantomLancer";
            case PUCK: return "DT_DOTA_Unit_Hero_Puck";
            case PUDGE: return "DT_DOTA_Unit_Hero_Pudge";
            case RAZOR: return "DT_DOTA_Unit_Hero_Razor";
            case SAND_KING: return "DT_DOTA_Unit_Hero_SandKing";
            case STORM_SPIRIT: return "DT_DOTA_Unit_Hero_StormSpirit";
            case SVEN: return "DT_DOTA_Unit_Hero_Sven";
            case TINY: return "DT_DOTA_Unit_Hero_Tiny";
            case VENGEFUL_SPIRIT: return "DT_DOTA_Unit_Hero_VengefulSpirit";
            case WINDRANGER: return "DT_DOTA_Unit_Hero_Windrunner";
            case ZEUS: return "DT_DOTA_Unit_Hero_Zuus";
            case KUNKKA: return "DT_DOTA_Unit_Hero_Kunkka";
            case LINA: return "DT_DOTA_Unit_Hero_Lina";
            case LICH: return "DT_DOTA_Unit_Hero_Lich";
            case LION: return "DT_DOTA_Unit_Hero_Lion";
            case SHADOW_SHAMAN: return "DT_DOTA_Unit_Hero_ShadowShaman";
            case SLARDAR: return "DT_DOTA_Unit_Hero_Slardar";
            case TIDEHUNTER: return "DT_DOTA_Unit_Hero_Tidehunter";
            case WITCH_DOCTOR: return "DT_DOTA_Unit_Hero_WitchDoctor";
            case RIKI: return "DT_DOTA_Unit_Hero_Riki";
            case ENIGMA: return "DT_DOTA_Unit_Hero_Enigma";
            case TINKER: return "DT_DOTA_Unit_Hero_Tinker";
            case SNIPER: return "DT_DOTA_Unit_Hero_Sniper";
            case NECROPHOS: return "DT_DOTA_Unit_Hero_Necrolyte";
            case WARLOCK: return "DT_DOTA_Unit_Hero_Warlock";
            case BEASTMASTER: return "DT_DOTA_Unit_Hero_Beastmaster";
            case QUEEN_OF_PAIN: return "DT_DOTA_Unit_Hero_QueenOfPain";
            case VENOMANCER: return "DT_DOTA_Unit_Hero_Venomancer";
            case FACELESS_VOID: return "DT_DOTA_Unit_Hero_FacelessVoid";
            case WRAITH_KING: return "DT_DOTA_Unit_Hero_SkeletonKing";
            case DEATH_PROPHET: return "DT_DOTA_Unit_Hero_DeathProphet";
            case PHANTOM_ASSASSIN: return "DT_DOTA_Unit_Hero_PhantomAssassin";
            case PUGNA: return "DT_DOTA_Unit_Hero_Pugna";
            case TEMPLAR_ASSASSIN: return "DT_DOTA_Unit_Hero_TemplarAssassin";
            case VIPER: return "DT_DOTA_Unit_Hero_Viper";
            case LUNA: return "DT_DOTA_Unit_Hero_Luna";
            case DRAGON_KNIGHT: return "DT_DOTA_Unit_Hero_DragonKnight";
            case DAZZLE: return "DT_DOTA_Unit_Hero_Dazzle";
            case CLOCKWERK: return "DT_DOTA_Unit_Hero_Rattletrap";
            case LESHRAC: return "DT_DOTA_Unit_Hero_Leshrac";
            case NATURES_PROPHET: return "DT_DOTA_Unit_Hero_Furion";
            case LIFESTEALER: return "DT_DOTA_Unit_Hero_Life_Stealer";
            case DARK_SEER: return "DT_DOTA_Unit_Hero_DarkSeer";
            case CLINKZ: return "DT_DOTA_Unit_Hero_Clinkz";
            case OMNIKNIGHT: return "DT_DOTA_Unit_Hero_Omniknight";
            case ENCHANTRESS: return "DT_DOTA_Unit_Hero_Enchantress";
            case HUSKAR: return "DT_DOTA_Unit_Hero_Huskar";
            case NIGHT_STALKER: return "DT_DOTA_Unit_Hero_NightStalker";
            case BROODMOTHER: return "DT_DOTA_Unit_Hero_Broodmother";
            case BOUNTY_HUNTER: return "DT_DOTA_Unit_Hero_BountyHunter";
            case WEAVER: return "DT_DOTA_Unit_Hero_Weaver";
            case JAKIRO: return "DT_DOTA_Unit_Hero_Jakiro";
            case BATRIDER: return "DT_DOTA_Unit_Hero_Batrider";
            case CHEN: return "DT_DOTA_Unit_Hero_Chen";
            case SPECTRE: return "DT_DOTA_Unit_Hero_Spectre";
            case ANCIENT_APPARITION: return "DT_DOTA_Unit_Hero_AncientApparition";
            case DOOM: return "DT_DOTA_Unit_Hero_DoomBringer";
            case URSA: return "DT_DOTA_Unit_Hero_Ursa";
            case SPIRIT_BREAKER: return "DT_DOTA_Unit_Hero_SpiritBreaker";
            case GYROCOPTER: return "DT_DOTA_Unit_Hero_Gyrocopter";
            case ALCHEMIST: return "DT_DOTA_Unit_Hero_Alchemist";
            case INVOKER: return "DT_DOTA_Unit_Hero_Invoker";
            case SILENCER: return "DT_DOTA_Unit_Hero_Silencer";
            case OUTWORLD_DEVOURER: return "DT_DOTA_Unit_Hero_Obsidian_Destroyer";
            case LYCANTHROPE: return "DT_DOTA_Unit_Hero_Lycan";
            case BREWMASTER: return "DT_DOTA_Unit_Hero_Brewmaster";
            case SHADOW_DEMON: return "DT_DOTA_Unit_Hero_Shadow_Demon";
            case LONE_DRUID: return "DT_DOTA_Unit_Hero_LoneDruid";
            case CHAOS_KNIGHT: return "DT_DOTA_Unit_Hero_ChaosKnight";
            case MEEPO: return "DT_DOTA_Unit_Hero_Meepo";
            case TREANT_PROTECTOR: return "DT_DOTA_Unit_Hero_Treant";
            case OGRE_MAGI: return "DT_DOTA_Unit_Hero_Ogre_Magi";
            case UNDYING: return "DT_DOTA_Unit_Hero_Undying";
            case RUBICK: return "DT_DOTA_Unit_Hero_Rubick";
            case DISRUPTOR: return "DT_DOTA_Unit_Hero_Disruptor";
            case NYX_ASSASSIN: return "DT_DOTA_Unit_Hero_Nyx_Assassin";
            case NAGA_SIREN: return "DT_DOTA_Unit_Hero_Naga_Siren";
            case KEEPER_OF_THE_LIGHT: return "DT_DOTA_Unit_Hero_KeeperOfTheLight";
            case IO: return "DT_DOTA_Unit_Hero_Wisp";
            case VISAGE: return "DT_DOTA_Unit_Hero_Visage";
            case SLARK: return "DT_DOTA_Unit_Hero_Slark";
            case MEDUSA: return "DT_DOTA_Unit_Hero_Medusa";
            case TROLL_WARLORD: return "DT_DOTA_Unit_Hero_TrollWarlord";
            case CENTAUR_WARRUNNER: return "DT_DOTA_Unit_Hero_Centaur";
            case MAGNUS: return "DT_DOTA_Unit_Hero_Magnataur";
            case TIMBERSAW: return "DT_DOTA_Unit_Hero_Shredder";
            case BRISTLEBACK: return "DT_DOTA_Unit_Hero_Bristleback";
            case TUSK: return "DT_DOTA_Unit_Hero_Tusk";
            case SKYWRATH_MAGE: return "DT_DOTA_Unit_Hero_Skywrath_Mage";
            case ABADDON: return "DT_DOTA_Unit_Hero_Abaddon";
            case ELDER_TITAN: return "DT_DOTA_Unit_Hero_Elder_Titan";
            case LEGION_COMMANDER: return "DT_DOTA_Unit_Hero_Legion_Commander";
            case UNKNOWN: return "Unknown";
            case EMBER_SPIRIT: return "DT_DOTA_Unit_Hero_EmberSpirit";
            case EARTH_SPIRIT: return "DT_DOTA_Unit_Hero_EarthSpirit";
            case ABYSSAL_UNDERLORD: return "DT_DOTA_Unit_Hero_AbyssalUnderlord";
            case TERRORBLADE: return "DT_DOTA_Unit_Hero_Terrorblade";
            default: return "Unknown";  
        }
    }
    public static int getHeroIdByScriptName(String heroName) {
        switch(heroName) {
            case "npc_dota_hero_antimage": return ANTI_MAGE;
            case "npc_dota_hero_axe": return AXE;
            case "npc_dota_hero_bane": return BANE;
            case "npc_dota_hero_bloodseeker": return BLOODSEEKER;
            case "npc_dota_hero_crystal_maiden": return CRYSTAL_MAIDEN;
            case "npc_dota_hero_drow_ranger": return DROW_RANGER;
            case "npc_dota_hero_earthshaker": return EARTHSHAKER;
            case "npc_dota_hero_juggernaut": return JUGGERNAUT;
            case "npc_dota_hero_mirana": return MIRANA;
            case "npc_dota_hero_nevermore": return SHADOW_FIEND;
            case "npc_dota_hero_morphling": return MORPHLING;
            case "npc_dota_hero_phantom_lancer": return PHANTOM_LANCER;
            case "npc_dota_hero_puck": return PUCK;
            case "npc_dota_hero_pudge": return PUDGE;
            case "npc_dota_hero_razor": return RAZOR;
            case "npc_dota_hero_sand_king": return SAND_KING;
            case "npc_dota_hero_storm_spirit": return STORM_SPIRIT;
            case "npc_dota_hero_sven": return SVEN;
            case "npc_dota_hero_tiny": return TINY;
            case "npc_dota_hero_vengefulspirit": return VENGEFUL_SPIRIT;
            case "npc_dota_hero_windrunner": return WINDRANGER;
            case "npc_dota_hero_zuus": return ZEUS;
            case "npc_dota_hero_kunkka": return KUNKKA;
            case "npc_dota_hero_lina": return LINA;
            case "npc_dota_hero_lich": return LICH;
            case "npc_dota_hero_lion": return LION;
            case "npc_dota_hero_shadow_shaman": return SHADOW_SHAMAN;
            case "npc_dota_hero_slardar": return SLARDAR;
            case "npc_dota_hero_tidehunter": return TIDEHUNTER;
            case "npc_dota_hero_witch_doctor": return WITCH_DOCTOR;
            case "npc_dota_hero_riki": return RIKI;
            case "npc_dota_hero_enigma": return ENIGMA;
            case "npc_dota_hero_tinker": return TINKER;
            case "npc_dota_hero_sniper": return SNIPER;
            case "npc_dota_hero_necrolyte": return NECROPHOS;
            case "npc_dota_hero_warlock": return WARLOCK;
            case "npc_dota_hero_beastmaster": return BEASTMASTER;
            case "npc_dota_hero_queenofpain": return QUEEN_OF_PAIN;
            case "npc_dota_hero_venomancer": return VENOMANCER;
            case "npc_dota_hero_faceless_void": return FACELESS_VOID;
            case "npc_dota_hero_skeleton_king": return WRAITH_KING;
            case "npc_dota_hero_death_prophet": return DEATH_PROPHET;
            case "npc_dota_hero_phantom_assassin": return PHANTOM_ASSASSIN;
            case "npc_dota_hero_pugna": return PUGNA;
            case "npc_dota_hero_templar_assassin": return TEMPLAR_ASSASSIN;
            case "npc_dota_hero_viper": return VIPER;
            case "npc_dota_hero_luna": return LUNA;
            case "npc_dota_hero_dragon_knight": return DRAGON_KNIGHT;
            case "npc_dota_hero_dazzle": return DAZZLE;
            case "npc_dota_hero_rattletrap": return CLOCKWERK;
            case "npc_dota_hero_leshrac": return LESHRAC;
            case "npc_dota_hero_furion": return NATURES_PROPHET;
            case "npc_dota_hero_life_stealer": return LIFESTEALER;
            case "npc_dota_hero_dark_seer": return DARK_SEER;
            case "npc_dota_hero_clinkz": return CLINKZ;
            case "npc_dota_hero_omniknight": return OMNIKNIGHT;
            case "npc_dota_hero_enchantress": return ENCHANTRESS;
            case "npc_dota_hero_huskar": return HUSKAR;
            case "npc_dota_hero_night_stalker": return NIGHT_STALKER;
            case "npc_dota_hero_broodmother": return BROODMOTHER;
            case "npc_dota_hero_bounty_hunter": return BOUNTY_HUNTER;
            case "npc_dota_hero_weaver": return WEAVER;
            case "npc_dota_hero_jakiro": return JAKIRO;
            case "npc_dota_hero_batrider": return BATRIDER;
            case "npc_dota_hero_chen": return CHEN;
            case "npc_dota_hero_spectre": return SPECTRE;
            case "npc_dota_hero_ancient_apparition": return ANCIENT_APPARITION;
            case "npc_dota_hero_doom_bringer": return DOOM;
            case "npc_dota_hero_ursa": return URSA;
            case "npc_dota_hero_spirit_breaker": return SPIRIT_BREAKER;
            case "npc_dota_hero_gyrocopter": return GYROCOPTER;
            case "npc_dota_hero_alchemist": return ALCHEMIST;
            case "npc_dota_hero_invoker": return INVOKER;
            case "npc_dota_hero_silencer": return SILENCER;
            case "npc_dota_hero_obsidian_destroyer": return OUTWORLD_DEVOURER;
            case "npc_dota_hero_lycan": return LYCANTHROPE;
            case "npc_dota_hero_brewmaster": return BREWMASTER;
            case "npc_dota_hero_shadow_demon": return SHADOW_DEMON;
            case "npc_dota_hero_lone_druid": return LONE_DRUID;
            case "npc_dota_hero_chaos_knight": return CHAOS_KNIGHT;
            case "npc_dota_hero_meepo": return MEEPO;
            case "npc_dota_hero_treant": return TREANT_PROTECTOR;
            case "npc_dota_hero_ogre_magi": return OGRE_MAGI;
            case "npc_dota_hero_undying": return UNDYING;
            case "npc_dota_hero_rubick": return RUBICK;
            case "npc_dota_hero_disruptor": return DISRUPTOR;
            case "npc_dota_hero_nyx_assassin": return NYX_ASSASSIN;
            case "npc_dota_hero_naga_siren": return NAGA_SIREN;
            case "npc_dota_hero_keeper_of_the_light": return KEEPER_OF_THE_LIGHT;
            case "npc_dota_hero_wisp": return IO;
            case "npc_dota_hero_visage": return VISAGE;
            case "npc_dota_hero_slark": return SLARK;
            case "npc_dota_hero_medusa": return MEDUSA;
            case "npc_dota_hero_troll_warlord": return TROLL_WARLORD;
            case "npc_dota_hero_centaur": return CENTAUR_WARRUNNER;
            case "npc_dota_hero_magnataur": return MAGNUS;
            case "npc_dota_hero_shredder": return TIMBERSAW;
            case "npc_dota_hero_bristleback": return BRISTLEBACK;
            case "npc_dota_hero_tusk": return TUSK;
            case "npc_dota_hero_skywrath_mage": return SKYWRATH_MAGE;
            case "npc_dota_hero_abaddon": return ABADDON;
            case "npc_dota_hero_elder_titan": return ELDER_TITAN;
            case "npc_dota_hero_legion_commander": return LEGION_COMMANDER;
            case "unknown": return UNKNOWN;
            case "npc_dota_hero_ember_spirit": return EMBER_SPIRIT;
            case "npc_dota_hero_earth_spirit": return EARTH_SPIRIT;
            case "npc_dota_hero_abyssal_underlord": return ABYSSAL_UNDERLORD;
            case "npc_dota_hero_terrorblade": return TERRORBLADE;
            default: return -1;  
        }
    }
   
    public static String getAvatarById(int heroId) {
        switch(heroId) {
            case ANTI_MAGE: return "Anti-Mage.png";
            case AXE: return "Axe.png";
            case BANE: return "Bane.png";
            case BLOODSEEKER: return "Bloodseeker.png";
            case CRYSTAL_MAIDEN: return "Crystal_Maiden.png";
            case DROW_RANGER: return "Drow_Ranger.png";
            case EARTHSHAKER: return "Earthshaker.png";
            case JUGGERNAUT: return "Juggernaut.png";
            case MIRANA: return "Mirana.png";
            case SHADOW_FIEND: return "Shadow_Fiend.png";
            case MORPHLING: return "Morphling.png";
            case PHANTOM_LANCER: return "Phantom_Lancer.png";
            case PUCK: return "Puck.png";
            case PUDGE: return "Pudge.png";
            case RAZOR: return "Razor.png";
            case SAND_KING: return "Sand_King.png";
            case STORM_SPIRIT: return "Storm_Spirit.png";
            case SVEN: return "Sven.png";
            case TINY: return "Tiny.png";
            case VENGEFUL_SPIRIT: return "Vengeful_Spirit.png";
            case WINDRANGER: return "Windranger.png";
            case ZEUS: return "Zeus.png";
            case KUNKKA: return "Kunkka.png";
            case LINA: return "Lina.png";
            case LICH: return "Lich.png";
            case LION: return "Lion.png";
            case SHADOW_SHAMAN: return "Shadow_Shaman.png";
            case SLARDAR: return "Slardar.png";
            case TIDEHUNTER: return "Tidehunter.png";
            case WITCH_DOCTOR: return "Witch_Doctor.png";
            case RIKI: return "Riki.png";
            case ENIGMA: return "Enigma.png";
            case TINKER: return "Tinker.png";
            case SNIPER: return "Sniper.png";
            case NECROPHOS: return "Necrophos.png";
            case WARLOCK: return "Warlock.png";
            case BEASTMASTER: return "Beastmaster.png";
            case QUEEN_OF_PAIN: return "Queen_of_Pain.png";
            case VENOMANCER: return "Venomancer.png";
            case FACELESS_VOID: return "Faceless_Void.png";
            case WRAITH_KING: return "Wraith_King.png";
            case DEATH_PROPHET: return "Death_Prophet.png";
            case PHANTOM_ASSASSIN: return "Phantom_Assassin.png";
            case PUGNA: return "Pugna.png";
            case TEMPLAR_ASSASSIN: return "Templar_Assassin.png";
            case VIPER: return "Viper.png";
            case LUNA: return "Luna.png";
            case DRAGON_KNIGHT: return "Dragon_Knight.png";
            case DAZZLE: return "Dazzle.png";
            case CLOCKWERK: return "Clockwerk.png";
            case LESHRAC: return "Leshrac.png";
            case NATURES_PROPHET: return "Nature's_Prophet.png";
            case LIFESTEALER: return "Lifestealer.png";
            case DARK_SEER: return "Dark_Seer.png";
            case CLINKZ: return "Clinkz.png";
            case OMNIKNIGHT: return "Omniknight.png";
            case ENCHANTRESS: return "Enchantress.png";
            case HUSKAR: return "Huskar.png";
            case NIGHT_STALKER: return "Night_Stalker.png";
            case BROODMOTHER: return "Broodmother.png";
            case BOUNTY_HUNTER: return "Bounty_Hunter.png";
            case WEAVER: return "Weaver.png";
            case JAKIRO: return "Jakiro.png";
            case BATRIDER: return "Batrider.png";
            case CHEN: return "Chen.png";
            case SPECTRE: return "Spectre.png";
            case ANCIENT_APPARITION: return "Ancient_Apparition.png";
            case DOOM: return "Doom.png";
            case URSA: return "Ursa.png";
            case SPIRIT_BREAKER: return "Spirit_Breaker.png";
            case GYROCOPTER: return "Gyrocopter.png";
            case ALCHEMIST: return "Alchemist.png";
            case INVOKER: return "Invoker.png";
            case SILENCER: return "Silencer.png";
            case OUTWORLD_DEVOURER: return "Outworld_Devourer.png";
            case LYCANTHROPE: return "Lycanthrope.png";
            case BREWMASTER: return "Brewmaster.png";
            case SHADOW_DEMON: return "Shadow_Demon.png";
            case LONE_DRUID: return "Lone_Druid.png";
            case CHAOS_KNIGHT: return "Chaos_Knight.png";
            case MEEPO: return "Meepo.png";
            case TREANT_PROTECTOR: return "Treant_Protector.png";
            case OGRE_MAGI: return "Ogre_Magi.png";
            case UNDYING: return "Undying.png";
            case RUBICK: return "Rubick.png";
            case DISRUPTOR: return "Disruptor.png";
            case NYX_ASSASSIN: return "Nyx_Assassin.png";
            case NAGA_SIREN: return "Naga_Siren.png";
            case KEEPER_OF_THE_LIGHT: return "Keeper_of_the_Light.png";
            case IO: return "Io.png";
            case VISAGE: return "Visage.png";
            case SLARK: return "Slark.png";
            case MEDUSA: return "Medusa.png";
            case TROLL_WARLORD: return "Troll_Warlord.png";
            case CENTAUR_WARRUNNER: return "Centaur_Warrunner.png";
            case MAGNUS: return "Magnus.png";
            case TIMBERSAW: return "Timbersaw.png";
            case BRISTLEBACK: return "Bristleback.png";
            case TUSK: return "Tusk.png";
            case SKYWRATH_MAGE: return "Skywrath_Mage.png";
            case ABADDON: return "Abaddon.png";
            case ELDER_TITAN: return "Elder_Titan.png";
            case LEGION_COMMANDER: return "Legion_Commander.png";
            case UNKNOWN: return "Unknown.png";
            case EMBER_SPIRIT: return "Ember_Spirit.png";
            case EARTH_SPIRIT: return "Earth_Spirit.png";
            case ABYSSAL_UNDERLORD: return "Abyssal_Underlord.png";
            case TERRORBLADE: return "Terrorblade.png";
            default: return "Unknown.png";  
        }
    }
   
    /**
     * Converts companion names like the spirit bear to the corresponding hero id, currently no necronomicon etc.
     * @param identifier companion string identifier, e.g. "npc_dota_beastmaster_boar"
     * @return hero id for this companion
     */
    public static int getHeroIdFromCompanions(String identifier) {
        if (identifier == null)
            return -1;
       
        switch(identifier) {
            case "npc_dota_beastmaster_boar":
            case "npc_dota_beastmaster_greater_boar":
                return BEASTMASTER;
            case "npc_dota_furion_treant":
                return NATURES_PROPHET;
            case "npc_dota_invoker_forged_spirit":
                return INVOKER;
            case "npc_dota_warlock_golem_1":
            case "npc_dota_warlock_golem_2":
            case "npc_dota_warlock_golem_3":
                return WARLOCK;
            case "npc_dota_broodmother_spiderling":
            case "npc_dota_broodmother_spiderite":
                return BROODMOTHER;
            case "npc_dota_shadow_shaman_ward_1":
            case "npc_dota_shadow_shaman_ward_2":
            case "npc_dota_shadow_shaman_ward_3":
                return SHADOW_SHAMAN;
            case "npc_dota_venomancer_plague_ward_1":
            case "npc_dota_venomancer_plague_ward_2":
            case "npc_dota_venomancer_plague_ward_3":
            case "npc_dota_venomancer_plague_ward_4":
                return VENOMANCER;
            case "npc_dota_eidolon":
            case "npc_dota_lesser_eidolon":
            case "npc_dota_greater_eidolon":
                return ENIGMA;
            case "npc_dota_lycan_wolf1":
            case "npc_dota_lycan_wolf2":
            case "npc_dota_lycan_wolf3":
            case "npc_dota_lycan_wolf4":
                return LYCANTHROPE;
            case "npc_dota_lone_druid_bear1":
            case "npc_dota_lone_druid_bear2":
            case "npc_dota_lone_druid_bear3":
            case "npc_dota_lone_druid_bear4":
                return LONE_DRUID;
               
            default: return Heroes.getHeroIdByScriptName(identifier);
        }
    }
   
    /**
     * Returns whether or not the given identifier is a hero or their companion
     * @param identifier
     * @return
     */
    public static boolean isHeroOrCompanion(String identifier) {
        if (identifier == null)
            return false;
       
        int heroId = Heroes.getHeroIdFromCompanions(identifier);
        if (heroId == -1) {
            return false;
        }
        return true;
    }
   
    /**
     * Returns whether or not the given identifier is a hero
     * @param identifier
     * @return
     */
    public static boolean isHero(String identifier) {
        if (identifier == null)
            return false;
       
        int heroId = Heroes.getHeroIdByScriptName(identifier);
        if (heroId == -1) {
            return false;
        }
        return true;
    }
   
}
