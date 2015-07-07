package com.jetnix.my.drawerandtoolbar;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerFragment extends Fragment {

    private RecyclerView recyclerView;

    private static final String PREF_FILE_NAME = "textpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ActionBarDrawerToggle mdrawerToogle;
    private DrawerLayout mDrawerLayout;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;

    private VivzAdapter adapter;

    private View containerView;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Log.d("check", "hello this is oncreate");
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));

        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        adapter = new VivzAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Log.d("check", "hello this is oncreateView");

        return layout;
        //  return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static List<Information> getData(){
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_number1, R.drawable.ic_number2, R.drawable.ic_number3, R.drawable.ic_number4};
        String[] titles = {"Sumit", "Singh", "shivi", "Hello"};
        for (int i = 0; i < titles.length && i<icons.length; i++) {
            Information information = new Information();
            information.title = titles[i];
            information.iconId = icons[i];
            data.add(information);
        }
        return data;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {

        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mdrawerToogle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }
                getActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().supportInvalidateOptionsMenu();
            }
        };

        if(!mUserLearnedDrawer && !mFromSavedInstanceState){
            mDrawerLayout.openDrawer(containerView);
        }

        mDrawerLayout.setDrawerListener(mdrawerToogle);

        mDrawerLayout.post(
                new Runnable() {
                    @Override
                    public void run() {
                        mdrawerToogle.syncState();
                    }
                }
        );
    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }
}
