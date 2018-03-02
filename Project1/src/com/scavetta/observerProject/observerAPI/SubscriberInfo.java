package com.scavetta.observerProject.observerAPI;

import java.lang.reflect.Method;

/**
 * This model class that represents a subscriber.
 */
public class SubscriberInfo {
    final Method method;
    final Object object;

    SubscriberInfo(Method method, Object object) {
        this.method = method;
        this.object = object;
    }

    /**
     * Invoke this instance's method using this instance's object and pass parameterObject as a parameter
     * @param parameterObject
     */
    void invoke(Object parameterObject) {
        try {
            this.method.invoke(this.object, parameterObject);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

}
