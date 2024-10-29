import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Runner {
    private final Table table = new Table();
    private Player player;

    public void run(String file) {
        try (Scanner scanner = new Scanner(new File(file))) {
            while (scanner.hasNextLine()) {
                execute(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read file");
        }
    }

    private void execute(String command) {
        if (Objects.isNull(player) && !command.startsWith("PLACE")) {
            System.out.println("'PLACE' needs to be the first command");
            return;
        }

        if (command.startsWith("PLACE")) {
            initPlace(command);
            return;
        }
        if (command.equals("MOVE")) {
            movePlayerIfValid();
            return;
        }
        if (command.equals("LEFT")) {
            player.turnLeft();
            return;
        }
        if (command.equals("RIGHT")) {
            player.turnRight();
            return;
        }
        if (command.equals("REPORT")) {
            System.out.println(player.report());
            return;
        }

        throw new IllegalArgumentException("Unkown command " + command);
    }

    private void initPlace(String command) {
        final String[] parts = command.split("[, ]+");
        final int x = Integer.parseInt(parts[1]);
        final int y = Integer.parseInt(parts[2]);
        final String direction = parts[3];
        place(x, y, direction);
    }

    private void place(int x, int y, String direction) {
        final Direction dir = Direction.valueOf(direction.toUpperCase());
        if (table.isValidPosition(x, y)) {
            player = new Player(x, y, dir);
        }
    }

    private void movePlayerIfValid() {
        final Player tempPlayer = new Player(player.getX(), player.getY(), player.getDirection());
        tempPlayer.move();

        if (table.isValidPosition(tempPlayer.getX(), tempPlayer.getY())) {
            player.move();
        }
    }

}
