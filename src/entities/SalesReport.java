package entities;

import java.util.Map;

public class SalesReport {
    private Map<String, Double> saleByCustomer;

    public SalesReport(Map<String, Double> saleByCustomer) {
        this.saleByCustomer = saleByCustomer;
    }

    public Map<String, Double> getSaleByCustomer() {
        return saleByCustomer;
    }

    public void setSaleByCustomer(Map<String, Double> saleByCustomer) {
        this.saleByCustomer = saleByCustomer;
    }

    @Override
    public String toString() {
        return "SalesReport{" +
                "saleByCustomer=" + saleByCustomer +
                '}';
    }
}
