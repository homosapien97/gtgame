package com.sleepyheads.game.entity;

class MHActionQ extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class MHActionW extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class MHActionE extends Action {
    public void doAction(Entity source, Target target) {

    }
}

class MHActionR extends Action {
    public void doAction(Entity source, Target target) {

    }
}

public class MadHatter extends Entity{
    public MadHatter() {
        super("MadHatter", 10, 10, new Action[]{new Attack(), new Move(), new MHActionQ(), new MHActionW(), new MHActionE(), new MHActionR()}, 0, 0, null);
    }
}