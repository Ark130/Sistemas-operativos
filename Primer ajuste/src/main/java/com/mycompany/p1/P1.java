package com.mycompany.listanodo;

public class ListaNodo {
    
    class Nodo { //Se crea el nodo
        int dato;
        Nodo next;
    }
    
    private Nodo inicio; 
    
    public ListaNodo() {
        inicio=null;
    }
      
   void insertar(int valor)
    {
        Nodo nuevo = new Nodo ();
        if (nuevo!=null) {
        nuevo.dato = valor;
        nuevo.next=null;
        Nodo previo=null;
        Nodo actual=inicio;
        while(actual!=null && valor>actual.dato){
            previo=actual;
            actual=actual.next;
        }
         if(previo==null){  //Al principio
            nuevo.next= inicio;
            inicio=nuevo;
        }
          else{
            previo.next=nuevo; //Final o medio
            nuevo.next=actual;
        }
    
        
    }else{
       System.out.println("Valor no insertado"+valor);
        }
    }
    
int eliminar(int valor)
{
    Nodo previo, actual, temporal;
    if(valor==(inicio).dato){
        temporal=inicio;
        inicio=(inicio).next;
        //free(temporal);
        return valor;
    }
    else
    {
        previo=inicio;
        actual=(inicio).next;
        while(actual!=null && actual.dato!=valor){
            previo=actual;
            actual=actual.next;
        }
        if(actual!=null){
            temporal=actual;
            previo.next=actual.next;

 

            return valor;
        }
        else
        {
            System.out.println("No existe el valor");
            return 0;
        }
    }
}

 

    public void imprimir () {
        Nodo actual = inicio;
        if(actual==null)
        {
            System.out.println("Lista vacía");
        }
        else
        {
            System.out.println("La lista es:");
        while (actual != null) {
            System.out.println("-->"+actual.dato);
            actual = actual.next;
        }
        System.out.println();
        }
    }
    
    
void buscar(int valor)
{
    Nodo previo, actual;
    int posicion=0;
    if(valor==(inicio).dato){
           posicion=posicion+1;
           System.out.println("Se encontro el valor: "+valor+ " en la posición "+posicion);
    }
    else
    {
        previo=inicio;
        actual=(inicio).next;
          posicion=posicion+1;
        while(actual!=null && actual.dato!=valor){
            previo=actual;
            actual=actual.next;
            posicion=posicion+1;
        }
        if(actual!=null){
           System.out.println("Se encontro el valor: "+valor+ " en la posición "+(posicion+1));
      
        }
        else
        {
            System.out.println("No existe el valor "+valor+" en la lista");
        }
    }
}

 

        
    
    public static void main(String[] ar) {
        ListaNodo listanodo=new ListaNodo();
        listanodo.insertar(2);
        listanodo.insertar(5);
        listanodo.insertar(10);
        listanodo.insertar(7);
        listanodo.imprimir();
        listanodo.eliminar(2);
        listanodo.insertar(-2);
        listanodo.imprimir();
        listanodo.buscar(10);
    }
}