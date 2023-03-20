/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_archivo;

/**
 *
 * @author BryanMlg
 */
public class Lista {
   
    private nodo inicio;
  
   // nodo aux;
    // Variable para registrar el tamaño de la lista.
    private int tamanio;
    /**
     * Constructor por defecto
     * 
     * .
     */
    
    public void Lista(){
        inicio = null;
        tamanio = 0;
    }
    
    
//    public nodo getsiguinte()
//    {
//        return aux.getSiguiente();
//    }
//    public void setsiguiente(nodo sig)
//    {
//        aux=sig;
//    }
//    public nodo getinicio(){
//        return inicio;
//    }
//    public String getartista()
//    {
//        return aux.getartista();
//    }
//    public String getalbum()
//    {
//        return aux.getalbum();
//    }
//    public String getnombre()
//    {
//        return aux.getcancion();
//    }
     public boolean esVacia(){
        return inicio == null;
    }
    public int getTamanio(){
        return tamanio;
    }
    
//    public int mostrar()
//	{
//	
//		aux=inicio;
//		if(inicio==null)
//		{
//			System.out.println("Lista vacia");
//                        return 0;
//		}
//		else
//		{
//			
//			while(aux!=null)
//			{
//				System.out.println("Ruta "+aux.getpath());
//                                System.out.println("Cancion "+aux.getcancion());
//                                System.out.println("Artista "+aux.getartista());
//                                System.out.println("Album "+aux.getalbum());
//                                System.out.println("Genero "+aux.getgenero());
//                                System.out.println("Pista "+aux.gettrack());
//                                System.out.println("No. Abum "+aux.getNoA());
//                                System.out.println("Año "+aux.getaño());
//                                System.out.println("Disquera "+aux.getdisquera());
//                                System.out.println("Letra "+aux.getletra());
//                        
//                                System.out.println("Pagina Disquera "+aux.getpagD());
//                               
//                                
//				aux=aux.getSiguiente();
//			}
//                        return-4;
//		}
//        }
   
     
     nodo auxiliar;
    
      public nodo getsiguinte()
    {
         return auxiliar.getSiguiente();
    }
    public void setsiguiente(nodo sig)
    {
        auxiliar=sig;
    }
    
     public String getartista()
    {
        return auxiliar.getartista();
    }
    public String getalbum()
    {
        return auxiliar.getalbum();
    }
    public String getnombre()
    {
        return auxiliar.getcancion();
    }
     
 
            
    public void agregarAlInicio(String path,String cancion,String artista,String album,String disquera,String letra, String pagA,String pagD,String genero,String track,String NoA,String año){
        // Define un nuevo nodo.
       nodo nuevo = new nodo();
        // Agrega al valor al nodo.
        nuevo.setpath(path);
        nuevo.setcancion(cancion);
        nuevo.setartista(artista);
        nuevo.setalbum(album);
        nuevo.setdisquera(disquera);
        nuevo.setPagA(pagA);
        nuevo.setpagD(pagD);
        nuevo.setgenero(genero);
        nuevo.settrack(track);
        nuevo.setNoA(NoA);
        nuevo.setaño(año);
        
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
        // Caso contrario va agregando los nodos al inicio de la lista.
        } else{
            // Une el nuevo nodo con la lista existente.
            nuevo.setSiguiente(inicio);
            // Renombra al nuevo nodo como el inicio de la lista.
            inicio = nuevo;
        }
        // Incrementa el contador de tamaño de la lista.
        tamanio++;
        
    }
    
    
    
      public void listar(){
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            nodo aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while(aux != null){
                // Imprime en pantalla el valor del nodo.
                System.out.println(i + ".[ " + aux.getcancion() + " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.getartista() + " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.getalbum() + " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.getNoA() + " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.getaño() + " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.getdisquera()+ " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.getgenero() + " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.getpagD() + " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.getpath() + " ]" + " ->  ");
                System.out.println(i + ".[ " + aux.gettrack() + " ]" + " ->  ");
             
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }
      
      public String rutaa(){
      
      
      String rut = inicio.getpath();
      
      return rut;
      
      }
             
       public void llenar(){
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            nodo aux = inicio;
            // Posicion de los elementos de la lista.
      
            // Recorre la lista hasta el final.
            while(aux != null){
                // Imprime en pantalla el valor del nodo.
              
               aux.getcancion();
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
             
            }
        }
        
    }
      
       public nodo getinicio(){
       
       return inicio;
       }
       
       
}
