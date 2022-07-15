package org.vertex.omlisp.token;

public class Token {
    private final TokenKind kind;
    private final CodePartLocation codePartLocation;
    private final TokenValue value;

    public Token(TokenKind kind, CodePartLocation codePartLocation,
                 TokenValue value) {
        this.kind = kind;
        this.codePartLocation = codePartLocation;
        this.value = value;
    }

    public TokenKind getKind() {
        return kind;
    }

    public CodePartLocation getCodePartLocation() {
        return codePartLocation;
    }

    public TokenValue getValue() {
        return value;
    }
}
