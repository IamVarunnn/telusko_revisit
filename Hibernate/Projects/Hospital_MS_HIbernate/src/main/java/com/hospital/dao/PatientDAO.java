package com.hospital.dao;

import com.hospital.HibernateUtil;
import com.hospital.entity.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatientDAO {

    public void addPatient(Patient patient) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(patient);

        transaction.commit();
        session.close();
    }

    public List<Patient> viewPatients() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Patient> patients = session
                .createQuery("FROM Patient", Patient.class)
                .getResultList();



        session.close();

        return patients;
    }
}
