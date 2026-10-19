package com.example.practice13;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class User implements Serializable, Parcelable {

    private String name;
    private String company;
    private int age;
    private String phone;

    public User(String name, String company, int age, String phone) {
        this.name = name;
        this.company = company;
        this.age = age;
        this.phone = phone;
    }

    protected User(Parcel in) {
        name = in.readString();
        company = in.readString();
        age = in.readInt();
        phone = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(company);
        dest.writeInt(age);
        dest.writeString(phone);
    }
}