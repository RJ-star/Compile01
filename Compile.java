import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compile {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("args[0]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String string = "";
        String str = "";
        while((string = bufferedReader.readLine()) != null)
        {
//            System.out.println(str);
            str+=string+"\n";
        }

        //close
        inputStream.close();
        bufferedReader.close();

//        String str="";
        int j=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\r' || str.charAt(i) == '\n' || str.charAt(i) == '\t') {
                continue;
            }

            if (Character.isDigit(str.charAt(i))) {
                j=i;
                String temp="";
                while (Character.isDigit(str.charAt(j))) {
                    temp+=str.charAt(j);
                    j++;
                    if (j == str.length())
                        break;
                }
                i=j-1;
                System.out.println(check(temp));
            }

            else if (Character.isLetter(str.charAt(i))) {
                j=i;
                String temp="";
                while (Character.isLetter(str.charAt(j)) || Character.isDigit(str.charAt(j))) {
                    temp+=str.charAt(j);
                    j++;
                    if (j == str.length())
                        break;
                }
                i=j-1;
                System.out.println(check(temp));
            }

            else if (str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == ',') {
                String temp="";
                temp+=str.charAt(i);
                System.out.println(check(temp));
            }

            else if (str.charAt(i) == ':') {
                String temp="";
                if (str.charAt(i+1) == '=') {
                    temp=":=";
                    i++;
                }
                else {
                    temp=":";
                }
                System.out.println(check(temp));
            }

            else System.out.println("Unknown");
        }
    }

    public static String[] token={"BEGIN","END","FOR","IF","THEN","ELSE",":","+","*",",","(",")",":="};
    public static String[] output={"Begin","End","For","If","Then","Else","Colon","Plus","Star","Comma","LParenthesis","RParenthesis","Assign"};
    static int len=token.length;
    public static String check(String s) {
        int flag=0;
        for (int i = 0; i < len; i++) {
            if (token[i].equals(s)) {
                return output[i];
            }
        }

        if (Character.isDigit(s.charAt(0))) {
            return "Int("+Integer.valueOf(s)+")";
        }
        else
            return "Ident("+s+")";
    }
}
