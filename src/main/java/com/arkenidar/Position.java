package com.arkenidar;

public class Position {
    private int i, j;
    private Maze maze;

    Position(int i, int j, Maze m) {
        this.i = i;
        this.j = j;
        this.maze = m;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean validI(int i) {
        return i < maze.getSizeI() && i >= 0;
    }

    public boolean validJ(int j) {
        return j < maze.getSizeJ() && j >= 0;
    }

    public boolean delta(int di, int dj) {
        int ti = i, tj = j;
        if (validI(i + di))
            ti += di;
        else
            return false;

        if (validJ(j + dj))
            tj += dj;
        else
            return false;

        if (maze.isWall(new Position(ti, tj, maze)))
            return false;

        i = ti;
        j = tj;
        return true;
    }

    public boolean setPosition(int i, int j) {
        Position position=this;

        boolean valid;
        // check validity of indices
        valid = position.validI(i) && position.validJ(j);
        if (!valid) return false;

        // check validity of "walls"
        valid = maze.isWall(position);
        if (!valid) return false;

        return false;
    }
}
