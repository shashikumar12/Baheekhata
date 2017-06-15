package com.example.centuratechnology.baheekhata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrontPage extends AppCompatActivity {

    Button button;
    LinearLayout l1, l2, l3, l4, l5, l6;
    private DrawerLayout mDarwerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        button = (Button) findViewById(R.id.btn_logout);
        l1 = (LinearLayout) findViewById(R.id.linearLayout1);
        l2 = (LinearLayout) findViewById(R.id.linearLayout2);
        l3 = (LinearLayout) findViewById(R.id.linearLayout3);
        l4 = (LinearLayout) findViewById(R.id.linearLayout4);
        l5 = (LinearLayout) findViewById(R.id.linearLayout5);
        l6 = (LinearLayout) findViewById(R.id.linearLayout6);

        mDarwerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDarwerLayout, R.string.open, R.string.close);
        mDarwerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enableExpandableList();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPage.this, UserLogin.class);
                startActivity(i);
            }
        });

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPage.this, GraphicalReport.class);
                startActivity(i);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPage.this, Order.class);
                startActivity(i);
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPage.this, Money.class);
                startActivity(i);
            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPage.this, Purchase.class);
                startActivity(i);
            }
        });

        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPage.this, Quantity.class);
                startActivity(i);
            }
        });

        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPage.this, Rating.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notification, menu);
        return super.onCreateOptionsMenu(menu);
    }


    // Code for ExpandableListView

    public void enableExpandableList() {
        final ArrayList<String> headerList = new ArrayList<String>();
        final HashMap<String, List<String>> childList = new HashMap<String, List<String>>();
        ExpandableListView expList = (ExpandableListView) findViewById(R.id.expList);
        ExpandList listAdapter = new ExpandList(this, headerList, childList);
        expList.setAdapter(listAdapter);
        prepareListData(headerList, childList);

        expList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        // Listview Group expanded listener
        expList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        headerList.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();*/
            }
        });

        // Listview Group collasped listener
        expList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        headerList.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();*/

            }
        });

        // Listview on child click listener
        expList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                /*Toast.makeText(getApplicationContext(), headerList.get(groupPosition) + " : " +
                        childList.get(headerList.get(groupPosition))
                        .get(childPosition), Toast.LENGTH_SHORT).show();*/
                return false;
            }
        });
    }

    //method for add the header and child data to the list
    public void prepareListData(ArrayList<String> headerList, HashMap<String, List<String>> childList) {
        // Adding Header data
        headerList.add("Party");
        headerList.add("Customer");
        headerList.add("Karighar");
        headerList.add("Sales");
        headerList.add("Purchase");
        headerList.add("Order");
        headerList.add("Quantity Based");
        headerList.add("Bullion");
        headerList.add("Melting");
        headerList.add("Stock");
        headerList.add("Product");
        headerList.add("MoneyIO/Scheme");
        headerList.add("Report");
        headerList.add("Estimate");
        headerList.add("Extra");

        // Adding child data to each header data
        List<String> Party = new ArrayList<String>();
        Party.add("Party A/C Book");
        Party.add("New Party ");
        Party.add("Party Book");

        List<String> Customer = new ArrayList<String>();
        Customer.add("New Cutomer");
        Customer.add("Customer Book");
        Customer.add("Customer Account Book");

        List<String> Karighar = new ArrayList<String>();
        Karighar.add("New Karighar Transactoin");
        Karighar.add("Item Details");
        Karighar.add("Karigar Item Book");
        Karighar.add("Payment Details");
        Karighar.add("Karighar Payment Book");
        Karighar.add("Karighar A/c Book");

        List<String> Sales = new ArrayList<String>();
        Sales.add("New Invoice");
        Sales.add("Sales Book");
        Sales.add("Sales Return");


        List<String> Purchase = new ArrayList<String>();
        Purchase.add("Nea Purchase");
        Purchase.add("Purchase Book");
        Purchase.add("Purchase Return");
        Purchase.add("Old Purchase");
        Purchase.add("Old Purchase Book");
        Purchase.add("Item Token Print");

        List<String> Order = new ArrayList<String>();
        Order.add("Order Book");
        Order.add("Order Record");

        List<String> QuantityBased = new ArrayList<String>();
        QuantityBased.add("NewQty Purchase");
        QuantityBased.add("QtyPurchase Book");
        QuantityBased.add("QtyPurchase Return");
        QuantityBased.add("New QtySale");
        QuantityBased.add("QtySale Book");
        QuantityBased.add("QtySale Return");
        QuantityBased.add("QtyItem Token Print ");


        List<String> Bullion = new ArrayList<String>();
        Bullion.add("Bullion");
        Bullion.add("Bullion Book");

        List<String> Melting = new ArrayList<String>();
        Melting.add("New Melting");
        Melting.add("Melting Book");

        List<String> Stock = new ArrayList<String>();
        Stock.add("Stock");
        Stock.add("Add Stock");
        Stock.add("Quantity Item Stock");
        Stock.add("Add Quantity Item Stock");

        List<String> Product = new ArrayList<String>();
        Product.add("Product Details");


        List<String> MoneyIO = new ArrayList<String>();
        MoneyIO.add("Payment Details");


        List<String> Report = new ArrayList<String>();
        Report.add("Report");
        Report.add("Today Report");
        Report.add("Today Rate Setup");
        Report.add("Graphical Report");

        List<String> Estimate = new ArrayList<String>();
        Estimate.add("New Estimate");

        List<String> Extra = new ArrayList<String>();
        Extra.add("Shop Profile");
        Extra.add("Setting");
        Extra.add("Change Password");
        Extra.add("Import/Export DB");
        Extra.add("Notification");
        Extra.add("Help");
        Extra.add("Share with Friends");

        // child data put into specific header data
        childList.put(headerList.get(0), Party);
        childList.put(headerList.get(1), Customer);
        childList.put(headerList.get(2), Karighar);
        childList.put(headerList.get(3), Sales);
        childList.put(headerList.get(4), Purchase);
        childList.put(headerList.get(5), Order);
        childList.put(headerList.get(6), QuantityBased);
        childList.put(headerList.get(7), Bullion);
        childList.put(headerList.get(8), Melting);
        childList.put(headerList.get(9), Stock);
        childList.put(headerList.get(10), Product);
        childList.put(headerList.get(11), MoneyIO);
        childList.put(headerList.get(12), Report);
        childList.put(headerList.get(13), Estimate);
        childList.put(headerList.get(14), Extra);

    }
}
