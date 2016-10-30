package usjt.caixa.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

public class SectionIndexBuilder {

    public static Object[] BuildSectionHeaders(Extrato[] extratos) {
        ArrayList<String> results = new ArrayList<>();
        TreeSet<String> used = new TreeSet<>();
        if (extratos != null) {
            for (Extrato item : extratos) {
                String letter = item.getOperacao().substring(0, 1);

                if (!used.contains(letter))
                    results.add(letter);

                used.add(letter);
            }
        }
        return results.toArray(new Object[0]);
    }

    public static Hashtable<Integer, Integer> BuildSectionForPositionMap(Extrato[] extratos) {
        Hashtable results = new Hashtable<Integer, Integer>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if (extratos != null) {
            for (int i = 0; i < extratos.length; i++) {
                String letter = extratos[i].getOperacao().substring(0, 1);

                if (!used.contains(letter)) {
                    section++;
                    used.add(letter);
                }

                results.put(i, section);
            }
        }
        return results;
    }

    public static Hashtable<Integer, Integer> BuildPositionForSectionMap(Extrato[] extratos) {
        Hashtable results = new Hashtable<Integer, Integer>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if (extratos != null) {
            for (int i = 0; i < extratos.length; i++) {
                String letter = extratos[i].getOperacao().substring(0, 1);

                if (!used.contains(letter)) {
                    section++;
                    used.add(letter);
                    results.put(section, i);
                }
            }
        }
        return results;
    }
}
