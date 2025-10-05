package org.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvFileSources;

import static org.junit.jupiter.api.Assertions.*;

class TicketSystemTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Kiemthubien.csv", numLinesToSkip = 1)
    void testCalculate_Discount_Boundary(int id,int age, int quantity, String ticketType, String payment,
                                         int expected) {
        TicketSystem ts = new TicketSystem();
        double result = ts.calculateDiscount(age, quantity, ticketType, payment);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/KTbangquyetdinh.csv", numLinesToSkip = 1)
    void testCalculate_Discount_DicisionTable(int id,int age, int quantity, String ticketType, String payment,
                                         int expected) {
        TicketSystem ts = new TicketSystem();
        double result = ts.calculateDiscount(age, quantity, ticketType, payment);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/KTLuongDieuKhien.csv", numLinesToSkip = 1)
    void testCalculate_Control_Flow(int id,int age, int quantity, String ticketType, String payment,
                                             int expected) {
        TicketSystem ts = new TicketSystem();
        double result = ts.calculateDiscount(age, quantity, ticketType, payment);
        assertEquals(expected, result);
    }
}