package load.testing;

class BaseNumber {
     static int getBaseNumber(String base){
        switch (base.toLowerCase()){
            case "двоичная": return 2;
            case "троичная": return 3;
            case "четверичная": return 4;
            case "пятеричная": return 5;
            case "шестеричная": return 6;
            case "семеричная": return 7;
            case "восьмеричная": return 8;
            case "девятеричная": return 9;
            case "десятеричная": return 10;
            case "одиннадцатеричная": return 11;
            case "двеннадцатеричная": return 12;
            case "триннадцитеричная": return 13;
            case "четырнадцатеричная": return 14;
            case "пятнадцатеричная": return 15;
            case "шестнадцатеричная": return 16;
            case "семнадцатеричная": return 17;
            case "восемнадцатеричная": return 18;
            case "девятнадцатеричная": return 19;
            case "двадцатеричная": return 20;
            case "двадцатиодноричная": return 21;
            case "двадцатидвухричная": return 22;
            case "двадцатитрехричная": return 23;
            case "двадцатичетырехричная": return 24;
            case "двадцатипятиричная": return 25;
            case "двадцатишестиричная": return 26;
            case "двадцатисемиричная": return 27;
            case "двадцативосьмиричная": return 28;
            case "двадцатидевятиричная": return 29;
            case "тридцатеричная": return 30;
            case "тридцатиодноричная": return 31;
            case "тридцатидвухричная": return 32;
            case "тридцатитрехричная": return 33;
            case "тридцатичетырехричная": return 34;
            case "тридцатипятиричная": return 35;
            case "тридцатишестиричная": return 36;
        }
        return 37;
    }
}
