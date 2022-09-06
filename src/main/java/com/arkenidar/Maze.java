package com.arkenidar;

public class Maze {
    private char[][] grid;

    private Position playerPosition;

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void load(String cells) {
        String[] lines = cells.split("\n");
        grid = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            char[] row = line.toCharArray();
            for(int j=0; j<row.length; j++)
                if(row[j]=='P'){
                    playerPosition=new Position(i,j,this);
                    row[j]='-';
                }
            grid[i] = row;
        }
    }

    void draw() {
        Position position=playerPosition;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char out;
                if (position.getI() == i && position.getJ() == j)
                    out = 'P';
                else
                    out = grid[i][j];
                System.out.print(out);
            }
            System.out.println("");
        }
    }

    public int getSizeI() {
        return grid.length;
    }

    public int getSizeJ() {
        return grid[0].length;
    }

    public boolean isWall(Position p) {
        return grid[p.getI()][p.getJ()] == 'W';
    }

    public boolean isEnd(Position p) {
        return grid[p.getI()][p.getJ()] == 'E';
    }
}
