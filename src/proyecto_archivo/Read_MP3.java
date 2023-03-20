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
 * @author BryanMlg
 */
public class Read_MP3 {

    Lista nuevaa = new Lista();
    
    
        public void mostrar(){
        
        nuevaa.listar();
        
        
        }
        
        public Lista devolver(){
        
        return nuevaa;
        
        }
    
        Guardadatos f = new Guardadatos();
                
    
    public void lectura(String ruta) {

        int end;
        int WPUB = 0;
        int TIT2 = 0;
        int TPUB = 0;
        int TPE2 = 0;
        int WOAR = 0;
        int USLT = 0;
        int TRCK = 0;
        int TPOS = 0;
        int TCON = 0;
        int TYER = 0;
        int TPE1 = 0;
        int TALB = 0;
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "r");
            int s = -52;
            int contador = 0;
            //ANTES DE LEER EL ARCHIVO COMPARAMOS SI ES UN ID3
            if ((char) archivo.readByte() == 'I') {
                contador++;
                if ((char) archivo.readByte() == 'D') {
                    contador++;
                    if ((char) archivo.readByte() == '3') {
                        contador++;
                        byte x = archivo.readByte();
                        contador++;

                        int a = 0, b = 0, c = 0, d = 0;
                        end = 0;

                        /* BUSQUEDA DEL TIT2 [#TIT2 Title/songname/content description]*/
                        while (a != 84 || b != 73 || c != 84 || d != 50) {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 73 || c != 84 || d != 50) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }

                            end++;
                            if (end == 2000) {
                                a = 84;
                                b = 73;
                                c = 84;
                                d = 50;
                            }
                        }

                        if (end < 2000) {
                            TIT2 = contador;
                        } else {
                            TIT2 = -1;
                        }

                        /* BUSQUEDA DEL TPE2 [#TPE2 Band/orchestra/accompaniment]*/
                        contador = 3;
                        archivo.seek(3);
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 84 || b != 80 || c != 69 || d != 50) {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 80 || c != 69 || d != 50) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 2000) {
                                a = 84;
                                b = 80;
                                c = 69;
                                d = 50;

                            }
                        }

                        if (end < 2000) {
                            TPE2 = contador;
                        } else {

                            TPE2 = -1;
                        }
                        /* BUSQUEDA DONDE TERMINA EL TALB*/
                        contador = 3;
                        archivo.seek(3);
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        /* [#TALB Album/Movie/Show title]*/
                        while (a != 84 || b != 65 || c != 76 || d != 66)
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 65 || c != 76 || d != 66) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 2000) {
                                a = 84;
                                b = 65;
                                c = 76;
                                d = 66;
                            }
                        }

                        if (end < 2000) {
                            TALB = contador;
                        } else {
                            TALB = -1;
                        }
                        //BUSCA DONDE TERMINA EL TPE1 [#TPE1 Lead performer(s)/Soloist(s)] //
                        contador = 3;
                        archivo.seek(3);
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 84 || b != 80 || c != 69 || d != 49) {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 80 || c != 69 || d != 49) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 2000) {
                                a = 84;
                                b = 80;
                                c = 69;
                                d = 49;
                            }
                        }

                        if (end < 2000) {
                            TPE1 = contador;
                        } else {
                            TPE1 = -1;
                        }
//                  buscar donde termina TPE1         //
                        contador = 3;
                        archivo.seek(3);
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 84 || b != 80 || c != 85 || d != 66)//TPE1
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 80 || c != 85 || d != 66) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 2000) {
                                a = 84;
                                b = 80;
                                c = 85;
                                d = 66;
                            }
                        }

                        if (end < 2000) {
                            TPUB = contador;
                        } else {
                            TPUB = -1;
                        }
                        contador = 3;
                        archivo.seek(3);
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 84 || b != 89 || c != 69 || d != 82)//TYER
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 89 || c != 69 || d != 82) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 2000) {
                                a = 84;
                                b = 89;
                                c = 69;
                                d = 82;
                            }
                        }

                        if (end < 2000) {
                            TYER = contador;///termina etiqueta TIT2
                        } else {
                            TYER = -1;
                        }

                        // System.out.println("TYER "+TYER+" " +archivo.readByte());
                        ///////////////
                        contador = 3;
                        archivo.seek(3);
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 84 || b != 67 || c != 79 || d != 78)//TCON
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 67 || c != 79 || d != 78) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 2000) {
                                a = 84;
                                b = 67;
                                c = 79;
                                d = 78;
                            }
                        }

                        if (end < 2000) {
                            TCON = contador;///termina etiqueta TIT2
                        } else {
                            TCON = -1;
                        }

                        // System.out.println("TCON "+TCON+" " +archivo.readByte());
                        ////////////////
                        ///////////////
                        contador = 3;
                        archivo.seek(3);
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 84 || b != 80 || c != 79 || d != 83)//TPOS
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 80 || c != 79 || d != 83) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 99999) {
                                a = 84;
                                b = 80;
                                c = 79;
                                d = 83;
                            }
                        }

                        if (end < 99999) {
                            TPOS = contador;///termina etiqueta TIT2
                        } else {
                            TPOS = -1;
                        }

                        // System.out.println("TPOS "+TPOS+" " +archivo.readByte());
                        ////////////////
                        ///////////////
                        contador = 3;
                        archivo.seek(3);

                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 84 || b != 82 || c != 67 || d != 75)//TPOS
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 84 || b != 82 || c != 67 || d != 75) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 99999) {
                                a = 84;
                                b = 82;
                                c = 67;
                                d = 75;
                            }
                        }

                        if (end < 99999) {
                            TRCK = contador;///termina etiqueta TIT2
                        } else {
                            TRCK = -1;
                        }

                        //System.out.println("TRCK "+TRCK+" " +archivo.readByte());
                        ////////////////
                        ///////////////
                        contador = 3;
                        archivo.seek(3);

                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 85 || b != 83 || c != 76 || d != 84)//TPOS
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 85 || b != 83 || c != 76 || d != 84) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 99999) {
                                a = 85;
                                b = 83;
                                c = 76;
                                d = 84;
                            }
                        }

                        if (end < 99999) {
                            USLT = contador;///termina etiqueta TIT2
                        } else {
                            USLT = -1;
                        }

                        // System.out.println("USLT "+USLT+" " +archivo.readByte());
                        ////////////////
                        contador = 3;
                        archivo.seek(3);

                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;
                        while (a != 87 || b != 79 || c != 65 || d != 82)//TPOS
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 87 || b != 79 || c != 65 || d != 82) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 99999) {
                                a = 87;
                                b = 79;
                                c = 65;
                                d = 82;
                            }
                        }

                        if (end < 99999) {
                            WOAR = contador;///termina etiqueta TIT2
                        } else {
                            WOAR = -1;
                        }

                        //System.out.println("WOAR "+WOAR+" " +archivo.readByte());
                        ////////////////
                        ////////////////
                        contador = 3;
                        archivo.seek(3);

                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        end = 0;

                        while (a != 87 || b != 80 || c != 85 || d != 66)//TPOS
                        {
                            a = archivo.readByte();
                            contador++;

                            b = archivo.readByte();
                            contador++;

                            c = archivo.readByte();
                            contador++;

                            d = archivo.readByte();
                            contador++;
                            if (a != 87 || b != 80 || c != 85 || d != 66) {
                                contador = contador - 3;
                                archivo.seek(contador);
                            }
                            end++;
                            if (end == 99999) {
                                a = 87;
                                b = 80;
                                c = 85;
                                d = 66;
                            }
                        }

                        if (end < 99999) {
                            WPUB = contador;///termina etiqueta TIT2
                        } else {
                            WPUB = -1;
                        }

                        //System.out.println("WPUB "+WPUB+" " +archivo.readByte());
                        ////////////////
                    }

                }

            }
            /////pagina del disquera
            
            String genero = "";
            if (TCON != -1) {

                archivo.seek(TCON);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();

                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        genero = genero + (char) aux;
                    }
                }
               // System.out.println("Genero " + genero);

            } else {
                //System.out.println("null");
                genero = "Desconocido";
            }

            /////pagina del disquera
            
            String pagD = "";
            if (WPUB != -1) {

                archivo.seek(WPUB);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();

                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        pagD = pagD + (char) aux;
                    }
                }
                //System.out.println("Pagina disquera " + pagD);

            } else {
                //System.out.println("null");
                pagD = "Desconocido";
            }

            /////pagina del artista
            
            String pagA = "";
            if (WOAR != -1) {

                archivo.seek(WOAR);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        pagA = pagA + (char) aux;
                    }
                }
                //System.out.println("Pagina " + pagA);

            } else {
                //System.out.println("null");
                pagA = "Desconocido";
            }
            /////letra
            String letra = "";
            if (USLT != -1) {

                archivo.seek(USLT);

                int longitud = archivo.readInt() + 2;
                byte aux = 0;
//                byte longitud=0;
//                for (int i = 0; i <= 3; i++) {
//                    longitud=archivo.readByte();
//                }
//                
//                for (int i = 0; i < 2; i++) {
//                    archivo.readByte();
//                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();

                    if (aux > 31 && aux < 124) {
                        letra = letra + (char) aux;
                    }
                    if (aux == 0 || aux == 12 || aux == 10) {
                        letra = letra + (char) aux;
                    }
                }
                //System.out.println("Letra " + letra);

            } else {
                //System.out.println("null");
                letra = "Desconocido";
            }
            /////numero track
            
            String track = "";
            if (TRCK != -1) {

                archivo.seek(TRCK);

                byte aux = 0;
                short longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        track = track + (char) aux;
                    }
                }
                //System.out.println("Pista " + track);

            } else {
                //System.out.println("null");
                track = "Desconocido";
            }
            /////año
            
            String año = "";
            if (TYER != -1) {

                archivo.seek(TYER);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        año = año + (char) aux;
                    }
                }
                //System.out.println("año " + año);

            } else {
                //System.out.println("null");
                año = "Desconocido";
            }
            /////no album
            
            String NoA = "";
            if (TPOS != -1) {

                archivo.seek(TPOS);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        NoA = NoA + (char) aux;
                    }
                }
                System.out.println("No. Album " + NoA);

            } else {
                //System.out.println("null");
                NoA = "Desconocido";
            }
            ///////////album
            
            String alb = "";
            if (TALB != -1) {

                archivo.seek(TALB);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        alb = alb + (char) aux;
                    }
                }
                //System.out.println("album " + alb);

            } else {
                //System.out.println("null");
                alb = "Desconocido";
            }
            //////artista2;
            
            String art2 = "";
            if (TPE2 != -1) {

                archivo.seek(TPE2);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        art2 = art2 + (char) aux;
                    }
                }
                //System.out.println("artsta 2 " + art2);

            } else {
                //System.out.println("null");
                art2 = "Desconocido";
            }
            //////artista;
            
            String art1 = "";
            if (TPE1 != -1) {

                archivo.seek(TPE1);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        art1 = art1 + (char) aux;
                    }
                }
                //System.out.println("artista 1 " + art1);

            } else {
               // System.out.println("null ");
                art1 = "Desconocido";
            }
            //////obtener cancion;
            String cancion = "";
            if (TIT2 != -1) {
                archivo.seek(TIT2);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        cancion = cancion + (char) aux;
                    }
                }
                //System.out.println("Cancion " + cancion);

            } else {
                //System.out.println("null");
                cancion = "Desconocido";
            }
            //////disquera;
            String disquera = "";
            if (TPUB != -1) {

                archivo.seek(TPUB);

                byte aux = 0;
                byte longitud = 0;
                for (int i = 0; i <= 3; i++) {
                    longitud = archivo.readByte();
                }

                for (int i = 0; i < 2; i++) {
                    archivo.readByte();
                }
                for (int i = 0; i < longitud; i++) {
                    aux = archivo.readByte();
                    if (aux > 31 && aux < 124) {
                        disquera = disquera + (char) aux;
                    }
                }
                //System.out.println("Disquera " + disquera);

            } else {
                //System.out.println("null");
                disquera = "Desconocido";
            }

            nuevaa.agregarAlInicio(ruta,cancion,art1,alb,disquera,letra,pagA,pagD,genero,track,NoA,año);
         
            archivo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Read_MP3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Read_MP3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    f.escribit(nuevaa);

    }
    
    
//      public  String retornanombre(){
//    
//          String nombre;
//    
//        nombre = list.getinicio().getcancion();
//        
//        return nombre;
//   
//    }
    

    
    
  
}
