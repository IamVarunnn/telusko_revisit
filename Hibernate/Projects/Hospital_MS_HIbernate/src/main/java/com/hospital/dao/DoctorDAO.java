package com.hospital.dao;

import com.hospital.HibernateUtil;
import com.hospital.entity.Doctor;
import org.hibernate.Session;

import java.util.List;

public class DoctorDAO {

    public List<Doctor> viewDoctors() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Doctor> doctors = session
                .createQuery("FROM Doctor", Doctor.class)
                .getResultList();

        session.close();

        return doctors;
    }
}