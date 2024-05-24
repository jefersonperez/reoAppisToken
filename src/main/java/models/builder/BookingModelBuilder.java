package models.builder;

import models.BookingModel;
import models.GetBookingModel;
import models.BookingModel.BookingDates;

public class BookingModelBuilder {
    private String firstName;
    private String lastName;
    private int totalPrice;
    private boolean depositPaid;
    private String checkIn;
    private String checkOut;
    private String additionalNeeds;

    public BookingModelBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BookingModelBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BookingModelBuilder withTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public BookingModelBuilder withDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
        return this;
    }

    public BookingModelBuilder withCheckIn(String checkIn) {
        this.checkIn = checkIn;
        return this;
    }

    public BookingModelBuilder withCheckOut(String checkOut) {
        this.checkOut = checkOut;
        return this;
    }

    public BookingModelBuilder withAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
        return this;
    }

    public GetBookingModel build() {
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(this.checkIn);
        bookingDates.setCheckout(this.checkOut);

        GetBookingModel booking = new GetBookingModel();
        booking.setFirstname(this.firstName);
        booking.setLastname(this.lastName);
        booking.setTotalprice(this.totalPrice);
        booking.setDepositpaid(this.depositPaid);
       // booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds(this.additionalNeeds);

        return booking;
    }
}
