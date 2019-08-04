package com.vegan.eiko.vegantravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewpager;
    private FirebaseAnalytics mFirebaseAlalytics;
    private Toolbar toolbar;
    private HashMap<String, String> hashMap;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Firebase Analytics
        mFirebaseAlalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAlalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        toolbar = findViewById(R.id.tabLayoutToolBar);
        setSupportActionBar(toolbar);
        TextView mTextView = toolbar.findViewById(R.id.toolbar_title_main);
        mTextView.setText(R.string.appbar_title);

        viewpager = findViewById(R.id.tabLayoutViewPager);
        if (viewpager != null) {
            setupViewPager(viewpager);
        }

        TabLayout tablayout = findViewById(R.id.tabLayoutTAB);
        tablayout.setupWithViewPager(viewpager);
        tablayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewpager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        /*if title has value add. add to HashMap*/
        hashMap = new HashMap<>();
        hashMap.put("Arabic", Veg_arabic.titleStringArabic);
        hashMap.put("Chinese",Veg_chinese.titleStringChinese);
        hashMap.put("Filipino", Veg_filipino.titleStringFilipino);
        hashMap.put("French", Veg_french.titleStringFrench);
        hashMap.put("German", Veg_german.titleStringGerman);
        hashMap.put("Hindi", Veg_hindi.titleStringHindi);
        hashMap.put("Italian", Veg_Italian.titleStringItalian);
        hashMap.put("Japanese", Veg_japanese.titleStringJapanese);
        hashMap.put("Korean", Veg_korean.titleStringKorean);
        hashMap.put("Portuguese", Veg_portuguese.titleStringPortuguese);
        hashMap.put("Russian", Veg_russian.titleStringRussian);
        hashMap.put("Spanish", Veg_spanish.titleStringSpanish);
        hashMap.put("Swahili", Veg_swahili.titleStringSwahili);
        hashMap.put("Thai", Veg_thai.titleStringThai);
        hashMap.put("Vietnamese", Veg_vietnamese.titleStringVietnamese);

        if (hashMap != null) {
            Log.i("test in mainactivity", hashMap.toString());
            databaseReference.setValue(hashMap);
        }
    }

    private void setupViewPager(ViewPager viewpPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFRAG(new Picture_tab(), "picture");
        adapter.addFRAG(new LanguageListSouthAmerica(), "Language Card\n South America");
        adapter.addFRAG(new LanguageListASIA(), "Language Card \n Asia");
        adapter.addFRAG(new LanguageListEU(), "Language Card \n Europe");
        adapter.addFRAG(new LanguageListAfrica(), "Language Card\n Africa");
        adapter.addFRAG(new SearchTab(),"Search");
        viewpPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //share button on tool bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mShare:
                Intent intent = new Intent(
                        Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, R.string.share_comment);
                startActivity(Intent.createChooser(intent, "Vegan Travel"));
                break;
            case R.id.mHistory:
                Intent intentHistory = new Intent(
                        getApplicationContext(), history_list.class);
                startActivity(intentHistory);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList_VT = new ArrayList<>();
        private final List<String> fragmentTitle_VT = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList_VT.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList_VT.size();
        }

        public void addFRAG(Fragment fragment, String title) {
            fragmentList_VT.add(fragment);
            fragmentTitle_VT.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle_VT.get(position);
        }
    }

}