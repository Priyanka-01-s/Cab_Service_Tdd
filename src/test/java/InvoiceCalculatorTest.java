import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.CaBInvoiceGenerator;
import com.example.Invoice;
import com.example.InvoiceService;
import com.example.RideRepository;
import com.example.Rides;

public class InvoiceCalculatorTest {

    @Test
    public void testCalculatorFare() {
        CaBInvoiceGenerator invoiceGenerator = new CaBInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(5, 15, "Normal");

        assertEquals(65, fare); // 5km *10 + 15min*1

    }

    @Test
    public void testMinFare() {
        CaBInvoiceGenerator invoiceGenerator = new CaBInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(2, 5, "Normal");

        assertEquals(25, fare); // 5km *10 + 15min*1

    }

    @Test
    public void TestMulltipleRides() {
        CaBInvoiceGenerator invoiceGenerator = new CaBInvoiceGenerator();
        Rides[] ride = { new Rides(4, 20, "Normal"), new Rides(1, 5, "Normal") };
        double fare = invoiceGenerator.calAggregateTotal(ride);

        assertEquals(75, fare); // 4 *10 +20*1 + 1*10 +5*1 =75
    }

    @Test
    public void TestEnhanceInvoice() {
        CaBInvoiceGenerator invoiceGenerator = new CaBInvoiceGenerator();
        Rides[] ride = { new Rides(4, 20, "Normal"), new Rides(1, 5, "Normal"), new Rides(3, 10, "Normal") };

        Invoice invoice = invoiceGenerator.invoiceInformation(ride);

        assertEquals(3, invoice.getTotalRides());
        assertEquals(115, invoice.getTotalFare()); // 75+ 30+10 = 115
        assertEquals(38.333333333333336, invoice.getavgFare());

        // Invoice invoice = new Invoice();
        // double fare = invoiceGenerator.calculateFare(2,5);

        // assertEquals(25,fare);
    }

    @Test
    public void TestUserRideRepository() {
        RideRepository rideRepository = new RideRepository();
        InvoiceService invoiceService = new InvoiceService(rideRepository);

        rideRepository.addRide(1, new Rides(4, 15, "Normal"));
        rideRepository.addRide(2, new Rides(5, 10, "Normal"));
        rideRepository.addRide(3, new Rides(2, 5, "Normal"));

        // for user 1
        Invoice invoice = invoiceService.generateInvoiceForUser(1);

        assertEquals(1, invoice.getTotalRides());
        assertEquals(55, invoice.getTotalFare());
        assertEquals(55, invoice.getavgFare());
    }

    @Test
    public void testCalculateFareForNormalRide() {
        CaBInvoiceGenerator invoiceGenerator = new CaBInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(5, 15, "Normal");

        assertEquals(65, fare); // 5km * 10 + 15min * 1
    }

    @Test
    public void testCalculateFareForPremiumRide() {
        CaBInvoiceGenerator invoiceGenerator = new CaBInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(5, 15, "Premium");

        assertEquals(105, fare);
    }

}
