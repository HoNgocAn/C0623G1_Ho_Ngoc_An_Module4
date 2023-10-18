package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public int calculator(int numberA, int numberB, char math) throws Exception {

        switch (math) {
            case '+':
                return numberA + numberB;
            case '-':
                return numberA - numberB;
            case '*':
                return numberA * numberB;
            case '/':
                if (numberB != 0)
                    return numberA / numberB;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}


