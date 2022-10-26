import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lyrics {

    private Map<String, List<Integer>> wordsPositions;

    
    public Set<String> getMapKeys() {
        return wordsPositions.keySet();
    }

    public Integer[][] getMapValues() {
       Integer[][] resultado = new Integer[wordsPositions.keySet().size()][];
       int pos=0;
       for (String s:wordsPositions.keySet()) {
           List<Integer> valor = wordsPositions.get(s);
           resultado[pos] = new Integer[valor.size()];
           valor.toArray(resultado[pos]);
           pos++;

       }
       return resultado;
    }

    //Completar constructor.
    //filename es el nombre del fichero
    //Debe crear un Mapa con las palabras del fichero y las posiciones que ocupan (empezando a contar en 1)
    public Lyrics(String filename) {
        Scanner sc = null;

        try {
            sc= new Scanner (new File(filename));

        } catch(FileNotFoundException e){
            System.out.println("Error al abrir el fichero");
            System.exit(0);
        }

        //Ejercicio 1 - Constructor
        wordsPositions = new TreeMap<>();
        int j=1,n;
        String palabra;
        while (sc.hasNextLine()) {
            //Lee la siguiente línea del fichero y la convierte en mayúscualas
            String line = sc.nextLine().toUpperCase(); 

            //Divide la línea en palabras
            String[] words = line.split(" ");
            for (int i=0;i<words.length;i++){
                palabra=words[i];
                n=(i==words.length-1?-1:1);
                if (wordsPositions.isEmpty() || !wordsPositions.containsKey(palabra)){
                    List<Integer>lista=new ArrayList<>();
                    lista.add(j*n);
                    wordsPositions.put(palabra,lista);
                }else
                    wordsPositions.get(palabra).add(j*n);
                j++;
            }
        }
        sc.close();

    }

    //Ejercicio 2: devuelve el número de palabras distintas
    public int differentWords() {
        return wordsPositions.size();

    }

    //Ejercicio 3: Devuelve el conjunto de palabras distintas ordenado alfabéticamente
    public Set<String> listWords() {
        return wordsPositions.keySet();
    }

    //Ejercicio 4: Devuelve el número de palabras distintas en el texto
    public int totalWords() {
        int x=0;
        Collection<List<Integer>>collection=wordsPositions.values();
        for (List<Integer>y:collection)
            x+=y.size();
        return x;
    }

    //Ejercicio 5: Palabras usadas al menos n veces
    public Set<String> wordsUsedOver (int n) {
        Set<String> palabras=new HashSet<>();
        Set<String> key=wordsPositions.keySet();
        for (String x:key){
            if (wordsPositions.get(x).size()>=n){
                palabras.add(x);
            }
        }
        return palabras;
    }

    //Ejercicio 6: Devuelve el conjunto de palabras que se usan para terminar versos
    public Set<String> terminalWords() {

        return null;
    }

    //Ejercicio 7: Devuelve un StringBuilder con el texto en versos, listo para ser
    //mostrado por pantalla
    public StringBuilder displayLyrics() {
        StringBuilder out= new StringBuilder();

        return out;
    }


    //Ejercicio 8: Cambiar todas las ocurrencias de una palabra por otra
    //Devuelve el número de palabras cambiadas
    //Si la palabra origin, no está, no cambia nada
    //La palabra target puede ser una palabra que ya esté en el texto o no
    public int changeWord (String source, String target) {

        return 0;
    }


}

