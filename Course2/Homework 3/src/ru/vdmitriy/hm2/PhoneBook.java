package ru.vdmitriy.hm2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by VasilyevD on 30.09.2016.
 */
public class PhoneBook {
    ArrayList<PhoneRecord> pb = new ArrayList<>();

    public PhoneBook() {
    }
    public void addRecord(PhoneRecord record){
        pb.add(record);
    }
    public void deleteRecord(int key) {
        pb.remove(key);
    }
    public void getRecord(int key) {
        pb.get(key).getInfo();
    }
    public void getAllRecords() {
        ListIterator<PhoneRecord> iterator = pb.listIterator(); //ListIterator get more methods =)
        while (iterator.hasNext()){
            System.out.println(iterator.nextIndex()+": "+iterator.next().getInfo());
        }
    }
    public void clearAllRecords(){
        Iterator<PhoneRecord> iterator = pb.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }

    /**
     *
     * @param name
     *          search string
     * @return index of object or size of ArrayList, if object not found
     *
     */
    public ArrayList<PhoneRecord> searchByName(String name) {
        ArrayList<PhoneRecord> searchResults = new ArrayList<>();
        ListIterator<PhoneRecord> iterator = pb.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().getName().contains(name)){
                searchResults.add(iterator.previous()); //Большая жирная бага
            }
        }
        return searchResults;
    }
    public ArrayList<String> getPhoneByName(ArrayList<PhoneRecord> results){
        ArrayList<String> phones = new ArrayList<>();
        for(PhoneRecord record: results)
            phones.add(record.getName()+": "+record.getPhone());
        return phones;
    }
    public ArrayList<String> getPhoneByName(String search){
        ArrayList<PhoneRecord> results = searchByName(search);
        ArrayList<String> phones = new ArrayList<>();
        for(PhoneRecord record: results)
            phones.add(record.getName()+": "+record.getPhone());
        return phones;
    }

}
