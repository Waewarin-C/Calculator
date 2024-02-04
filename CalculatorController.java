import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * The CalculatorController interacts with the Calculator.fxml file.
 * Performs the basic calculator operations: add, subtract, multiply,
 * divide, equals, percent, plus/minus, square, square root, remove
 * a single number, and clear all.
 *
 * @author Waewarin Chindarassami
 */
public class CalculatorController {
    @FXML
    private TextField numberDisplay;

    private String currentNumber = "";
    private String prevOperation = "";

    private double total = 0;

    private boolean isDivideByZero = false;

    /**
     * Shows the number clicked/pressed in the text field
     *
     * @param event ActionEvent - event of the button that was clicked/pressed
     */
    public void showOnDisplay(ActionEvent event)
    {
        if(this.prevOperation.equals("="))
        {
            this.total = 0;
        }

        this.currentNumber += ((Button)event.getSource()).getText();
        setDisplayNumber(this.currentNumber);
    }

    /**
     * Gets the operation that was clicked/pressed and performs that operation
     *
     * @param event ActionEvent - event of the button that was clicked/pressed
     */
    public void operationPressed(ActionEvent event)
    {
        String operation = ((Button) event.getSource()).getText();

        performOperation();

        this.prevOperation = operation;

        String totalString = convertNumberToString(this.total);

        if(this.isDivideByZero)
        {
            setDisplayNumber("Error");
            setCurrentNumber("");
        }
        else
        {
            displayNumberAfterOperation(totalString);
        }
    }

    /**
     * Performs the equals operation
     */
    public void equals()
    {
        performOperation();

        this.prevOperation = "=";

        String totalString = convertNumberToString(this.total);

        if(this.isDivideByZero)
        {
            setDisplayNumber("Error");
            setCurrentNumber("");
        }
        else
        {
            displayNumberAfterOperation(totalString);
        }
    }

    /**
     * Performs the operations add, subtract, multiply, and divide
     */
    public void performOperation()
    {
        try
        {
            double prevNumber = Double.parseDouble(numberDisplay.getText());

            if(this.prevOperation.equals("+"))
            {
                this.total += prevNumber;
            }
            else if(this.prevOperation.equals("-"))
            {
                this.total -= prevNumber;
            }
            else if(this.prevOperation.equals("X"))
            {
                this.total *= prevNumber;
            }
            else if(this.prevOperation.equals("÷"))
            {
                if(prevNumber == 0)
                {
                    this.isDivideByZero = true;
                    return;
                }

                this.total /= prevNumber;
            }
            else
            {
                this.total = prevNumber;
            }
        }
        catch(NumberFormatException e)
        {
            return;
        }
    }

    /**
     * Converts the current number into a percent in decimal form
     */
    public void convertToPercent()
    {
        String percentString = Double.toString(Double.parseDouble(numberDisplay.getText()) / 100);
        displayNumberAfterOperation(percentString);
    }

    /**
     * Negates the sign of the current number
     */
    public void plusMinus()
    {
        double number = Double.parseDouble(numberDisplay.getText());
        String numberString = convertNumberToString(number);

        if(number >= 0)
        {
            displayNumberAfterOperation("-" + numberString);
        }
        else
        {
            displayNumberAfterOperation(numberString.substring(1, numberString.length()));
        }
    }

    /**
     * Squares the current number
     */
    public void squareNumber()
    {
        double square = Math.pow(Double.parseDouble(numberDisplay.getText()), 2);

        String numberString = convertNumberToString(square);

        setCurrentNumber(numberString);
        displayNumberAfterOperation(numberString);
    }

    /**
     * Gives the square root of the current number
     */
    public void squareRootNumber()
    {
        double squareRoot = Math.sqrt(Double.parseDouble(numberDisplay.getText()));

        String numberString = convertNumberToString(squareRoot);

        setCurrentNumber(numberString);
        displayNumberAfterOperation(numberString);
    }

    /**
     * Deletes the last digit clicked/pressed
     */
    public void deleteADigit()
    {
        setCurrentNumber(this.currentNumber.substring(0, this.currentNumber.length()-1));
        setDisplayNumber(this.currentNumber);
    }

    /**
     * Clears the display of the current number and the calculator of the total
     * accumulated so far
     */
    public void clearAll()
    {
        setCurrentNumber("");
        total = 0;
        numberDisplay.clear();
        this.isDivideByZero = false;
    }

    /*
     * Converts the number to a string to be displayed
     */
    private String convertNumberToString(double number)
    {
        String numString = "";

        if(number == Math.floor(number))
        {
            numString = Integer.toString((int)number);
        }
        else
        {
            numString = Double.toString(number);
        }

        return numString;
    }

    /*
     * Display the number after an operation is performed
     */
    private void displayNumberAfterOperation(String number)
    {
        setCurrentNumber("");

        setDisplayNumber(number);
    }

    /*
     * Sets the current number
     */
    private void setCurrentNumber(String currentNumber)
    {
        this.currentNumber = currentNumber;
    }

    /*
     * Sets the current display number
     */
    private void setDisplayNumber(String displayNumber)
    {
        numberDisplay.setText(displayNumber);
    }
}
