package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Person {
    public Person(String name,String phone){
        this.name=name;
        this.phone=phone;
    }
    public Person(BufferedReader br)throws IOException{
        this.name=br.readLine();
        this.phone=br.readLine();
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(phone+ '\n');
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public int hashCode(){
        return this.name.length()%10;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        Customer cust=(Customer)obj;

        return this.name == cust.name && this.phone == cust.phone;
    }
    protected String name;
    protected String phone;

    
}
