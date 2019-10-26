package com.sleepyheads.game.entity;

public abstract class Action {
    /**
     * This method performs an action using the source Entity and the target.
     * @param source
     * @param target
     */
    abstract void doAction(Entity source, Target target);
}
