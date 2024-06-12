package app;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;

import javafx.scene.Node;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

import javafx.event.EventHandler;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    boolean canel = false;
    int back;
    String Calc = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Bfacts;

    @FXML
    private Label Sfacts;

    @FXML
    private TextField TFtime;

    @FXML
    private Label Timeover;

    @FXML
    void onBack(ActionEvent event) {
        if (back > 0) {
            JDBCConnection jdbc = new JDBCConnection();
            ArrayList<facts> facts = jdbc.getFacts(back--);

            for (facts facts2 : facts) {
                Bfacts.setText(facts2.getfNumber() + "." + facts2.getBFacts());
                Sfacts.setText(facts2.getSFacts());
            }
        } else {
            Bfacts.setText("No more facts, press next for a Random Fact.");
            Sfacts.setText("");
        }
    }

    @FXML
    void onRandomFacts(ActionEvent event) {
        Stage mainWindow = (Stage) Bfacts.getScene().getWindow();
        Random rand = new Random();
        int top = 52;
        int count = rand.nextInt(top);
        back = count - 1;
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<facts> facts = jdbc.getFacts(count);

        for (facts facts2 : facts) {
            Bfacts.setText(facts2.getfNumber() + "." + facts2.getBFacts());
            Sfacts.setText(facts2.getSFacts());
        }
    }

    @FXML
    private Button startBtn;

    @FXML
    void onTimer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("NewScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openCheckList(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Bfacts != null : "fx:id=\"Bfacts\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert Sfacts != null : "fx:id=\"Sfacts\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert TFtime != null : "fx:id=\"TFtime\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert Timer != null : "fx:id=\"Timer\" was not injected: check your FXML file 'NewScene.fxml'.";
        assert tfTime != null : "fx:id=\"tfTime\" was not injected: check your FXML file 'NewScene.fxml'.";
        assert startBtn != null : "fx:id=\"startBtn\" was not injected: check your FXML file 'NewScene.fxml'.";
        assert Timeover != null : "fx:id=\"Timeover\" was not injected: check your FXML file 'NewScene.fxml'.";
        assert mainCalc != null : "fx:id=\"mainCalc\" was not injected: check your FXML file 'Calculator.fxml'.";
    }

    @FXML
    private Label mainCalc;

    @FXML
    private Label Timer;

    int time;

    @FXML
    private TextField tfTime;

    @FXML
    void DeepWork(ActionEvent event) {
        time = 5400;
        int hours = time / 3600;
        int mins = (time % 3600) / 60;
        int sec = time % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
        Timer.setText(timeString);
    }

    /**
     * @param event
     */
    @FXML
    void TimerStart(ActionEvent event) {
        canel = false;
        doTime();
    }

    @FXML
    void TimerStop(ActionEvent event) {
        canel = true;
        int hours = time / 3600;
        int mins = (time % 3600) / 60;
        int sec = time % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
        Timer.setText(timeString);
        doTime();
    }

    @FXML
    void mins10(ActionEvent event) {
        time = 600;
        int hours = time / 3600;
        int mins = (time % 3600) / 60;
        int sec = time % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
        Timer.setText(timeString);

    }

    @FXML
    void mins15(ActionEvent event) {
        time = 900;
        int hours = time / 3600;
        int mins = (time % 3600) / 60;
        int sec = time % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
        Timer.setText(timeString);
    }

    @FXML
    void mins1H(ActionEvent event) {
        time = 3600;
        int hours = time / 3600;
        int mins = (time % 3600) / 60;
        int sec = time % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
        Timer.setText(timeString);
    }

    @FXML
    void mins30(ActionEvent event) {
        time = 1800;
        int hours = time / 3600;
        int mins = (time % 3600) / 60;
        int sec = time % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
        Timer.setText(timeString);
    }

    @FXML
    void mins5(ActionEvent event) {
        time = 300;
        int hours = time / 3600;
        int mins = (time % 3600) / 60;
        int sec = time % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
        Timer.setText(timeString);
    }

    @FXML
    void onCalc(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onCheckList(ActionEvent event) {

    }

    @FXML
    void onMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void doTime() {
        // Duration duration = Duration.ofSeconds(10000);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        if (timeline != null) {// if the time is equal to zero it is finished but if it is not equal to
                               // something then it is //doing something
            timeline.stop();
        }
        if (canel == false) {

            KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                // every one second of the timeline the keyframe will do something (i.e.,
                // perform a job and that job //is defined by the event handler)
                @Override
                public void handle(ActionEvent event) {

                    time--;
                    int hours = time / 3600;
                    int mins = (time % 3600) / 60;
                    int sec = time % 60;
                    String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
                    Timer.setText(timeString);

                    if (time <= 0) {
                        timeline.stop();
                        Timeover.setText("Time Over!");
                        startBtn.setDisable(false);
                    }
                    if (canel == true) {
                        timeline.stop();
                        startBtn.setDisable(false);
                        Timeover.setText("Time Paused");
                    } else if (canel == false) {
                        Timeover.setText("");
                        startBtn.setDisable(true);

                    }

                }

            });

            timeline.getKeyFrames().add(frame);
            timeline.playFromStart();
        }

    }

    @FXML
    void TfTimerConfirm(ActionEvent event) {
        time = Integer.parseInt(tfTime.getText());
        time = time * 60;
        int hours = time / 3600;
        int mins = (time % 3600) / 60;
        int sec = time % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mins, sec);
        Timer.setText(timeString);
    }

    @FXML
    void Calc0(ActionEvent event) {
        Calc = Calc + "0";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc1(ActionEvent event) {
        Calc = Calc + "1";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc2(ActionEvent event) {
        Calc = Calc + "2";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc3(ActionEvent event) {
        Calc = Calc + "3";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc4(ActionEvent event) {
        Calc = Calc + "4";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc5(ActionEvent event) {
        Calc = Calc + "5";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc6(ActionEvent event) {
        Calc = Calc + "6";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc7(ActionEvent event) {
        Calc = Calc + "7";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc8(ActionEvent event) {
        Calc = Calc + "8";
        mainCalc.setText(Calc);
    }

    @FXML
    void Calc9(ActionEvent event) {
        Calc = Calc + "9";
        mainCalc.setText(Calc);
    }

    @FXML
    void CalcAC(ActionEvent event) {
        Calc = "";
        mainCalc.setText(Calc);
    }

    @FXML
    void CalcBack(ActionEvent event) {
        Calc = Calc.substring(0, Calc.length() - 1);
        mainCalc.setText(Calc);
    }

    @FXML
    void CalcDivide(ActionEvent event) {

    }

    @FXML
    void CalcDot(ActionEvent event) {

    }

    @FXML
    void CalcEqual(ActionEvent event) {

    }

    @FXML
    void CalcMinus(ActionEvent event) {

    }

    @FXML
    void CalcPlus(ActionEvent event) {

    }

    @FXML
    void CalcTiimes(ActionEvent event) {

    }

}
