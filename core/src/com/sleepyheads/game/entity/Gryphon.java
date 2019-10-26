package com.sleepyheads.game.entity;

import java.util.ArrayList;
import java.util.Random;

class GActionQ extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        for (Entity e: source.visible) {
            if (rand.nextInt(2) == 1) {
                e.decreaseHealth(source.energy, source);
            }
        }
    }
}

class GActionW extends Action {
    public void doAction(Entity source, Target target) {
        Random rand = new Random();
        source.decreaseHealth(source.energy, source);
    }
}

class GActionE extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class GActionR extends Action {
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

public class Gryphon extends Entity {
    public Gryphon() {
        super("Gryphon", 10, 10, new Action[]{new Attack(), new Move(), new GActionQ(), new GActionW(), new GActionE(), new GActionR()}, 0, 0, null);
    }
}