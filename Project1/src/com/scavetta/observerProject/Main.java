package com.scavetta.observerProject;

import com.scavetta.observerProject.observerAPI.ObservationHandler;

public class Main {

    public static void main(String[] args) {
        //create test objects
        AlbumAnalyticsService analytics = new AlbumAnalyticsService();
        ArtistBillingService billing = new ArtistBillingService();
        Album b4da$$ = new Album("B4.DA.$$", "Joey Bada$$");
        Album weGotItFromHere = new Album("We got it from here", "A Tribe Called Quest");

        //register the test observers to the handler
        ObservationHandler observationHandler = ObservationHandler.getInstance();
        observationHandler.add(analytics);
        observationHandler.add(billing);

        //Do action and publish objects
        b4da$$.play();
        observationHandler.publish(b4da$$);

        weGotItFromHere.play();
        observationHandler.publish(weGotItFromHere);

        weGotItFromHere.play();
        observationHandler.publish(weGotItFromHere);

        observationHandler.remove(billing);
        weGotItFromHere.play();
        observationHandler.publish(weGotItFromHere);
    }
}
