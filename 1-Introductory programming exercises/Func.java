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

    private static String draw_line(int n, String ch){
        String ret = "";
        for(int i =0; i<n ; i+=1){
            ret += ch;
        }
        return ret;
    }

    private static String fill_space(int width, String ori){
        String ret = "";
        int l = ori.length();
        int space_volumn = (width - l) / 2;
        ret+=draw_line(space_volumn, " ");
        ret+=ori;
        return ret;
    }

    public static String isosceles_triangle(int n){
        String ret = "";
        int width = 2 * n -1;
        for(int layer=0; layer<n; layer+=1){
            ret+=Func.fill_space(width,Func.draw_line(layer*2+1, "*"));
            ret+="\n";
        }
        return ret;
    };

    public static String dimond(int n){
        String ret = Func.isosceles_triangle(n);
        int width = 2 * n - 1;
        for(int layer=n-2; layer>=0; layer-=1){
            ret+=Func.fill_space(width, Func.draw_line(layer*2+1, "*"));
            ret+="\n";
        }
        return ret;
        
    }

    public static String dimond_with_name(String name, int n){
        String ret = Func.dimond(n);
        String target = Func.draw_line(2 * n -1, "\\*");
        String substitute = Func.fill_space(2 * n - 1, name);
        return ret.replaceFirst(target, substitute);
    }

    public static String FizzBuzz(int begin, int end){
        String fizz = "Fizz";
        String buzz = "Buzz";
        String ret = "";
        for(int i =begin; i<=end; i+=1){
            if(i%15==0){ret+=fizz; ret+=buzz;}
            else if (i%3==0){ret+=fizz;}
            else if (i%5==0){ret+=buzz;}
            else{ret+=String.format("%d", i);}
            ret+="\n";
        }
        return ret;
    }
}