
import com.google.gson.reflect.TypeToken;
import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.google.gson.*;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class client extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    // Create the GridPane.
    FlowPane flowpane = new FlowPane();
    ScrollPane scrollPane = new ScrollPane();
    GridPane home_gridpane_disp = new GridPane();
    Button button_homedisp_back_new = new Button("GO TO PREVIOUS PAGE");
    GridPane home_gridpane = new GridPane();
    GridPane display_gridpane=new GridPane();
    GridPane display_one_gridpane = new GridPane();
    GridPane add_gridpane=new GridPane();
    GridPane delete_gridpane=new GridPane();
    ComboBox delitem=new ComboBox();

    Button button_display = new Button("DISPLAY MUTANTS");
    Button button_add = new Button("ADD MUTANTS");
    Button button_delete = new Button("DELETE MUTANTS");

    Button button_confirm_add = new Button("Click here to add!");
    Label label_confirm_add = new Label("");

    TextField idField = new TextField();
    Button button_confirm_delete = new Button("Click here to delete!");
    Label label_confirm_delete = new Label("");
    Label test = new Label("Select from below to delete mutant");

    Button button_display_page_back = new Button("GO TO PREVIOUS PAGE");
    Button button_display_one_back = new Button("GO TO PREVIOUS PAGE");
    Button button_add_back = new Button("GO TO PREVIOUS PAGE");
    Button button_delete_back = new Button("GO TO PREVIOUS PAGE");

    Label label_displaypage = new Label("WELCOME TO  \n" + " THE WORLD OF MUTANTS \n");
    Label label_display_one_page = new Label("");

    TextField nameField = new TextField();
    TextField heightField = new TextField();
    TextField weightField= new TextField();
    //TextField catField = new TextField();
    ComboBox catField=new ComboBox();
    TextField abilityField= new TextField();


    void createHomePage() {

        //Create Label for homepage description
        Label label_home = new Label("             WELCOME TO  \n" + " THE WORLD OF MUTANTS \n");
        label_home.setFont(Font.font("Cambria", 32));
        label_home.setWrapText(true);


        //Create HBox
        HBox home_hbox = new HBox(10, button_display, button_add, button_delete);
        home_hbox.setSpacing(20);
        home_hbox.setHgrow(button_display, Priority.ALWAYS);
        home_hbox.setHgrow(button_add, Priority.ALWAYS);
        home_hbox.setHgrow(button_delete, Priority.ALWAYS);
        home_hbox.setPrefHeight(80);


        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row2 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        home_gridpane.getRowConstraints().addAll(row1, row2);


        Image image = new Image(getClass().getResourceAsStream("fire.jpg"));
        Label label3 = new Label("Search", new ImageView(image));

        Image img = new Image("fire.png");
        ImageView fire = new ImageView(img);
        fire.setFitHeight(20);
        fire.setPreserveRatio(true);

        home_gridpane.add(label_home, 0, 0);
        home_gridpane.add(home_hbox, 0, 1);

        home_gridpane.setHgap(8);
        home_gridpane.setVgap(20);
        home_gridpane.setPadding(new Insets(30));
        home_gridpane.setStyle("-fx-background-color: beige;");

    }

    void createDisplayPage() {

        //Create Label for homepage description
        label_displaypage.setFont(Font.font("Cambria", 32));
        label_displaypage.setWrapText(true);

        //Create HBox
        HBox display_hbox = new HBox(10, button_display_page_back);
        display_hbox.setSpacing(20);
        display_hbox.setHgrow(button_display_page_back, Priority.ALWAYS);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row2 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        display_gridpane.getRowConstraints().addAll(row1, row2);

        display_gridpane.setStyle("-fx-background-color: yellow;");
        display_gridpane.add(label_displaypage, 0, 0);
        display_gridpane.add(display_hbox, 0, 1);

        display_gridpane.setHgap(4);
        display_gridpane.setVgap(4);
        display_gridpane.setPadding(new Insets(10));


    }

    void createDisplayOnePage(){
        //Create Label for homepage description
        label_display_one_page.setFont(Font.font("Cambria", 32));
        label_display_one_page.setWrapText(true);


        //Create HBox
        HBox display_one_hbox = new HBox(10, button_display_one_back);
        display_one_hbox.setSpacing(20);
        display_one_hbox.setHgrow(button_display_one_back, Priority.ALWAYS);
        display_one_hbox.setPrefHeight(80);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row2 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        display_one_gridpane.getRowConstraints().addAll(row1, row2);
        label_display_one_page.setStyle("-fx-background-color: BEIGE;");
        display_one_gridpane.add(label_display_one_page, 0, 0);
        display_one_gridpane.add(display_one_hbox, 0, 1);
        display_one_gridpane.setHgap(8);
        display_one_gridpane.setVgap(20);
        display_one_gridpane.setPadding(new Insets(30));

    }

    void createAddPage(){
        //Create Label for homepage description
        Label label_add_page1 = new Label(" Name");
        label_add_page1.setWrapText(true);

        Label label_add_page2 = new Label(" Height");
        label_add_page1.setWrapText(true);

        Label label_add_page3 = new Label(" Weight");
        label_add_page1.setWrapText(true);

        Label label_add_page4 = new Label(" Category");
        label_add_page1.setWrapText(true);

        Label label_add_page5 = new Label(" Overall Ability");
        label_add_page1.setWrapText(true);

        //Create HBox
        HBox add_page_hbox = new HBox(10,button_confirm_add, button_add_back);
        add_page_hbox.setSpacing(20);
        add_page_hbox.setHgrow(button_add_back, Priority.ALWAYS);
        add_page_hbox.setHgrow(button_confirm_add, Priority.ALWAYS);
        add_page_hbox.setPrefHeight(80);

        HBox add_page_hbox_name = new HBox(10, label_add_page1, nameField);
        add_page_hbox_name.setSpacing(20);
        add_page_hbox_name.setHgrow(label_add_page1, Priority.ALWAYS);
        add_page_hbox_name.setHgrow(nameField, Priority.ALWAYS);
        add_page_hbox_name.setPrefHeight(80);

        HBox add_page_hbox_height = new HBox(10, label_add_page2, heightField);
        add_page_hbox_height.setSpacing(20);
        add_page_hbox_height.setHgrow(label_add_page2, Priority.ALWAYS);
        add_page_hbox_height.setHgrow(heightField, Priority.ALWAYS);
        add_page_hbox_height.setPrefHeight(80);

        HBox add_page_hbox_weight = new HBox(10, label_add_page3, weightField);
        add_page_hbox_weight.setSpacing(20);
        add_page_hbox_weight.setHgrow(label_add_page3, Priority.ALWAYS);
        add_page_hbox_weight.setHgrow(weightField, Priority.ALWAYS);
        add_page_hbox_weight.setPrefHeight(80);

        catField.getItems().addAll("FREEZE", "FIRE", "STRENGTH","MAGIC","TELEPATHY", "FLIGHT");
        HBox add_page_hbox_cat = new HBox(10, label_add_page4, catField);
        add_page_hbox_cat.setSpacing(20);
        add_page_hbox_cat.setHgrow(label_add_page4, Priority.ALWAYS);
        add_page_hbox_cat.setHgrow(catField, Priority.ALWAYS);
        add_page_hbox_cat.setPrefHeight(80);

        HBox add_page_hbox_oa = new HBox(10, label_add_page5, abilityField);
        add_page_hbox_oa.setSpacing(20);
        add_page_hbox_oa.setHgrow(label_add_page5, Priority.ALWAYS);
        add_page_hbox_oa.setHgrow(abilityField, Priority.ALWAYS);
        add_page_hbox_oa.setPrefHeight(80);

        HBox add_page_hbox_label = new HBox(10, label_confirm_add);
        add_page_hbox.setSpacing(20);
        add_page_hbox_label.setHgrow(label_confirm_add, Priority.ALWAYS);
        add_page_hbox_label.setPrefHeight(80);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row2 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row3 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row4 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row5 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row6 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);

        add_gridpane.getRowConstraints().addAll(row1, row2, row3, row4,row5, row6);
        add_gridpane.add(add_page_hbox_name, 0, 0);
        add_gridpane.add(add_page_hbox_height, 0, 1);
        add_gridpane.add(add_page_hbox_weight, 0, 2);
        add_gridpane.add(add_page_hbox_cat, 0, 3);
        add_gridpane.add(add_page_hbox_oa, 0, 4);
        add_gridpane.add(add_page_hbox_label, 0, 5);
        add_gridpane.add(add_page_hbox, 0, 6);
        add_gridpane.setHgap(8);
        add_gridpane.setVgap(20);
        add_gridpane.setPadding(new Insets(30));



    }

    void createDeletePage(){

        //Create Label for homepage description
        Label label_delete_page = new Label("Testing for now -Specific deletion\n" + " Testing for now -Specific deletion \n" + "Testing for now -Specific deletion");
        label_delete_page.setFont(Font.font("Cambria", 32));
        label_delete_page.setWrapText(true);


        //Create HBox
        HBox delete_page_hbox = new HBox(2, button_confirm_delete,button_delete_back);
        delete_page_hbox.setHgrow(button_confirm_delete, Priority.ALWAYS);
        delete_page_hbox.setHgrow(button_delete_back, Priority.ALWAYS);
        delete_gridpane.setHgap(8);
        delete_gridpane.setVgap(12);
        delete_gridpane.setPadding(new Insets(10));

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MUTANT");

        createHomePage();
        createDisplayPage();
        createDisplayOnePage();
        createAddPage();
        createDeletePage();

        //Create scene for homepage
        Scene home_scene = new Scene(home_gridpane, 460, 400);

        Scene display_scene=new Scene(display_gridpane, 460,400);
        Scene display_specific =new Scene(display_one_gridpane, 460, 400);
        Scene add_scene=new Scene(add_gridpane, 460,400);
        Scene delete_scene=new Scene(delete_gridpane, 380,300);
        Scene home_disp_scene=new Scene(scrollPane, 400,600);

        button_display.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    home_gridpane_disp.getChildren().clear();

                    URL url = new URL("http://localhost:8080/api/mutant/all");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    connection.getInputStream();
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getInputStream())
                    );
                    String output = br.readLine();
                    String str=output;
                    String disp=("ID  "+"Name            "+"Weight    "+"Height   "+"\n");

                    TestJson[] mutant = new Gson().fromJson(str, TestJson[].class);
                    int i=0;
                    int j=0;
                    int count=0;
                    int r=0;

                    for (TestJson s : mutant) {

                        System.out.println(s.getName());

                     if (j== 1) {
                            i++;
                            j=0;
                            r++;
                        }
                                 Label l=new Label(String.valueOf(s.getName()));
                                 l.setId(String.valueOf(s.getId()));
                                 count++;
                                 l.setPrefHeight(60);
                                 l.setFont(new Font("Lucida Sans Unicode", 16));
                                 l.setWrapText(true);
                                 l.setPrefWidth(180);
                                 l.setTextFill(Color.BLACK);
                                 l.setStyle("-fx-border-color: black; -fx-background-color: white;");


                        String imgfile="";
                        if(s.getCategory().equalsIgnoreCase("fire")){
                            imgfile="fire.png";
                        }
                        else if (s.getCategory().equalsIgnoreCase("freeze")) {
                            imgfile="freeze.png";

                        }
                        else if (s.getCategory().equalsIgnoreCase("flight")) {
                            imgfile="flight.png";

                        }
                        else if (s.getCategory().equalsIgnoreCase("telepathy")) {
                            imgfile="telepathy.png";

                        }
                        else if (s.getCategory().equalsIgnoreCase("magic")) {
                            imgfile="magic.png";

                        }
                        else if (s.getCategory().equalsIgnoreCase("strength")) {
                            imgfile="strength.png";

                        }

                        if(imgfile=="")
                        {}
                        else {

                            System.out.println("\n"+imgfile);

                            Image img = new Image(imgfile);
                            ImageView view = new ImageView(img);
                            view.setFitHeight(40);
                            view.setPreserveRatio(true);

                            l.setGraphic(view);
                        }

                        flowpane.getChildren().add(l);

                                 l.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                     @Override
                                     public void handle(MouseEvent mouseEvent) {
                                         int i= Integer.parseInt(l.getId());

                                         Label source = (Label) mouseEvent.getSource();
                                         Integer cIndex = GridPane.getColumnIndex(source);
                                         Integer rIndex = GridPane.getRowIndex(source);

                                         try{

                                             URL url = new URL("http://localhost:8080/api/mutant/"+i);
                                             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                                             connection.setRequestMethod("GET");

                                             connection.getInputStream();
                                             BufferedReader br = new BufferedReader(
                                                     new InputStreamReader(connection.getInputStream())
                                             );
                                             String output = br.readLine();
                                             String str=output;
                                             str="["+str+"]";
                                             TestJson[] mu = new Gson().fromJson(str, TestJson[].class);
                                             String temp="";

                                             for (TestJson s : mu) {

                                                  temp="|Name                 |"+s.getName()+"\n"+
                                                          "|Height               |"+s.getHeight()+"\n"+
                                                          "|Weight              |"+ s.getWeight()+"\n"+
                                                          "|Category           |"+s.getCategory()+"\n"+
                                                         "|Overall-Abilty |"+s.getOverall_ability();
                                             }
                                             label_display_one_page.setText(temp);
                                             primaryStage.setScene(display_specific);

                                         }
                                         catch (Exception e){
                                             e.printStackTrace();
                                         }
                                     }
                                 });
                                 j++;

                    disp=(disp+s.getId()+"  "+s.getName()+"     "+s.getWeight()+"      "+s.getHeight()+ "      "+s.getCategory()+"      "+s.getOverall_ability()+"\n");

                    }

                    flowpane.getChildren().add(button_homedisp_back_new);
                    flowpane.setHgap(10);
                    flowpane.setVgap(10);
                    flowpane.setPadding(new Insets(10));
                    scrollPane.setPannable(true);
                    scrollPane.setContent(flowpane);
                    label_displaypage.setText(disp);
                    primaryStage.setScene(home_disp_scene);
                    connection.disconnect();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        });


        button_add.setOnAction(e -> primaryStage.setScene(add_scene));

        button_confirm_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("button clicked");

                String newName = nameField.getText();
                String newHeight = heightField.getText();
                String newWeight = weightField.getText();
                String newCat= (String) catField.getValue();
                newCat=newCat.toLowerCase(Locale.ROOT);
                String newAbility=abilityField.getText();

                System.out.println(newName);
                try {
                    URL url = new URL("http://localhost:8080/api/mutant/add");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);
                    connection.setRequestProperty("Content-Type","application/json");

                    OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                    wr.write("{\"name\":\""+newName+"\",\"height\":"+newHeight+",\"weight\":"+newWeight+",\"category\":\""+newCat+"\",\"overall_ability\":"+newAbility+"}");


                    wr.flush();
                    wr.close();




                    connection.connect();
                    System.out.println(connection.getResponseCode());
                    if(connection.getResponseCode()==201){
                        label_confirm_add.setText("Mutant added successfully");
                    }
                    else{
                        label_confirm_add.setText("Mutant not added, "+"\n"+" please verify your values and try again");

                    }
                    connection.disconnect();
                }
                catch(IOException e){

                }
            }
        });

        button_delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                try {
                    delete_gridpane.getChildren().clear();
                    delitem.getItems().clear();

                    URL url = new URL("http://localhost:8080/api/mutant/all");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    connection.getInputStream();
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getInputStream())
                    );
                    String output = br.readLine();
                    String str=output;
                    System.out.println(str);
                    //str = str.substring(1, str.length() - 1);

                    String disp=("ID  "+"Name            "+"Weight    "+"Height   "+"\n");

                    TestJson[] mutant = new Gson().fromJson(str, TestJson[].class);
                   // delitem.setPromptText("SELECT ONE FROM THE FOLLOWING TO DELETE");


                    for (TestJson s : mutant) {
                        String temp="ID:"+s.getId()+"-"+""+s.getName();
                        delitem.getItems().add(temp);
                        disp=(disp+s.getId()+"  "+s.getName()+"     "+s.getWeight()+"      "+s.getHeight()+ "      "+s.getCategory()+"      "+s.getOverall_ability()+"\n");

                    }
                    connection.disconnect();

                }
                catch (IOException e){
                    e.printStackTrace();
                }
                delete_gridpane.add(test, 0, 0);
                delete_gridpane.add(delitem, 0, 1);
                delete_gridpane.add(label_confirm_delete, 0, 2);
                delete_gridpane.add(button_confirm_delete, 0,3);
                delete_gridpane.add(button_delete_back, 0, 4);

                primaryStage.setScene(delete_scene);
            }
        });

        button_confirm_delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("delete confirm button clicked");
                String temp= (String) delitem.getValue();
                temp=temp.substring(3,temp.indexOf("-"));
                System.out.println(temp);

                String delId = idField.getText();
                long del= Long.parseLong(temp);

                try {
                    URL url = new URL("http://localhost:8080/api/mutant/"+(del));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("DELETE");
                    connection.setDoOutput(true);
                    connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

                    OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                    wr.flush();
                    wr.close();
                    connection.connect();
                    if(connection.getResponseCode()==204){
                        label_confirm_delete.setText("Mutant deleted successfully");
                    }
                    else{
                        label_confirm_delete.setText("Mutant not added, "+"\n"+" please verify your values and try again");

                    }
                    connection.disconnect();
                }
                catch(IOException e){

                }
            }
        });
        button_display_page_back.setOnAction(e -> primaryStage.setScene(home_scene));
        button_display_one_back.setOnAction(e -> primaryStage.setScene(home_disp_scene));
        button_homedisp_back_new.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                flowpane.getChildren().clear();

                primaryStage.setScene(home_scene);
            }
        });

        button_add_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                label_confirm_add.setText("");
                primaryStage.setScene(home_scene);
            }
        });
       

        button_delete_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                delete_gridpane.getChildren().clear();
                label_confirm_delete.setText("");
                primaryStage.setScene(home_scene);
            }
        });
        primaryStage.setScene(home_scene);
        primaryStage.show();
    }

}
