package com.ddd.demo;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;

public class FizzBuzzWithEasyRules {

    public static void main(String[] args) {

        // create rules engine
        RulesEngine fizzBuzzEngine =
                RulesEngineBuilder.aNewRulesEngine()
                        .withSkipOnFirstAppliedRule(true) // 如果第一个规则满足条件，后面的规则将不再执行
                        .withSilentMode(true)
                        .build();

        // create rules
        FizzRule fizzRule = new FizzRule();
        BuzzRule buzzRule = new BuzzRule();
        FizzBuzzRule fizzBuzzRule
                = new FizzBuzzRule(fizzRule, buzzRule);
        NonFizzBuzzRule nonFizzBuzzRule = new NonFizzBuzzRule();

        // register rules
        fizzBuzzEngine.registerRule(fizzRule);
        fizzBuzzEngine.registerRule(buzzRule);
        fizzBuzzEngine.registerRule(fizzBuzzRule);
        fizzBuzzEngine.registerRule(nonFizzBuzzRule);

        // fire rules
        for (int i = 1; i <= 100; i++) {
            fizzRule.setInput(i);
            buzzRule.setInput(i);
            nonFizzBuzzRule.setInput(i);
            fizzBuzzEngine.fireRules();
            System.out.println();
        }
    }
}
