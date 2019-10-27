package com.sleepyheads.game.world;

import com.sleepyheads.game.entity.Entity;

import java.util.HashSet;

public class World {
    public HashSet<Entity> entities;
    public World() {
        entities = new HashSet<>();
    }
}
