package com.sleepyheads.game.entity;

public class Move extends Action {
    /**
     *  Moves the source to the LocationTarget target.
     * @param source
     * @param target
     */
    public void doAction(Entity source, Target target) {
        if (target.getClass() == LocationTarget.class) {
            LocationTarget locationTarget = (LocationTarget) target;
            source.locationX = locationTarget.locationX;
            source.locationY = locationTarget.locationY;
        } else {
            System.out.println("Move target is of type "
                    + target.getClass().toString()
                    + " instead of type "
                    + LocationTarget.class.toString());
        }
    }
}
