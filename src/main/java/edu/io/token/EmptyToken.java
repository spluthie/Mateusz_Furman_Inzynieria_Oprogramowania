package edu.io.token;

public class EmptyToken extends Token{
    public String label;

    public EmptyToken(){
        super(Label.EMPTY_TOKEN_LABEL);
    }
}
