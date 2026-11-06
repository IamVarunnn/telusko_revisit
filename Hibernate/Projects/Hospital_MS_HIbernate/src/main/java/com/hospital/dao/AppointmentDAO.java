package com.hospital.dao;

import com.hospital.HibernateUtil;
import com.hospital.entity.Appointment;
import com.hospital.entity.Patient;
import com.hospital.entity.Doctor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class AppointmentDAO {

    public String bookAppointment(int patientId, int doctorId, LocalDate date) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {

            Patient patient = session.find(Patient.class, patientId);
            Doctor doctor = session.find(Doctor.class, doctorId);

            if (patient == null || doctor == null) {
                transaction.rollback();
                return "Either doctor or patient does not exist";
            }

            Long count = session.createQuery(
                            "SELECT COUNT(a) FROM Appointment a " +
                                    "WHERE a.doctor.id = :doctorId " +
                                    "AND a.appointmentDate = :date",
                            Long.class
                    )
                    .setParameter("doctorId", doctorId)
                    .setParameter("date", date)
                    .getSingleResult();

            if (count > 0) {
                transaction.rollback();
                return "Doctor is not available on this date";
            }

            Appointment appointment = new Appointment();
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setAppointmentDate(date);

            session.persist(appointment);

            transaction.commit();

            return "Appointment Booked";

        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}