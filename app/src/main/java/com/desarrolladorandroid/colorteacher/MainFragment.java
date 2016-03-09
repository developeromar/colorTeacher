package com.desarrolladorandroid.colorteacher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.desarrolladorandroid.colorteacher.Adapters.MenuRecyclerAdapter;
import com.desarrolladorandroid.colorteacher.utilities.MainListObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cosanchez on 07/03/2016.
 */
public class MainFragment extends Fragment {
    private List<MainListObject> options;
    public MainFragment() {
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.menu_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        initList();
        MenuRecyclerAdapter menusRecyclerAdapter = new MenuRecyclerAdapter(getActivity(), options);
        recyclerView.setAdapter(menusRecyclerAdapter);
        return view;
    }

    private void initList() {
        options = Arrays.asList(
                new MainListObject(ContextCompat.getColor(getContext(), R.color.menu_red), getString(R.string.basicColors)),
                new MainListObject(ContextCompat.getColor(getContext(), R.color.menu_blue), getString(R.string.basicColorsName)),
                new MainListObject(ContextCompat.getColor(getContext(), R.color.menu_green), getString(R.string.howtoObtain)),
                new MainListObject(ContextCompat.getColor(getContext(), R.color.menu_yellow), getString(R.string.secundaryColorsNames)),
                new MainListObject(ContextCompat.getColor(getContext(), R.color.menu_light_green), getString(R.string.colorMixer))
        );
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
