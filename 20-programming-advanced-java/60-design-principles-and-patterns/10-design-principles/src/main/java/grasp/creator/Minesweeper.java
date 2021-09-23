package grasp.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select a difficulty rating: EASY, MEDIUM or HARD");
        System.out.print(">");
        Difficulty difficulty = Difficulty.valueOf(scanner.nextLine().trim());
        List<Coordinate> bombs = new ArrayList<>();
        switch (difficulty) {
            case EASY:
                for(int i = 0; i < 10; i ++) {
                    int x = new Random().nextInt(10);
                    int y = new Random().nextInt(10);
                    if(!bombs.contains(new Coordinate(x, y))) {
                        bombs.add(new Coordinate(x, y));
                    }
                }
                break;
            case MEDIUM:
                for(int i = 0; i < 20; i ++) {
                    int x = new Random().nextInt(10);
                    int y = new Random().nextInt(10);
                    if(!bombs.contains(new Coordinate(x, y))) {
                        bombs.add(new Coordinate(x, y));
                    }
                }
                break;
            case HARD:
                for(int i = 0; i < 30; i ++) {
                    int x = new Random().nextInt(10);
                    int y = new Random().nextInt(10);
                    if(!bombs.contains(new Coordinate(x, y))) {
                        bombs.add(new Coordinate(x, y));
                    }
                }
                break;
            default:
                throw new RuntimeException("Impossible!");
        }

        Board board = new Board(bombs);
        System.out.println(board);
        while(!board.isDead() && !board.hasWon()) {
            System.out.println("Please select a place you want to hit:");
            System.out.print("x:");
            int xCoordinate = Integer.parseInt(scanner.nextLine());

            System.out.print("y:");
            int yCoordinate = Integer.parseInt(scanner.nextLine());

            board.hit(new Coordinate(xCoordinate, yCoordinate));
            System.out.println(board);
        }

        if(board.isDead()) {
            System.out.println("You've lost!");
        } else {
            System.out.println("You've won!");
        }
    }
}
