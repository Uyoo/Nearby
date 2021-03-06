package cf.nearby.nearby.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

import cf.nearby.nearby.BaseActivity;
import cf.nearby.nearby.Information;
import cf.nearby.nearby.R;
import cf.nearby.nearby.activity.SearchPatientActivity;
import cf.nearby.nearby.activity.SearchPatientByLocationIdActivity;

public class AdminManageActivity extends BaseActivity implements Serializable {

    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage);

        init();

    }

    private void init(){

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setCardButtonOnTouchAnimation(findViewById(R.id.cv_edit_my_info));
        findViewById(R.id.cv_edit_my_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        setCardButtonOnTouchAnimation(findViewById(R.id.cv_edit_location_info));
        findViewById(R.id.cv_edit_location_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        setCardButtonOnTouchAnimation(findViewById(R.id.cv_edit_patient_info));
        findViewById(R.id.cv_edit_patient_info).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SearchPatientByLocationIdActivity.class);
                intent.putExtra("nextActivity", Information.NURSE_MANAGE_MENU);
                startActivity(intent);

            }
        });

    }
}
