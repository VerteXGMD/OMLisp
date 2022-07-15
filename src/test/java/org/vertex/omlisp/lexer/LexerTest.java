package org.vertex.omlisp.lexer;

import org.junit.Assert;
import org.junit.Test;
import org.vertex.omlisp.token.Token;
import org.vertex.omlisp.token.TokenKind;

public class LexerTest {
    @Test
    public void testEOF() {
        Token token = new Lexer(
                "<input>", "\0").nextToken();

        Assert.assertEquals(TokenKind.EOF, token.getKind());
        Assert.assertEquals('\0', token.getValue().getCharacterValue());
    }

    @Test
    public void testUnexceptedToken() {
        Token token = new Lexer(
                "<input>", "[\0").nextToken();

        Assert.assertEquals(TokenKind.UNEXCEPTED_CHARACTER_ERROR, token.getKind());
        Assert.assertEquals('[', token.getValue().getCharacterValue());
    }
}
