package cf.nearby.nearby.obj;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import cf.nearby.nearby.util.AdditionalFunc;

/**
 * Created by ewon on 2017-10-01.
 */

public class Patient implements Serializable {
    String id, loginId, email, fn, ln, gender, address, zip, phone, pic, description;
    long startDate, dob, registeredDate;
    Double height, basicLivingAllowance;
    Location location;

    public Patient(){

        location = new Location();

    }

    public Patient (String data){
        this();
        build(data);
    }

    public boolean isEmpty(){
        if(id == null){
            return true;
        }
        return "".equals(id);
    }

    public void build(String data){

        try {
            // PHP에서 받아온 JSON 데이터를 JSON오브젝트로 변환
            JSONObject jObject = new JSONObject(data);
            // results라는 key는 JSON배열로 되어있다.
            JSONArray results = jObject.getJSONArray("result");
            String countTemp = (String)jObject.get("num_result");
            int count = Integer.parseInt(countTemp);

            for ( int i = 0; i < count; ++i ) {
                JSONObject temp = results.getJSONObject(i);
                convert(temp);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void convert(JSONObject temp){
        ArrayList<String> keySet = AdditionalFunc.getKeySet(temp.keys());

        try {

            if (keySet.contains("id")) {
                id = (String) temp.get("id");
            }
            if (keySet.contains("login_id")) {
                loginId = (String) temp.get("login_id");
            }
            if (keySet.contains("email")) {
                email = (String) temp.get("email");
            }
            if (keySet.contains("first_name")) {
                fn = (String) temp.get("first_name");
            }
            if (keySet.contains("last_name")) {
                ln = (String) temp.get("last_name");
            }
            if (keySet.contains("gender")) {
                gender = (String) temp.get("gender");
            }
            if (keySet.contains("address")) {
                address = (String) temp.get("address");
            }
            if (keySet.contains("zip")) {
                zip = (String) temp.get("zip");
            }
            if (keySet.contains("phone")) {
                phone = (String) temp.get("phone");
            }
            if (keySet.contains("pic")) {
                pic = (String) temp.get("pic");
            }
            if (keySet.contains("description")) {
                description = (String) temp.get("description");
            }
            if (keySet.contains("start_date")) {
                startDate = Long.parseLong((String) temp.get("start_date"));
            }
            if (keySet.contains("date_of_birth")) {
                dob = Long.parseLong((String) temp.get("date_of_birth"));
            }
            if (keySet.contains("registered_date")) {
                registeredDate = Long.parseLong((String) temp.get("registered_date"));
            }

            if (keySet.contains("height")) {
                height = Double.parseDouble((String) temp.get("height"));
            }
            if (keySet.contains("basic_living_allowance")) {
                basicLivingAllowance = Double.parseDouble((String) temp.get("basic_living_allowance"));
            }

            location.convert(temp);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Patient> getPatientList(String data){

        ArrayList<Patient> list = new ArrayList<>();

        try {
            JSONObject jObject = new JSONObject(data);
            JSONArray results = jObject.getJSONArray("result");
            String countTemp = (String)jObject.get("num_result");
            int count = Integer.parseInt(countTemp);

            for ( int i = 0; i < count; ++i ) {
                JSONObject temp = results.getJSONObject(i);

                Patient patient = new Patient();
                patient.convert(temp);

                list.add(patient);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getName(){
        return ln + fn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public long getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(long registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Double getBasicLivingAllowance() {
        return basicLivingAllowance;
    }

    public void setBasicLivingAllowance(double basicLivingAllowance) {
        this.basicLivingAllowance = basicLivingAllowance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
