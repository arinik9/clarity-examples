package skadistats.clarity.examples.pdc04;


public class Item {
	//item names are extracted from "https://www.dota2.com/items/"

	private final String name;
	private int gold;
		
	public Item(String name) {
		//name'in basindaki prefix'i at
        this.name = name;//we drop "item_" prefix
        this.gold = itemToGold();
    }
	
	public boolean isDivineRapierBought(){
		if(this.name.equals("rapier")){
			return true;
		}
		
		return false;
	}
	
	public int itemToGold(){
		switch(this.name) {
		case "clarity": return 50;
		case "faerie_fire": return 75;
		case "enchanted_mango": return 125;
		case "tango": return 125;
		case "flask": return 110;//healing salve
		case "smoke_of_deceit": return 50;
		case "tpscroll": return 75;
		case "dust": return 180;
		case "courier": return 100;
		case "flying_courier": return 300;
		case "ward_observer": return 75;
		case "ward_sentry": return 200;
		case "bottle": return 660;
		case "branches": return 50;
		case "gauntlets": return 150;
		case "slippers": return 150;
		case "mantle": return 150;
		case "circlet": return 165;
		case "belt_of_strength": return 450;
		case "boots_of_elves": return 450;//Band of Elvenskin
		case "robe": return 450;
		case "ogre_axe": return 1000;
		case "blade_of_alacrity": return 1000;
		case "staff_of_wizardry": return 1000;
		case "ring_of_protection": return 175;
		case "stout_shield": return 200;
		case "quelling_blade": return 200;
		case "orb_of_venom": return 275;
		case "blades_of_attack": return 420;
		case "chainmail": return 550;
		case "quarterstaff": return 875;
		case "helm_of_iron_will": return 900;
		case "broadsword": return 1200;
		case "claymore": return 1400;
		case "javelin": return 1500;
		case "mithril_hammer": return 1600;
		case "magic_stick": return 200;
		case "sobi_mask": return 325;//Sage's Mask
		case "ring_of_regen": return 350;
		case "boots": return 400;
		case "gloves": return 500;
		case "cloak": return 550;
		case "ring_of_health": return 850;
		case "void_stone": return 850;
		case "gem": return 900;
		case "lifesteal": return 900;//Morbid Mask
		case "shadow_amulet": return 1400;
		case "ghost": return 1500;
		case "blink": return 2250;
		case "magic_wand": return 465;
		case "null_talisman": return 470;
		case "wraith_band": return 485;
		case "poor_mans_shield": return 500;
		case "bracer": return 525;
		case "soul_ring": return 800;
		case "phase_boots": return 1240;
		case "power_treads": return 1350;
		case "oblivion_staff": return 1650;
		case "pers": return 1700;
		case "hand_of_midas": return 2050;
		case "travel_boots": return 2400;//Boots of Travel
		case "moon_shard": return 4000;
		case "ring_of_basilius": return 500;
		case "iron_talon": return 500;
		case "headdress": return 600;
		case "buckler": return 800;
		case "urn_of_shadows": return 875;
		case "tranquil_boots": return 925;
		case "ring_of_aquila": return 985;
		case "medallion_of_courage": return 1200;
		case "arcane_boots": return 1300;
		case "ancient_janggo": return 1850;//Drum of Endurance
		case "mekansm": return 2300;
		case "vladmir": return 2300;
		case "guardian_greaves": return 5250;
		case "pipe": return 3500;
		case "glimmer_cape": return 1950;
		case "force_staff": return 2250;
		case "veil_of_discord": return 2270;
		case "aether_lens": return 2300;
		case "necronomicon": return 2650;
		case "dagon": return 2720;
		case "cyclone": return 2825;//Eul's Scepter of Divinity
		case "solar_crest": return 3000;
		case "rod_of_atos": return 3100;
		case "orchid": return 4075;
		case "ultimate_scepter": return 4200;
		case "refresher": return 5200;
		case "sheepstick": return 5650;//Scythe of Vyse
		case "octarine_core": return 5900;
		case "lesser_crit": return 2120;//Crystalys
		case "armlet": return 2320;
		case "invis_sword": return 2800;//Shadow Blade
		case "basher": return 2950;
		case "bfury": return 4500;
		case "ethereal_blade": return 4700;
		case "silver_edge": return 5450;
		case "radiance": return 5150;
		case "monkey_king_bar": return 5400;
		case "greater_crit": return 5520;//Daedalus
		case "butterfly": return 5875;
		case "rapier": return 6200;
		case "abyssal_blade": return 6750;
		case "hood_of_defiance": return 2100;
		case "vanguard": return 2150;
		case "blade_mail": return 2200;
		case "soul_booster": return 3200;
		case "crimson_guard": return 3550;
		case "black_king_bar": return 3975;
		case "lotus_orb": return 4000;
		case "shivas_guard": return 4700;
		case "bloodstone": return 4900;
		case "manta": return 4950;
		case "sphere": return 5125;
		case "assault": return 5250;
		case "heart": return 5500;
		case "mask_of_madness": return 1800;
		case "helm_of_the_dominator": return 1800;
		case "dragon_lance": return 1875;
		case "sange": return 2050;
		case "yasha": return 2050;
		case "maelstrom": return 2800;
		case "diffusal_blade": return 3150;
		case "desolator": return 3500;
		case "heavens_halberd": return 3850;
		case "sange_and_yasha": return 4100;
		case "skadi": return 5675;
		case "mjollnir": return 5700;
		case "satanic": return 5900;
		case "energy_booster": return 900;
		case "vitality_booster": return 1100;
		case "point_booster": return 1200;
		case "platemail": return 1400;
		case "talisman_of_evasion": return 1800;
		case "hyperstone": return 2000;
		case "ultimate_orb": return 2100;
		case "demon_edge": return 2400;
		case "mystic_staff": return 2700;
		case "reaver": return 3000;
		case "eagle": return 3200;
		case "relic": return 3800;
		//case "Aegis of the Immortal": return 0;
		//case "Cheese": return 0;
		//case "Greevil Taffy": return 0;
		//case "Clove Studded Ham": return 0;
		//case "Cocoa With Marshmallows": return 0;
		//case "Fruit-bit Cake": return 0;
		//case "Greevil Blink Bone": return 0;
		//case "Greevil Chow": return 0;
		//case "Greevil Treat": return 0;
		//case "Greevil Whistle": return 0;
		//case "Kringle": return 0;
		//case "Speed Skates": return 0;
		//case "Snow Mushroom": return 0;
		//case "Wizard Cookie": return 0;
		//case "Xmas Stocking": return 0;
		//case "Greater Salve": return 275;
		//case "Slippers of Halcyon": return 2075;
		//case "Arcane Boots II": return 2450;
		//case "Flinching Firecrackers": return 100;
		//case "Firework Mine": return 1000;
		//case "Scare the Beast": return 1500;
		//case "Force Boots": return 3650;
		//case "": return 5725;
		//case "Desolator 2": return 8375;
		//case "Vermillion Robe": return 9750;
        default: return 0;
		}
	}
	
}
