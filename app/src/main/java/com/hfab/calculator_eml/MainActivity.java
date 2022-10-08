package com.hfab.calculator_eml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> wholeEquation;

    private String lastNum = "";
    private int listLength = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The number displayed on the activity_main.xml file
        TextView display = findViewById(R.id.Display);

        // All of the numbered buttons
        Button btnOne = findViewById(R.id.btnOne);
        Button btnTwo = findViewById(R.id.btnTwo);
        Button btnThree = findViewById(R.id.btnThree);
        Button btnFour = findViewById(R.id.btnFour);
        Button btnFive = findViewById(R.id.btnFive);
        Button btnSix = findViewById(R.id.btnSix);
        Button btnSeven = findViewById(R.id.btnSeven);
        Button btnEight = findViewById(R.id.btnEight);
        Button btnNine = findViewById(R.id.btnNine);
        Button btnZero = findViewById(R.id.btnZero);

        // All of the operations
        Button btnAC = findViewById(R.id.btnAC);
        Button btnNegativeOrPositive = findViewById(R.id.btnNegativeOrPositive);
        Button btnPercent = findViewById(R.id.btnPercent);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnSubtract = findViewById(R.id.btnMinus);
        Button btnAdd = findViewById(R.id.btnPlus);
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnDecimal = findViewById(R.id.btnDecimal);

        // The whole equation
        wholeEquation = new ArrayList<String>();

        btnOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addOn(1, display);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(2, display);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(3, display);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(4, display);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(5, display);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(6, display);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(7, display);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(8, display);
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(9, display);
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(0, display);
            }
        });

        /**
         * BtnAC clears the entire equation the user created
         */
        btnAC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                lastNum = "";
                wholeEquation.removeAll(wholeEquation);
                display.setText("0");
            }

        });

        /**
         * btnEquals takes the equation the user created and
         * uses PEMDAS to produce the result
         */
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equalsEquation(lastNum);
                display.setText(wholeEquation.get(0).toString());
            }
        });

        /**
         * btnAdd adds an operator in this case the "+" operator
         */
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOrSwitchOperator(lastNum, wholeEquation, "+");
            }
        });

        /**
         * btnSubtract adds an operator in this case the "-" operator
         */
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOrSwitchOperator(lastNum, wholeEquation, "-");
            }
        });

        /**
         * btnMultiply adds an operator in this case the "X" operator
         */
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOrSwitchOperator(lastNum, wholeEquation, "X");
            }
        });

        /**
         * btnDivide adds an operator in this case the "/" operator
         */
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOrSwitchOperator(lastNum, wholeEquation, "/");
            }
        });

        /**
         * btnPercent divides the number the user is inputing by 100
         */
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {makeNumPercent(display);}
        });

        /**
         * btnNegativeOrPositive makes the number is inputing
         */
        btnNegativeOrPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setNumNegativeOrPositive(display); }
        });

        /**
         * btnDecimal divides the number the user is working on by 100
         */
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addDecimal(display); }
        });

    }

    /**
     * addOn adds a number to the lastNum
     *
     * @param num - number the user is working on currently
     * @param display - displays the number to the user
     */
    public void addOn(int num, TextView display) {
        switch (num) {
            case 0:
                lastNum += "0";
                break;

            case 1:
                lastNum += "1";
                break;

            case 2:
                lastNum += "2";
                break;

            case 3:
                lastNum += "3";
                break;

            case 4:
                lastNum += "4";
                break;

            case 5:
                lastNum += "5";
                break;

            case 6:
                lastNum += "6";
                break;

            case 7:
                lastNum += "7";
                break;

            case 8:
                lastNum += "8";
                break;

            case 9:
                lastNum += "9";
                break;

            default:
                lastNum += "";
        }
        display.setText(lastNum);
    }

    /**
     * addOrSwitchOperator adds a operator or switches the operator
     *
     * @param input - the number the user wants
     * @param wE - the whole Equation
     * @param operand - the operator the user wants to use
     */
    public void addOrSwitchOperator(String input, ArrayList<String> wE, String operand) {

        // If the user has not put any numbers in
        // the operand should be added
        if (input.equals(""))
        {
            wE.add(operand);

            // This checks for if the user has not
            // added any number to do anything with
            if(wholeEquation.size() == 1)
            {
                // Since there needs to be a number before an operator
                // the operand will be removed and replaced with a 0
                if (wholeEquation.get(0).toString().equals("+") || wholeEquation.get(0).toString().equals("-") || wholeEquation.get(0).toString().equals("X") || wholeEquation.get(0).toString().equals("/"))
                {
                    wholeEquation.remove(0);
                    wholeEquation.add("0");
                    wholeEquation.add(operand);
                }
            }
        }

        // Otherwise add the number and the operator
        else
        {
            wE.add(input);
            wE.add(operand);
        }

        // Checks to see if the prev string is an operator
        // for a deletion of the prev operator to replace with
        // the one user wants to use

        // For example "2, +, x, 2"
        // The program will get rid of "+" and replace it with "X"
        // in this case
        if (isPrevNumAnOperator(wE))
        {
            wE.remove(wE.get(wE.size() - 2));
            lastNum = "";
        }

        // This is only checked if the user has hit the equals sign
        // Example: "234, 456, +, 34"
        // The program will get rid of "234" in this case
        else if (isCurrentAndPrevNumANum(wE))
        {
            wE.remove(wE.get(wE.size() - 3));
            lastNum = "";
        }

        // Otherwise, empty lastNum
        else
        {
            lastNum = "";
        }
    }

    /**
     * isPrevAnOperator checks to see if the previous number is an operator
     * and handle it depending on the situations that may be presented
     *
     * @param wE - the whole equation
     * @return true if the prev string is an operator
     * Otherwise, false
     */
    public boolean isPrevNumAnOperator(ArrayList<String> wE) {
        boolean isOperator = false;

        int size = wE.size();

        if(wE.size() <= 1)
        {
            return isOperator;
        }

        else if (wE.get(wE.size() - 2).toString().equals("+") || wE.get(wE.size() - 2).toString().equals("-") || wE.get(wE.size() - 2).toString().equals("X") || wE.get(wE.size() - 2).toString().equals("/")) {
            isOperator = true;
        }

        return isOperator;
    }

    /**
     * isCurrentAndPrevNumANum checks if the first and second of the
     * position of the whole equation. Once it detects both number
     * then it gets rid of the first number
     *
     * Example: "234, 444, + 345"
     *
     * @param wE - the whole equation
     * @return
     */
    public boolean isCurrentAndPrevNumANum(ArrayList<String> wE)
    {
        boolean isANum = true;

        int size = wE.size();

        if (wE.size() == 2)
            return isANum = false;

        try
        {
            double thisNumOne = Double.parseDouble(wE.get(size - 2).toString());
            double thisNumTwo = Double.parseDouble(wE.get(size - 3).toString());
        }

        catch(Exception e)
        {
            isANum = false;
        }


        return isANum;
    }

    /**
     * equalsEquation does PEMDAS to solve the equation
     *
     * @param input - the number the user wants
     */
    public void equalsEquation(String input) {
        // Checks if the user wanted no number
        if (input.equals(""))
        {
            // If nothing is in the equation add a 0 to stop crash
            if(wholeEquation.size() == 0)
                wholeEquation.add("0");

            if(wholeEquation.size() == 1)
            {

            }

            // Otherwise remove operator
            else
                wholeEquation.remove(wholeEquation.size() - 1);

        }

        // Otherwise add number
        else
        {
            wholeEquation.add(input);
        }

        int indexM = 0;
        int indexD = 0;
        int indexSmall = 0;

        indexM = wholeEquation.indexOf("X");
        indexD = wholeEquation.indexOf("/");

        // While the equation still has "X" and "/" do operations to get rid of them
        while (indexM != -1 || indexD != -1) {
            indexSmall = findMinIndex(wholeEquation, "X", "/");

            performOperation(indexSmall);


            indexM = wholeEquation.indexOf("X");
            indexD = wholeEquation.indexOf("/");

        }

        int indexA = 0;
        int indexS = 0;

        indexA = wholeEquation.indexOf("+");
        indexS = wholeEquation.indexOf("-");


        // While the equation still has "+" and "-" do operations to get rid of them
        while (indexA != -1 || indexS != -1) {
            indexSmall = findMinIndex(wholeEquation, "+", "-");

            performOperation(indexSmall);
            System.out.println(wholeEquation);

            indexA = wholeEquation.indexOf("+");
            indexS = wholeEquation.indexOf("-");

        }

        lastNum = "";
    }

    /**
     * findMinIndex looks for when an operator appears first
     * @param wE - the wholeEquation
     * @param op1 - "+" or "X"
     * @param op2 = "-" or "/"
     * @return the first instance of one of those operators
     */
    public int findMinIndex(ArrayList<String> wE, String op1, String op2) {
        int indexM = 0;
        int indexD = 0;

        int indexSmall = 0;

        indexM = wholeEquation.indexOf(op1);
        indexD = wholeEquation.indexOf(op2);

        if (indexM == -1)
            indexSmall = indexD;

        else if (indexD == -1)
            indexSmall = indexM;

        else if (indexM < indexD)
            indexSmall = indexM;

        else
            indexSmall = indexD;

        return indexSmall;
    }

    /**
     * performOperation performs the operation once an operator is detected
     * @param i - first instance of an operator in order: "X", "/", "+", "-"
     *
     */
    public void performOperation(int i) {

        String num1 = wholeEquation.get(i - 1).toString();
        String num2 = wholeEquation.get(i + 1).toString();
        String op = wholeEquation.get(i).toString();

        double firstNum = 0;
        double secondNum = 0;

        // Tries to see if strings are numbers
        try
        {
            firstNum = Double.parseDouble(num1);
            secondNum = Double.parseDouble(num2);
        }

        // If not, report an error on the screen
        catch(Exception e)
        {
            wholeEquation.removeAll(wholeEquation);
            wholeEquation.add("Error");
        }

        String total = "";

        double answer = 0;

        for(int j=0; j < wholeEquation.size()-1; j++)
        {
            if(wholeEquation.get(j).toString().equals("Error"))
            {

            }
        }

        if (op.equals("X"))
            answer = firstNum * secondNum;

            // Another error check if the user divides by 0
        else if (op.equals("/")) {
            if (secondNum == 0)
            {
                wholeEquation.removeAll(wholeEquation);
                wholeEquation.add("Error");
            }

            else
            {
                answer = firstNum / secondNum;
            }
        }

        else if (op.equals("+"))
            answer = firstNum + secondNum;

        else
            answer = firstNum - secondNum;

        // Since an operation can't be done with 3 placements, nothing will happen
        if(wholeEquation.size() < 3)
        {

        }

        // Otherwise, once an operation is completed, get rid of the numbers
        // surrounding the operator and replace the operator with the number
        // as a string
        else
        {
            wholeEquation.remove(i + 1);
            wholeEquation.remove(i - 1);

            // Checks if a decimal is used, thus show the decimal
            // similar to a double
            if (num1.contains(".") || num2.contains("."))
            {
                total = String.format("%f", answer);
                wholeEquation.set(i - 1, total);
            }

            // Otherwise prints like an integer
            else
            {
                total = String.format("%.0f", answer);
                wholeEquation.set(i - 1, total);
            }
        }

    }

    public void setNumNegativeOrPositive(TextView display) {

        // If no input was given, add a zero
        if(lastNum.equals(""))
        {
            lastNum = "0";
        }

        // If the number does have a "-" then get rid of it
        if (lastNum.contains("-"))
            lastNum = lastNum.replace("-", "");

            // Otherwise add a "-" to the number
        else
            lastNum = "-" + lastNum;

        // Then display it to the user
        display.setText(lastNum);
    }

    /**
     * makeNumPercent divides the number is working on by 100
     * to display the percentage in decimal form
     *
     * @param display - displays the number to the user
     */
    public void makeNumPercent(TextView display) {
        double resultPercent = 0;

        // If the user added nothing, then don't do anything
        if(lastNum.equals(""))
        {

        }

        // Otherwise divide by 100 and display it to the user
        else
        {
            resultPercent = Double.parseDouble(lastNum);

            resultPercent = resultPercent / 100;

            lastNum = String.format("%f", resultPercent);
            display.setText(lastNum);
        }
    }

    /**
     * addDecimal adds a decimal to the number the user is working on
     * @param display - displays the number to the user
     */
    public void addDecimal(TextView display)
    {
        // If the user already has a decimal in the number
        // they are working on, do nothing to the string
        if (lastNum.contains("."))
        {
        }

        // Otherwise add the decimal
        else
        {
            lastNum += ".";
            display.setText(lastNum);
        }
    }
}