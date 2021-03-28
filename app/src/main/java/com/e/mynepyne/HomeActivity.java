package com.e.mynepyne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;


    public Button addTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();


        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);


        addTask = (Button) findViewById(R.id.button6);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, TaskActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout){
        //Close drawer layout
        //Check direction

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            ////Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }

    public void ClickHome(View view){
        //Recreate activity
        redirectActivity(this, TaskActivity.class);
    }

    public void ClickDashboard(View view){
        //Redirect activity to dashboard
        redirectActivity(this, HostfragmentsActivity.class);
    }

    public void ClickLogout(View view){
        //Close app
        logout(this);
    }



    public static void logout(final Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        //Set title
        builder.setTitle("Logout");

        //Set message
        builder.setMessage("Are you sure you want to logout?");

        //Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish activity
                activity.finishAffinity();

                //Exit app
                System.exit(0);
            }
        });

        //Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });

        //Show dialog
        builder.show();

    }




    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity, aClass);

        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause(){
        super.onPause();

        //Close drawer
        closeDrawer(drawerLayout);
    }
}















