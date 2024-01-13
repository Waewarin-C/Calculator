import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField numberDisplay;

    private String currentNumber = "";
    private double total = 0;

    public void showOnDisplay(ActionEvent event)
    {
        this.currentNumber += ((Button)event.getSource()).getText();
        setDisplayNumber(this.currentNumber);
    }

    public void add()
    {
        this.total += Double.parseDouble(currentNumber);

        displayNumberAfterOperation();
    }

    public void subtract()
    {
        this.total -= Double.parseDouble(currentNumber);

        displayNumberAfterOperation();
    }

    public void multiply()
    {
        this.total *= Double.parseDouble(currentNumber);

        displayNumberAfterOperation();
    }

    public void divide()
    {
        this.total /= Double.parseDouble(currentNumber);

        displayNumberAfterOperation();
    }

    public void equals()
    {

    }

    public void convertToPercent()
    {
        this.currentNumber = Double.toString(Double.parseDouble(this.currentNumber) / 100);
        setDisplayNumber(this.currentNumber);
    }

    public void plusMinus()
    {
        double number = Double.parseDouble(this.currentNumber);

        if(number >= 0)
        {
            this.currentNumber = "-" + this.currentNumber;
        }
        else
        {
            this.currentNumber = this.currentNumber.substring(1, this.currentNumber.length());
        }

        setDisplayNumber(this.currentNumber);
    }

    public void squareNumber()
    {
        setCurrentNumber(Double.toString(Math.pow(Float.parseFloat(numberDisplay.getText()), 2)));
        displayNumberAfterOperation();
    }

    public void squareRootNumber()
    {
        setCurrentNumber((Double.toString(Math.sqrt(Double.parseDouble(numberDisplay.getText())))));
        displayNumberAfterOperation();
    }

    public void deleteANumber()
    {
        setCurrentNumber(this.currentNumber.substring(0, this.currentNumber.length()-1));
        setDisplayNumber(this.currentNumber);
    }

    public void clearAll()
    {
        setCurrentNumber("");
        numberDisplay.clear();
    }

    private void displayNumberAfterOperation()
    {
        this.currentNumber = "";

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
