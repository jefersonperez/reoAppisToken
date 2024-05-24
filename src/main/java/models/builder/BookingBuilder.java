package models.builder;

import models.BookingModel;


public class BookingBuilder {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingModel.BookingDates bookingdates = new BookingModel.BookingDates();
    private String additionalneeds;

    public BookingBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public BookingBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public BookingBuilder withTotalprice(int totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BookingBuilder withDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    public BookingBuilder withCheckin(String checkin) {
        this.bookingdates.setCheckin(checkin);
        return this;
    }

    public BookingBuilder withCheckout(String checkout) {
        this.bookingdates.setCheckout(checkout);
        return this;
    }

    public BookingBuilder withAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public BookingModel.BookingDates getBookingdates() {
        return bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public BookingModel build() {
        return new BookingModel(this);
    }
}
