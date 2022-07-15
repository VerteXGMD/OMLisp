/**
 * MIT License
 *
 * Copyright (c) 2022 Adi Salimgereyev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
