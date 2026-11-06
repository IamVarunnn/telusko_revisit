package com.hospital;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.DoctorDAO;
import com.hospital.dao.PatientDAO;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Hospital_Main {

    static void main() {

        Scanner scanner = new Scanner(System.in);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while (true) {

            System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    Patient patient = new Patient();

                    System.out.print("Enter patient name: ");
                    patient.setName(scanner.next());

                    System.out.print("Enter patient age: ");
                    patient.setAge(scanner.nextInt());

                    System.out.print("Enter patient gender: ");
                    patient.setGender(scanner.next());

                    patientDAO.addPatient(patient);

                    System.out.println("Patient added successfully!");
                    break;

                case 2:

                    List<Patient> patients = patientDAO.viewPatients();


                    System.out.println("\nPatients:");
                    System.out.println("+------------+--------------------+------------+------------+");
                    System.out.println("| Patient Id | Name               | Age        | Gender     |");
                    System.out.println("+------------+--------------------+------------+------------+");

                    for (Patient p : patients) {
                        System.out.printf("| %-10d | %-18s | %-10d | %-10s |%n",
                                p.getId(),
                                p.getName(),
                                p.getAge(),
                                p.getGender());
                    }

                    System.out.println("+------------+--------------------+------------+------------+");
                    break;

                case 3:

                    List<Doctor> doctors = doctorDAO.viewDoctors();

                    System.out.println("\nDoctors:");
                    System.out.println("+------------+--------------------+------------------+");
                    System.out.println("| Doctor Id  | Name               | Specialization   |");
                    System.out.println("+------------+--------------------+------------------+");

                    for (Doctor d : doctors) {
                        System.out.printf("| %-10d | %-18s | %-16s |%n",
                                d.getId(),
                                d.getName(),
                                d.getSpecialization());
                    }

                    System.out.println("+------------+--------------------+------------------+");
                    break;

                case 4:
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();

                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();

                    System.out.print("Enter appointment date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.next());

                    String result = appointmentDAO.bookAppointment(
                            patientId, doctorId, date
                    );

                    System.out.println(result);
                    break;

                case 5:
                    scanner.close();
                    sessionFactory.close();
                    return;

                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
}