/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 04999521202
 */
public class HistoricoController implements Initializable {

    @FXML
    private TableView<?> tbHistorico;
    @FXML
    private Button btnFechar;
    @FXML
    private TableColumn<?, ?> tbId;
    @FXML
    private TableColumn<?, ?> tbN1;
    @FXML
    private TableColumn<?, ?> tbN2;
    @FXML
    private TableColumn<?, ?> tbOp;
    @FXML
    private TableColumn<?, ?> tbResult;
    
    
    @FXML
    private void Fechar(ActionEvent event) {
         Stage stage = (Stage) btnFechar.getScene().getWindow();
            stage.close();
        }
    
    public void Listar(){
        // 1. Buscar fábrica de EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
     // 2. Buscar Entity manager ativo
        EntityManager em = emf.createEntityManager();
     // 3. Cria uma Query HQL para consulta no banco de dados
        Query query = em.createQuery("SELECT a FROM Historico a");
     // 4. Buscar uma lista (java.util.List)
        List<Historico> historico = query.getResultList();
     // 5. Converter List para ObservableList
     // Integer.parseint();
        ObservableList obHis = FXCollections.observableArrayList(historico);
     // 6. Adicionar lista na View
        tbHistorico.setItems(obHis);
               
        em.close();
        emf.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Listar();

    }    
    
}
