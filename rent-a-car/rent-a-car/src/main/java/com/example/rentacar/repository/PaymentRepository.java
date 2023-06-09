package com.example.rentacar.repository;

import com.example.rentacar.business.dto.requests.create.payment.CreatePaymentRequest;
import com.example.rentacar.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Payment findByCardNumber(String cardNumber);
    boolean existsByCardNumber(String cardNumber);

    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
            String cardNumber,
            String cardHolder,
            int cardExpirationYear,
            int cardExpirationMonth,
            String cardCvv
    );


    /*
    // SPeL - > Spring Expression Lenguages
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END "+
            "FROM Payment p WHERE p.cardNumber = :#{paymentRequest.cardNumber}"+
            " AND p.cardHolder = :#{paymentRequest.cardHolder} AND"+
            " p.cardExpirationYear = :#{paymentRequest.cardExpirationYear} AND"+
            " p.cardExpirationMonth = :#{paymentRequest.cardExpirationMonth} AND "+
            " p.cardCvv = :#{paymentRequest.cardCvv}"
    )
    boolean existsByCardNumberAndCardHolderAndCardExprirationYearAndCardExpirationMonthAndCardCvv(
            @Param("paymentRequest")CreatePaymentRequest paymentRequest);

    */


}
