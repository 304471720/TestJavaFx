package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    /*@Override
    public void start(Stage stage) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.LIGHTGRAY);
        material.setSpecularColor(Color.rgb(30, 30, 30));
        Shape3D[] meshView = new Shape3D[]{new
                Box(200, 200, 200),
                new Sphere(100),
                new Cylinder(100, 200),
        };
        for (int i = 0; i != 3; ++i) {
            meshView[i].setMaterial(material);
            meshView[i].setTranslateX((i + 1) * 220);
            meshView[i].setTranslateY(500);
            meshView[i].setTranslateZ(20);
            meshView[i].setDrawMode(DrawMode.FILL);
            meshView[i].setCullFace(CullFace.BACK);
        }
        PointLight pointLight = new PointLight(Color.ANTIQUEWHITE);
        pointLight.setTranslateX(800);
        pointLight.setTranslateY(-100);
        pointLight.setTranslateZ(-1000);

        Group root = new Group(meshView);
        root.getChildren().add(pointLight);

        Scene scene = new Scene(root, 800, 800, true);
        scene.setFill(Color.rgb(10, 10, 40));
        scene.setCamera(new PerspectiveCamera(false));
        stage.setScene(scene);
        stage.show();
    }*/
    /*@Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("say hello world");


        //为按钮添加事件
        //匿名类方式添加事件
//      btn.setOnAction(new EventHandler<ActionEvent>(){
//          @Override
//          public void handle(ActionEvent event) {
//              System.out.println("hello world。。。");
//          }
//      });


        //lambda表达式方式添加事件（java8可以使用这种语法）
        btn.setOnAction((e) -> {
            System.out.println("hello world。。。");
            System.out.println(e.toString());
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        //场景
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);


        primaryStage.show();
    }*/
    /*@Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Group circles = new Group();
        for (int i = 0; i < 30; i++) {
            Circle circle = new Circle(150, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.16));
            circle.setStrokeWidth(4);
            circles.setEffect(new BoxBlur(10, 10, 3));
            circles.getChildren().add(circle);
        }
        root.getChildren().add(circles);
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);

        primaryStage.show();
    }*/


    public static void main(String[] args) {
        launch(args);
    }
}
