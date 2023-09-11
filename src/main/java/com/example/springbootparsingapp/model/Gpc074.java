package com.example.springbootparsingapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Entity(name = "listing")
@NoArgsConstructor
@Data
public class Gpc074 extends GpcRecordList   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderId_seq_gen")
    @SequenceGenerator(name = "orderId_seq_gen", sequenceName = "orderId_id_seq")
    private Long id;

    private String recordType;
    private String accountNumber;
    private String beneficiaryName;
    private LocalDate startDate;
    private double startBalance;
    private char startBalanceSign;
    private double endBalance;
    private char endBalanceSign;
    private double debitTotal;
    private char debitSign;
    private double creditTotal;
    private char creditSign;
    private int statementNumber;
    private LocalDate statementDate;

    @Override
    public String toString() {
        return "Listing header{" +
                "recordType='" + recordType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", startDate=" + startDate +
                ", startBalance=" + startBalance +
                ", startBalanceSign=" + startBalanceSign +
                ", endBalance=" + endBalance +
                ", endBalanceSign=" + endBalanceSign +
                ", debitTotal=" + debitTotal +
                ", debitSign=" + debitSign +
                ", creditTotal=" + creditTotal +
                ", creditSign=" + creditSign +
                ", statementNumber=" + statementNumber +
                ", statementDate=" + statementDate +
                '}';
    }

    public Gpc074(String data) {
        this.recordType = data.substring(0, 3).trim();
        this.accountNumber = data.substring(3, 19).trim();
        this.beneficiaryName = data.substring(19, 39).trim();
        this.startDate = LocalDate.of(2000 + Integer.parseInt(data.substring(39, 41)),
                Integer.parseInt(data.substring(41, 43)), Integer.parseInt(data.substring(43, 45)));
        this.startBalance = Double.parseDouble(data.substring(45, 57) + "." + data.substring(57, 59));
        this.startBalanceSign = data.charAt(59);
        this.endBalance = Double.parseDouble(data.substring(60, 72) + "." + data.substring(72, 74));
        this.endBalanceSign = data.charAt(74);
        this.debitTotal = Double.parseDouble(data.substring(75, 87) + "." + data.substring(87, 89));
        this.debitSign = data.charAt(89);
        this.creditTotal = Double.parseDouble(data.substring(90, 102) + "." + data.substring(102, 104));
        this.creditSign = data.charAt(104);
        this.statementNumber = Integer.parseInt(data.substring(105, 108));
        this.statementDate = LocalDate.of(2000 + Integer.parseInt(data.substring(108, 110)),
                Integer.parseInt(data.substring(110, 112)), Integer.parseInt(data.substring(112, 114)));
    }
}
