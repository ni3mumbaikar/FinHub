package herokuapp.com.finhublti.models;

import javax.persistence.*;

@Entity
@Table(name = "cardtype")
public class CardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int card_type;
    String card_name;

    @OneToOne(mappedBy = "ct", cascade = CascadeType.ALL)

    @JoinColumn(name = "card_type", insertable = false, updatable = false)
    Card c;

    public CardType() {
        super();
    }


    public Card getC() {
        return c;
    }

    public void setC(Card c) {
        this.c = c;
    }

    public CardType(int card_type, String card_name) {
        super();
        this.card_type = card_type;
        this.card_name = card_name;
    }

    public int getCard_type() {
        return card_type;
    }

    public void setCard_type(int card_type) {
        this.card_type = card_type;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }


}
