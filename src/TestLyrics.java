import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestLyrics {

    String[] casos = new String[]{"alberti.txt", "enjoanpetit.txt", "pisos.txt", "unamuno.txt"};
    String[] caso1w = new String[]{"CANTARÉ", "CUANDO", "DE", "FALTA", "GRITARÉ", "HAGA", "LLORARÉ", "NUNCA", "PIEDRA", "REIRÉ", "SERÉ", "YO"};
    int[][] caso1mat = {{18}, {7, 11, 15, 19}, {4}, {-9, -13, -17, -21}, {10}, {8, 12, 16, 20}, {6}, {2}, {-5}, {14}, {3}, {1}};
    String[] caso2w = new String[]{"", "AMB", "ARA", "BALLA", "BRAÇ", "DIT", "EL", "EN", "JOAN", "LA", "MÀ", "PETIT", "PEU", "QUAN"};
    int[][] caso2mat = {{-28, -61, -99}, {15, 18, 43, 46, 51, 76, 79, 84, 89, 114, 117, 122, 127, 132}, {23, 56, 94, 137}, {-5, 6, 7, -8, -13, 14, 24, -33, 34, 35, -36, -41, 42, 57, -66, 67, 68, -69, -74, 75, 95, -104, 105, 106, -107, -112, 113, 138}, {-78, 81, 82, -83, 124, 125, -126}, {-17, 20, 21, -22, 53, 54, -55, 91, 92, -93, 134, 135, -136}, {16, 19, 44, 52, 77, 80, 90, 115, 118, 123, 133}, {1, 9, 25, 29, 37, 58, 62, 70, 96, 100, 108, 139}, {2, 10, 26, 30, 38, 59, 63, 71, 97, 101, 109, 140}, {47, 85, 128}, {-45, 48, 49, -50, 86, 87, -88, 129, 130, -131}, {3, 11, -27, 31, 39, -60, 64, 72, -98, 102, 110, -141}, {-116, 119, 120, -121}, {4, 12, 32, 40, 65, 73, 103, 111}};
    String[] caso3w = new String[]{"AL", "ALGO", "AMARILLO", "AQUEL", "BLANCO", "BRILLO", "COLOR", "CUÁL", "DE", "DECIR", "EL", "ENOJO", "ES", "ESPUMA", "GRILLO", "LA", "MARRÓN", "MIRADO", "NEGRA", "NUBE", "O", "PENA", "QUIERE", "REVÉS", "RISA", "ROJO", "SI", "SUBE", "TIERRA", "Y"};
    int[][] caso3mat = {{23, 55}, {-12}, {-9}, {16}, {-19, -24}, {-8}, {43, 50}, {47}, {15, 20, 25, 36, 39, 44, 51}, {11}, {2, 7, 13, 18, 42, 49}, {-3}, {4, 33, 35, -48}, {-22}, {-17}, {21, 26, 31, 45, 52}, {-14}, {54}, {-34}, {-27, -32, -37}, {38}, {-53}, {10}, {-56}, {-46}, {-5}, {1, 30}, {-28}, {-40}, {6, 29, 41}};
    String[] caso4w = new String[]{"", "ADENTRO", "AFUERA", "CASA", "COMO", "CON", "CREAN", "CRÍA", "DE", "DESDE", "EL", "EN", "ESFERA", "ESPERAN", "ESTÁN", "ETERNA", "FLORES", "FUERA", "HACIA", "HACIENDO", "HAY", "HIERBA", "LA", "LAS", "LLAMAN", "LLANTO", "LLORAN", "LLOROSOS", "LOS", "MANO", "MAS", "ME", "MI", "MIRAN", "MUERO", "NAZCO", "OJOS", "OTROS", "PENA", "PLACENTERA", "QUE", "RIENTES", "RISA", "RÍEN", "SOL", "SON", "SUEÑAN", "TERESA", "TIERRA", "TU", "TUMBA", "TUS", "UNOS", "VERDES", "VEREDA", "VIVO", "Y", "YO"};
    int[][] caso4mat = {{-37, -87}, {33, 83}, {-86}, {111}, {39}, {27, 77}, {-95}, {43}, {29, 59, 79, 103}, {81, 84}, {101}, {88, 98, 106}, {-105}, {-16, -68}, {55}, {51}, {41}, {-36}, {32, 35}, {56}, {1, 5, 9, 13, 17, 23}, {-60}, {44}, {40}, {12, 66}, {28, 78}, {26, 75}, {76}, {53}, {58}, {46}, {61, 63, 65, 67, 69, 74, 94}, {50, 104, 110, 116, 120}, {4, 62}, {109}, {91}, {2, 6, 10, 14, 18, 24, 48, 90, 93, 100, 108, 115, 119}, {34}, {-30, -80}, {-22, -73}, {3, 7, 11, 15, 19, 25, 42, 54}, {71}, {21, 72}, {20, 70}, {102}, {38}, {-8, 64}, {-52}, {-45, 82, 85, -121}, {57}, {117}, {47, 89, 92, 99, 107, 114, 118}, {31}, {49}, {-113}, {96}, {112}, {97}};

    public static Set<String> leerfichero(String filename, ArrayList<String> palabras) {
        Scanner sc = null;

        try {
            sc = new Scanner(new File(filename));

        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el fichero");
            System.exit(0);
        }

        Set<String> res = new HashSet<>();

        while (sc.hasNextLine()) {

            String line = sc.nextLine(); //Lee la siguiente línea del fichero

            String[] words = line.split(" "); //Divide la línea en palabras

            palabras.add("");
            for (int i = 0; i < words.length - 1; i++) {
                //System.out.println(words[i]);
                String word = words[i].toUpperCase();
                palabras.add(word+" ");

            }

            String lastWord = words[words.length - 1].toUpperCase() + "\n";
            palabras.add(lastWord);
            res.add(words[words.length - 1].toUpperCase());

        }
        sc.close();
        List<String> aux = new ArrayList<>(res);
        Collections.sort(aux);
        res.clear();
        res.addAll(aux);
        return res;
    }

    private static int findPos(String word, String[] casew) {
        int i = 0;
        boolean found = false;
        while (i < casew.length && !found) {
            if (casew[i].equals(word))
                found = true;
            else
                i++;
        }
        if (found)
            return i;
        else
            return -1;
    }


    private void constructorTest (String [] casow, int[][] casomat, Lyrics ly) {
        Set<String> obtenidow = ly.getMapKeys();
        assertEquals(casow.length, obtenidow.size());
        int i = 0;
        for (String s : obtenidow) {
            assertEquals(casow[i], s);
            i++;
        }
        //assertEquals(caso1w, obtenidow.toArray());
        System.out.println("Obtenido: " + obtenidow);
        Integer[][] obtenidov = ly.getMapValues();
        assertEquals(casomat.length, obtenidov.length);
        for (i = 0; i < obtenidov.length; i++) {
            for (int j = 0; j < obtenidov[i].length; j++)
                assertEquals((Integer) casomat[i][j], obtenidov[i][j]);
        }
        System.out.println();
    }

    @Test
    public void constructorTest() {
        System.out.println("Test constructor ");
        System.out.println();
        Lyrics lyricsCaso = new Lyrics(casos[0]);
        System.out.println("Caso: " + casos[0]);
        constructorTest(caso1w, caso1mat, lyricsCaso);

        System.out.println("Caso: " + casos[1]);
        lyricsCaso = new Lyrics(casos[1]);
        constructorTest(caso2w, caso2mat, lyricsCaso);

        System.out.println("Caso: " + casos[2]);
        lyricsCaso = new Lyrics(casos[2]);
        constructorTest(caso3w, caso3mat, lyricsCaso);

        System.out.println("Caso: " + casos[3]);
        lyricsCaso = new Lyrics(casos[3]);
        constructorTest(caso4w, caso4mat, lyricsCaso);

    }

    @Test
    public void differentWordsTest() {
        System.out.println("differentWords");
        Lyrics lyricsCaso = new Lyrics(casos[0]);
        int esperado = caso1w.length;
        int obtenido = lyricsCaso.differentWords();
        System.out.println("Caso 1. Esperado: " + esperado + " obtenido: " + obtenido);
        assertEquals(esperado, obtenido);
        System.out.println();

        lyricsCaso = new Lyrics(casos[1]);
        esperado = caso2w.length;
        obtenido = lyricsCaso.differentWords();
        System.out.println("Caso 2. Esperado: " + esperado + " obtenido: " + obtenido);
        assertEquals(esperado, obtenido);
        System.out.println();

        lyricsCaso = new Lyrics(casos[2]);
        esperado = caso3w.length;
        obtenido = lyricsCaso.differentWords();
        System.out.println("Caso 3. Esperado: " + esperado + " obtenido: " + obtenido);
        assertEquals(esperado, obtenido);
        System.out.println();

        lyricsCaso = new Lyrics(casos[3]);
        esperado = caso4w.length;
        obtenido = lyricsCaso.differentWords();
        System.out.println("Caso 4. Esperado: " + esperado + " obtenido: " + obtenido);
        assertEquals(esperado, obtenido);
        System.out.println();
    }

    @Test
    public void listWordsTest() {
        System.out.println("listWords test ");
        System.out.println( " caso: "+casos[0]);
        Lyrics lyricsCaso = new Lyrics(casos[0]);
        Set<String> obtenido = lyricsCaso.listWords();
        Set<String> esperado = new HashSet<>();
        for (String w:caso1w)
            esperado.add(w);
        assertEquals(esperado,obtenido);
        System.out.println("Obtenido: "+obtenido);
        System.out.println();

        System.out.println( " caso: "+casos[1]);
        lyricsCaso = new Lyrics(casos[1]);
        obtenido.clear();
        esperado.clear();
        obtenido = lyricsCaso.listWords();
        for (String w:caso2w)
            esperado.add(w);
        assertEquals(esperado,obtenido);
        System.out.println("Obtenido: "+obtenido);
        System.out.println();

        System.out.println( " caso: "+casos[2]);
        lyricsCaso = new Lyrics(casos[2]);
        obtenido.clear();
        esperado.clear();
        obtenido = lyricsCaso.listWords();
        for (String w:caso3w)
            esperado.add(w);
        assertEquals(esperado,obtenido);
        System.out.println("Obtenido: "+obtenido);
        System.out.println();

        System.out.println( " caso: "+casos[3]);
        lyricsCaso = new Lyrics(casos[3]);
        obtenido.clear();
        esperado.clear();
        obtenido = lyricsCaso.listWords();
        for (String w:caso4w)
            esperado.add(w);
        assertEquals(esperado,obtenido);
        System.out.println("Obtenido: "+obtenido);
        System.out.println();

    }
    @Test
    public void totalWordsTest() {
        System.out.println("totalWords test");
        Lyrics lyricsCaso = new Lyrics(casos[0]);
        int esperado = 0;
        for (int i = 0; i < caso1mat.length; i++)
            esperado += caso1mat[i].length;
        int obtenido = lyricsCaso.totalWords();
        System.out.println("Caso 1. Esperado: " + esperado + " obtenido: " + obtenido);
        assertEquals(esperado, obtenido);
        System.out.println();

        lyricsCaso = new Lyrics(casos[1]);
        esperado = 0;
        for (int i = 0; i < caso2mat.length; i++)
            esperado += caso2mat[i].length;
        obtenido = lyricsCaso.totalWords();
        System.out.println("Caso 2. Esperado: " + esperado + " obtenido: " + obtenido);
        assertEquals(esperado, obtenido);
        System.out.println();

        lyricsCaso = new Lyrics(casos[2]);
        esperado = 0;
        for (int i = 0; i < caso3mat.length; i++)
            esperado += caso3mat[i].length;
        obtenido = lyricsCaso.totalWords();
        System.out.println("Caso 3. Esperado: " + esperado + " obtenido: " + obtenido);
        assertEquals(esperado, obtenido);
        System.out.println();

        lyricsCaso = new Lyrics(casos[3]);
        esperado = 0;
        for (int i = 0; i < caso4mat.length; i++)
            esperado += caso4mat[i].length;
        obtenido = lyricsCaso.totalWords();
        System.out.println("Caso 4. Esperado: " + esperado + " obtenido: " + obtenido);
        assertEquals(esperado, obtenido);
        System.out.println();
    }

    @Test
    public void wordsUsedOverTest() {
        System.out.println("ordsUsedOver");

        int n = 0;
        System.out.println("With n= " + n);

        Lyrics lyricsCase = new Lyrics(casos[0]);
        Set<String> obtenido = lyricsCase.wordsUsedOver(n);
        HashSet<String> esperado = new HashSet<>();
        for (int i = 0; i < caso1w.length; i++)
            esperado.add(caso1w[i]);
        assertEquals(esperado, obtenido);
        System.out.println("Obtenido: " + obtenido);
        System.out.println();

        lyricsCase = new Lyrics(casos[1]);
        obtenido.clear();
        obtenido = lyricsCase.wordsUsedOver(n);
        esperado.clear();
        for (int i = 0; i < caso2w.length; i++)
            esperado.add(caso2w[i]);
        assertEquals(esperado, obtenido);
        System.out.println("Obtenido: " + obtenido);
        System.out.println();

        lyricsCase = new Lyrics(casos[2]);
        obtenido.clear();
        obtenido = lyricsCase.wordsUsedOver(n);
        esperado.clear();
        for (int i = 0; i < caso3w.length; i++)
            esperado.add(caso3w[i]);
        assertEquals(esperado, obtenido);
        System.out.println("Obtenido: " + obtenido);
        System.out.println();

        lyricsCase = new Lyrics(casos[3]);
        obtenido.clear();
        obtenido = lyricsCase.wordsUsedOver(n);
        esperado.clear();
        for (int i = 0; i < caso4w.length; i++)
            esperado.add(caso4w[i]);
        assertEquals(esperado, obtenido);
        System.out.println("Obtenido: " + obtenido);
        System.out.println();

        for (n = 1; n <= 20; n++) {
            System.out.println("With n= " + n);

            lyricsCase = new Lyrics(casos[0]);
            obtenido.clear();
            obtenido = lyricsCase.wordsUsedOver(n);
            esperado.clear();
            for (int i = 0; i < caso1mat.length; i++) {
                if (caso1mat[i].length >= n)
                    esperado.add(caso1w[i]);
            }

            assertEquals(esperado, obtenido);
            System.out.println("Obtenido: " + obtenido);
            System.out.println();

            lyricsCase = new Lyrics(casos[1]);
            obtenido.clear();
            obtenido = lyricsCase.wordsUsedOver(n);
            esperado.clear();
            for (int i = 0; i < caso2w.length; i++)
                if (caso2mat[i].length >= n)
                    esperado.add(caso2w[i]);
            assertEquals(esperado, obtenido);
            System.out.println("Obtenido: " + obtenido);
            System.out.println();

            lyricsCase = new Lyrics(casos[2]);
            obtenido.clear();
            obtenido = lyricsCase.wordsUsedOver(n);
            esperado.clear();
            for (int i = 0; i < caso3w.length; i++)
                if (caso3mat[i].length >= n)
                    esperado.add(caso3w[i]);
            assertEquals(esperado, obtenido);
            System.out.println("Obtenido: " + obtenido);
            System.out.println();

            lyricsCase = new Lyrics(casos[3]);
            obtenido.clear();
            obtenido = lyricsCase.wordsUsedOver(n);
            esperado.clear();
            for (int i = 0; i < caso4w.length; i++)
                if (caso4mat[i].length >= n)
                    esperado.add(caso4w[i]);
            assertEquals(esperado, obtenido);
            System.out.println("Obtenido: " + obtenido);
            System.out.println();
        }

        n = 30;
        System.out.println("with n = " + n);
        lyricsCase = new Lyrics(casos[1]);
        obtenido.clear();
        obtenido = lyricsCase.wordsUsedOver(n);
        esperado.clear();
        for (int i = 0; i < caso2w.length; i++)
            if (caso2mat[i].length >= n)
                esperado.add(caso2w[i]);
        assertEquals(esperado, obtenido);
        System.out.println("Obtenido: " + obtenido);
        System.out.println();

    }

    @Test
    public void terminalWordsTest() {
        System.out.println("terminalWords");

        System.out.println("caso " + casos[0]);
        Lyrics lyricsCase = new Lyrics(casos[0]);
        Set<String> obtenido = lyricsCase.terminalWords();
        ArrayList<String> words = new ArrayList<>();
        Set<String> esperado = leerfichero(casos[0], words);
        System.out.println("obtenido " + obtenido);
        System.out.println("esperado: " + esperado);
        assertEquals(esperado, obtenido);
        System.out.println();

        System.out.println("caso " + casos[1]);
        lyricsCase = new Lyrics(casos[1]);
        obtenido.clear();
        obtenido = lyricsCase.terminalWords();
        words = new ArrayList<>();
        esperado.clear();
        esperado = leerfichero(casos[1], words);
        System.out.println("obtenido " + obtenido);
        System.out.println("esperado: " + esperado);
        assertEquals(esperado, obtenido);
        System.out.println();

        System.out.println("caso " + casos[2]);
        lyricsCase = new Lyrics(casos[2]);
        obtenido.clear();
        obtenido = lyricsCase.terminalWords();
        words = new ArrayList<>();
        esperado.clear();
        esperado = leerfichero(casos[2], words);
        System.out.println("obtenido " + obtenido);
        System.out.println("esperado: " + esperado);
        assertEquals(esperado, obtenido);
        System.out.println();

        System.out.println("caso " + casos[3]);
        lyricsCase = new Lyrics(casos[3]);
        obtenido.clear();
        obtenido = lyricsCase.terminalWords();
        words = new ArrayList<>();
        esperado.clear();
        esperado = leerfichero(casos[3], words);
        System.out.println("obtenido " + obtenido);
        System.out.println("esperado: " + esperado);
        assertEquals(esperado, obtenido);
        System.out.println();

    }


    @Test
    public void changeWordTest() {

        System.out.println("testing changeWord...");

        System.out.println("caso " + casos[0]);
        Lyrics lyricsCase = new Lyrics(casos[0]);

        Set<String> palabras = lyricsCase .getMapKeys();
        Iterator<String> it = palabras.iterator();
        it.next();
        String primera = it.next();
        String segunda = it.next();
        System.out.println("   1:change " + primera + " by " + segunda);
        int obtenido = lyricsCase.changeWord(primera, segunda);

        ArrayList<List<Integer>> casoLista = casomatALista(caso1mat);
        List<String> auxwords = new ArrayList<>(List.of(caso1w));
        int pos1 = findPos(primera, caso1w);
        int pos2 = findPos(segunda, caso1w);
        int esperado = 0;
        if (pos1 !=-1) {
            esperado = casoLista.get(pos1).size();
            auxwords.remove(pos1);
            if (pos2 !=-1) {
                casoLista.get(pos2).addAll(casoLista.get(pos1));
                casoLista.remove(pos1);
                caso1w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso1w[i] = auxwords.get(i);
            }
            else {
                List<Integer> auxList = new ArrayList<>(casoLista.get(pos1));
                casoLista.remove(pos1);
                auxwords.add(segunda);
                caso1w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso1w[i] = auxwords.get(i);
                Arrays.sort(caso1w);
                pos2 = findPos(segunda, caso1w);
                casoLista.add(pos2, auxList);
            }
        }

        caso1mat = new int[casoLista.size()][];
        for (int i = 0; i < casoLista.size(); i++) {
            caso1mat[i] =new int[casoLista.get(i).size()];
            for (int j = 0; j < casoLista.get(i).size(); j++)
                caso1mat[i][j] = casoLista.get(i).get(j);
        }

        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso1w, caso1mat, lyricsCase);
        System.out.println();

        //--------------------------------------
        palabras = lyricsCase .getMapKeys();
        it = palabras.iterator();
        for (int z=0; z<4; z++)
            primera=it.next();
        segunda = "NEWWORD";
        System.out.println("   2:change " + primera + " by " + segunda);
        obtenido = lyricsCase.changeWord(primera, segunda);

        casoLista.clear();
        casoLista = casomatALista(caso1mat);
        auxwords = new ArrayList<>(List.of(caso1w));
        pos1 = findPos(primera, caso1w);
        pos2 = findPos(segunda, caso1w);
        esperado = 0;
        if (pos1 !=-1) {
            esperado = casoLista.get(pos1).size();
            auxwords.remove(pos1);
            if (pos2 !=-1) {
                casoLista.get(pos2).addAll(casoLista.get(pos1));
                casoLista.remove(pos1);
                caso1w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso1w[i] = auxwords.get(i);
            }
            else {
                List<Integer> auxList = new ArrayList<>(casoLista.get(pos1));
                casoLista.remove(pos1);
                auxwords.add(segunda);
                caso1w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso1w[i] = auxwords.get(i);
                Arrays.sort(caso1w);
                pos2 = findPos(segunda, caso1w);
                casoLista.add(pos2, auxList);
            }
        }

        caso1mat = new int[casoLista.size()][];
        for (int i = 0; i < casoLista.size(); i++) {
            caso1mat[i] =new int[casoLista.get(i).size()];
            for (int j = 0; j < casoLista.get(i).size(); j++)
                caso1mat[i][j] = casoLista.get(i).get(j);
        }

        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso1w, caso1mat, lyricsCase);
        System.out.println();

        //---------------------------------------------
        primera = "noesta";
        segunda = "OTRA";
        System.out.println("   3:change " + primera + " by " + segunda);
        obtenido = lyricsCase.changeWord(primera, segunda);
        esperado = 0;
        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso1w, caso1mat, lyricsCase);
        System.out.println();

        //------------------------------------------------
        //misma palabra
        palabras = lyricsCase .getMapKeys();
        it = palabras.iterator();
        for (int z=0; z<4; z++)
            primera=it.next();
        segunda = primera;
        obtenido = lyricsCase.changeWord(primera,segunda);
        esperado = 0;
        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso1w, caso1mat, lyricsCase);
        System.out.println();

        //==========================================

        System.out.println("caso " + casos[1]);
        lyricsCase = new Lyrics(casos[1]);

        palabras = lyricsCase .getMapKeys();
        it = palabras.iterator();
        it.next();
        primera = it.next();
        segunda = it.next();
        System.out.println("   1:change " + primera + " by " + segunda);
        obtenido = lyricsCase.changeWord(primera, segunda);

        casoLista.clear();
        casoLista = casomatALista(caso2mat);
        auxwords = new ArrayList<>(List.of(caso2w));
        pos1 = findPos(primera, caso2w);
        pos2 = findPos(segunda, caso2w);
        esperado = 0;
        if (pos1 !=-1) {
            esperado = casoLista.get(pos1).size();
            auxwords.remove(pos1);
            if (pos2 !=-1) {
                casoLista.get(pos2).addAll(casoLista.get(pos1));
                casoLista.remove(pos1);
                caso2w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso2w[i] = auxwords.get(i);
            }
            else {
                List<Integer> auxList = new ArrayList<>(casoLista.get(pos1));
                casoLista.remove(pos1);
                auxwords.add(segunda);
                caso2w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso2w[i] = auxwords.get(i);
                Arrays.sort(caso2w);
                pos2 = findPos(segunda, caso2w);
                casoLista.add(pos2, auxList);
            }
        }

        caso2mat = new int[casoLista.size()][];
        for (int i = 0; i < casoLista.size(); i++) {
            caso2mat[i] =new int[casoLista.get(i).size()];
            for (int j = 0; j < casoLista.get(i).size(); j++)
                caso2mat[i][j] = casoLista.get(i).get(j);
        }

        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso2w, caso2mat, lyricsCase);
        System.out.println();

        //--------------------------------------
        palabras = lyricsCase .getMapKeys();
        it = palabras.iterator();
        for (int z=0; z<4; z++)
            primera=it.next();
        segunda = "NEWWORD";
        System.out.println("   2:change " + primera + " by " + segunda);
        obtenido = lyricsCase.changeWord(primera, segunda);

        casoLista.clear();
        casoLista = casomatALista(caso2mat);
        auxwords = new ArrayList<>(List.of(caso2w));
        pos1 = findPos(primera, caso2w);
        pos2 = findPos(segunda, caso2w);
        esperado = 0;
        if (pos1 !=-1) {
            esperado = casoLista.get(pos1).size();
            auxwords.remove(pos1);
            if (pos2 !=-1) {
                casoLista.get(pos2).addAll(casoLista.get(pos1));
                casoLista.remove(pos1);
                caso2w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso2w[i] = auxwords.get(i);
            }
            else {
                List<Integer> auxList = new ArrayList<>(casoLista.get(pos1));
                casoLista.remove(pos1);
                auxwords.add(segunda);
                caso2w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso2w[i] = auxwords.get(i);
                Arrays.sort(caso2w);
                pos2 = findPos(segunda, caso2w);
                casoLista.add(pos2, auxList);
            }
        }

        caso2mat = new int[casoLista.size()][];
        for (int i = 0; i < casoLista.size(); i++) {
            caso2mat[i] =new int[casoLista.get(i).size()];
            for (int j = 0; j < casoLista.get(i).size(); j++)
                caso2mat[i][j] = casoLista.get(i).get(j);
        }

        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso2w, caso2mat, lyricsCase);
        System.out.println();

        //---------------------------------------------
        primera = "noesta";
        segunda = "OTRA";
        System.out.println("   3:change " + primera + " by " + segunda);
        obtenido = lyricsCase.changeWord(primera, segunda);
        esperado = 0;
        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso2w, caso2mat, lyricsCase);
        System.out.println();

        //------------------------------------------------
        //misma palabra
        palabras = lyricsCase .getMapKeys();
        it = palabras.iterator();
        for (int z=0; z<4; z++)
            primera=it.next();
        segunda = primera;
        obtenido = lyricsCase.changeWord(primera,segunda);
        esperado = 0;
        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso2w, caso2mat, lyricsCase);
        System.out.println();

        //==========================================

        System.out.println("caso " + casos[2]);
        lyricsCase = new Lyrics(casos[2]);

        palabras = lyricsCase .getMapKeys();
        it = palabras.iterator();
        it.next();
        primera = it.next();
        segunda = it.next();
        System.out.println("   1:change " + primera + " by " + segunda);
        obtenido = lyricsCase.changeWord(primera, segunda);

        casoLista.clear();
        casoLista = casomatALista(caso3mat);
        auxwords = new ArrayList<>(List.of(caso3w));
        pos1 = findPos(primera, caso3w);
        pos2 = findPos(segunda, caso3w);
        esperado = 0;
        if (pos1 !=-1) {
            esperado = casoLista.get(pos1).size();
            auxwords.remove(pos1);
            if (pos2 !=-1) {
                casoLista.get(pos2).addAll(casoLista.get(pos1));
                casoLista.remove(pos1);
                caso3w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso3w[i] = auxwords.get(i);
            }
            else {
                List<Integer> auxList = new ArrayList<>(casoLista.get(pos1));
                casoLista.remove(pos1);
                auxwords.add(segunda);
                caso3w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso3w[i] = auxwords.get(i);
                Arrays.sort(caso3w);
                pos2 = findPos(segunda, caso3w);
                casoLista.add(pos2, auxList);
            }
        }

        caso3mat = new int[casoLista.size()][];
        for (int i = 0; i < casoLista.size(); i++) {
            caso3mat[i] =new int[casoLista.get(i).size()];
            for (int j = 0; j < casoLista.get(i).size(); j++)
                caso3mat[i][j] = casoLista.get(i).get(j);
        }

        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso3w, caso3mat, lyricsCase);
        System.out.println();

        //--------------------------------------
        palabras = lyricsCase .getMapKeys();
        it = palabras.iterator();
        for (int z=0; z<4; z++)
            primera=it.next();
        segunda = "NEWWORD";
        System.out.println("   2:change " + primera + " by " + segunda);
        obtenido = lyricsCase.changeWord(primera, segunda);

        casoLista.clear();
        casoLista = casomatALista(caso3mat);
        auxwords = new ArrayList<>(List.of(caso3w));
        pos1 = findPos(primera, caso3w);
        pos2 = findPos(segunda, caso3w);
        esperado = 0;
        if (pos1 !=-1) {
            esperado = casoLista.get(pos1).size();
            auxwords.remove(pos1);
            if (pos2 !=-1) {
                casoLista.get(pos2).addAll(casoLista.get(pos1));
                casoLista.remove(pos1);
                caso3w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso3w[i] = auxwords.get(i);
            }
            else {
                List<Integer> auxList = new ArrayList<>(casoLista.get(pos1));
                casoLista.remove(pos1);
                auxwords.add(segunda);
                caso3w = new String[auxwords.size()];
                for (int i = 0; i < auxwords.size(); i++)
                    caso3w[i] = auxwords.get(i);
                Arrays.sort(caso3w);
                pos2 = findPos(segunda, caso3w);
                casoLista.add(pos2, auxList);
            }
        }

        caso3mat = new int[casoLista.size()][];
        for (int i = 0; i < casoLista.size(); i++) {
            caso3mat[i] =new int[casoLista.get(i).size()];
            for (int j = 0; j < casoLista.get(i).size(); j++)
                caso3mat[i][j] = casoLista.get(i).get(j);
        }

        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso3w, caso3mat, lyricsCase);
        System.out.println();

        //---------------------------------------------
        primera = "noesta";
        segunda = "OTRA";
        System.out.println("   3:change " + primera + " by " + segunda);
        obtenido = lyricsCase.changeWord(primera, segunda);
        esperado = 0;
        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso3w, caso3mat, lyricsCase);
        System.out.println();

        //==========================================

        //------------------------------------------------
        //misma palabra
        palabras = lyricsCase .getMapKeys();
        it = palabras.iterator();
        for (int z=0; z<4; z++)
            primera=it.next();
        segunda = primera;
        obtenido = lyricsCase.changeWord(primera,segunda);
        esperado = 0;
        System.out.println("obtenido "+obtenido);
        System.out.println("esperado: "+esperado);
        assertEquals(esperado, obtenido);
        this.constructorTest(caso3w, caso3mat, lyricsCase);
        System.out.println();
    }
    
    @Test
    public void displayLyricsTest() {
        System.out.println("Test de displayLyrics ...") ;
        for (int i=0; i< casos.length; i++)  {
            System.out.println("Caso: "+casos[i]);

            ArrayList<String> texto = new ArrayList<>();
            TestLyrics.leerfichero(casos[i],texto);
            String esperado = "";
            for (int j=1; j< texto.size(); j++) {
                esperado+=texto.get(j);
            }

            Lyrics lyricsCase = new Lyrics(casos[i]);
            StringBuilder obtenido= lyricsCase.displayLyrics();
            String obtenido2 = obtenido.toString();

            assertEquals(esperado,obtenido2);

            System.out.println(obtenido);
            System.out.println();
        }
    }

    private ArrayList<List<Integer>> casomatALista (int[][] casomat) {
        ArrayList<List<Integer>> casoLista = new ArrayList<>();
        for (int i = 0; i < casomat.length; i++) {
            ArrayList<Integer> aux = new ArrayList<>();
            for (int j = 0; j < casomat[i].length; j++)
                aux.add(casomat[i][j]);
            casoLista.add(aux);
        }
        return casoLista;
    }


}

