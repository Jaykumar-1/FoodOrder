package com.example.foodorder;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> ListFood = getListCart();
        boolean AlreadyExist = false;
        int n = 0;
        for (int i = 0; i < ListFood.size(); i++) {
            if (ListFood.get(i).getTitle().equals(item.getTitle())) {
                AlreadyExist = true;
                n = i;
                break;
            }
        }

        if (AlreadyExist) {
            ListFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            ListFood.add(item);
        }
        tinyDB.putListObject("CartList", ListFood);
        Toast.makeText(context, "Added to Your Cart", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<FoodDomain> getListCart() {

        return tinyDB.getListObject("CartList");
    }

    public  void plusNumberFood(ArrayList<FoodDomain> listFood, int position, ChangeNumberItemListener changeNumberItemListener){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemListener.changed();
    }

    public void minusNumberFood(ArrayList<FoodDomain> listFood, int position, ChangeNumberItemListener changeNumberItemListener){
        if(listFood.get(position).getNumberInCart()==1){
            listFood.remove(position);
        }
        else{
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemListener.changed();
    }
    public Double getTotalFee(){
        ArrayList<FoodDomain>listFood = getListCart();
        double fee =0;
        for(int i=0;i<listFood.size();i++){
            fee= fee+(listFood.get(i).getFees()*listFood.get(i).getNumberInCart());
        }
        return fee;
    }
}
