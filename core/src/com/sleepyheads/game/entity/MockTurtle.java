package com.sleepyheads.game.entity;

import com.sleepyheads.game.draw.Model;

import java.util.ArrayList;
import java.util.Random;

class MTActionQ extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        for (Entity e: source.visible) {
            if (rand.nextInt(2) == 1) {
                e.decreaseHealth(source.energy, source);
            }
        }
    }
}

class MTActionW extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        if (rand.nextInt(2) == 1) {
            source.decreaseHealth(source.energy, source);
        }
    }
}

class MTActionE extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        Entity entityTarget = ((EntityTarget) target).entity;
        if (rand.nextInt(2) == 1) {
            entityTarget.decreaseHealth(entityTarget.energy, entityTarget);
        }
    }
}

class MTActionR extends Action {
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

public class MockTurtle extends Entity{
    public MockTurtle() {
        super("MockTurtle", 10, 10, new Action[]{new Attack(), new Move(), new MTActionQ(), new MTActionW(), new MTActionE(), new MTActionR()}, 0, 0, null, new Model("models/turtle.txt"));
    }
}