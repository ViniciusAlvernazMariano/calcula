package br.edu.ifro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer Id;
    private String primeiroValor;
    private String segundoValor;
    private String operador;
    private String resultado;
    
    public String toString() {
        return this.primeiroValor;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getPrimeiroValor() {
        return primeiroValor;
    }

    public void setPrimeiroValor(String primeiroValor) {
        this.primeiroValor = primeiroValor;
    }

    public String getSegundoValor() {
        return segundoValor;
    }

    public void setSegundoValor(String segundoValor) {
        this.segundoValor = segundoValor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
