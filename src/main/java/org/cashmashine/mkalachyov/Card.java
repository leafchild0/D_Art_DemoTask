package org.cashmashine.mkalachyov;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/*TODO Add named queries for fast access*/
@Entity
@Table(name = "cards")
public class Card {


    @Id
    @GeneratedValue
    private Long card_id;
    private BigDecimal currentBalance;
    private short pin;
    private boolean isLocked;



    @OneToMany
    @JoinTable(name = "jnd_cards_transactions", joinColumns = @JoinColumn(name = "card_fk"), inverseJoinColumns = @JoinColumn(name = "transaction_fk"))
    private List<CardTransaction> trasactions;


    public Card() {
    }

    public Card(short pin, BigDecimal currentBalance) {
        this.pin = pin;
        this.currentBalance = currentBalance;
    }


    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal current_balance) {
        this.currentBalance = current_balance;
    }

    public short getPin() {
        return pin;
    }

    public void setPin(short pin) {
        this.pin = pin;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public List<CardTransaction> getTrasactions() {
        return trasactions;
    }

    public void setTrasactions(List<CardTransaction> trasactions) {
        this.trasactions = trasactions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Card");
        sb.append("{id=").append(card_id);
        sb.append(", pin='").append(pin);
        sb.append(", isLocked='").append(isLocked);
        sb.append('}');
        return sb.toString();
    }
}