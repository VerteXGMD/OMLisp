package org.vertex.omlisp.token;

public class TokenValue {
    private String stringValue;
    private double numberValue;
    private boolean booleanValue;
    private char characterValue;

    public TokenValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public TokenValue(double numberValue) {
        this.numberValue = numberValue;
    }

    public TokenValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public TokenValue(char characterValue) {
        this.characterValue = characterValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public double getNumberValue() {
        return numberValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public char getCharacterValue() {
        return characterValue;
    }
}
