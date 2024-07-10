import java.io.IOException;

//executes the actual conversions with math operations and if, elses to choose the next step.
//it might need the help of the command reader and the conversionValues
//RETURNS the converted values
public class CommandExecutor {

    private String currencyToBeConverted;
    private String targetCurrency;

    public String getTargetCurrency(){
        return targetCurrency;
    }

    public String getCurrencyToBeConverted(){
        return currencyToBeConverted;
    }

    //Api reader is gonna need this because of the currencyToBeConverted and
    // the targetCurrency, that will be needed to read to API
    public double executeCommand(int command, double value) throws IOException, InterruptedException {
        ApiReader apiReader = new ApiReader();

        //object that stores all the current data necessary for the conversions of this application,
        // will only have a value once currencyToBeConverted is discovered, on one of the conditions
        // below
        ApiFilter currencyConversionData;

        double result = 0; //result to be returned and printed on UserInterface
        switch(command){

            case 1:
                this.currencyToBeConverted = "USD";
                this.targetCurrency = "BRL"; //not necessary?

                currencyConversionData =  apiReader.readApi(currencyToBeConverted);
                result = value * currencyConversionData.getRate(targetCurrency);
//
                break;
            case 2:
                this.currencyToBeConverted = "BRL";
                this.targetCurrency = "USD";

                currencyConversionData =  apiReader.readApi(currencyToBeConverted);
                result = value * currencyConversionData.getRate(targetCurrency);


                break;
            case 3:
                this.currencyToBeConverted = "COP";
                this.targetCurrency = "BRL";

                currencyConversionData =  apiReader.readApi(currencyToBeConverted);
                result = value * currencyConversionData.getRate(targetCurrency);

                break;
            case 4:
                this.currencyToBeConverted = "BRL";
                this.targetCurrency = "COP";

                currencyConversionData =  apiReader.readApi(currencyToBeConverted);
                result = value * currencyConversionData.getRate(targetCurrency);

                break;
            case 5:
                this.currencyToBeConverted = "ARS";
                this.targetCurrency = "USD";

                currencyConversionData =  apiReader.readApi(currencyToBeConverted);
                result = value * currencyConversionData.getRate(targetCurrency);

                break;
            case 6:
                this.currencyToBeConverted = "USD";
                this.targetCurrency = "ARS";

                currencyConversionData =  apiReader.readApi(currencyToBeConverted);
                result = value * currencyConversionData.getRate(targetCurrency);



                break;
        }

        if(result ==  0){
        System.out.println("Invalid command was typed or 'result' wasn't allocated properly.");
            return 0;
        }

        return result;



    }



}
