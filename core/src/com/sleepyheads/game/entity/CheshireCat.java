package com.sleepyheads.game.entity;

import java.util.ArrayList;
import java.util.Random;

class CCActionQ extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        for (Entity e: source.visible) {
            if (rand.nextInt(2) == 1) {
                e.decreaseHealth(source.energy, source);
            }
        }
    }
}

class CCActionW extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        if (rand.nextInt(2) == 1) {
            source.decreaseHealth(source.energy, source);
        }
    }
}

class CCActionE extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        Entity entityTarget = ((EntityTarget) target).entity;
        if (rand.nextInt(2) == 1) {
            entityTarget.decreaseHealth(entityTarget.energy, entityTarget);
        }
    }
}

class CCActionR extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        ArrayList<Entity> killed = source.killed;
        if (rand.nextInt(killed.size()) == 0) {
            for (Entity e: killed) {
                e.resurrect();
            }
        }
    }
}

public class CheshireCat extends Entity {
    public CheshireCat() {
        super("CheshireCat", 10, 10, new Action[]{new Attack(), new Move(), new CCActionQ(), new CCActionW(), new CCActionE(), new CCActionR()}, 0, 0, null);
    }
}