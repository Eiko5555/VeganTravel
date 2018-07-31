package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout VT_draweLayout;
    private ViewPager viewpager;
    //ExpandableListAdapter VegTravel_ExpandMenuAdapter;
    //ExpandableListView VegTravel_expandList;
    //List<String> VegTravel_listDataHeader;
    //HashMap<String, List<String>> VegTravel_listDataChild;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    //private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tabLayoutToolBar);
        setSupportActionBar(toolbar);

        VT_draweLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, VT_draweLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        final ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        VT_draweLayout.setDrawerListener(toggle);
        toggle.syncState();
        //VegTravel_expandList = (ExpandableListView) findViewById(R.id.navigationmenu);

        NavigationView navgationView = (NavigationView) findViewById(R.id.nav_view);
        if (navgationView != null) {
            setupDrawerContent(navgationView);
        }

        viewpager = (ViewPager) findViewById(R.id.tabLayoutViewPager);
        //viewpager.setAdapter(new Tab_Fragment_Page_Adapter(getSupportFragmentManager(),
        //      MainActivity.this ));
        if (viewpager != null) {
            setupViewPager(viewpager);
        }

        TabLayout tablayout = (TabLayout) findViewById(R.id.tabLayoutTAB);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setOnTabSelectedListener(
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
        /*prepare_ListData();
        VegTravel_ExpandMenuAdapter = new VegTravel_ExpandlistAdapter(this, VegTravel_listDataHeader,
                VegTravel_listDataChild, VegTravel_expandList);
        VegTravel_expandList.setAdapter(VegTravel_ExpandMenuAdapter);

        VegTravel_expandList.setOnGroupClickListener
                (new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent,
                                                View v, int groupPosition, long id) {
                        return false;
                    }
                });

        VegTravel_expandList.setOnChildClickListener(
           new ExpandableListView.OnChildClickListener() {
               @Override
               public boolean onChildClick(ExpandableListView parent,
                      View v, int groupPosition,
                       int childPosition, long id) {
                      switch (groupPosition) {
                        case 0:
                      switch (childPosition) {
                        case 0:
                             Intent VegTravel_italian = new Intent(
                             MainActivity.this, Veg_Italian.class);
                             startActivity(VegTravel_italian);
                             break;
                        case 1:
                             Intent VegTravel_spanish = new Intent(
                             MainActivity.this, Veg_spanish.class);
                             startActivity(VegTravel_spanish);
                             break;
                        case 2:
                             Intent VegTravel_german = new Intent(
                             MainActivity.this, Veg_german.class);
                             startActivity(VegTravel_german);
                             break;
                        case 3:
                             Intent VegTravel_french = new Intent(
                             MainActivity.this, Veg_french.class);
                             startActivity(VegTravel_french);
                             break;
               }
               break;
               case 1:
                  switch (childPosition) {
                     case 0:
                          Intent VegTravel_chinese = new Intent(
                          MainActivity.this, Veg_chinese.class);
                          startActivity(VegTravel_chinese);
                          break;
                     case 1:
                          Intent VegTravel_japanese = new Intent(
                          MainActivity.this, Veg_japanese.class);
                          startActivity(VegTravel_japanese);
                          break;
                     case 2:
                          Intent VegTravel_thai = new Intent(
                          MainActivity.this, Veg_thai.class);
                          startActivity(VegTravel_thai);
                          break;
                     case 3:
                          Intent VegTravel_korean = new Intent(
                          MainActivity.this, Veg_korean.class);
                          startActivity(VegTravel_korean);
                          break;
                    case 4:
                         Intent VegTravel_filipino = new Intent(
                         MainActivity.this, Veg_filipino.class);
                         startActivity(VegTravel_filipino);
                         break;
                    case 5:
                         Intent VegTravel_rossian = new Intent(
                         MainActivity.this, Veg_russian.class);
                         startActivity(VegTravel_rossian);
                         break;
                    case 6:
                         Intent VegTravel_hindi = new Intent(
                         MainActivity.this, Veg_hindi.class);
                         startActivity(VegTravel_hindi);
                         break;
                    case 7:
                         Intent VegTravel_vietnamese = new Intent(
                         MainActivity.this, Veg_vietnamese.class);
                         startActivity(VegTravel_vietnamese);
                         break;
                    case 8:
                         Intent VegTravel_arabic = new Intent(
                         MainActivity.this, Veg_arabic.class);
                         startActivity(VegTravel_arabic);
                         break;
                   }
                   break;
                   case 2:
                     switch (childPosition) {
                          case 0:
                              Intent VegTravel_northAmerica_spanish =
                              new Intent(MainActivity.this, Veg_spanish.class);
                              artActivity(VegTravel_northAmerica_spanish);
                              break;
                          case 1:
                             Intent VegTravel_portuguese = new Intent(
                             MainActivity.this, Veg_portuguese.class);
                             startActivity(VegTravel_portuguese);
                             break;
                             }
                             break;
                   case 3:
                     switch (childPosition) {
                        case 0:
                          Intent VegTravel_africa_french = new Intent(
                          MainActivity.this, Veg_french.class);
                          startActivity(VegTravel_africa_french);
                          break;
                        case 1:
                          Intent VegTravel_africa_arabic = new Intent(
                          MainActivity.this, Veg_arabic.class);
                          startActivity(VegTravel_africa_arabic);
                          break;
                        case 2:
                          Intent VegTravel_swahili = new Intent(
                          MainActivity.this, Veg_swahili.class);
                          startActivity(VegTravel_swahili);
                          break;
                     }
                     break;
                }
                return false;
             }
          }
        );
        */
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    private void setupViewPager(ViewPager view_pager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFRAG(new Picture_tab(), "picture");
        adapter.addFRAG(new LanguageSouthAmerica(), "Language Card\n South America");
        adapter.addFRAG(new LanguageASIA(), "Language Card \n Asia");
        adapter.addFRAG(new LanguageEU(), "Language Card \n Europe");
        adapter.addFRAG(new LanguageAfrica(), "Language Card\n Africa");
        //adapter.addFRAG(new (), "5");
        view_pager.setAdapter(adapter);
    }
    private void setupDrawerContent(NavigationView navigationview){
        navigationview.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.drawer_1:
                                viewpager.setCurrentItem(0);
                                break;
                            case R.id.drawer_3:
                                viewpager.setCurrentItem(1);
                                break;
                            case R.id.drawer_4:
                                viewpager.setCurrentItem(1);
                                break;
                        }
                        VT_draweLayout.closeDrawers();
                        return true;
                    }
                });
         };

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.action_settings){ return true; }
        switch (id) {
            case android.R.id.home:
                if (VT_draweLayout.isDrawerOpen(GravityCompat.START)){
                    VT_draweLayout.closeDrawer(GravityCompat.START);
                }else {
                    VT_draweLayout.openDrawer(GravityCompat.START);
                }
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}

   /* public void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        VT.closeDrawers();
                        return true;
                    }
                });
     */
        /*  private void prepare_ListData() {
                        VegTravel_listDataHeader = new ArrayList<String>();
                        VegTravel_listDataChild = new HashMap<String, List<String>>();
                        // adding parent data
                       VegTravel_listDataHeader.add("EUROPE");
                        VegTravel_listDataHeader.add("ASIA");
                        VegTravel_listDataHeader.add("NORTH AMERICA");
                        VegTravel_listDataHeader.add("AFRICA");
                        // adding child data ... europe
                        List<String> VegTravel_euro = new ArrayList<String>();
                        VegTravel_euro.add("ITALIAN");
                        VegTravel_euro.add("SPANISH");
                        VegTravel_euro.add("GERMAN");
                        VegTravel_euro.add("FRENCH");
                        // asia
                        ArrayList<String> VegTravel_asia = new ArrayList<String>();
                        VegTravel_asia.add("CHINESE");
                        VegTravel_asia.add("JAPANESE");
                        VegTravel_asia.add("THAI");
                        VegTravel_asia.add("KOREAN");
                        VegTravel_asia.add("FILIPINO");
                        VegTravel_asia.add("RUSSIAN");
                        VegTravel_asia.add("HINDI");
                        VegTravel_asia.add("VIETNAMESE");
                        // north america
                        List<String> VegTravel_northAmerica = new ArrayList<String>();
                        VegTravel_northAmerica.add("SPANISH");
                        VegTravel_northAmerica.add("PORTUGUESE");
                        // africa
                        List<String> VegTravel_africa = new ArrayList<String>();
                        VegTravel_africa.add("FRENCH");
                        VegTravel_africa.add("ARABIC");
                        VegTravel_africa.add("SWAHILI");

                        VegTravel_listDataChild.put(VegTravel_listDataHeader.get(0), VegTravel_euro);
                        VegTravel_listDataChild.put(VegTravel_listDataHeader.get(1), VegTravel_asia);
                        VegTravel_listDataChild.put(VegTravel_listDataHeader.get(2), VegTravel_northAmerica);
                        VegTravel_listDataChild.put(VegTravel_listDataHeader.get(3), VegTravel_africa);
                   */

/*
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.vegan.eiko.vegantravel/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.vegan.eiko.vegantravel/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();}}
*/