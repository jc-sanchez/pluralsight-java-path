package com.jcsanchez.designpatterns.structural.bridge.Shape1;

/**
 * Created by jsssn on 18-May-17.
 */
public class BlueSquare extends Square {

    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}
