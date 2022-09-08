package com.arkenidar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello maze!");

        String level1 = """
                PWW
                --W
                W-W
                WEW""";

        Maze maze = new Maze();

        maze.load(level1);

        final Scanner in = new Scanner(System.in);

        Position pos = maze.getPlayerPosition();

        maze.draw();

        while (true) {

            boolean endReached = maze.isEnd(pos);
            if (endReached) {
                System.out.println("maze end reached!");
                break;
            }

            System.out.print("WASD direction? (or exit) ");
            String action = in.nextLine();
            if (action.equals("exit")) break;

            int di = 0, dj = 0;
            switch (action) {
                case "w" -> di--;
                case "s" -> di++;
                case "a" -> dj--;
                case "d" -> dj++;
            }
            pos.delta(di, dj);

            maze.draw();

        }
        System.out.println("exiting...");
        in.close();
    }
}