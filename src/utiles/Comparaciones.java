package utiles;

public class Comparaciones {



    public static boolean compararMayor(Object objeto1,Object objeto2){
        if(objeto1 instanceof Number && objeto2 instanceof  Number){
            if(((Number) objeto1).doubleValue() > ((Number) objeto2).doubleValue()){
                return true;
            }else{
                return false;
            }
        }else {
            if(objeto1.toString().compareTo(objeto2.toString()) >0){

                return true;
            }

            return false;
        }
    }

    public static boolean compararMenor(Object objeto1,Object objeto2){
        if(objeto1 instanceof Number && objeto2 instanceof  Number){
            if(((Number) objeto1).doubleValue() < ((Number) objeto2).doubleValue()){
                return true;
            }else{
                return false;
            }
        }else {
            if(objeto1.toString().compareTo(objeto2.toString()) <0){

                return true;
            }

            return false;
        }
    }

}
