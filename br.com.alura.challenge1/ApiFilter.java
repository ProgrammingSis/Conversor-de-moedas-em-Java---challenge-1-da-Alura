import java.util.Map;

import static java.lang.Double.parseDouble;

public class ApiFilter {
    private Map<String, Double> conversion_rates;

    public double getRate(String currency) {
        return conversion_rates.get(currency);
    }

    @Override
    public String toString() {
        return "BRL: [" + getRate("BRL") + "]" +
                " COP: [" + getRate("COP") +
                "] ARS: [" + getRate("ARS") +
                "] USD: [" + getRate("USD") + "]";
    }
}
