package skadistats.clarity.examples.pdc04;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import skadistats.clarity.decoder.Util;
import skadistats.clarity.model.Entity;
import skadistats.clarity.model.FieldPath;
import skadistats.clarity.model.Vector;
import skadistats.clarity.processor.entities.Entities;
import skadistats.clarity.processor.entities.OnEntityCreated;
import skadistats.clarity.processor.entities.OnEntityUpdated;
import skadistats.clarity.processor.entities.UsesEntities;
import skadistats.clarity.processor.reader.OnMessage;
import skadistats.clarity.processor.runner.Context;
import skadistats.clarity.processor.stringtables.StringTables;
import skadistats.clarity.processor.stringtables.UsesStringTable;
import skadistats.clarity.util.TextTable;
import skadistats.clarity.wire.common.proto.DotaUserMessages.CDOTAUserMsg_ChatEvent;
import sun.applet.Main;

public class DotaProcessor {

    private final Logger log = LoggerFactory.getLogger(Main.class.getPackage().getClass());
    private int cellX = 10, cellY = 10,tickmax;
    private static final int MAX_COORD_INTEGER = 16384;
    private final float curtime = -1.0f;
    private final ArrayList<Hero> heroes = new ArrayList<>();
    private int gameStartTick = 0;
    private int gameEndTick = 0;
    private int gameStartTime = 0;
    private int gameEndTime = 0;
    private boolean isGameEnd = false;
    
    private FieldPath mana;
    private FieldPath maxMana;
    private FieldPath health;
    private FieldPath maxHealth;
    //
    private FieldPath physicalArmor;
    private FieldPath magicalResistance;
    private FieldPath damageMin;
    private FieldPath damageMax;
    private FieldPath damageBonus;
    private FieldPath strength;
    private FieldPath agility;
    private FieldPath intellect;
    private FieldPath strengthTotal;
    private FieldPath agilityTotal;
    private FieldPath intellectTotal;
    
    //print writer
    private PrintWriter myWriter;
    
    private int remaining_time=0;
    private int match_ligue_level=-1;
    private int nbPlayer=-1;
    private int target_tick = 0;
    
    private int mostExpensiveItem = 0;
    private int highestLevelTowerDestroyed = 0;
    private int isDivineRapierBought = 0;
    
    private int nbDireMeleeBarracksDestroyed = 0;
    private int nbDireRangeBarracksDestroyed = 0;
    private int nbRadiantMeleeBarracksDestroyed = 0;
    private int nbRadiantRangeBarracksDestroyed = 0;
    private int isRadiantMegaCreeps = 0;
    private int isDireMegaCreeps = 0;
    
    private int maxAttackPowerAmongHeroes = 0;
    
    private int level=0;
    private int kill=0;
    private int death=0;
    private int assist=0;
    private int gold=0;
    private int last_hit=0;
    private int deny=0;
    
    private int sumAllLevelsInGame = 0;
    private int sumAllGoldsInGame = 0;
    
    //Towers
    private int nbTowerDestroyedInGame = 0;
    
    private int radiant_tower1_mid=1;
    private int radiant_tower2_mid=1;
    private int radiant_tower3_mid=1;
    private int dire_tower1_mid=1;
    private int dire_tower2_mid=1;
    private int dire_tower3_mid=1;
    private int radiant_tower1_bottom=1;
    private int radiant_tower2_bottom=1;
    private int radiant_tower3_bottom=1;
    private int radiant_tower4_bottom=1;
    private int dire_tower1_bottom=1;
    private int dire_tower2_bottom=1;
    private int dire_tower3_bottom=1;
    private int dire_tower4_bottom=1;
    private int radiant_tower1_top=1;
    private int radiant_tower2_top=1;
    private int radiant_tower3_top=1;
    private int radiant_tower4_top=1;
    private int dire_tower1_top=1;
    private int dire_tower2_top=1;
    private int dire_tower3_top=1;
    private int dire_tower4_top=1;
    
    private int radiant_barrack_melee_mid=1;
    private int dire_barrack_melee_mid=1;
    private int radiant_barrack_range_mid=1;
    private int dire_barrack_range_mid=1;
    private int radiant_barrack_melee_top=1;
    private int dire_barrack_melee_top=1;
    private int radiant_barrack_range_top=1;
    private int dire_barrack_range_top=1;
    private int radiant_barrack_melee_bottom=1;
    private int dire_barrack_melee_bottom=1;
    private int radiant_barrack_range_bottom=1;
    private int dire_barrack_range_bottom=1;
    
    int[] stats_unit_hero = new int[7];
    long[] distance_hero_to_ennemy_base = new long[10];
    private int distance_count_radiant=0;
    private int distance_count_dire=0;
    
    ////////
    
    private final HashMap<Integer, Integer[]> tuples = new HashMap<>();
    private int current_tick = 0;
    
    
    public void addTuple(int tick, int sumAllLevelsInGame,int nbTowerNotDestroyed,int mostExpensiveItem,
    		int isDivineRapierBought, int maxAttackPowerAmongHeroes, int highestLevelTowerDestroyed,
    		int nbMeleeBarrackDestroyed, int mega, int remaining_time, int match_league_level, int nbPlayer) {
        Integer[] xy = new Integer[]{sumAllLevelsInGame, nbTowerNotDestroyed,  mostExpensiveItem,
        		isDivineRapierBought, maxAttackPowerAmongHeroes, highestLevelTowerDestroyed, nbMeleeBarrackDestroyed,
        		mega, remaining_time, match_league_level, nbPlayer};
        
        if (current_tick != tick) {
            tuples.put(tick, xy);
            current_tick = tick;
        }
    }
    
    public HashMap<Integer, Integer[]> getTuples() {
        return tuples;
    }
    
    @Override
    public String toString() {
    	String str = "";
        for (Integer sec : tuples.keySet()) {
            str += "Sum Level: " + tuples.get(sec)[0] + " Number of Tower Not Destroyed: " + tuples.get(sec)[1] + "\r\n";
        }
        return str;
    }

    
    public void writeTraceFile(PrintWriter myWriter, int counter)
    {
    	for (Integer sec : tuples.keySet()) {
            tuples.get(sec)[8] += (gameEndTime-gameStartTime); // we add duration of a game
        }
    	


        HashMap<Integer, Integer[]> allTuples=this.getTuples();
        ArrayList<Integer> keys = new ArrayList<>(allTuples.keySet());
        Collections.sort(keys);
        Integer[] xy;
        
        for (int tick : keys) {
            xy = allTuples.get(tick);
            float time_float = (tick-gameStartTick)/30;
            int time = (int) Math.ceil(time_float);
            myWriter.println(counter+";"+time+";"+xy[0]+";"+xy[1]+";"+xy[2]+";"+xy[3]+";"+xy[4]+";"+xy[5]+";"+xy[6]+";"+xy[7]+";"+xy[8]);//+";"+xy[9]+";"+xy[10]
        }
        System.out.println(counter+" writed successfully !");      
    }
  
    private void ensureFieldPaths(Entity e) {
        if (mana == null) {
            //qSystem.out.println(e);
            mana = e.getDtClass().getFieldPathForName("m_flMana");
            maxMana = e.getDtClass().getFieldPathForName("m_flMaxMana");
            health = e.getDtClass().getFieldPathForName("m_iHealth");
            maxHealth = e.getDtClass().getFieldPathForName("m_iMaxHealth");
            //
            physicalArmor = e.getDtClass().getFieldPathForName("m_flPhysicalArmorValue");
            magicalResistance = e.getDtClass().getFieldPathForName("m_flMagicalResistanceValue");
            damageMin = e.getDtClass().getFieldPathForName("m_iDamageMin");
            damageMax = e.getDtClass().getFieldPathForName("m_iDamageMax");
            damageBonus = e.getDtClass().getFieldPathForName("m_iDamageBonus");
            strength = e.getDtClass().getFieldPathForName("m_flStrength");
            agility = e.getDtClass().getFieldPathForName("m_flAgility");
            intellect = e.getDtClass().getFieldPathForName("m_flIntellect");
            strengthTotal = e.getDtClass().getFieldPathForName("m_flStrengthTotal");
            agilityTotal = e.getDtClass().getFieldPathForName("m_flAgilityTotal");
            intellectTotal = e.getDtClass().getFieldPathForName("m_flIntellectTotal");
        }
    }

   

    /*public static float getVecOrigin(Entity e, int idx) {
        Vector v = e.getProperty("m_vecOrigin");
        System.out.println(e.toString());
        return v.getElement(idx);
    }*/
    
    public int getGameStartTick() {
        //int cellBits = e.getProperty("m_cellbits");
        return gameStartTick; //* (1 << cellBits) - DotaProcessor.MAX_COORD_INTEGER + DotaProcessor.getVecOrigin(e, 0) / 128.0f;
    }
    
    public int getGameEndTick(){
    	return gameEndTick;
    }

    
    public static float getX(Entity e) {
        //int cellBits = e.getProperty("m_cellbits");
        int cellX = e.getProperty("CBodyComponent.m_cellX");
        return cellX; //* (1 << cellBits) - DotaProcessor.MAX_COORD_INTEGER + DotaProcessor.getVecOrigin(e, 0) / 128.0f;
    }

    public static float getY(Entity e) {
        //int cellBits = e.getProperty("m_cellbits");
        int cellY = e.getProperty("CBodyComponent.m_cellY");
        return cellY;// * (1 << cellBits) - DotaProcessor.MAX_COORD_INTEGER + DotaProcessor.getVecOrigin(e, 1) / 128.0f;
    }
    
    public float getMana(Entity e) {
         ensureFieldPaths(e);
         float manaFloat=e.getPropertyForFieldPath(mana); 
         float maxManaFloat=e.getPropertyForFieldPath(maxMana);
         return manaFloat/maxManaFloat;
    }
    
    public float getHealth(Entity e) {
         ensureFieldPaths(e);
         int healthFloat=e.getPropertyForFieldPath(health); 
         int maxHealthFloat=e.getPropertyForFieldPath(maxHealth);
         return (float) ((1.0*healthFloat)/maxHealthFloat);
    }
    
    public float getPhysicalArmor(Entity e) {
        ensureFieldPaths(e);
        float physicalArmorFloat = e.getPropertyForFieldPath(physicalArmor); 

        return physicalArmorFloat;
    }
    
    public float getMagicalResistance(Entity e) {
        ensureFieldPaths(e);
        float magicalResistanceFloat = e.getPropertyForFieldPath(magicalResistance); 

        return magicalResistanceFloat;
    }
    
    public int getDamageMin(Entity e) {
        ensureFieldPaths(e);
        int damageMinFloat = e.getPropertyForFieldPath(damageMin); 

        return damageMinFloat;
    }
    
    public int getDamageMax(Entity e) {
        ensureFieldPaths(e);
        int damageMaxFloat = e.getPropertyForFieldPath(damageMax);

        return damageMaxFloat;
    }
    
    public int getDamageBonus(Entity e) {
        ensureFieldPaths(e);
        boolean b = e.getPropertyForFieldPath(damageBonus) instanceof Integer;//sometimes we get a boolean type instead of integer
        if(b){
        	int damageBonusFloat = e.getPropertyForFieldPath(damageBonus);
        	return damageBonusFloat;
        }
        return 0;
        
    } 
     
    public float getStrength(Entity e) {
        ensureFieldPaths(e);
        float physicalArmorFloat =  e.getPropertyForFieldPath(physicalArmor); 

        return physicalArmorFloat;
    }  
   
   public float getAgility(Entity e) {
        ensureFieldPaths(e);
        float agilityFloat = e.getPropertyForFieldPath(agility); 

        return agilityFloat;
   }
   
   public float getIntellect(Entity e) {
       ensureFieldPaths(e);
       float intellectFloat = e.getPropertyForFieldPath(intellect); 

       return intellectFloat;
  }
   
   
   public float getStrengthTotal(Entity e) {
       ensureFieldPaths(e);
       float strengthFloat = e.getPropertyForFieldPath(strengthTotal); 

       return strengthFloat;
   }
   
   public float getAgilityTotal(Entity e) {
       ensureFieldPaths(e);
       float agilityFloat = e.getPropertyForFieldPath(agilityTotal); 

       return agilityFloat;
   }
   
   public float getIntellectTotal(Entity e) {
       ensureFieldPaths(e);
       float intellectFloat = e.getPropertyForFieldPath(intellectTotal); 

       return intellectFloat;
   }
   


    public static int getNumCell(float coords, int numcellaxe) {

        double taillecellule = DotaProcessor.MAX_COORD_INTEGER / numcellaxe;
        return (int) ((coords + DotaProcessor.MAX_COORD_INTEGER / 2) / taillecellule);
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public boolean hasHero(String name) {
        for (Hero h : heroes) {
            if (h.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Hero getHero(String name) {
        for (Hero h : heroes) {
            if (h.getName().equals(name)) {
                return h;
            }
        }
        return null;
    }

    public void setTickMax(int tickmax){
        this.tickmax = tickmax;
    }
    
    @OnEntityCreated
    public void OnEntityCreated(Context ctx, Entity e) {
        if (e.getDtClass().getDtName().startsWith("CDOTA_Unit_Hero_")) {
            String name = HeroesUtil.DTClassToName(e.getDtClass().getDtName());
            ensureFieldPaths(e);
            //System.out.println("On Creation: => " + name + ", tick: " + ctx.getTick());
            
            if (!hasHero(name)) {
                Hero hero = new Hero(name, cellX, cellY,tickmax);
                hero.setFirstTick(ctx.getTick());
                heroes.add(hero);
            }
        }     
    }


    public void setCellSize(int x, int y) {
        this.cellX = x;
        this.cellY = y;
    }

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }
    
    public int getRegion(float x, float y) {
    	int result = -1;
    	
        if((x>=70 && x<104) && (y>=70 && y<104)){
        	result = 1;
        }
        else if((x>=104 && x<150) && (y>=70 && y<104)){
        	result = 2;
        }
        else if((x>=150 && x<190) && (y>=70 && y<104)){
        	result = 3;
        }
        else if((x>=70 && x<104) && (y>=104 && y<150)){
        	result = 4;
        }
        else if((x>=104 && x<150) && (y>=104 && y<150)){
        	result = 5;
        }
        else if((x>=150 && x<190) && (y>=104 && y<150)){
        	result = 6;
        }
        else if((x>=70 && x<104) && (y>=150 && y<190)){
        	result = 7;
        }
        else if((x>=104 && x<150) && (y>=150 && y<190)){
        	result = 8;
        }
        else if((x>=150 && x<190) && (y>=150 && y<190)){
        	result = 9;
        }
        
        return result;
    }
    

    @OnEntityUpdated
    public void onEntityUpdated(Context ctx, Entity e, FieldPath[] changedPaths, int numChangedPaths) throws UnsupportedEncodingException {
  	
    	//m_pGameRules.m_lobbyLeagueID
    	//m_pGameRules.m_lobbyGameName
  
    	Entity grp = ctx.getProcessor(Entities.class).getByDtName("CDOTAGamerulesProxy");
        int gameStart = Math.round( (float) grp.getProperty("m_pGameRules.m_flGameStartTime"));
        int gameEnd = Math.round( (float) grp.getProperty("m_pGameRules.m_flGameEndTime"));
        //grp.toString()
        
        if(gameStartTick == 0 && gameStart != 0){
        	gameStartTick = ctx.getTick();
        	gameStartTime = gameStart;
        	target_tick = (30*60*5); 
        }
        
        if(gameEndTick == 0 && gameEnd != 0){
        	gameEndTick = ctx.getTick();
        	gameEndTime = gameEnd;
        	isGameEnd = true;
        	
        	//add tuple
        	//last time for match end
        	int mega=0;
			if((isDireMegaCreeps == 1) || (isRadiantMegaCreeps == 1)) mega = 1;
			remaining_time = (-1)*(gameEndTime-gameStartTime);//we want to zero here: because will add (gameEndTime-gameStartTime) later
			addTuple(ctx.getTick(),sumAllLevelsInGame,(22 - nbTowerDestroyedInGame), //22 is the total number of towers in the game
					mostExpensiveItem, isDivineRapierBought, maxAttackPowerAmongHeroes, highestLevelTowerDestroyed,
					(nbDireMeleeBarracksDestroyed+nbRadiantMeleeBarracksDestroyed), mega, 
					remaining_time, match_ligue_level, nbPlayer);
			
			//distance
			/*int radiant_distance = (int) Math.ceil((distance_hero_to_ennemy_base[0] + distance_hero_to_ennemy_base[1] + distance_hero_to_ennemy_base[2] + distance_hero_to_ennemy_base[3] + distance_hero_to_ennemy_base[4])/distance_count_radiant);
			int dire_distance = (int) Math.ceil((distance_hero_to_ennemy_base[5] + distance_hero_to_ennemy_base[6] + distance_hero_to_ennemy_base[7] + distance_hero_to_ennemy_base[8] + distance_hero_to_ennemy_base[9])/distance_count_dire);
			System.out.println("radiant_distance:"+radiant_distance+",dire_distance:"+dire_distance);
        	*/
        }
    	
    	if (e.getDtClass().getDtName().startsWith("CDOTA_BaseNPC_Tower")) {//_Barracks
    		highestLevelTowerDestroyed = UsesStringTable2(ctx, e, highestLevelTowerDestroyed);
    		//22 - nbTowerDestroyedInGame : Nobmre de Tower Restant
    	}
    	
    	
    	else if (e.getDtClass().getDtName().startsWith("CDOTA_BaseNPC_Barracks")) {
    		UsesStringTable3(ctx, e);	
    	}
    	
    	else if (e.getDtClass().getDtName().startsWith("CDOTA_Unit_Hero_")) {
            String name = HeroesUtil.DTClassToName(e.getDtClass().getDtName());
            //System.out.println(name);
            Hero hero = getHero(name);
            ArrayList<Integer> elements = UsesStringTable(ctx, e, name, mostExpensiveItem);
            int goldsForItems = elements.get(0);
            isDivineRapierBought = elements.get(1);
            mostExpensiveItem = elements.get(2);
            
            //if(gameStartTick>0 && ctx.getTick()>(gameStartTick-30*90) && !isGameEnd){
        	if(gameStartTick>0 && ctx.getTick()>(gameStartTick-1) && !isGameEnd){
	        	int hero_index = UsesEntities(ctx, e);
	        	/*if((ctx.getTick()%5) == 0){//cok sik distance hesaplamayalim diye
	        		if(hero_index < 5){//radiant heroes
	        			distance_count_radiant++;
	        			distance_hero_to_ennemy_base[hero_index] += (long) Math.ceil(Math.sqrt(Math.pow((170-getX(e)),2)+Math.pow((166-getY(e)),2)));
	        		}
	        		else{//hero_index>=5 => dire heroes
	        			distance_count_dire++;
	        			distance_hero_to_ennemy_base[hero_index] += (long) Math.ceil(Math.sqrt(Math.pow((80-getX(e)),2)+Math.pow((84-getY(e)),2)));//TODO radiant base(in koordiantlari yaklasikli
	        		}
	        	}*/
	
				level = stats_unit_hero[0];
				kill = stats_unit_hero[1];
				death = stats_unit_hero[2];
				assist = stats_unit_hero[3];
				gold = stats_unit_hero[4];
				last_hit = stats_unit_hero[5];
				deny = stats_unit_hero[6];
        	}
        	
        	int mean_damage = (getDamageMin(e) + getDamageMax(e))/2;
        	int hero_attack_power = mean_damage + getDamageBonus(e);
        	if(maxAttackPowerAmongHeroes < hero_attack_power){
        		maxAttackPowerAmongHeroes = hero_attack_power;
        	}
        	
        	
        	//getNumCell(getX(e), cellX),getNumCell(getY(e), cellY)
        	int region = getRegion(getX(e),getY(e));
        	
            //hero.addPosition(hero.getFirstTick()+ctx.getTick(), region, getHealth(e),getMana(e), 
            		//hero_attack_power, level, kill, death, assist, gold+goldsForItems, last_hit, deny);
    	}
    	
		//each 5 minutes, we collecte some features
		if(gameStartTick>0 && ctx.getTick()>(gameStartTick-1) && !isGameEnd){	
			if((ctx.getTick() - gameStartTick) > target_tick){ //30:nb of tick, 60:nb of seconds, 5: nb of minutes	 
				//distance
				/*int radiant_distance = (int) Math.ceil((distance_hero_to_ennemy_base[0] + distance_hero_to_ennemy_base[1] + distance_hero_to_ennemy_base[2] + distance_hero_to_ennemy_base[3] + distance_hero_to_ennemy_base[4])/distance_count_radiant);
				int dire_distance = (int) Math.ceil((distance_hero_to_ennemy_base[5] + distance_hero_to_ennemy_base[6] + distance_hero_to_ennemy_base[7] + distance_hero_to_ennemy_base[8] + distance_hero_to_ennemy_base[9])/distance_count_dire);
				for(int i=0;i<distance_hero_to_ennemy_base.length;i++){
					distance_hero_to_ennemy_base[i]=0L;
				}
				distance_count_dire=0;
				distance_count_radiant=0;*/
				//distance farkini kullan TODO
				//System.out.println("radiant_distance:"+radiant_distance+",dire_distance:"+dire_distance);
				
				//add tuple
				int mega=0;
				if((isDireMegaCreeps == 1) || (isRadiantMegaCreeps == 1)) mega = 1;
				remaining_time -= (300+Math.ceil((ctx.getTick()-(target_tick+gameStartTick))/30)); //we substract each time 300 seconds and at the end, we add gameTimeEnd in order to compute the remaining_time
				target_tick += 30*60*5;
				addTuple(ctx.getTick(),sumAllLevelsInGame,(22 - nbTowerDestroyedInGame), //22 is the total number of towers in the game
						mostExpensiveItem, isDivineRapierBought, maxAttackPowerAmongHeroes, highestLevelTowerDestroyed,
						(nbDireMeleeBarracksDestroyed+nbRadiantMeleeBarracksDestroyed), mega, 
						remaining_time, match_ligue_level, nbPlayer);
			}
		}
    }
    
    
    /*@OnMessage(CDOTAUserMsg_ChatEvent.class)
    public void onChatEvent(Context ctx, CDOTAUserMsg_ChatEvent message) {       
	    	//System.out.println("ChatEvent");
	    	Integer value = message.getValue();
	        String type = String.valueOf(message.getType());
	        //System.out.println(ctx.getTick());
	        //System.out.println(type);
	        Integer player1 = message.getPlayerid1();
	        Integer player2 = message.getPlayerid2();
	
	        //System.out.println(player1);
	        //System.out.println(player2);
	               
	        if(message.getType().toString().equals("CHAT_MESSAGE_TOWER_KILL")) {			
				if(message.getValue()==2) {
					//System.out.println("RADIANT");
				} else {
					//System.out.println("DIRE");
				}
	        }
	        
	        
	        if(message.getType().toString().equals("CHAT_MESSAGE_BARRACKS_KILL")) {			
	        	 if(message.getValue()>64) {
	        		 //System.out.println("DIRE barrack");
	     		} else {
	     			//System.out.println("RADIANT barrack");
	     		}
	        }
	       
       
        //Entity e = ctx.getProcessor(Entities.class).getByIndex(message.getEntindex());
        
    }*/
    
    @UsesStringTable("EntityNames")
    public int UsesStringTable2(Context ctx, Entity e, int highestLevelTowerDestroyed) throws UnsupportedEncodingException {
    	//System.out.println("EntityNames");
    	//System.out.println(ctx.getTick());
   	
    	//Get a player attribute that depends on which side the player is on.
    	//A creep kill for a radiant hero is a badguy_kill, while a creep kill for a dire hero is a goodguy_kill.

        StringTables stringTables = ctx.getProcessor(StringTables.class);

        if (e != null) {
            Integer idx = e.getProperty("m_pEntity.m_nameStringableIndex");
            //System.out.println(idx);
            String name = stringTables.forName("EntityNames").getNameByIndex(idx);
            //System.out.println(nameHero); //her heronun ayri item listesinin CSV'de olsutur
            FieldPath hhh = e.getDtClass().getFieldPathForName("m_iHealth");
            FieldPath mmm = e.getDtClass().getFieldPathForName("m_iMaxHealth");
            int healthFloat2=e.getPropertyForFieldPath(hhh); 
            int maxHealthFloat2=e.getPropertyForFieldPath(mmm);
            float healthTower = (float) ((1.0*healthFloat2)/maxHealthFloat2);
            //System.out.println(name);//badguys/goodguys dedigi zaman saldirani/(badguys attack) soyluyo
            //normalde badguys dedigi radiant.
            //o yuzden tower bilgisinde onun tam tersini al
            //System.out.println("Health tower: "+healthTower);
            //IF TOWER KILL
            if(healthTower == 0){
            	changeTowerStatus(name);
            	int level = 0;
            	if(name.substring(5,13).equals("goodguys")){
            		level = Integer.parseInt(name.substring(19, 20));
            	}
            	else{//badguys
            		level = Integer.parseInt(name.substring(18, 19));
            	}
            			
        		if(level > highestLevelTowerDestroyed){
        			highestLevelTowerDestroyed = level;
        		}
            }
            
            
            //int cellXTower = e.getProperty("CBodyComponent.m_cellX");//of tower
            //int cellYTower = e.getProperty("CBodyComponent.m_cellY");//of tower
            //System.out.println("Location tower: ("+cellXTower+", "+cellYTower+")");
        }
        
        return highestLevelTowerDestroyed;
    }

    
    public void changeTowerStatus(String name){
    	if(name.substring(5,13).equals("goodguys")){//Radiant tower	
    		if((name.substring(14, name.length()).equals("tower1_top"))
    				&& radiant_tower1_top == 1){
    			radiant_tower1_top=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower2_top"))
    				&& radiant_tower2_top == 1){
    			radiant_tower2_top=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower3_top"))
    				&& radiant_tower3_top == 1){
    			radiant_tower3_top=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower4_top"))
    				&& radiant_tower4_top == 1){
    			radiant_tower4_top=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower1_bot"))
    				&& radiant_tower1_bottom == 1){
    			radiant_tower1_bottom=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower2_bot"))
    				&& radiant_tower2_bottom == 1){
    			radiant_tower2_bottom=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower3_bot"))
    				&& radiant_tower3_bottom == 1){
    			radiant_tower3_bottom=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower4_bot"))
    				&& radiant_tower4_bottom == 1){
    			radiant_tower4_bottom=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower1_mid"))
    				&& radiant_tower1_mid == 1){
    			radiant_tower1_mid=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower2_mid"))
    				&& radiant_tower2_mid == 1){
    			radiant_tower2_mid=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(14, name.length()).equals("tower3_mid"))
    				&& radiant_tower3_mid == 1){
    			radiant_tower3_mid=0;
    			nbTowerDestroyedInGame++;
    		}
    	}
    	else{//badguys => Dire tower is under attack
    		if((name.substring(13, name.length()).equals("tower1_top"))
    				&& dire_tower1_top == 1){
    			dire_tower1_top=1;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower2_top"))
    				&& dire_tower2_top == 1){
    			dire_tower2_top=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower3_top"))
    				&& dire_tower3_top == 1){
    			dire_tower3_top=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower4_top"))
    				&& dire_tower4_top == 1){
    			dire_tower4_top=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower1_bot"))
    				&& dire_tower1_bottom == 1){
    			dire_tower1_bottom=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower2_bot"))
    				&& dire_tower2_bottom == 1){
    			dire_tower2_bottom=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower3_bot"))
    				&& dire_tower3_bottom == 1){
    			dire_tower3_bottom=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower4_bot"))
    				&& dire_tower4_bottom == 1){
    			dire_tower4_bottom=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower1_mid"))
    				&& dire_tower1_mid == 1){
    			dire_tower1_mid=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower2_mid"))
    				&& dire_tower2_mid == 1){
    			dire_tower2_mid=0;
    			nbTowerDestroyedInGame++;
    		}
    		else if((name.substring(13, name.length()).equals("tower3_mid"))
    				&& dire_tower3_mid == 1){
    			dire_tower3_mid=0;
    			nbTowerDestroyedInGame++;
    		}
    	}
    }
    
    @UsesStringTable("EntityNames")
    public void UsesStringTable3(Context ctx, Entity e) throws UnsupportedEncodingException {

    	StringTables stringTables = ctx.getProcessor(StringTables.class);

        if (e != null) {
            Integer idx = e.getProperty("m_pEntity.m_nameStringableIndex");
            //System.out.println(idx);
            String name = stringTables.forName("EntityNames").getNameByIndex(idx);
            //System.out.println(nameHero); //her heronun ayri item listesinin CSV'de olsutur
            FieldPath hhh = e.getDtClass().getFieldPathForName("m_iHealth");
            FieldPath mmm = e.getDtClass().getFieldPathForName("m_iMaxHealth");
            int healthFloat2=e.getPropertyForFieldPath(hhh); 
            int maxHealthFloat2=e.getPropertyForFieldPath(mmm);
            float healthTower = (float) ((1.0*healthFloat2)/maxHealthFloat2);
            //System.out.println(name);//badguys/goodguys dedigi zaman saldirani/(badguys attack) soyluyo
            //normalde badguys dedigi radiant.
            //o yuzden tower bilgisinde onun tam tersini al
            //System.out.println("Health tower: "+healthTower);
            //IF TOWER KILL
            if(healthTower == 0){
            	changeBarrackStatus(name);
            	int nbDireBarracksDestroyed = nbDireRangeBarracksDestroyed+nbDireMeleeBarracksDestroyed;
        		int nbRadiantBarracksDestroyed = nbRadiantRangeBarracksDestroyed+nbRadiantMeleeBarracksDestroyed;
        		if(nbDireBarracksDestroyed == 6){
        			isDireMegaCreeps = 1;
        		}
        		if(nbRadiantBarracksDestroyed == 6){
        			isRadiantMegaCreeps = 1;
        		}
            }
        }
    }
    
    public void changeBarrackStatus(String name){
    	if(name.substring(0,8).equals("good_rax")){//Radiant tower
    		if(name.substring(9,14).equals("melee")){
    			if((name.substring(name.length()-3, name.length()).equals("top"))
    					&& (radiant_barrack_melee_top == 1)){
    				radiant_barrack_melee_top=0;
    				nbRadiantMeleeBarracksDestroyed++;
        		}
    			else if((name.substring(name.length()-3, name.length()).equals("mid"))
    					&& (radiant_barrack_melee_mid == 1)){
    				radiant_barrack_melee_mid=0;
    				nbRadiantMeleeBarracksDestroyed++;
        		}
    			else if((name.substring(name.length()-3, name.length()).equals("bot"))
    					&& (radiant_barrack_melee_bottom == 1)){//bottom
    				radiant_barrack_melee_bottom=0;
    				nbRadiantMeleeBarracksDestroyed++;
    			}
    		}
    		else{//range
    			if((name.substring(name.length()-3, name.length()).equals("top"))
    					&& (radiant_barrack_range_top == 1)){
    				radiant_barrack_range_top=0;
    				nbRadiantRangeBarracksDestroyed++;
        		}
    			else if((name.substring(name.length()-3, name.length()).equals("mid"))
    					&& (radiant_barrack_range_mid == 1)){
    				radiant_barrack_range_mid=0;
    				nbRadiantRangeBarracksDestroyed++;
        		}
    			else if((name.substring(name.length()-3, name.length()).equals("bot"))
    					&& (radiant_barrack_range_bottom == 1)){//bottom
    				radiant_barrack_range_bottom=0;
    				nbRadiantRangeBarracksDestroyed++;
    			}
    		}
    		
    		
    	}
    	else{//"bad_rax" => Dire Tower is destroyed
    		if(name.substring(8,13).equals("melee")){
    			if((name.substring(name.length()-3, name.length()).equals("top"))
    					&& (dire_barrack_melee_top == 1)){
    				dire_barrack_melee_top=0;
    				nbDireMeleeBarracksDestroyed++;
        		}
    			else if((name.substring(name.length()-3, name.length()).equals("mid"))
    					&& (dire_barrack_melee_mid == 1)){
    				dire_barrack_melee_mid=0;
    				nbDireMeleeBarracksDestroyed++;
        		}
    			else if((name.substring(name.length()-3, name.length()).equals("bot"))
    					&& (dire_barrack_melee_bottom == 1)){//bottom
    				dire_barrack_melee_bottom=0;
    				nbDireMeleeBarracksDestroyed++;
    			}
    		}
    		else{//range
    			if((name.substring(name.length()-3, name.length()).equals("top"))
    					&& (dire_barrack_range_top == 1)){
    				dire_barrack_range_top=0;
    				nbDireRangeBarracksDestroyed++;
        		}
    			else if((name.substring(name.length()-3, name.length()).equals("mid"))
    					&& (dire_barrack_range_mid == 1)){
    				dire_barrack_range_mid=0;
    				nbDireRangeBarracksDestroyed++;
        		}
    			else if((name.substring(name.length()-3, name.length()).equals("bot"))
    					&& (dire_barrack_range_bottom == 1)){//bottom
    				dire_barrack_range_bottom=0;
    				nbDireRangeBarracksDestroyed++;
    			}
    		}
    	}
    }

    
    //source: https://github.com/skadistats/clarity-examples/issues/10
    @UsesStringTable("EntityNames")
    public ArrayList<Integer> UsesStringTable(Context ctx, Entity e, String nameHero, int mostExpensiveItem) {
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	int isRapier = 0;
    	 
	    String [] itemPropertyNames = {"m_hItems.0001", "m_hItems.0002", "m_hItems.0003", "m_hItems.0004", "m_hItems.0005", "m_hItems.0006", "m_hItems.0007", "m_hItems.0008", "m_hItems.0009", "m_hItems.0010", "m_hItems.0011", "m_hItems.0013"};
    	Entities entities = ctx.getProcessor(Entities.class);
        StringTables stringTables = ctx.getProcessor(StringTables.class);
        //System.out.println(nameHero);
        int totalGolds = 0;
        for(String itemP : itemPropertyNames){
        	int itemId = e.getProperty(itemP);
	        Entity item = entities.getByHandle(itemId);//int
	        if (item != null) {
	            Integer idx = item.getProperty("m_pEntity.m_nameStringableIndex");
	            String name = stringTables.forName("EntityNames").getNameByIndex(idx);
	             //her heronun ayri item listesinin CSV'de olsutur
	            Item i = new Item(name.substring(5));//we drop "item_" prefix
	            //System.out.println(name.substring(5)+", "+i.itemToGold()+" golds");
	            int itemGold = i.itemToGold();
	            totalGolds = totalGolds + itemGold;
	            
	            if(itemGold > mostExpensiveItem){
	            	mostExpensiveItem = itemGold;
	            }
	            
	            if((isRapier == 0) && i.isDivineRapierBought()){
	            	 isRapier = 1;
	            }
	           
	        }
        }
        
        array.add(totalGolds);
        array.add(isRapier);
        array.add(mostExpensiveItem);
        
        return array;
    }
    
    
    @UsesEntities
    public int UsesEntities(Context ctx, Entity e) throws UnsupportedEncodingException {
    	sumAllLevelsInGame = 0;
    	sumAllGoldsInGame = 0;
    	
    	Entity ps = ctx.getProcessor(Entities.class).getByDtName("CDOTA_PlayerResource");
        Entity dr = ctx.getProcessor(Entities.class).getByDtName("CDOTA_DataRadiant");
        Entity dd = ctx.getProcessor(Entities.class).getByDtName("CDOTA_DataDire");
        

        String[][] columns;
        if (ps.getDtClass().getFieldPathForName("m_vecPlayerData") != null) {
            columns = new String[][]{
                //{"Name", "ps", "m_vecPlayerData.%i.m_iszPlayerName"},
                //{"Name", "ps", "m_vecPlayerTeamData.%i.m_nSelectedHeroID"},
                {"Name", "ps", "m_vecPlayerTeamData.%i.m_hSelectedHero"},
                {"Level", "ps", "m_vecPlayerTeamData.%i.m_iLevel"},
                {"K", "ps",  "m_vecPlayerTeamData.%i.m_iKills"},
                {"D", "ps", "m_vecPlayerTeamData.%i.m_iDeaths"},
                {"A", "ps", "m_vecPlayerTeamData.%i.m_iAssists"},
                {"Gold", "d", "m_vecDataTeam.%i.m_iTotalEarnedGold"},
                {"LH", "d", "m_vecDataTeam.%i.m_iLastHitCount"},
                {"DN", "d", "m_vecDataTeam.%i.m_iDenyCount"},
            };
        } else {
            columns = new String[][]{
                //{"Name", "ps", "m_iszPlayerNames.%i"},
            	{"Name", "ps", "m_hSelectedHero.%i"},
                {"Level", "ps", "m_iLevel.%i"},
                {"K", "ps",  "m_iKills.%i"},
                {"D", "ps", "m_iDeaths.%i"},
                {"A", "ps", "m_iAssists.%i"},
                {"Gold", "ps", "m_iTotalEarnedGold.%i"},
                {"LH", "ps", "m_iLastHitCount.%i"},
                {"DN", "ps", "m_iDenyCount.%i"},
            };
        }

        //TextTable.Builder b = new TextTable.Builder();
        //for (int c = 0; c < columns.length; c++) {
        //    b.addColumn(columns[c][0], c == 0 ? TextTable.Alignment.LEFT : TextTable.Alignment.RIGHT);
        //}
        //TextTable t = b.build();
        int current_hero=0;
        for (int c = 0; c < columns.length; c++) {
            for (int r = 0; r < 10; r++) {
                String entityStr = columns[c][1];
                
                Entity e1;
                int idx;
                if ("ps".equals(entityStr)) {
                    e1 = ps;
                    idx = r;
                } else {
                    e1 = r < 5 ? dr : dd;
                    idx = r % 5;
                }
                FieldPath fp = e1.getDtClass().getFieldPathForName(columns[c][2].replace("%i", Util.arrayIdxToString(idx)));
                Object val = e1.getPropertyForFieldPath(fp);
                String str = new String(val.toString().getBytes("ISO-8859-1"));
                //stats_unit_hero
                
                if(c==0){//hero name
                	Entity entity_hero = ctx.getProcessor(Entities.class).getByHandle(Integer.parseInt(str));
                	if(entity_hero.getDtClass().getDtName().equals(e.getDtClass().getDtName())){
                		current_hero=r;
                	}
                }
                else if(c==1){//level
                	sumAllLevelsInGame += Integer.parseInt(str);
                	if(r == current_hero){
                		stats_unit_hero[c-1] = Integer.parseInt(str);
                	}
                }
                else if(c==2){//gold
                	sumAllGoldsInGame += Integer.parseInt(str);
                	if(r == current_hero){
                		stats_unit_hero[c-1] = Integer.parseInt(str);
                	}
                }
                else{
                	if(r == current_hero){
                		stats_unit_hero[c-1] = Integer.parseInt(str);
                	}
                }
                //t.setData(r, c, str);
            }
        }   
        return current_hero; //hero index (between 0 and 9)	
    }

}
