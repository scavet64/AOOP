package com.scavetta.observerProject;

public class Main {

    public static void main(String[] args) {
        AlbumAnalyticsService analytics = new AlbumAnalyticsService();
        ArtistBillingService billing = new ArtistBillingService();
        Album b4da$$ = new Album("B4.DA.$$", "Joey Bada$$");
        Album weGotItFromHere = new Album("We got it from here", "A Tribe Called Quest");

        b4da$$.getObservableDataHelper().registerObserver(analytics);
        b4da$$.getObservableDataHelper().registerObserver(billing);
        weGotItFromHere.getObservableDataHelper().registerObserver(analytics);
        weGotItFromHere.getObservableDataHelper().registerObserver(billing);

        b4da$$.play();
        weGotItFromHere.play();
        weGotItFromHere.play();

        weGotItFromHere.getObservableDataHelper().removeObserver(analytics);
        weGotItFromHere.getObservableDataHelper().removeObserver(billing);
        weGotItFromHere.play();

        b4da$$.getObservableDataHelper().removeAllObservers();
        b4da$$.play();
    }
}
