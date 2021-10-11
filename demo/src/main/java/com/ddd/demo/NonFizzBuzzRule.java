package com.ddd.demo;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;

@Rule
public class NonFizzBuzzRule {

    private int input;

    @Condition
    public boolean isNotFizzNorBuzz() {
        // can return true here
        return input % 5 != 0 || input % 7 != 0;
    }

    @Action
    public void printInput() {
        System.out.print(input);
    }

    public void setInput(int input) {
        this.input = input;
    }

    @Priority
    public int getPriority() {
        return 3;
    }
}
