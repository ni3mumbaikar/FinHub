package herokuapp.com.finhublti.services;

import herokuapp.com.finhublti.models.Bank;
import herokuapp.com.finhublti.models.Card;
import herokuapp.com.finhublti.repositories.BankRepository;
import herokuapp.com.finhublti.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardsService {
    @Autowired
    CardsRepository cardsRepository;

    public ResponseEntity<List<Card>> getCards() {
        return new ResponseEntity<>(cardsRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Card> getCard(String cid) {
        try {
            Optional<Card> cardData = cardsRepository.findById(Long.parseLong(cid));
            return cardData.map(documents -> new ResponseEntity<>(documents, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
