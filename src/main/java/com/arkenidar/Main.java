package com.arkenidar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello maze!");

        String level1 =
                "PWW\n" +
                        "--W\n" +
                        "W-W\n" +
                        "WEW\n";
        Maze maze = new Maze();

        maze.load(level1);
        Scanner in = new Scanner(System.in);
        Position pos = maze.getPlayerPosition();
        maze.draw();
        while (!maze.isEnd(pos)) {
            System.out.print("WASD direction? ");
            String action = in.nextLine();
            int di = 0, dj = 0;
            switch (action) {
                case "w" -> di--;
                case "s" -> di++;
                case "a" -> dj--;
                case "d" -> dj++;
            }
            pos.delta(di, dj);
            maze.draw();
            System.out.println("");
        }
        System.out.println("end reached! exiting...");
    }
}