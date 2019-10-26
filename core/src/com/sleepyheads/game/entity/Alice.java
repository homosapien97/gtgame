package com.sleepyheads.game.entity;

class AActionQ extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class AActionW extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class AActionE extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class AActionR extends Action {
    public void doAction(Entity source, Target target) {

    }
}

public class Alice extends Entity {
    public Alice() {
        super("Alice", 10, 10, new Action[]{new Attack(), new Move(), new AActionQ(), new AActionW(), new AActionE(), new AActionR()}, 0, 0, null);
    }
}