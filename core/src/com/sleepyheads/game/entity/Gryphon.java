package com.sleepyheads.game.entity;

class GActionQ extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class GActionW extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class GActionE extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class GActionR extends Action {
    public void doAction(Entity source, Target target) {

    }
}

public class Gryphon extends Entity {
    public Gryphon() {
        super("Gryphon", 10, 10, new Action[]{new Attack(), new Move(), new GActionQ(), new GActionW(), new GActionE(), new GActionR()}, 0, 0, null);
    }
}