package com.sleepyheads.game.entity;

import java.util.ArrayList;
import java.util.Random;

class AActionQ extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        for (Entity e: source.visible) {
            if (rand.nextInt(2) == 1) {
                e.decreaseHealth(source.energy, source);
            }
        }
    }
}

class AActionW extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        source.decreaseHealth(source.energy, source);
    }
}

class AActionE extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class AActionR extends Action {
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

public class Alice extends Entity {
    public Alice() {
        super("Alice", 10, 10, new Action[]{new Attack(), new Move(), new AActionQ(), new AActionW(), new AActionE(), new AActionR()}, 0, 0, null);
    }
}