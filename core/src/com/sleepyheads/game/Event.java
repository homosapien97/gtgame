package com.sleepyheads.game;

import com.sleepyheads.game.world.World;

import java.io.Serializable;

public abstract class Event implements Serializable {
    public abstract void happen(World world);
}
