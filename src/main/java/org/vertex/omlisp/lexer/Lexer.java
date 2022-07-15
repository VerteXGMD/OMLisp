package org.vertex.omlisp.lexer;

import org.vertex.omlisp.token.*;

public class Lexer {
    private final String filename;
    private final String content;
    private final CodeLocation currentLocation;
    private char currentCharacter;

    public Lexer(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.currentLocation = new CodeLocation(1, 0, 0);
        this.currentCharacter = (content.length() != 0) ?
                content.charAt(0) : '\0';
    }

    private void advance() {
        currentLocation.advance(currentCharacter == '\n');
        currentCharacter = content.charAt(currentLocation.getIndex());
    }

    public Token nextToken() {
        if (currentCharacter == '\0') {
            return new Token(TokenKind.EOF, new CodePartLocation(
                    currentLocation,
                    currentLocation.getAdvanced()),
                    new TokenValue('\0'));
        }

        if (Character.isDigit(currentCharacter)) {
            return nextNumberToken();
        }

        Token token = new Token(TokenKind.UNEXCEPTED_CHARACTER_ERROR,
                new CodePartLocation(
                        currentLocation,
                        currentLocation.getAdvanced()),
                new TokenValue(currentCharacter));
        advance();
        return token;
    }

    private Token nextNumberToken() {
        double numberValue = 0;
        int currentDigitIndex = 0;

        CodeLocation startLocation = currentLocation.clone();

        while (Character.isDigit(currentCharacter)) {
            numberValue += (currentCharacter - '0') * Math.pow(
                    10, currentDigitIndex);
            advance();
        }

        return new Token(TokenKind.NUMBER, new CodePartLocation(
                startLocation,
                currentLocation
                ), new TokenValue(numberValue));
    }

    public String getFilename() {
        return filename;
    }
}
