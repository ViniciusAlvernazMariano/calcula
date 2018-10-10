/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 04999521202
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnFechar;
    @FXML
    private Button btnconfirmar;
    @FXML
    private PasswordField txtpass;
    @FXML
    private TextField txtUsu;

    @FXML
    private void Entrar() throws IOException {
        javax.persistence.EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaPlanet");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT l FROM Usuario as l WHERE l.Usuario = :usuario");        
        //Query query = em.createQuery("SELECT l FROM Login as l WHERE l.usuario = :usuario and l.senha = :senha");
        String user = txtUsu.getText();
        query.setParameter("usuario", user);
        //query.setParameter("senha", txtSenha.getText());
        //Login login1 = (Login) query.getSingleResult();
        List<usuario> Usuariol = query.getResultList();
        if (!Usuariol.isEmpty()) {
            //System.out.println(l[0]);
            usuario login = Usuariol.get(0);
            String senha = txtpass.getText();
            if (login.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
                Stage stage = (Stage) btnconfirmar.getScene().getWindow();
                    stage.close();
       abrirMenuPrincipal();
            }
            else {
                JOptionPane.showMessageDialog(null, "Senha incorreta");
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "Usuário incorreto");
        }
        em.close();
        emf.close();
    }
  @FXML
    private void Fechar(ActionEvent event) {
       
        Stage stage = (Stage) btnFechar.getScene().getWindow();
        stage.close();
    }
    private void abrirMenuPrincipal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/Calculadora.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),600,425);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(" Calculadora");
            stage.setScene(scene);
            stage.show();
            
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
