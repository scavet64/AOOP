package com.scavetta.observerProject;

public class Album {

    private String name;
    private String artist;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public void play() {
        System.out.println("\n///////////////////////////////////////////////////////////");
        System.out.println("Currently playing " + name + " by " + artist);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

}
