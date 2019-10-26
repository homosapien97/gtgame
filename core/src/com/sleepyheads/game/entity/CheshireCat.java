package com.sleepyheads.game.entity;

class CCActionQ extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class CCActionW extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class CCActionE extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class CCActionR extends Action {
    public void doAction(Entity source, Target target) {

    }
}

public class CheshireCat extends Entity {
    public CheshireCat() {
        super("CheshireCat", 10, 10, new Action[]{new Attack(), new Move(), new CCActionQ(), new CCActionW(), new CCActionE(), new CCActionR()}, 0, 0, null);
    }
}