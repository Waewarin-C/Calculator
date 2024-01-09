import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField numberDisplay;

    private String currentNumber = "";
    private float total = 0;

    public void showOnDisplay(ActionEvent event)
    {
        this.currentNumber += ((Button)event.getSource()).getText();
        setDisplayNumber(this.currentNumber);
    }

    public void add()
    {
        this.total += Float.parseFloat(currentNumber);

        displayNumberAfterOperation();
    }

    public void subtract()
    {
        this.total -= Float.parseFloat(currentNumber);

        displayNumberAfterOperation();
    }

    public void multiply()
    {
        this.total *= Float.parseFloat(currentNumber);

        displayNumberAfterOperation();
    }

    public void divide()
    {
        this.total /= Float.parseFloat(currentNumber);

        displayNumberAfterOperation();
    }

    public void equals()
    {

    }

    public void convertToPercent()
    {

    }

    public void plusMinus()
    {

    }

    public void squareNumber()
    {

    }

    public void squareRootNumber()
    {

    }

    public void deleteANumber()
    {

    }

    public void clearAll()
    {

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
            setDisplayNumber(Float.toString(this.total));
        }
    }

    private void setDisplayNumber(String displayNumber)
    {
        numberDisplay.setText(displayNumber);
    }
}
