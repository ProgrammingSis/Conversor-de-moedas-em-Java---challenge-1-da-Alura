import java.util.Scanner;

/* ok, anotações de variáveis não estão funcionando e ainda não sei o motivo. AAAAAAAAAAAAAAAAAAAAA
///@param
*/

//Reads the command and the currencies being converted in this aplication
public class CommandReader {


    private final Scanner read = new Scanner(System.in);
    private int command;
    private double ValueToBeConverted;

    //reads the command and stores it inside the CommandReader object created (instanciado)
    public void readCommand(){
        this.command = this.read.nextInt();
    }

    public void readValueToBeConverted(){
        this.ValueToBeConverted = read.nextDouble();
    }
    //returns the command that was read previously with readCommand
    public int getCommand(){
        return this.command;
    }

    //returns the valueToBeConverted, that was read previously with readValueToBeConverted
    public double getValueToBeConverted() {
        return ValueToBeConverted;
    }


}
