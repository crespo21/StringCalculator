public class StringCalculator {
    public static int add(String input) throws Exception {
        if (input ==""){
            input = input.replace("", "0");
        }
        int sum = 0;
        String DLimit = "[,;\\\n]";
        if (input.startsWith("//")){
            String[] arrSum = input.split("[\\\n]",2);
            DLimit = arrSum[0].substring(2);
            input =arrSum[1];
        }
        if(input.startsWith("-")){
            try{
                String[] inputValue = input.split("[,]");
                DLimit = inputValue[0].substring(2);
                System.out.println(" 'ERROR: negatives not allowed "+ input+"'");
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        // This part is showing me flames please help when you find the bug
//
//            String numDLimit = "^ [1-9][0-9]{0,2}" ;
//            if (input.contains(numDLimit)){
//            String[] inputValue1 = input.split(",");
//            DLimit = inputValue1[0].substring(8);
//            input =inputValue1[1];
//
//            }
        String[] inputValue2 =input.split(DLimit);
        for ( String i :inputValue2){
            sum = sum + Integer.parseInt(i);
        }
        return sum;
    }




    public static void main(String[] args)  {
        try {
            String sum = "";
            String sum1 = "1,2,3,4";
            String sum2 = "1,2\n1";
            String sum3 = "//;\n111,1;2";
            String sum4 = "-1,-2,-3,-4";
            String sum5 = "//;\n1000,1;2";
            System.out.println(add(sum));
            System.out.println(add(sum1));
            System.out.println(add(sum2));
            System.out.println(add(sum3));
            System.out.println(add(sum4));
            System.out.println(add(sum5));
            System.out.println(add(sum4));
        }
        catch (NumberFormatException e){
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}