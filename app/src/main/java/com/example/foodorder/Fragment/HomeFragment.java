package com.example.foodorder.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.foodorder.CategoryAdapter;
import com.example.foodorder.CategoryDomain;
import com.example.foodorder.FoodDomain;
import com.example.foodorder.PopularAdapter;
import com.example.foodorder.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    private  RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoriesList,getRecyclerViewPopularList;
    private ArrayList<CategoryDomain> category;
    private ImageView profileImg;
    private ArrayList<FoodDomain> foodlist;
    View v;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        recyclerViewCategory();
        recyclerViewPopular();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home, container, false);

        profileImg = v.findViewById(R.id.imgProfile);

        recyclerViewCategoriesList = v.findViewById(R.id.recyclerViewCate);
        getRecyclerViewPopularList =v.findViewById(R.id.recyclerViewPopular);

        adapter = new CategoryAdapter(category);
        recyclerViewCategoriesList.setAdapter(adapter);
        recyclerViewCategoriesList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        adapter2 =new PopularAdapter(foodlist);
        getRecyclerViewPopularList.setAdapter(adapter2);
        getRecyclerViewPopularList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));


        return  v;
    }

    private void recyclerViewCategory(){

        category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_2"));
        category.add(new CategoryDomain("Hotdog", "cat_3"));
        category.add(new CategoryDomain("Drink", "cat_4"));
        category.add(new CategoryDomain("Donut", "cat_5"));



    }

    private void recyclerViewPopular(){

        foodlist =new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni Pizza", "pop_1", "slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",299));
        foodlist.add(new FoodDomain("Burger", "pop_2","Gouda cheese, Special Sauce, Lettuce, tomato",399));
        foodlist.add(new FoodDomain("Vegetable Pizza", "pop_3", "oliv oil, vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano,basil",499));


    }
}