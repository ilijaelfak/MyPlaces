package com.example.myplaces;

public class MyPlace {
    String name;
    String description;

    public MyPlace(String nme,String desc)
    {
        this.name=nme;
        this.description=desc;
    }
    public MyPlace(String nme){
        this(nme,"");
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return  description;
    }

    public void setName(String nme){
        this.name=nme;
    }
    public void setDescription(String desc){
        this.description=desc;
    }

    public String toString(){
        return this.name;
    }

}
