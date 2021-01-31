package load.testing;

class Letter {
    //перевод буквенных значений в цифры и наоборот
     static String getLetter(int num){
        switch (num){
            case 10: return "A";
            case 11: return "B";
            case 12: return "C";
            case 13: return "D";
            case 14: return "E";
            case 15: return "F";
            case 16: return "G";
            case 17: return "H";
            case 18: return "I";
            case 19: return "J";
            case 20: return "K";
            case 21: return "L";
            case 22: return "M";
            case 23: return "N";
            case 24: return "O";
            case 25: return "P";
            case 26: return "Q";
            case 27: return "R";
            case 28: return "S";
            case 29: return "T";
            case 30: return "U";
            case 31: return "V";
            case 32: return "W";
            case 33: return "X";
            case 34: return "Y";
            case 35: return "Z";
        }
        return "usage";
    }

    static int getNumber(String letter){
        letter = letter.toUpperCase();
        switch (letter){
            case "A": return 10;
            case "B": return 11;
            case "C": return 12;
            case "D": return 13;
            case "E": return 14;
            case "F": return 15;
            case "G": return 16;
            case "H": return 17;
            case "I": return 18;
            case "J": return 19;
            case "K": return 20;
            case "L": return 21;
            case "M": return 22;
            case "N": return 23;
            case "O": return 24;
            case "P": return 25;
            case "Q": return 26;
            case "R": return 27;
            case "S": return 28;
            case "T": return 29;
            case "U": return 30;
            case "V": return 31;
            case "W": return 32;
            case "X": return 33;
            case "Y": return 34;
            case "Z": return 35;
        }
        return 37;
    }
}
