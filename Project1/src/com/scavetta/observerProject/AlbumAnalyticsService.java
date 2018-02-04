package com.scavetta.observerProject;

import com.scavetta.observerProject.observerAPI.*;

public class AlbumAnalyticsService implements IObserver {

    public void update(Object observableObject)
    {
        if(observableObject instanceof Album){
            processNewAlbumListen((Album)observableObject);
        }
    }

    private void processNewAlbumListen(Album album)
    {
        System.out.println("Calculating analytics for " + album.getName());
        //do analytics on this album
    }
}
