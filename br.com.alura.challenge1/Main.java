import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        int command = 0;
        double value;
        System.out.println("The currency converter is initializing...");

        while(true) {

            System.out.println("\n -----------------------------------------------------");
            System.out.println("Commands (type one of the 7 numbers below):");
            System.out.println("""
                    1 - Dollar =>> Brazilian real
                    2 - Brazilian real =>>  Dollar
                    3 - Colombian peso =>>  Brazilian real
                    4 - Brazilian real =>>  Colombian peso
                    5 - Argentine Peso =>>  Dollar
                    6 - Dollar         =>>  Argentine peso
          
                    7 - Exit
                    """);
            System.out.println("-----------------------------------------------------");

            System.out.println("Type a valid command:");

            //I'll put a loop here, as if it was the main function of this code
            CommandReader commandReader = new CommandReader();

            //read the commando from the terminal
            commandReader.readCommand();
            command = commandReader.getCommand();

            if(command == 7) break;

            CommandExecutor commandExecutor = new CommandExecutor();

            //it reads the value that you want to be converting into another currency value
            System.out.println("Type the value you want to convert:");
            commandReader.readValueToBeConverted();
            value = commandReader.getValueToBeConverted();

            double result = commandExecutor.executeCommand(command, value);
            System.out.println("The result of the conversion is: " + result);
        }
    }
}
