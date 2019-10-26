package com.sleepyheads.game.entity;

public class Attack extends Action {
    /**
     * Attacks target using source's attack method.
     * @param source
     * @param target
     */
    public void doAction(Entity source, Target target) {
        if (target.getClass() == EntityTarget.class) {
            ((EntityTarget) target).entity.decreaseHP(source.energy);
        } else {
            System.out.println("Move target is of type "
                    + target.getClass().toString()
                    + " instead of type "
                    + EntityTarget.class.toString());
        }
    }
}
