import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField numberDisplay;

    private String currentNumber = "";
    private String prevOperation = "";

    private double total = 0;

    public void showOnDisplay(ActionEvent event)
    {
        if(this.prevOperation.equals("="))
        {
            this.total = 0;
        }

        this.currentNumber += ((Button)event.getSource()).getText();
        setDisplayNumber(this.currentNumber);
    }

    public void operationPressed(ActionEvent event)
    {
        String operation = ((Button) event.getSource()).getText();

        performOperation();

        this.prevOperation = operation;

        String totalString = convertNumberToString(this.total);

        displayNumberAfterOperation(totalString);
    }

    public void equals()
    {
        performOperation();

        this.prevOperation = "=";

        String totalString = convertNumberToString(this.total);

        displayNumberAfterOperation(totalString);
    }

    public void performOperation()
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
            this.total /= prevNumber;
        }
        else
        {
            this.total = prevNumber;
        }
    }

    public void convertToPercent()
    {
        setCurrentNumber(Double.toString(Double.parseDouble(this.currentNumber) / 100));
        setDisplayNumber(this.currentNumber);
    }

    public void plusMinus()
    {
        double number = Double.parseDouble(numberDisplay.getText());
        String numberString = convertNumberToString(number);

        if(number >= 0)
        {
            setCurrentNumber("-" + numberString);
        }
        else
        {
            setCurrentNumber(numberString.substring(1, numberString.length()));
        }

        setDisplayNumber(this.currentNumber);
    }

    public void squareNumber()
    {
        double square = Math.pow(Double.parseDouble(numberDisplay.getText()), 2);

        String numberString = convertNumberToString(square);

        setCurrentNumber(numberString);
        displayNumberAfterOperation(numberString);
    }

    public void squareRootNumber()
    {
        double squareRoot = Math.sqrt(Double.parseDouble(numberDisplay.getText()));

        String numberString = convertNumberToString(squareRoot);

        setCurrentNumber(numberString);
        displayNumberAfterOperation(numberString);
    }

    public void deleteANumber()
    {
        setCurrentNumber(this.currentNumber.substring(0, this.currentNumber.length()-1));
        setDisplayNumber(this.currentNumber);
    }

    public void clearAll()
    {
        setCurrentNumber("");
        total = 0;
        numberDisplay.clear();
    }

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

    private void displayNumberAfterOperation(String number)
    {
        setCurrentNumber("");

        setDisplayNumber(number);
    }

    private void setCurrentNumber(String currentNumber)
    {
        this.currentNumber = currentNumber;
    }

    private void setDisplayNumber(String displayNumber)
    {
        numberDisplay.setText(displayNumber);
    }
}
