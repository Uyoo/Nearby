package cf.nearby.nearby.util;

import android.content.Context;

import java.util.HashMap;

import cf.nearby.nearby.Information;
import cf.nearby.nearby.R;
import cf.nearby.nearby.StartActivity;
import cf.nearby.nearby.obj.Employee;
import cf.nearby.nearby.obj.Patient;
import cf.nearby.nearby.obj.PatientMedicine;
import cf.nearby.nearby.obj.PatientSymptom;
import cf.nearby.nearby.obj.Supporter;

/**
 * Created by tw on 2017. 10. 17..
 */

public class LogManager {

    public final String TYPE_WEIGHT = "weight";
    public final String TYPE_SYMPTOM = "symptom";
    public final String TYPE_MEDICINE = "medicine";
    public final String TYPE_RECORD = "record";
    public final String TYPE_EDIT_PATIENT = "edit_patient";
    public final String TYPE_SUPPORTER = "supporter";

    Context context;

    Patient patient;
    String type, msg;

    public LogManager(Context context){
        this.context = context;
    }

    public LogManager buildWeightMsg(Patient patient, String weight){

        this.type = TYPE_WEIGHT;
        this.patient = patient;
        this.msg = String.format(context.getString(R.string.log_add_weight), patient.getName(), weight);


        return this;
    }

    public LogManager buildSymptomMsg(Patient patient, PatientSymptom symptom){

        this.type = TYPE_SYMPTOM;
        this.patient = patient;
        this.msg = String.format(context.getString(R.string.log_add_symptom), patient.getName(), symptom.getDescription());

        return this;
    }

    public LogManager buildMedicineMsg(Patient patient, String title){

        this.type = TYPE_MEDICINE;
        this.patient = patient;
        this.msg = String.format(context.getString(R.string.log_add_medicine), patient.getName(), title);

        return this;
    }

    public LogManager buildRecordMsg(Patient patient, String content){
        this.type = TYPE_RECORD;
        this.patient = patient;
        this.msg = String.format(context.getString(R.string.log_add_record), patient.getName(), content);

        return this;
    }

    public LogManager buildEditPatientInfo(Patient patient){
        this.type = TYPE_EDIT_PATIENT;
        this.patient = patient;
        this.msg = String.format(context.getString(R.string.log_edit_patient_info), patient.getName());

        return this;
    }

    public LogManager buildManageSupporterMsg(Patient patient, Supporter supporter, boolean isAdd){
        this.type = TYPE_SUPPORTER;
        this.patient = patient;
        if(isAdd)
            this.msg = String.format(context.getString(R.string.log_add_supporter), patient.getName(), supporter.getName());
        else
            this.msg = String.format(context.getString(R.string.log_remove_supporter), patient.getName(), supporter.getName());

        return this;
    }

    public void record(){

        HashMap<String, String> map = new HashMap<>();
        map.put("service", "addLog");
        map.put("location_id", StartActivity.employee.getLocation().getId());
        map.put("employee_id", StartActivity.employee.getId());
        if(patient != null)
            map.put("patient_id", patient.getId());
        map.put("type", type);
        map.put("msg", msg);

        new ParsePHP(Information.MAIN_SERVER_ADDRESS, map){
            @Override
            protected void afterThreadFinish(String data) {

                System.out.println(data);

            }
        }.start();

    }


}
