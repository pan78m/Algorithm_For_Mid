package Dynamic_Topics.custom_collection;

import java.util.LinkedList;

class Home{
  private String name;
  private String street;
  private String city;
  private String state;
  private String code;
  public Home(String n,String s,String c,String st,String cd){
    name=n;
    street=s;
    city=c;
    state=st;
    code=cd;
  }
  public String toString(){
    return name+"\n"+street+"\n"+city+"\n"+state+"\n"+code;
  }
}
public class Address {
    public static void main(String[] args) {
       LinkedList<Home> m1=new LinkedList<Home>();
       m1.add(new Home("pan", "norshinput", "Savar", "Dhaka", "121345"));
       m1.add(new Home("Mahanto", "norshinput", "Dhaka", "Dhaka", "121345"));
       m1.add(new Home("pankaj", "norshinput", "Savar", "Dhaka", "1210245"));

       //Display the Home list
       for(Home i:m1)
       System.out.println(i+" \n");
       System.out.println();
    }
}
