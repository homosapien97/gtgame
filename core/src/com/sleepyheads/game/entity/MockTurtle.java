package com.sleepyheads.game.entity;

class MTActionQ extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class MTActionW extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class MTActionE extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class MTActionR extends Action {
    public void doAction(Entity source, Target target) {

    }
}

public class MockTurtle extends Entity{
    public MockTurtle() {
        super("MockTurtle", 10, 10, new Action[]{new Attack(), new Move(), new MTActionQ(), new MTActionW(), new MTActionE(), new MTActionR()}, 0, 0, null);
    }
}