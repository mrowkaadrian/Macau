import java.util.*;

public class Table {

// ====== VARIABLES ======

    List<Card> _Center = new ArrayList<>();      // kolekcja Center (karty położone będą tutaj składowane aż do Shuffle'a)
    List<Card> _Player1 = new ArrayList<>();
    List<Card> _Player2 = new ArrayList<>();
    List<Card> _Deck = new ArrayList<>();        // kolekcja _Deck (Tutaj składowane będą potasowane karty gotowe do zebrania przez graczy)

// ====== MEMBER FUNCTIONS ======

    public void createDeck() {
        for (int i = 2; i < 15; ++i) {
            for (int j = 0; j < 4; ++j) {
                _Deck.add(new Card(Card.CardValue.returnValue(i), Card.CardColor.returnColor(j)));
            }
        }
    }

    public void shuffleDeck() {
        //TODO
    }

    public void addCardToPlayer(List<Card> Deck, List<Card> Player) {
        Player.add(drawFromDeck());

        System.out.println("Added card to Player");
    }

    public Card drawFromDeck() {
        Card toReturn = _Deck.get(_Deck.size() - 1);
        _Deck.remove(_Deck.size() - 1);

        System.out.println("Removed last card");

        return toReturn;
    }

    public static void main(String [] args) {

        Table table = new Table();
        table.createDeck();
    }
}

