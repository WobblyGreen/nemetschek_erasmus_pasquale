public class Task1 {
    public static void main(String[] args){
        String encoded = encodingDecoding(true, "AAAABBBCCDAA");
        System.out.println(encoded);
    }

    public static String encodingDecoding(boolean encode, String raw){
        return (encode ? encode(raw) : decode(raw));
    }

    private static String encode(String raw){
        String result ="";
        int count=0;
        char current = raw.charAt(0);
        for(int i=0; i<raw.length(); i++){
            if(current==raw.charAt(i))count++;

            else{
                result+=count+""+current;
                count=0;
                current=raw.charAt(i--);
            }

        }
        return result;
    }

    private static String decode(String raw){
        String result ="";
        for(int i=0; i<raw.length(); i+=2){
            int times = Integer.parseInt(raw.charAt(i)+"");
            for(int j=0; j<times; j++){
                result+=raw.charAt(i+1)+"";
            }
        }
        return result;
    }


}
