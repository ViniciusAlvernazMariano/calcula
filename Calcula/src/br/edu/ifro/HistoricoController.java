/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 04999521202
 */
public class HistoricoController implements Initializable {

    @FXML
    private TableColumn<?, ?> tbHistorico;
    @FXML
    private Button btnFechar;
    @FXML
    private void Fechar(ActionEvent event) {
         Stage stage = (Stage) btnFechar.getScene().getWindow();
            stage.close();
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
