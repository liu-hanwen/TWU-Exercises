public class Func{
    public static String print_one_asterisk(){
        String ret = "*";
        return ret;
    };

    public static String draw_a_horizontal_line(int n){
        
        String ret = "";
        for(int i = 0; i<n; i+=1){
            ret = ret.concat(Func.print_one_asterisk());
        }
        return ret;
    };
}