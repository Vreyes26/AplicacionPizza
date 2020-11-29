package Models;

public class Promos {

    public String getCliente(int item) {
        if (item == 0){
            return "Ramiro";
        }else if (item == 1){
            return "Rosa";
        }else if (item == 2){
            return "Robert";
        }else{
            return "";
        }

    }

    public String getCalculo(int envio, String promo) {
        if (promo.equals("PIZZAS PROMO")){
            return "$"+(envio+5990);
        }else if (promo.equals("MASTER PIZZA")){
            return "$"+(envio+12990);
        }else if (promo.equals("PIZZA MAX")){
            return "$"+(envio+18500);
        }else{
            return "Promo no encontrada";
        }

    }
}
