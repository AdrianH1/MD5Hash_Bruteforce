public class TestTry {

    public static Hash hash = new Hash();
    
    public static void main(String[] args) {
        // String keyword = "asdfjklö";
        String keyword = "asdf";
        // String md5 = "9dee6f8e04622dcc2a594e3669bd72c3"; //asdfjklö
        String md5 = "912ec803b2ce49e4a541068d495ab570"; //asdf
        int numOfChars = 8;
        // System.out.println(hash.generateMD5("aaaacbfn"));

        words('a', 'z', numOfChars);

    }

    public static void words(char min, char max, int n) {
        for(int i = 8; i <= n; ++i) {
           wordsRecursive("", min, max, i);
        }
     }
     
     public static void wordsRecursive(String base, char min, char max, int n) {
        if(n == 0) {
           System.out.println(base);
           if (hash.generateMD5(base).equals("9dee6f8e04622dcc2a594e3669bd72c3")){
               System.out.println(base);
           }
        } else {
           for(char c = min; c <= max; ++c) {
              wordsRecursive(base + c, min, max, n - 1);
           }
        }
     }

}
