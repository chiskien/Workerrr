package workerr;

import java.util.Comparator;

public class CodeComparator implements  Comparator<History>{
    @Override
    public int compare(History o1, History o2) {
        return extractInt(o1.getCode())-extractInt(o2.getCode());
    }
    public  int extractInt(String s) { 
        String num = s.replaceAll("\\D", "");
        return Integer.parseInt(num);
    }
    }

