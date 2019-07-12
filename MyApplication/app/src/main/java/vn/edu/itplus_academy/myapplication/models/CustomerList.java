package vn.edu.itplus_academy.myapplication.models;

import java.util.ArrayList;

public class CustomerList {

    ArrayList<Customer>listKH=new ArrayList<Customer>();

    public void addKhachHang(Customer kh)
    {

        listKH.add(kh);

    }

    public double tongDoanhThu()

    {

        double tien=0.0;

        for(Customer kh:listKH)

        {

            tien+=kh.tinhThanhTien();

        }

        return tien;

    }

    public int tongKhachHang()

    {

        return listKH.size();

    }

    public int tongKhachHangVip()

    {

        int s=0;

        for(Customer kh:listKH)

        {

            if(kh.isVip())

                s++;

        }

        return s;

    }
}
