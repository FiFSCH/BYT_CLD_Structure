package Tests;

import Models.Offer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.time.LocalDate;
import java.util.Optional;

public class OfferTest {
    static LocalDate currentDate = LocalDate.now();
    /**
     * Because I wrapped optional attributes inside Optional Class, we have to create those values in the way showed below;
     */
    static String samplePublisher = "SamplePublisher";
    static Optional<String> publisher = Optional.of(samplePublisher);
    static Offer offer1;
    static Offer offer2;

    @BeforeAll //not "BeforeEach" because of the way that ids are auto assigned
    public static void setUp() throws IndexOutOfBoundsException {
        //In case of values wrapped inside Optional class
        //it is better to use Optional.empty() instead of null, but I used null for clarity.
        offer1 = new Offer(currentDate, null, "SampleTitle", 2, "Author1", null, 1, null);
        offer2 = new Offer(currentDate, null, "SampleTitle2", 2, "Author2", publisher, 1, null);
    }

    @Test
    public void checkIfExist() {
        Assertions.assertNotNull(offer1);
        Assertions.assertNotNull(offer2);
    }

    @Test
    public void checkId() {
        Assertions.assertEquals(1, offer1.getId(), "Values should be the same!");
        Assertions.assertEquals(2, offer2.getId(), "Values should be the same!");
    }

    @Test
    public void testGetDateAdded() {
        LocalDate newDate = LocalDate.now();
        Assertions.assertEquals(newDate, offer1.getDateAdded(), "Dates should be the same!");
    }

    @Test
    public void testSetDateAdded() {
        LocalDate newDate = LocalDate.of(2009, 9, 12);
        offer1.setDateAdded(newDate);
        Assertions.assertEquals(newDate, offer1.getDateAdded(), "Dates should be the same!");
        offer1.setDateAdded(currentDate);
        Assertions.assertEquals(currentDate, offer1.getDateAdded(), "Dates should be the same!");
    }

    @Test
    public void testGetDateEnded() {
        Assertions.assertNull(offer1.getDateEnded(), "Expected null!");
        Assertions.assertNull(offer2.getDateEnded(), "Expected null!");
        //Assert null because in setUp function endDates are initialized with nulls
        //Different values are checked in "testSetDateEnded"
    }

    @Test
    public void testSetDateEnded() {
        LocalDate sampleDate = LocalDate.of(2023, 10, 22);
        //Because of the use of Optional Class we have to wrap LocalDate instance in Optional
        Optional<LocalDate> endDate = Optional.of(sampleDate);
        offer1.setDateEnded(endDate);
        Assertions.assertEquals(endDate, offer1.getDateEnded(), "Objects should be the same!");
        offer1.setDateEnded(null); //better to use Optional.empty()
        Assertions.assertNull(offer1.getDateEnded());
    }

    @Test
    public void testGetBookTitle() {
        String trueSampleTitle = "SampleTitle";
        String falseSampleTitle = "DefinitelyNotABookTitle";
        Assertions.assertEquals(trueSampleTitle, offer1.getBookTitle(), "Titles should be the same!");
        Assertions.assertNotEquals(falseSampleTitle, offer2.getBookTitle(), "Titles shouldn't be equal!");
    }

    @Test
    public void testSetBookTitle() {
        String newBookTitle = "TheNewTitle";
        offer1.setBookTitle(newBookTitle);
        Assertions.assertEquals(newBookTitle, offer1.getBookTitle(), "Titles should be the same!");
        offer1.setBookTitle("SampleTitle");
        Assertions.assertEquals("SampleTitle", offer1.getBookTitle(), "Titles should be the same!");
    }

    @Test
    public void testGetBookCondition() {
        Assertions.assertEquals(Offer.getBookConditionTypes(2), offer1.getBookCondition(), "Values should be equal!");
    }

    @Test
    public void testSetBookCondition() {
        offer1.setBookCondition(1);
        Assertions.assertEquals(Offer.getBookConditionTypes(1), offer1.getBookCondition(), "Values should be the same!");
        offer1.setBookCondition(2);
        Assertions.assertEquals(Offer.getBookConditionTypes(2), offer1.getBookCondition(), "Values should be the same!");
    }

    @Test
    public void testGetBookAuthor() {
        String author1 = "Author1";
        String notAuthor2 = "NotAuthor2";
        Assertions.assertEquals(author1, offer1.getBookAuthor(), "This book should be written by the same person!");
        Assertions.assertNotEquals(notAuthor2, offer2.getBookAuthor(), "NotAuthor2 didn't write this book!");
    }

    @Test
    public void testSetBookAuthor() {
        String newAuthor = "NewAuthor";
        offer1.setBookAuthor(newAuthor);
        Assertions.assertEquals(newAuthor, offer1.getBookAuthor(), "This book should be created by 'NewAuthor'");
        offer1.setBookAuthor("Author1");
        Assertions.assertEquals("Author1", offer1.getBookAuthor(), "Values should be the same!");
    }

    @Test
    public void testGetPublishingCompany() {
        Assertions.assertNull(offer1.getPublishingCompany(), "Expected null!");
        Assertions.assertEquals(publisher, offer2.getPublishingCompany(), String.format("This book was published by %s", publisher));
    }

    @Test
    public void testSetPublishingCompany() {
        String newPublisher = "NewPublisher";
        //This string needs to be wrapped inside optional class
        Optional<String> newPublishingCompany = Optional.of(newPublisher);
        offer1.setPublishingCompany(newPublishingCompany);
        Assertions.assertEquals(newPublishingCompany, offer1.getPublishingCompany(), "Values should be equal!");
        offer1.setPublishingCompany(null); //Better to use Optional.empty()
        Assertions.assertNull(offer1.getPublishingCompany());
    }

    @Test
    public void testGetPicture() { //This test is expected to throw an exception as this method only throws it.
        Assertions.assertThrows(UnsupportedOperationException.class, () -> offer1.getPicture(), "Exception is expected!");
        Assertions.assertThrows(UnsupportedOperationException.class, () -> offer2.getPicture(), "Exception is expected!");
    }

    @Test
    public void testSetPicture() { //This test is expected to throw an exception as this method only throws it.
        Assertions.assertThrows(UnsupportedOperationException.class, () -> offer1.setPicture(null), "Exception is expected!");
        Assertions.assertThrows(UnsupportedOperationException.class, () -> offer2.setPicture(null), "Exception is expected!");
    }

    @Test
    public void testGetStatus() {
        Assertions.assertEquals(Offer.getOfferStatusTypes(1), offer1.getStatus(), "Should be the same!");
        Assertions.assertEquals(Offer.getOfferStatusTypes(1), offer2.getStatus(), "Should be the same!");
    }

    @Test
    public void testSetStatus() {
        offer1.setStatus(0);
        Assertions.assertEquals(Offer.getOfferStatusTypes(0), offer1.getStatus(), "Should be the same!");
        offer1.setStatus(1);
        Assertions.assertEquals(Offer.getOfferStatusTypes(1), offer1.getStatus(), "Should be the same!");
    }

}