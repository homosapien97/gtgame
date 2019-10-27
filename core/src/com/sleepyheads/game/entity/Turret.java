package com.sleepyheads.game.entity;

import com.sleepyheads.game.draw.Model;

public class Turret extends Entity {
    public Turret() {
        super("Turret", 30, 20, new Action[]{new Attack(), new Attack(), new Attack(), new Attack(), new Attack(), new Attack()}, 0, 0, null, new Model("models/turret.txt"));
    }
}