import java.util.Arrays;

public class ArrayQuestions {

    //region 1.1

    /* DESCRIPTION: Implement an algorithm to detect if a string has all unique characters.
    * What if you can't use additional data structures */

    // With additional data structure
    public boolean isUnique1(String text)
    {
        int[] charFreq = new int[127];

        for(char c : text.toCharArray()){
            charFreq[c]++;
            if(charFreq[c] > 1){
                return false;
            }
        }
        return true;
    }

    // Without additional sort
//    public boolean isUnique2(String text)
//    {
//        text = new String(Arrays.sort(text.toCharArray()));
//        for(int i = 0; i < text.length() - 1; i++){
//            if(text.charAt(i) == text.charAt((i+1))){
//                return false;
//            }
//        }
//        return true;
//    }

    //endregion

    //region 1.2

    /* DESCRIPTION: Given two strings, write a method to decide if one is a permutation of the other. */

    public boolean checkPermutation1(String stringA, String stringB){
        if(stringA.length() != stringB.length()){
            return false;
        }

        int[] charFreqs = new int[127];
        for(char c : stringA.toCharArray()){
            charFreqs[c]++;
        }

        for(char c : stringB.toCharArray()){
            charFreqs[c]--;
            if(charFreqs[c] < 0){
                return false;
            }
        }

        return true;
    }

    public boolean checkPermutation2(String stringA, String stringB){
        if(stringA.length() != stringB.length()){
            return false;
        }

        char[] stringAChars = stringA.toCharArray();
        Arrays.sort(stringAChars);
        stringA = new String(stringAChars);

        char[] stringBChars = stringB.toCharArray();
        Arrays.sort(stringBChars);
        stringB = new String(stringBChars);

        if(stringA.equals(stringB)){
            return true;
        }

        return false;

    }

    //endregion

    //region 1.3

    /* DESCRIPTION: Write a method to replace all spaces in a string with %20 */

    public String URLify(String original, int trueLength){
        int grabPointer = trueLength - 1;
        int fillPointer = original.length() - 1;
        char[] url = original.toCharArray();

        while(fillPointer >= 0){
            if(url[grabPointer] != ' '){
                url[fillPointer] = url[grabPointer];
                fillPointer--;
            }
            else{
                fillSpace(url, fillPointer);
                fillPointer -= 3;
            }
            grabPointer--;
        }

        return new String(url);
    }

    private void fillSpace(char[] url, int index){
        url[index] = '0';
        url[index - 1] = '2';
        url[index - 2] = '%';
    }

    //endregion
}
