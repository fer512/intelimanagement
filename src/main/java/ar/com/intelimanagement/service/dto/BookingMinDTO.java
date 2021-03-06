package ar.com.intelimanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * A DTO for the Booking entity.
 */
public class BookingMinDTO implements Serializable {

    private Long id;

    private String idTransaction;

    private String detail;

    @NotNull
    private String paymentType;

    private Double paymentCreditCard;

    private Integer paymentPointsInUSD;

    @NotNull
    private Double juniperSalePrice;

    @NotNull
    private Double juniperReservationCost;

    private Double benefitInReservation;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getPaymentCreditCard() {
        return paymentCreditCard;
    }

    public void setPaymentCreditCard(Double paymentCreditCard) {
        this.paymentCreditCard = paymentCreditCard;
    }

    public Integer getPaymentPointsInUSD() {
        return paymentPointsInUSD;
    }

    public void setPaymentPointsInUSD(Integer paymentPointsInUSD) {
        this.paymentPointsInUSD = paymentPointsInUSD;
    }

    public Double getJuniperSalePrice() {
        return juniperSalePrice;
    }

    public void setJuniperSalePrice(Double juniperSalePrice) {
        this.juniperSalePrice = juniperSalePrice;
    }

    public Double getJuniperReservationCost() {
        return juniperReservationCost;
    }

    public void setJuniperReservationCost(Double juniperReservationCost) {
        this.juniperReservationCost = juniperReservationCost;
    }

    public Double getBenefitInReservation() {
        return benefitInReservation;
    }

    public void setBenefitInReservation(Double benefitInReservation) {
        this.benefitInReservation = benefitInReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookingMinDTO bookingDTO = (BookingMinDTO) o;
        if (bookingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bookingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
            "id=" + getId() +
            ", idTransaction='" + getIdTransaction() + "'" +
            ", detail='" + getDetail() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            ", paymentCreditCard=" + getPaymentCreditCard() +
            ", paymentPointsInUSD=" + getPaymentPointsInUSD() +
            ", juniperSalePrice=" + getJuniperSalePrice() +
            ", juniperReservationCost=" + getJuniperReservationCost() +
            ", benefitInReservation=" + getBenefitInReservation() +
            "}";
    }

}
