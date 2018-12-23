package com.imbuegen.alumniapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.imbuegen.alumniapp.Adapters.MyDeptAdapter;
import com.imbuegen.alumniapp.Models.Department;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Department> deptList;
    ListView deptListView;
    MyDeptAdapter myDeptAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        instantiateDeptList();
    }
    @Override
    protected void onResume() {
        super.onResume();

        loadData();
        setListeners();
    }

    private void setListeners() {

    }

    private void init(){
        deptList = new ArrayList<>();
        deptListView = findViewById(R.id.list_depts);
    }
    private void loadData() {
        deptList.clear();
        deptList.add(new Department("Computers and IT", R.drawable.monitor));
        deptList.add(new Department("Elex & Telecom", R.drawable.tower));
        deptList.add(new Department("Electronics", R.drawable.chip));
        deptList.add(new Department("Mechanical", R.drawable.mech));
        deptList.add(new Department("Production", R.drawable.assembly));
        deptList.add(new Department("Chemical", R.drawable.laboratory));
        myDeptAdapter.notifyDataSetChanged();
    }

    private void instantiateDeptList() {

        myDeptAdapter = new MyDeptAdapter(this, deptList);



        deptListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Department selectedDepartment = (Department) deptListView.getItemAtPosition(i);

                String selectedDeptName = selectedDepartment.getName();
                Intent companyActivityIntent = new Intent(MainActivity.this,CompanyActivity.class);
                companyActivityIntent.putExtra("deptName",selectedDeptName);
                startActivity(companyActivityIntent);

            }
        });


        deptListView.setAdapter(myDeptAdapter);
    }

}
