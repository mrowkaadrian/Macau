public class Card {

// ====== ENUMERATION ======

    public enum CardValue {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, JOKER
    }

    public enum CardColor {
        HEART, DIAMOND, CLUB, SPADE
    }

// ====== VARIABLES ======

    private CardValue value;
    private CardColor color;

    private CardValue valueRequested = null;    //When somebody placed jack and requested some value, this variable is being changed.
    private CardColor colorRequested = null;    //When somebody placed ace and requested some color, this variable is being changed.

// ====== CONSTRUCTOR ======

    public Card (CardValue value, CardColor color) {
        this.value = value;
        this.color = color;
    }

// ====== GETTER/SETTER ======

    public void setValue(CardValue value) {
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public CardColor getColor() {
        return color;
    }

// ====== MEMBER FUNCTIONS ======

    boolean isPlacable(Card cardPlacedBefore) {

        if (cardPlacedBefore.color == this.color)
            return true;

        if (cardPlacedBefore.value == this.value)
            return true;

        return false;

    }

    boolean isPlacableAfterRequest(Card cardPlacedBefore) {
        if ((cardPlacedBefore.valueRequested == null) && (cardPlacedBefore.colorRequested == this.color)) {
            return true;
        }

        if ((cardPlacedBefore.colorRequested == null) && (cardPlacedBefore.valueRequested == this.value)) {
            return true;
        }
        if ((cardPlacedBefore.colorRequested == null) && (cardPlacedBefore.valueRequested == null))
            return isPlacable(cardPlacedBefore);

        return false;
    }


    // === Card Exceptions ===
    boolean isPlacableTwo (Card cardPlacedBefore) {
        if (this.value == CardValue.TWO)
            return true;

        if ((cardPlacedBefore.color == this.color) && ((this.value == CardValue.KING) || (this.value == CardValue.THREE)) )
            return true;

        return false;
    }

    boolean isPlacableThree (Card cardPlacedBefore) {
        if (this.value == CardValue.THREE)
            return true;

        if ((cardPlacedBefore.color == this.color) && ((this.value == CardValue.KING) || (this.value == CardValue.TWO)) )
            return true;

        return false;
    }

    boolean isPlacableKing (Card cardPlacedBefore) {
        if (this.value == CardValue.KING)
            return true;

        if ((cardPlacedBefore.color == this.color) && ((this.value == CardValue.THREE) || (this.value == CardValue.TWO)) )
            return true;

        return false;
    }

    boolean isPlacableFour () {
        if (this.value == CardValue.FOUR)
            return true;

        return false;
    }
}
