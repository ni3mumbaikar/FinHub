package herokuapp.com.finhublti.models;

public class CardType {

int card_type;
String card_name;
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

public CardType() {
	super();
}
public CardType(int card_type, String card_name) {
	super();
	this.card_type = card_type;
	this.card_name = card_name;
}
 
	
}
