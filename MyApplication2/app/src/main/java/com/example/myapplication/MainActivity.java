package com.example.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    private TextView displayTv;
    private StringBuilder currentInput;
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize displayTv after setContentView
        displayTv = findViewById(R.id.display);
        currentInput = new StringBuilder();
    }

    public void addSymbol(View view) {
        TextView tv = (TextView) view;
        String clickedText = tv.getText().toString();

        if (isNewOperation || displayTv.getText().toString().equals("0") || displayTv.getText().toString().equals("Error")) {
            displayTv.setText(clickedText);
            currentInput.setLength(0);
            currentInput.append(clickedText);
            isNewOperation = false;
        } else {
            // Check if the clicked symbol is the plus-minus symbol
            if (clickedText.equals("+/-")) {
                // Toggle the sign of the last operand
                handlePlusMinus();
            } else if (clickedText.equals(".")) {
                // Handle decimal points
                handleDecimalPoint();
            } else {
                // Concatenate the current input and the clicked text
                if (Character.isDigit(clickedText.charAt(0)) && Character.isDigit(currentInput.charAt(currentInput.length() - 1))) {
                    // If the clicked text is a digit and the last character in currentInput is a digit, concatenate without space
                    currentInput.append(clickedText);
                } else if (clickedText.equals(".")) {
                    // If the clicked text is a decimal point, concatenate without space if the last character is a digit
                    if (currentInput.length() > 0 && Character.isDigit(currentInput.charAt(currentInput.length() - 1))) {
                        currentInput.append(clickedText);
                    }
                } else {
                    // Otherwise, concatenate with a space
                    currentInput.append(" ").append(clickedText);
                }

                // Display the concatenated input without leading zeros and spaces around decimal points
                String displayText = currentInput.toString().replaceAll("^0+", "");
                displayText = displayText.replaceAll("\\s+\\.", "."); // Remove spaces around decimal points
                displayText = displayText.replaceAll("\\.\\s+", "."); // Remove spaces around decimal points
                displayTv.setText(displayText);
            }
        }
    }



    // Display the concatenated input without leading zeros




    private void handlePlusMinus() {
        // Toggle the sign of the last operand
        String[] tokens = currentInput.toString().split("\\s+");
        int lastIndex = tokens.length - 1;

        if (lastIndex >= 0) {
            BigDecimal lastOperand = new BigDecimal(tokens[lastIndex]);

            // Toggle the sign of the last operand
            lastOperand = lastOperand.negate();

            // Replace the last operand with the updated value
            tokens[lastIndex] = lastOperand.stripTrailingZeros().toPlainString();

            // Reconstruct the expression
            currentInput.setLength(0);
            for (String token : tokens) {
                currentInput.append(token).append(" ");
            }
        }

        displayTv.setText(currentInput.toString().trim());
    }

    private void handleDecimalPoint() {
        // Handle decimal points without introducing spaces
        if (currentInput.length() == 0 || !Character.isDigit(currentInput.charAt(currentInput.length() - 1))) {
            currentInput.append("0");
        }

        if (!currentInput.toString().contains(".")) {
            currentInput.append(".");
            displayTv.setText(currentInput.toString());
        }
    }







    public void reset(View view) {
        // Reset the text of displayTv to "0"
        displayTv.setText("0");
        currentInput.setLength(0);
        isNewOperation = true;
    }

    public void calculate(View view) {
        try {
            // Evaluate the expression using BigDecimal
            BigDecimal result = evaluateExpression(currentInput.toString());

            // Display the result
            displayTv.setText(result.stripTrailingZeros().toPlainString());
            isNewOperation = true;
            currentInput.setLength(0);
            currentInput.append(result.stripTrailingZeros().toPlainString());
        } catch (Exception e) {
            // Handle the case where the expression is not valid
            displayTv.setText("Error");
            isNewOperation = true;
        }
    }


    private BigDecimal evaluateExpression(String expression) {
        // Use BigDecimal for precise calculations
        String[] tokens = expression.split("\\s+"); // Split by any whitespace

        if (tokens.length == 1) {
            // Only one number, possibly negative or with a decimal
            return new BigDecimal(tokens[0].replace(",", "")); // Replace commas if present
        } else {
            // Evaluate the expression following the order of operations (BIDMAS/BODMAS)
            List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));

            // First, handle percentages
            for (int i = 0; i < tokenList.size(); i++) {
                if (tokenList.get(i).equals("%")) {
                    BigDecimal operand = new BigDecimal(tokenList.get(i - 1));
                    BigDecimal result = operand.divide(BigDecimal.valueOf(100), 10, BigDecimal.ROUND_HALF_UP);

                    // Replace the operator and operand with the result
                    tokenList.set(i - 1, result.stripTrailingZeros().toPlainString());
                    tokenList.remove(i); // Remove the "%"
                    i--; // Move back one position to reevaluate if needed
                }
            }

            // Now, handle multiplication and division
            for (int i = 1; i < tokenList.size(); i += 2) {
                String operator = tokenList.get(i);

                if (operator.equals("×") || operator.equals("÷")) {
                    BigDecimal leftOperand = new BigDecimal(tokenList.get(i - 1));
                    BigDecimal rightOperand = new BigDecimal(tokenList.get(i + 1));

                    BigDecimal result;
                    if (operator.equals("×")) {
                        result = leftOperand.multiply(rightOperand);
                    } else {
                        if (rightOperand.compareTo(BigDecimal.ZERO) != 0) {
                            result = leftOperand.divide(rightOperand, 10, BigDecimal.ROUND_HALF_UP);
                        } else {
                            throw new ArithmeticException("Division by zero");
                        }
                    }

                    // Replace the operator, left operand, and right operand with the result
                    tokenList.set(i - 1, result.stripTrailingZeros().toPlainString());
                    tokenList.remove(i);
                    tokenList.remove(i);
                    i -= 2; // Move back two positions to reevaluate if needed
                }
            }

            // Now, handle addition and subtraction
            for (int i = 1; i < tokenList.size(); i += 2) {
                String operator = tokenList.get(i);
                BigDecimal leftOperand = new BigDecimal(tokenList.get(i - 1));
                BigDecimal rightOperand = new BigDecimal(tokenList.get(i + 1));

                BigDecimal result;
                if (operator.equals("+")) {
                    result = leftOperand.add(rightOperand);
                } else {
                    result = leftOperand.subtract(rightOperand);
                }

                // Replace the operator, left operand, and right operand with the result
                tokenList.set(i - 1, result.stripTrailingZeros().toPlainString());
                tokenList.remove(i);
                tokenList.remove(i);
                i -= 2; // Move back two positions to reevaluate if needed
            }

            // The final result should be at the first position in the list
            return new BigDecimal(tokenList.get(0).replace(",", ""));
        }
    }



}



