package com.scavetta.observerProject;

import com.scavetta.observerProject.observerAPI.Subscription;

/**
 * Very basic class to demonstrate the annotation based observer pattern
 */
public class ArtistBillingService {

    @Subscription
    public void processArtistCompensation(Album albumOfArtist)
    {
        // Give the artist compensation for the album play
        System.out.println(albumOfArtist.getArtist() + " was compensated for a play");
    }
}
