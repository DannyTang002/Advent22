package day7Fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Directory implements Data {
    private Map<String,Set<Data>> map;

    private Set<Data>  set = new HashSet<>();
    private String name;

    public Directory(String name ){
        this.name = name;
        this.map= new HashMap<>();
        this.map.put(name, set);
    }
    public void add(Data data){
        map.get(name).add(data);
    }


    public String getName(){
        return name;
    }

    public int fileSize() {
        return set.stream().mapToInt(x->x.fileSize()).sum();
    }

    public void printInfo(){
        set.stream().forEach(x->System.out.println(name + " info:" + x.getName() + " size:" + x.fileSize()));
    }

    

}
