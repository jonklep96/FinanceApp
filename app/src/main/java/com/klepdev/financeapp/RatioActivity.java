package com.klepdev.financeapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class RatioActivity extends AppCompatActivity {

    public final static String ASSET_KEY = "asset_ratios";
    public final static String DEBT_KEY = "debt_ratios";
    public final static String EQUITY_KEY = "equity_ratios";

    RatioPagerAdapter ratioPagerAdapter;
    ViewPager ratioViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio);

        ratioPagerAdapter = new RatioPagerAdapter(getSupportFragmentManager());

        ratioViewPager = (ViewPager) findViewById(R.id.vp_ratio);
        ratioViewPager.setAdapter(ratioPagerAdapter);
        ratioViewPager.setCurrentItem(0);
    }

    public static class RatioPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public RatioPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            return RatioFragment.newInstance(position);
        }
    }

    public static class RatioFragment extends ListFragment {

        private String mKey;
        private static final String BUNDLE_KEY = "key";

        private ArrayAdapter<String> adapter;

        public static RatioFragment newInstance(int pos) {
            RatioFragment toReturn = new RatioFragment();

            String listKey;
            switch (pos) {
                case 0: listKey = ASSET_KEY; break;
                case 1: listKey = DEBT_KEY; break;
                case 2: listKey = EQUITY_KEY; break;
                default: listKey = null; break;
            }

            Bundle args = new Bundle();
            args.putString(BUNDLE_KEY, listKey);
            toReturn.setArguments(args);

            return toReturn;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mKey = getArguments() != null ? getArguments().getString(BUNDLE_KEY) : null;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_ratio, container, false);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            if(savedInstanceState != null)
                mKey = savedInstanceState.getString(BUNDLE_KEY);

            String[] list;

            if(mKey != null) {
                switch (mKey) {
                    case ASSET_KEY:
                        list = getResources().getStringArray(R.array.asset_ratios);
                        break;
                    case DEBT_KEY:
                        list = getResources().getStringArray(R.array.debt_ratios);
                        break;
                    case EQUITY_KEY:
                        list = getResources().getStringArray(R.array.equity_ratios);
                        break;
                    default:
                        list = new String[0];
                        break;
                }
                adapter = new ArrayAdapter<>(getActivity(), R.layout.ratio_item, list);
                setListAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }
    }
}
