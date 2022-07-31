package herokuapp.com.finhublti.services;

import herokuapp.com.finhublti.models.Card;
import herokuapp.com.finhublti.models.CardType;
import herokuapp.com.finhublti.repositories.CardTypeRepository;
import herokuapp.com.finhublti.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardTypeService {
    @Autowired
    CardTypeRepository cardTypeRepository;

    public ResponseEntity<List<CardType>> getCardTypes() {
        return new ResponseEntity<>(cardTypeRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<CardType> getCardType(String cid) {
        try {
            Optional<CardType> cardTypeData = cardTypeRepository.findById(Integer.parseInt(cid));
            return cardTypeData.map(cardType -> new ResponseEntity<>(cardType, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
