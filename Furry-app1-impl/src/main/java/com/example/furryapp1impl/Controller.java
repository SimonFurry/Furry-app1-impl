package com.example.furryapp1impl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.stage.*;

import java.io.*;

import java.util.*;


public class Controller {

    @FXML TextArea textDisplay;
    @FXML TextField itemDesc;
    @FXML TextField itemDate;
    @FXML TextField textField;
    @FXML TextField textField1;
    @FXML TextField textField2;
    @FXML TextField textFieldDelete;
    @FXML Button addButton;
    @FXML TextField saveName;

    private Stage stage;



    public void init(Stage stage){
        this.stage = stage;
    }

    public void loadList(MouseEvent mouseEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if(file != null){
            System.out.println("Chosen file: " + file);
            /*
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> lines = new ArrayList<>();
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);

             */

            Scanner s = new Scanner(file);
            while(s.hasNext()){
                if(s.hasNextInt()){
                    textDisplay.appendText(s.nextInt()+" ");
                }else{
                    textDisplay.appendText(s.next()+" ");
                }
            }
            //fr.close();


        }
    }


    public void addNewList(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(toDoListApplication.class.getResource("NameList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Mom's Basement");
        stage.setScene(scene);
        stage.show();
    }

        public void listName(MouseEvent mouseEvent) throws IOException {
            String fileName = textField.getText();
            fileName = fileName + ".txt";
            File file = new File("Lists/"+fileName);
            file.createNewFile();
            ((Stage)(((Button)mouseEvent.getSource()).getScene().getWindow())).close();
        }

    public void editExistingList() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(toDoListApplication.class.getResource("EditList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Mom's Basement");
        stage.setScene(scene);
        stage.show();
    }

        public void replaceListName(MouseEvent mouseEvent) throws IOException {
            String fileName1 = textField1.getText();
            String fileName2 = textField2.getText();

            File file1 = new File("Lists/"+fileName1+".txt");
            File file2 = new File("Lists/"+fileName2+".txt");

            if(file1.renameTo(file2)){
                System.out.print("Success"); //Success and failure for testing.
            }else{
                System.out.print("failure");
            }
            ((Stage)(((Button)mouseEvent.getSource()).getScene().getWindow())).close();
        }

    public void removeExistingList() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(toDoListApplication.class.getResource("DeleteList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Mom's Basement");
        stage.setScene(scene);
        stage.show();
    }

    public void saveList(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(toDoListApplication.class.getResource("SaveList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Mom's Basement");
        stage.setScene(scene);
        stage.show();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Lists/default_renameable_file.txt"));
        bufferedWriter.write(textDisplay.getText());

        bufferedWriter.close();



        textDisplay.setText("");
    }

    public void addItemToList(MouseEvent mouseEvent) {
        textDisplay.appendText("\n" + itemDesc.getText() +" ; " + itemDate.getText());
        itemDesc.setText("");
        itemDate.setText("");
    }

    public void exit(MouseEvent mouseEvent) {
        ((Stage)(((Button)mouseEvent.getSource()).getScene().getWindow())).close();
    }

    public void deleteList(MouseEvent mouseEvent) {

        String fileNameDelete = textFieldDelete.getText();
        File fileToDelete = new File("Lists/"+fileNameDelete + ".txt");

        if(fileToDelete.delete()){
            System.out.println("File Deleted Successfully: " + fileToDelete.getName());
        }else{
            System.out.println("Failed to Delete");
        }

        ((Stage)(((Button)mouseEvent.getSource()).getScene().getWindow())).close();
    }

    public void saveButton(ActionEvent actionEvent) throws IOException {

        String fileName = saveName.getText();

        File file1 = new File("Lists/default_renameable_file.txt");
        File file2 = new File("Lists/"+fileName+".txt");

        if(file1.renameTo(file2)){
            System.out.print("Success"); //Success and failure for testing.
        }else{
            System.out.print("failure");
        }
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
}
