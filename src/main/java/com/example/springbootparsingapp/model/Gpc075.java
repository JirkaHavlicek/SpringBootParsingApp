package com.example.springbootparsingapp.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity(name = "movement")
@NoArgsConstructor
@Data
public class Gpc075 extends GpcRecordList  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderId_seq_gen")
    @SequenceGenerator(name = "orderId_seq_gen", sequenceName = "orderId_id_seq")
    private Long id;

    private String recordType;
    private String accountNumberMovement;
    private String counterpartAccountNumberMovement;
    private String transactionIdentifier;
    private double transactionAmount;
    private int transactionCode;
    private String variableSymbol;
    private String separator;
    private String bankCode;
    private String constantSymbol;
    private String specificSymbol;
    private LocalDate currencyDate;
    private String counterParty;
    private String currencyNumber;
    private LocalDate postingDate;

    @Override
    public String toString() {
        return "Movement on the account{" +
                "recordType='" + recordType + '\'' +
                ", accountNumber='" + accountNumberMovement + '\'' +
                ", counterpartAccountNumber='" + counterpartAccountNumberMovement + '\'' +
                ", transactionIdentifier='" + transactionIdentifier + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionCode=" + transactionCode +
                ", variableSymbol='" + variableSymbol + '\'' +
                ", separator='" + separator + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", constantSymbol='" + constantSymbol + '\'' +
                ", specificSymbol='" + specificSymbol + '\'' +
                ", currencyDate='" + currencyDate + '\'' +
                ", counterParty=" + counterParty +
                ", currencyNumber='" + currencyNumber + '\'' +
                ", postingDate=" + postingDate +
                '}';
    }

    public Gpc075(String data) {
        this.recordType = data.substring(0, 3).trim();
        this.accountNumberMovement = data.substring(3, 19).trim();
        this.counterpartAccountNumberMovement = data.substring(19, 35).trim();
        this.transactionIdentifier = data.substring(35, 48).trim();
        this.transactionAmount = Double.parseDouble(data.substring(48, 58) + "." + data.substring(58, 60));
        this.transactionCode = Integer.parseInt(data.substring(60, 61));
        this.variableSymbol = data.substring(61, 71).trim();
        this.separator = data.substring(71, 73).trim();
        this.bankCode = data.substring(73, 77).trim();
        this.constantSymbol = data.substring(77, 81).trim();
        this.specificSymbol = data.substring(81, 91).trim();
        this.currencyDate = LocalDate.of(2000 + Integer.parseInt(data.substring(91, 93)),
                Integer.parseInt(data.substring(93, 95)), Integer.parseInt(data.substring(95, 97)));
        this.counterParty = data.substring(97, 117).trim();
        this.currencyNumber = data.substring(117, 122).trim();
        this.postingDate = LocalDate.of(2000 + Integer.parseInt(data.substring(122, 124)),
                Integer.parseInt(data.substring(124, 126)), Integer.parseInt(data.substring(126, 128)));
    }
}