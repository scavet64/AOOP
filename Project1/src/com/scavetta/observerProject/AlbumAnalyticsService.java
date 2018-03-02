package com.scavetta.observerProject;

import com.scavetta.observerProject.observerAPI.Subscription;

/**
 * Very basic class to demonstrate the annotation based observer pattern
 */
public class AlbumAnalyticsService {

    @Subscription
    public void processNewAlbumListen(Album album)
    {
        System.out.println("Calculating analytics for " + album.getName());
        //do analytics on this album
    }
}
