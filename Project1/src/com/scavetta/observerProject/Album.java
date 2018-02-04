package com.scavetta.observerProject;

import com.scavetta.observerProject.observerAPI.*;

public class Album {

    private String name;
    private String artist;
    private ObservableDataHelper observableDataHelper = new ObservableDataHelper();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public void play() {
        System.out.println("\n///////////////////////////////////////////////////////////");
        System.out.println("Currently playing " + name + " by " + artist);
        observableDataHelper.notifyObservers(this);
        // code to play the album
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

    public ObservableDataHelper getObservableDataHelper(){
        return observableDataHelper;
    }

}
