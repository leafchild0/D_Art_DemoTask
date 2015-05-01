package org.cashmashine.mkalachyov;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/*TODO Add named queries for fast access*/
@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue
    private Long customer_id;
    @NotNull
    private String customerName;
    @OneToMany
    @JoinTable(name = "jnd_customer_cards", joinColumns = @JoinColumn(name = "customer_fk"), inverseJoinColumns = @JoinColumn(name = "card_fk"))
    private List<Card> cards;

    public Customer() {
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customer_name) {
        this.customerName = customer_name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> orderLines) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Customer");
        sb.append("{id=").append(customer_id);
        sb.append(", customer_name='").append(customerName);
        sb.append('}');
        return sb.toString();
    }
}