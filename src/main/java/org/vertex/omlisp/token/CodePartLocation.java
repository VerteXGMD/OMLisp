package org.vertex.omlisp.token;

public class CodePartLocation {
    private final CodeLocation startLocation, endLocation;

    public CodePartLocation(CodeLocation startLocation, CodeLocation endLocation) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public CodeLocation getStartLocation() {
        return startLocation;
    }

    public CodeLocation getEndLocation() {
        return endLocation;
    }
}
