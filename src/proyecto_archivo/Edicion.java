/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_archivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniba
 */
public class Edicion {
    Lista x=new Lista();
    public void escribitedicion(Lista x)
    {
        try {
            RandomAccessFile j=new RandomAccessFile("PlayList.ggs","rw");
            j.writeByte('P');
            j.writeByte('P');
            j.writeByte('P');
            j.writeByte('0');
            j.writeByte('0');
            j.writeByte('0');
            String cancion;
            String Artista;
            int largo;
            String Album;
            
            x.setsiguiente(x.getinicio());
            while(x.auxiliar!=null)
            {   
                if(x.getartista()!=null)
                {
                    
                     Artista=x.getartista();
                     
                     largo=Artista.length();
                    
                      j.writeByte('0');
                      j.writeByte((byte)largo);
                      j.writeByte('0');
                      for (int i = 0; i < Artista.length(); i++) {
                        j.writeByte(Artista.charAt(i));
                    }
                      
                }
                else
                {
                    j.writeByte('0');
                    j.writeByte('0');
                    
                }
                if(x.getalbum()!=null)
                {
                   
                     Album=x.getalbum();
                     largo=Album.length();
                     
                      j.writeByte('0');
                      j.writeByte((byte)largo);
                      j.writeByte('0');
                      for (int i = 0; i < Album.length(); i++) {
                        j.writeByte(Album.charAt(i));
                    }
                }
                else
                {
                    
                    j.writeByte('0');
                    j.writeByte('0');
                }
                 if(x.getnombre()!=null)
                {
                    
                     cancion=x.getnombre();
                    
                     largo=cancion.length();
                    
                      j.writeByte('0');
                      j.writeByte((byte)largo);
                      j.writeByte('0');
                      for (int i = 0; i < cancion.length(); i++) {
                        j.writeByte(cancion.charAt(i));
                    }
                      
                }
                else
                {
                    j.writeByte('0');
                    j.writeByte('0');
                    
                }
                cancion=x.getnombre();
                
                x.setsiguiente(x.getsiguinte());
            }
            j.close();
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Guardadatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Guardadatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
