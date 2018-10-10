/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Vinícius
 */
public class CalculadoraController implements Initializable {
    
    String n1, n2, nR, op;
            
    @FXML
    private TextField txt1, txt2, txtResult;
    
    @FXML
    private Button btnAdicao, btnSubtracao, btnMultiplicacao, btnDivisao;
    
    @FXML
    private Label lbln1, lbln2;
    @FXML
    private Label lblresult;
    @FXML
    private Button btnLimpar;
    @FXML
    private Button btnHistorico;
    
    @FXML
    private void Adicao(ActionEvent event) {
        Double N1 = Double.parseDouble(txt1.getText());
        Double N2 = Double.parseDouble(txt2.getText());
        Double resultado= N1 + N2;
        txtResult.setText(resultado.toString());
        
        n1 = txt1.getText();
        n2 = txt2.getText();
        nR = txtResult.getText();
        op = "+";
    }
    @FXML
    private void Subtracao(ActionEvent event) {
        Double N1 = Double.parseDouble(txt1.getText());
        Double N2 = Double.parseDouble(txt2.getText());
        Double resultado= N1 - N2;
        txtResult.setText(resultado.toString());
        
        n1 = txt1.getText();
        n2 = txt2.getText();
        nR = txtResult.getText();
        op = "-";
    }
    
    @FXML
    private void Multiplicacao(ActionEvent event) {
        Double N1 = Double.parseDouble(txt1.getText());
        Double N2 = Double.parseDouble(txt2.getText());
        Double resultado= N1 * N2;
        txtResult.setText(resultado.toString());
        
        n1 = txt1.getText();
        n2 = txt2.getText();
        nR = txtResult.getText();
        op = "*";
    }
    @FXML
    private void Divisao(ActionEvent event) {
        Double N1 = Double.parseDouble(txt1.getText());
        Double N2 = Double.parseDouble(txt2.getText());
        Double resultado= N1 / N2;
        txtResult.setText(resultado.toString());
        
        n1 = txt1.getText();
        n2 = txt2.getText();
        nR = txtResult.getText();
        op = "/";
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Limpar(ActionEvent event) {
        txt1.setText("");
        txt2.setText("");
        txtResult.setText("");
        
    }

    @FXML
    private void Historico(ActionEvent event) {
         try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/Historico.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),600,430);
            Stage stage = new Stage();
            stage.setTitle("Historico");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
    }
    
}
}
