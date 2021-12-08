package com.munnicha.patterns.gof.behavior.interpreter.model;

/**
 *
 * @author munnicha
 */
public class VariableExpression implements BooleanExpression{
    
    private String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public boolean evaluate(Context context) {
        return context.lookup(name);
    }

    public String getName() {
        return name;
    }

}
