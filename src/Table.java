import java.util.*;

public class Table {

// ====== VARIABLES ======

    List<Card> _Center = new ArrayList<>();
    List<Card> _Player1 = new ArrayList<>();
    List<Card> _Player2 = new ArrayList<>();
    List<Card> _Deck = new ArrayList<>();

// ====== MEMBER FUNCTIONS ======

    public void startGame() {
        createDeck();
        shuffleDeck();
        for (int i = 0; i < 5; ++i) {
            addCardToPlayer(_Player1);
            addCardToPlayer(_Player2);
        }
        addCardToPlayer(_Center);
    }

    public void createDeck() {
        for (int i = 2; i < 15; ++i) {
            for (int j = 0; j < 4; ++j) {
                _Deck.add(new Card(Card.CardValue.returnValue(i), Card.CardColor.returnColor(j)));
            }
        }
    }

    public void shuffleDeck() {
        long seed = System.nanoTime();
        Collections.shuffle(_Deck, new Random(seed)); // not sure if that works, ---TO CHECK---
    }

    public void addCardToPlayer(List<Card> Player) {
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
        table.startGame();
        while (table._Player1.size() != 0 && table._Player2.size() != 0) {
            // Actual game loop
            // table._Player1.size() != 0     ->     break
            // table._Player2.size() != 0     ->     break
        }

        if (table._Player1.size() == 0)
            System.out.println("Player 1 wins!");
        else if (table._Player2.size() == 0)
            System.out.println("Player 2 wins!");
        else
            System.out.println("Why the hell it went out of the loop? Fix it!");
    }
}

