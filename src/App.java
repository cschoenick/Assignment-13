import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{
private TextField tfUserInput = new TextField();
private TextField tfOutput = new TextField();
private Button btCalculate = new Button("Convert");
    

@Override
public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    Label inputLabel = new Label("Please input your query. For example, 1 km to m.");
    inputLabel.setWrapText(true);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(inputLabel, 0, 0);
    gridPane.add(tfUserInput, 1, 0);
    gridPane.add(new Label("Output:"), 0, 1);
    gridPane.add(tfOutput, 1, 1);
    gridPane.add(btCalculate, 1, 5);

    gridPane.setAlignment(Pos.CENTER);
    tfUserInput.setAlignment(Pos.BOTTOM_RIGHT);
    tfOutput.setEditable(false);
    tfOutput.setAlignment(Pos.BOTTOM_RIGHT);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);

    btCalculate.setOnAction(e -> convert());

    Scene scene = new Scene(gridPane, 500, 350);
    primaryStage.setTitle("Metric Converter"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
  }
  private void convert(){
    String input = tfUserInput.getText();
        if (input.equals("exit") || input.equals("-1")) {
        }
        
        String[] parts = input.split(" ");
        if (parts.length != 4) {
          tfOutput.setText("Invalid Input");
        }

        double value = Double.parseDouble(parts[0]);
        String from = parts[1];
        String to = parts[3];

        double result = 0;
        switch (from + "-" + to) {
          case "km-m":
            result = value * 1000;
            break;
          case "m-km":
            result = value / 1000;
            break;
          case "kg-lb":
            result = value * 2.20462;
            break;
          case "lb-kg":
            result = value / 2.20462;
            break;
          case "ft-m":
            result = value * .3048;
            break;
          case "m-ft":
            result = value / .3048;
            break;
          case "mi-km":
            result = value * 1.609344;
            break;
          case "km-mi":
            result = value / 1.609344;
            break;
          case "mph-kph":
            result = value * 1.609344;
            break;
          case "kph-mph":
            result = value / 1.609344;
            break;
          default:
            tfOutput.setText("Invalid Input");

        }

        tfOutput.setText(String.format("%.2f %s = %.2f %s", value, from, result, to));
  }
    public static void main(String[] args) {
        launch(args);
    }

   
}
