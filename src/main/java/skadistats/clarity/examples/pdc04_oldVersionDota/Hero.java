package skadistats.clarity.examples.pdc04_oldVersionDota;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olivier.cavadenti
 */
public class Hero {

    private final String name;
    private final HashMap<Integer, Float[]> seconds = new HashMap<>();
    private final HashMap<String, Integer> objects = new HashMap<>();

    private int cellx, celly, tickmax,creepkilled,gold;
    private int[] levelab = new int[4];
    
    public Hero(String name, int cellx, int celly, int tickmax) {
        this.cellx = cellx;
        this.celly = celly;
        this.name = name;
        this.tickmax = tickmax;
        objects.clear();
        seconds.clear();
    }
    private int currenttick = 0;

    public HashMap<String, Integer> getObjects() {
        return objects;
    }
    private int firstick = -1;

    private ArrayList<Integer> abs = new ArrayList<>();
    
    public int getNumAbChanged(int[] levels){
        int l = -1;
        for(int i = 0;i < levels.length;i++){
            if(levels[i]==-1)break;
            if(levelab[i] == levels[i]-1){
                levelab = levels.clone();
                return i;
            }
        }
        return l;
    }
    
    public void addAbility(int numab){
        abs.add(numab);
    }
    public ArrayList<Integer> getAbilities(){
        return abs;
    }
    public void addObject(String obj) {

        int count = 0;
        if (objects.containsKey(obj)) {
            count = objects.get(obj);
        }
        count++;
        objects.put(obj, count);
    }

    public int getFirstTick() {
        return firstick;
    }

    public void setFirstTick(int tick) {
        firstick = tick;
    }

    public void addPosition(int tick, int x, int y,int numx,int numy,float health,float mana) {
        Float[] xy = new Float[]{(float) x, (float) y,(float) numx,(float) numy,health,mana};
        tick -= firstick;
        if (currenttick != tick) {
            seconds.put(tick, xy);
            currenttick = tick;
        }
    }
    
    public HashMap<Integer, Float[]> getPositions(int firsttick, int finaltick) {
        HashMap<Integer, Float[]> pos = new HashMap<>();

        for (int tick : seconds.keySet()) {
            if (tick > firsttick && tick < finaltick) {
                pos.put(tick, seconds.get(tick));
            }
        }
        return pos;
    }
    
    public String getName() {
        return name;
    }

    public HashMap<Integer, Float[]> getPositions() {
        return seconds;
    }

    public int getGoldByMinute(){
        ArrayList<Integer> secs = new ArrayList<>(seconds.keySet());
        Collections.sort(secs);
        int tickfirst = secs.get(0);
        int tickend = secs.get(secs.size()-1);
        
        int rangeinminute = (int)((double)(tickend - tickfirst)/(double)1080);
        System.out.println("Gold/Minutes: " +(int)((double)gold/(double)rangeinminute));
        return gold;
    }
    
    public int getCreepsKilledByMinute(){
        return creepkilled;
    }
    private int XMIN = -(16384/2);
    private int YMIN = (16384/2);
    private int XMAX = (16384/2);
    private int YMAX = -(16384/2);
    
    
    @Override
    public String toString() {
        String str = "Heroname: " + name + "\r\n";
        for (Integer sec : seconds.keySet()) {
            str += "x: " + seconds.get(sec)[0] + " y: " + seconds.get(sec)[1] + "\r\n";
        }
        return str;
    }

    public void killCreep() {
        creepkilled++;
    }

    public void addGold(int value) {
       gold += value;
    }
    
    public void writeTraceFile(String filename)
    {
        try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
                HashMap<Integer, Float[]> positions=this.getPositions();
                ArrayList<Integer> keys = new ArrayList<>(positions.keySet());
                Collections.sort(keys);
                Float[] xy;
                Float[] firstPosition=positions.get(keys.get(0));
                String type = "Dire";
                if (firstPosition[0]<0 && firstPosition[1]<0) type = "Radiance";
                writer.println("#Hero name : "+this.getName());
                writer.println("#Number : "+positions.size());
                writer.println("#type : "+type);
                writer.println("tick;x;y;health;mana");
                for (int tick : keys) {
                    xy = positions.get(tick);
                    writer.println(tick+";"+xy[0]+";"+xy[1]+";"+xy[4]+";"+xy[5]);
                }
                writer.close();
                System.out.println(filename+" writed successfully !");
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("ERROR !");
        }
        
    }

}
