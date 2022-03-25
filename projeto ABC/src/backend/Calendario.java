/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 
 */
public class Calendario {
    //variaveis de instancia
    HashMap <LocalDate, ArrayList<Evento>> calendario;
    
    //construtor
    public Calendario(){
        calendario = new HashMap();
    }
    
    //Método seletor
    public HashMap<LocalDate, ArrayList<Evento>> getcalendario() {
        return calendario;
    }
    
    //Método modificador
    public void setcalendario(HashMap<LocalDate, ArrayList<Evento>> calendario) {
        this.calendario = calendario;
    }

    //metodos
    public void AdicionarEvento(LocalDate data, Evento evento){
        ArrayList<Evento> marcacoes = calendario.get(data);
        
        if (marcacoes == null){
           marcacoes= new ArrayList<>();
           marcacoes.add(evento);
           calendario.put(data, marcacoes);
        } else if (!marcacoes.contains(evento)){
           marcacoes.add(evento);
        }else {
           System.out.println("O evento já está agendado para esse dia.");
        }       
    }
    
    public void CancelarEvento(LocalDate data, Evento evento){
        ArrayList<Evento> marcacoes = calendario.get(data);
        
        if (marcacoes != null && marcacoes.contains(evento)) {
            marcacoes.remove(evento);
            if (marcacoes.isEmpty()) {
                calendario.remove(data);
            }
        }
    }

    //consultar eventos num certo dia
    public ArrayList<Evento> ConsultarEvento(LocalDate data){
        return calendario.get(data);
    }

    //consultar eventos dia seguinte
    public ArrayList<Evento> EventosDiaSeguinte (){
        return calendario.get(LocalDate.now().plusDays(1));
    }
    
    //obter uma listagem com todos os Eventos marcados no calendario
    public List<Evento> Marcacoes_calendario (){
        ArrayList<Evento> lista = new ArrayList();
        
        for (LocalDate data: calendario.keySet()){
            ArrayList<Evento> marcacoes = calendario.get(data);
            for (Evento evento : marcacoes) {
                if (!lista.contains(evento)) {
                    lista.add(evento);
                }
            }
        }
        return lista;
    }
       
    //consultar data do proximo evento marcado no calendario
    public LocalDate ProximaMarcacao(Evento evento){
        int contador=0;
        ArrayList<Evento> marcacoes;
        do {
            if (calendario.containsKey(LocalDate.now().plusDays(contador))){
                marcacoes = calendario.get(LocalDate.now().plusDays(contador));
            }else{
                marcacoes= null;
            }
            contador+=1;
        } while (!marcacoes.contains(evento));
        return LocalDate.now().plusDays(contador);
    }
    
    //consultar o dia da marcacao do evento
    public LocalDate MarcacoesDoEvento(Evento evento){
        for(LocalDate data: calendario.keySet()){
            ArrayList<Evento> marcacoes = calendario.get(data);            
            if (marcacoes.contains(evento))
                return data;
        }
        return null;
    }
    
    //lista com todos os dias em que há marcacao de eventos
    public ArrayList<LocalDate> DiasComEventos(){
        ArrayList<LocalDate> lista= new ArrayList();
        for(LocalDate data: calendario.keySet()){
            ArrayList<Evento> marcacoes = calendario.get(data);
            if (marcacoes!=null){
                lista.add(data);
            }         
        }
        return lista;
    }
}

