
package skadistats.clarity.examples.pdc04;

public class HeroesUtil {
    
    public static String DTClassToName(String dtclass){
        return dtclass.replace("CDOTA_Unit_Hero_", "").replace("_", "").toLowerCase();
    }
    public static String NPCNameToName(String npcname){
        return npcname.replace("npc_dota_hero_", "").replace("_", "").toLowerCase();
    }
    
}
