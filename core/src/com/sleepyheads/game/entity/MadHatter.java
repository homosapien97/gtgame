package com.sleepyheads.game.entity;

import com.sleepyheads.game.draw.Model;

import java.util.ArrayList;
import java.util.Random;

class MHActionQ extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        for (Entity e: source.visible) {
            if (rand.nextInt(2) == 1) {
                e.decreaseHealth(source.energy, source);
            }
        }
    }
}

class MHActionW extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        if (rand.nextInt(2) == 1) {
            source.decreaseHealth(source.energy, source);
        }
    }
}

class MHActionE extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        Entity entityTarget = ((EntityTarget) target).entity;
        if (rand.nextInt(2) == 1) {
            entityTarget.decreaseHealth(entityTarget.energy, entityTarget);
        }
    }
}

class MHActionR extends Action {
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

public class MadHatter extends Entity{
    public MadHatter() {
        super("MadHatter", 10, 10, new Action[]{new Attack(), new Move(), new MHActionQ(), new MHActionW(), new MHActionE(), new MHActionR()}, 0, 0, null, new Model("models/hatter_main.txt"));
    }
}