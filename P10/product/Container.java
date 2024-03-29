package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Container {
    public Container(String name, String description, int MaxScoop) {
        this.name = name;
        this.description = description;
        this.maxScoops = MaxScoop;
   
    }
    
    public Container(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.description = br.readLine();
        this.maxScoops = Integer.parseInt(br.readLine());
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(description + '\n');
        bw.write("" + maxScoops + '\n');
    }
    
    
    @Override
    public String toString() {
        return name;
    }
    private String name;
    private String description;
    private int maxScoops;
   
}
