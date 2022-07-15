package org.vertex.omlisp.lexer;

import org.junit.Assert;
import org.junit.Test;
import org.vertex.omlisp.token.TokenKind;

public class LexerTest {
    @Test
    public void testEOF() {
        Assert.assertEquals(TokenKind.EOF, new Lexer(
                "<input>", "\0").nextToken().getKind());
    }
}
