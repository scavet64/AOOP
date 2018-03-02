package com.scavetta.observerProject.observerAPI;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Singleton class that handles the register and publishing of observers and observable data.
 * This handler only supports methods that take a single parameter.
 */
public class ObservationHandler {
    private volatile static ObservationHandler instance;
    private static Object lock = new Object();
    private final Map<Class, List<SubscriberInfo>> classToListOfSubscriberInfoMap;

    /**
     * Private constructor for singleton pattern
     */
    private ObservationHandler(){
        classToListOfSubscriberInfoMap = new LinkedHashMap<>();
    }

    /**
     * Return the singleton instance of the ObservationHandler. This method implements the double locking pattern
     * to ensure that this singleton is thread safe.
     * @return Singleton instance
     */
    public static ObservationHandler getInstance(){
        if(instance == null){
            synchronized (lock){
                if(instance == null){
                    instance = new ObservationHandler();
                }
            }
        }
        return instance;
    }

    /**
     * Add a new observer to the classToListOfSubscriberInfoMap.
     *
     * <p>The passed in object is inspected using reflection to search for all it's methods that have the
     * subscription annotation. </p>
     * @param observingObject object that should receive events
     */
    public void add(Object observingObject) {
        //get the object's methods and iterate through them
        for (Method method : observingObject.getClass().getMethods()) {

            //is this method a valid subscription method
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (method.getAnnotation(Subscription.class) == null || parameterTypes.length != 1) {
                continue;
            }

            //check to see if we have a subscriber info list mapped to the parameter's type. If not, create it
            Class subscribeTo = parameterTypes[0];
            List<SubscriberInfo> subscriberInfoList = classToListOfSubscriberInfoMap.get(subscribeTo);
            if (subscriberInfoList == null) {
                subscriberInfoList = new ArrayList<>();
                classToListOfSubscriberInfoMap.put(subscribeTo, subscriberInfoList);
            }

            //add to the classToListOfSubscriberInfoMap
            subscriberInfoList.add(new SubscriberInfo(method, observingObject));
        }
    }

    /**
     * Remove a subscribed object from the list. This object will no longer be updated with new information.
     * @param objectToRemove the object that will be removed from updates
     */
    public void remove(Object objectToRemove) {
        for (List<SubscriberInfo> subscriberInfoList : classToListOfSubscriberInfoMap.values()) {
            for (int i = subscriberInfoList.size() - 1; i >= 0; i--)
                if (subscriberInfoList.get(i).object == objectToRemove)
                    subscriberInfoList.remove(i);
        }
    }

    /**
     * Publish an object to the listening objects
     * @param objectToPublish the object that should be sent to any listeners
     * @return number of objects that were notified about the published object
     */
    public int publish(Object objectToPublish) {
        List<SubscriberInfo> subscriberInfoList = classToListOfSubscriberInfoMap.get(objectToPublish.getClass());
        if (subscriberInfoList == null) return 0;
        int count = 0;
        for (SubscriberInfo subscriberInfo : subscriberInfoList) {
            subscriberInfo.invoke(objectToPublish);
            count++;
        }
        return count;
    }

}
