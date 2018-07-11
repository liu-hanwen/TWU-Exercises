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

    public static String draw_a_vertical_line(int n){
        String ret = "";
        for(int i = 0; i<n; i+=1){
            ret = ret.concat(Func.print_one_asterisk());
            ret = ret.concat("\n");
        }
        return ret;
    };

    public static String draw_a_right_triangle(int n){
        String ret = "";
        for(int layer=0; layer<n; layer+=1){
            ret = ret.concat(Func.draw_a_horizontal_line(layer+1));
            ret = ret.concat("\n");
        }
        return ret;
    };

    public static String isosceles_triangle(int n){
        String ret = "";
        int width = (n-1)*2+1;
        for(int layer=0; layer<n; layer+=1){
            int fill_width = layer*2+1;
            int space_width = (width - fill_width) / 2;
            for(int n_space = 0; n_space<space_width; n_space+=1){
                ret = ret.concat(" ");
            }
            ret = ret.concat(Func.draw_a_horizontal_line(fill_width));
            ret = ret.concat("\n");
        }
        return ret;
    };
}