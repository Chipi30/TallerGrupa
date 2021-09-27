package com.example.fxjava;

import java.util.ArrayList;
import java.util.Iterator;

public class Juego {

    private int numeroJugadores, nivelJuego,posicion;
    private ArrayList<Jugador> jugador;

    public Juego(int numeroJugadores, int nivel,int posicion) {
        this.numeroJugadores = numeroJugadores;
        this.nivelJuego = nivel;
        jugador = nuevosJugadores();
        this.posicion = posicion;
    }

    private ArrayList<Jugador> nuevosJugadores(){
        ArrayList<Jugador> play = new ArrayList();
        for(int i = 1; i <= this.numeroJugadores; ++i){
            play.add(new Jugador(i + "" ,this.nivelJuego));
        }
        return play;
    }

    public void ronda(int avanzo1, int avanzo2){
        devolver(jugador.get(this.posicion).getPosAvanzadas()+(avanzo1+avanzo2));
        jugador.get(posicion).avanzar(avanzo1 + avanzo2);
        if(avanzo1 != avanzo2){
            if(this.posicion < this.numeroJugadores - 1){
                ++this.posicion;
            }
            else this.posicion = 0;
        }
    }
    public void devolver(int dev){
        for(int i = 0; i < jugador.size(); ++i){
            if( jugador.get(i).getPosAvanzadas() == dev){
                jugador.get(i).reiniciar();
            }
        }
    }
    //public void prueba(){
      //  System.out.println("****PRUEBA****");
      //  System.out.println("id = "+jugador.get(posicion).getId());
       // System.out.println("avanzadas = "+jugador.get(posicion).getPosAvanzadas());
  //  }

    public boolean hayGanador(){
        boolean ganador = false;
        Iterator k = jugador.iterator();
        while(k.hasNext()){
            Jugador a = (Jugador) k.next();
            if(a.getPosAvanzadas() >= a.getNivel()){
                ganador = true;
            }
        }
        return ganador;
    }

    public int nombreGanador(){
        boolean ganador = false;
        Iterator k = this.jugador.iterator();
        Jugador a;
        do{
            if(k.hasNext()){
                return -1;
            }
            a = (Jugador) k.next();
        }while(a.getPosAvanzadas() < a.getNivel());
        return Integer.parseInt(a.getId());
    }

    public ArrayList<Jugador> getJugador() {

        return jugador;
    }

    public void setJugador(ArrayList<Jugador> jugador) {

        this.jugador = jugador;
    }

    public int getNumeroDeJugadores() {

        return numeroJugadores;
    }

    public void setNumeroDeJugadores(int numeroDeJugadores) {

        this.numeroJugadores = numeroDeJugadores;
    }

    public int getNivelJuego() {

        return nivelJuego;
    }

    public void setNivelJuego(int nivelJuego) {

        this.nivelJuego = nivelJuego;
    }

    public int getPosicion() {

        return posicion;
    }

    public void setPosicion(int posicion) {

        this.posicion = posicion;
    }


}
