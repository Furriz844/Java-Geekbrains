package ru.geekbrains.java1.dz.dz4.VasilyevDmitriy;

/**
 * Created by VasilyevD on 29.08.2016.
 */
public class Main {
    public static void main(String args[]){
        Person[] staff =new Person[5];
        staff[0]= new Person("Mike Potter","Teacher","m.potter@gmail.com","8-800-555-35-35",500,23);
        staff[1]= new Person("Frank Jaywood","Director","f.jaywood@gmail.com","8-800-343-21-12",1000,44);
        staff[2]= new Person("Haris Pilton","Actor","h.pilton@gmail.com","8-800-345-45-44",600,56);
        staff[3]= new Person("Maria Dark","Writer","m.dark@gmail.com","8-800-565-55-12",897,50);
        staff[4]= new Person("Bob Marley","Singer","b.marley@gmail.com","8-800-434-89-62",450,30);

        for (int i=0;i<5;i++){
            if(staff[i].getAge()>40){
                System.out.println('\n'+staff[i].getName()+ " information list");
                staff[i].printPerson();
            }
        }
    }
}
