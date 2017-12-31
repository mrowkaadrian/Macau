public class Card {

// ====== ENUMERATION ======

    public enum CardValue {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), JOKER(14);

        private final int value;
        CardValue(int value) {
            this.value = value;
        }

        static public CardValue returnValue(int value) {
            switch (value) {
                case 2: return TWO;
                case 3: return THREE;
                case 4: return FOUR;
                case 5: return FIVE;
                case 6: return SIX;
                case 7: return SEVEN;
                case 8: return EIGHT;
                case 9: return NINE;
                case 10: return TEN;
                case 11: return JACK;
                case 12: return QUEEN;
                case 13: return KING;
                case 14: return JOKER;

                default: return null;
            }
        }

        public int getValue() {
            return value;
        }
    }

    public enum CardColor {
        HEART(0), DIAMOND(1), CLUB(2), SPADE(3);

        private final int value;
        CardColor(int value) {
            this.value = value;
        }

        static public CardColor returnColor(int value) {
            switch (value) {
                case 0: return HEART;
                case 1: return DIAMOND;
                case 2: return CLUB;
                case 3: return SPADE;

                default: return null;
            }
        }

        public int getValue() {
            return value;
        }
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
