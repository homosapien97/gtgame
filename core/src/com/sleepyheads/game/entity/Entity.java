package com.sleepyheads.game.entity;

import java.util.ArrayList;

public class Entity{
    public boolean alive;           // If currently alive (health > 0)
    public int currentEnergy;       // currentEnergy (if alive == energy, otherwise == 0)
    public int currentHealth;       // currentHealth (if not alive, == 0)
    public int energy;              // attack energy
    public int health;              // maximum possible health
    public Action[] listOfActions;  // list of all possible actions
    public int locationX;           // current x location
    public int locationY;           // current y location
    public String name;             // entity name
    public Entity[] visible;        // list of visible entities

    public ArrayList<Entity> killed;

    /**
     * Sets all instance variables.
     * @param name
     * @param health
     * @param energy
     * @param listOfActions
     * @param initialX
     * @param initialY
     * @param visible
     */
    public Entity(String name, int health, int energy, Action[] listOfActions, int initialX, int initialY, Entity[] visible) {
        this.name = name;
        this.health = health;
        this.currentHealth = health;
        this.energy = energy;
        this.currentEnergy = energy;
        this.locationX = initialX;
        this.locationY = initialY;
        this.visible = visible;
        assert(listOfActions.length == Settings.lengthOfActions);
        this.listOfActions = listOfActions;
        killed = new ArrayList<Entity>();
    }

    /**
     * Indexes into listOfActions using index and performs action against target.
     * @param index
     * @param target
     */
    public void doAction(int index, Target target) {
        try {
            listOfActions[index].doAction(this, target);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is out of bounds in listOfActions");
        }
    }

    /**
     * Decreases health by decrementBy
     * @param decrementBy
     */
    public void decreaseHealth(int decrementBy, Entity source) {
        int newHealth = this.currentHealth - decrementBy;
        if (newHealth <= 0) {
            this.alive = false;
            this.currentEnergy = 0;
            this.currentHealth = 0;
            source.killed.add(this);
        } else {
            this.currentHealth = newHealth;
        }
    }

    /**
     * Brings back an entity
     */
    public void resurrect() {
        if (!this.alive) {
            this.alive = true;
            this.currentEnergy = this.energy;
            this.currentHealth = this.health;
        }
    }

    /**
     * Updates the list of visible entities.
     * @param visible
     */
    public void updateVisibility(Entity[] visible) {
        this.visible = visible;
    }
}
