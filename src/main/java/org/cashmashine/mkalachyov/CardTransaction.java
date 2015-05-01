package org.cashmashine.mkalachyov;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/*TODO Add named queries for fast access*/
@Entity
@Table(name = "Transactions")
public class CardTransaction {

    @Id
    @GeneratedValue
    private Long cardTransaction_id;
    @NotNull
    private String cardTransactionCode;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cardTranaactionDate;
    private BigDecimal transactionAmount;

    public CardTransaction() {
    }

    public CardTransaction (String cardTransactionCode, Date cardTranaactionDate, BigDecimal transactionAmount) {
        this.cardTransactionCode = cardTransactionCode;
        this.cardTranaactionDate = cardTranaactionDate;
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CardTransaction");
        sb.append("{cardTransaction_id=").append(cardTransaction_id);
        sb.append(", transactionAmount='").append(transactionAmount);
        sb.append(", cardTransactionCode='").append(cardTransactionCode);
        sb.append(", cardTranaactionDate='").append(cardTranaactionDate);
        sb.append('}');
        return sb.toString();
    }
}
