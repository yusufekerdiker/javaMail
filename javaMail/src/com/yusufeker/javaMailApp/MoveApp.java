package com.yusufeker.javaMailApp;

public class MoveApp {

    mailApp app;

    public MoveApp(mailApp app) {
        this.app = app;
    }

    int mousepressX, mousepressY, locationX, locationY, x, y;

    public void getLocaction(java.awt.event.MouseEvent evt) {
        mousepressX = evt.getX();
        mousepressY = evt.getY();
        // When the interface calls this method, it takes the x and y position 
        // of the pointer and assigns it to a variable.
    }

    public void changeLocaction(java.awt.event.MouseEvent evt) {
        locationX = evt.getXOnScreen(); // Get x position when frame start dragging
        locationY = evt.getYOnScreen(); // Get y position when frame start dragging

        x = locationX - mousepressX;
        y = locationY - mousepressY;
        // Gets the lates location of frame

        app.setLocation(x, y); // Sets the location

        //locX = app.getX() + evt.getX() - mousepressX;
        //locY = app.getY() + evt.getY() - mousepressY;
        //app.setLocation(app.getX() + evt.getX() - mousepressX,
        //                app.getY() + evt.getY() - mousepressY);
    }
}
