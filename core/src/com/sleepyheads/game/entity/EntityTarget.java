package com.sleepyheads.game.entity;

public class EntityTarget extends Target {
    public Entity entity;

    /**
     * Sets the target entity
     * @param entity
     */
    public EntityTarget(Entity entity) {
        this.entity = entity;
    }
}
