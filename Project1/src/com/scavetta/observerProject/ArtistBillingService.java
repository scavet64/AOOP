package com.scavetta.observerProject;

import com.scavetta.observerProject.observerAPI.IObserver;

public class ArtistBillingService implements IObserver {

    @Override
    public void update(Object object) {
        if(object instanceof Album){
            Album album = (Album)object;
            processArtistCompensation(album.getArtist());

        }
    }

    private void processArtistCompensation(String artist)
    {
        // Give the artist compensation for the album play
        System.out.println(artist + " was compensated for a play");
    }
}
