package com.example.foodorder.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.foodorder.CartListAdepter;
import com.example.foodorder.ChangeNumberItemListener;
import com.example.foodorder.ManagementCart;
import com.example.foodorder.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {
    View v;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView totalFee,totalTax,totalDelivery,emptyTxt,total;
    private double tax;
    private ScrollView scrollView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }


    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        managementCart = new ManagementCart(getActivity());
       /* CalculatedCart();*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerViewList = v.findViewById(R.id.cartRecycler);
        totalDelivery  = v.findViewById(R.id.TotalDelivery);
        totalFee = v.findViewById(R.id.TotalFee);
        total =v.findViewById(R.id.TotalTxt);
        totalTax = v.findViewById(R.id.TotalTax);
        emptyTxt = v.findViewById(R.id.emptyTxt);
        scrollView = v.findViewById(R.id.scrollView2);

        adapter = new CartListAdepter(managementCart.getListCart(), getActivity(), new ChangeNumberItemListener() {
            @Override
            public void changed() {
                CalculatedCart();
            }
        });
            recyclerViewList.setAdapter(adapter);
            recyclerViewList.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        return v;
    }

    public void CalculatedCart(){
        double percentTax  = 0.12;
        double delivery = 40;

        tax = Math.round((managementCart.getTotalFee()*percentTax)*100)/100;
        double totalCart = Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double ItemTotal = Math.round(managementCart.getTotalFee()*100)/100;

        totalFee.setText("₹ "+ItemTotal);
        totalTax.setText("₹ "+tax);
        totalDelivery.setText("₹ "+delivery);
        total.setText("₹ "+totalCart);
    }
}