import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input) throws Error{
        int sum = 0;
        //if input is empty return sum
        if (input.equals("")){
            return sum;
        }

        //if character at the last index of input is not,
        // a digit throw an error message.
        if (!Character.isDigit(input.charAt(input.length()-1))){
                throw new Error("INVALID INPUT!");
        }

        //if input starts with space, throw an error message.
        if (input.startsWith(" ")){
                throw new Error("INVALID INPUT!");
        }

        // if input does not start with "//" and input contains "//",
        // throw an error message,
        if (!input.startsWith("//") && input.contains("//")){
                throw new Error("INVALID INPUT!");
        }

        //default string separators (delimiters)
        String DLimit = "[,;\\n]";

        //create an delimiter array to store delimiters
        String[] delimiter = new String[2];

        // create a  new String Array arrSum , and
        // initialize the splitting delimiter with
        // the limit of 2 to the array arrSum,
        String[] arrSum = input.split("[\\\n]", 2);

        // initialize the value at index 0
        // in arrSum starting from index "2" to DLimit1
        String dLimit1 = arrSum[0].substring(2);

        //create a pattern to match delimiters
        Pattern pattern = Pattern.compile("(\\[).+(])(\\[).+(])");

        //Match the variable DLimit1 with the compiled pattern
        Matcher matcher = pattern.matcher(dLimit1);

        // If the input start with "//" and matcher does not match dLimit,
        if (input.startsWith("//") && !(matcher.matches())) {

            //replace dLimit1 at arrSum[1] with comma and
            // initialize the value at index 1 in arrSum to input,
            input = arrSum[1].replace(dLimit1,",");
        }

        // if matcher match dLimit,
        if (matcher.matches()){
            //in dLimit1 replace target "["  with an empty string
            dLimit1 = dLimit1.replace("[","");

            //in delimiter array split with dLimit1 "]"
            delimiter = dLimit1.split("]");
            input = arrSum[1];

            // for each string element in delimiter array
            for (String i : delimiter ) {

                //from the input target each element
                // on the array and replace it with a comma,
                input = input.replace(i,",");
            }
        }

        // for each element on arrSum2,
        // add all the elements,
        // and return sum,
        String[] arrSum2 =input.split(DLimit);
            for (String j : arrSum2) {
                // if element(s) in arrSum2 is/are
                // greater than or equals to 1000,
                // continue
                if (Integer.parseInt(j) >= 1000){
                    continue;
                }
                 // if element(s) in arrSum2 is/are,
                 //  less than zero printout an error
                if (Integer.parseInt(j) < 0){
                    System.out.println(" 'ERROR: negatives not allowed "+ Integer.parseInt(j));
                }
                //add all the values within arrSum with values of variable sum and
                // assign them to be sum
                sum += Integer.parseInt(j);
            }
        return sum;
    }
    public static void main(String[] args)  {
        //Please uncomment the below statements to test this program

//        String sum0 = "";
//        String sum = "1,1,1,5";
//        String sum1 = "1,2\n1";
//        String sum2 = "//4\n142";
//        String sum3 = "-1,-1,-1,-5";
//        String sum4 = "//;\n100;1;2";
//        String sum5 = "//;\n1000;1;2";
//        String sum6 = "//***\n1***2***3";
//        String sum7 = "//[:D][%]\n1:D2%3";
//        String sum8 = "//[:D][%]\n1:D2%3;";
        String sum9 = "   //[:D][%]\n1:D2%3;";
        String sum10 = "1,2,3//[:D][%]\n1:D2%3;";

//        System.out.println(add(sum0));
//        System.out.println(add(sum));
//        System.out.println(add(sum1));
//        System.out.println(add(sum2));
//        System.out.println(add((sum3)));
//        System.out.println(add((sum4)));
//        System.out.println(add((sum5)));
//        System.out.println(add((sum6)));
//        System.out.println(add((sum7)));
//        System.out.println(add((sum8)));
        System.out.println(add((sum9)));
        System.out.println(add((sum10)));

        }
    }
