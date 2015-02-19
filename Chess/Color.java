package Chess;

public enum Color {

    BLACK, WHITE;

    public String getColorName(){
        switch(this){
            case WHITE:
                return "WHITE";
            case BLACK:
                return "BLACK";
            default:
                return "";
        }
    }

    public String toString(){
        switch(this){
            case WHITE:
                return "\033[;45m \033[0m"; 
            case BLACK:
                return "\033[;40m \033[0m";
            default:
                return "";
        }
    }
}
