package skadistats.clarity.examples.pdc04_oldVersionDota;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olivier.cavadenti
 */
public class HeroesUtil {
    
    public static String DTClassToName(String dtclass){
        return dtclass.replace("DT_DOTA_Unit_Hero_", "").replace("_", "").toLowerCase();
    }
    public static String NPCNameToName(String npcname){
        return npcname.replace("npc_dota_hero_", "").replace("_", "").toLowerCase();
    }
    
}
