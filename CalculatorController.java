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

        displayNumberAfterOperation();
    }

    public void equals()
    {
        performOperation();

        this.prevOperation = "=";

        displayNumberAfterOperation();
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
    }

    public void convertToPercent()
    {
        setCurrentNumber(Double.toString(Double.parseDouble(this.currentNumber) / 100));
        setDisplayNumber(this.currentNumber);
    }

    public void plusMinus()
    {
        double number = Double.parseDouble(this.currentNumber);

        if(number >= 0)
        {
            setCurrentNumber("-" + this.currentNumber);
        }
        else
        {
            setCurrentNumber(this.currentNumber.substring(1, this.currentNumber.length()));
        }

        setDisplayNumber(this.currentNumber);
    }

    public void squareNumber()
    {
        setCurrentNumber(Double.toString(Math.pow(Double.parseDouble(numberDisplay.getText()), 2)));
        setDisplayNumber(this.currentNumber);
    }

    public void squareRootNumber()
    {
        setCurrentNumber((Double.toString(Math.sqrt(Double.parseDouble(numberDisplay.getText())))));
        setDisplayNumber(this.currentNumber);
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

    private void displayNumberAfterOperation()
    {
        setCurrentNumber("");

        if(this.total == Math.floor(this.total))
        {
            int currentTotal = (int)this.total;
            setDisplayNumber(Integer.toString(currentTotal));
        }
        else
        {
            setDisplayNumber(Double.toString(this.total));
        }
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
