package emporium;
import java.util.HashMap;
import java.util.HashSet;

public class MultiMap<K,V> {
    private HashMap<K, HashSet<V>>map;
    public MultiMap(){
        this.map= new HashMap<K,HashSet<V>>();
    }

    public void put(K Key,V value){
        if(this.map.get(Key)==null){
            this.map.put(Key, new HashSet<V>());
        }
        this.map.get(Key).add(value);
    }

    public Object[] get(K Key){
        Object[] obj;
        if(this.map.get(Key)==null){
            obj= new Object[0];
        }
        else{
            obj= this.map.get(Key).toArray();
        }
        
        System.out.println(obj.toString());
        return obj;
    }
}
