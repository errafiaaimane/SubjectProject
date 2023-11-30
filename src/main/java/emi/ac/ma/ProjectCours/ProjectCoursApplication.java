package emi.ac.ma.ProjectCours;

import emi.ac.ma.ProjectCours.entities.Subject;
import emi.ac.ma.ProjectCours.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectCoursApplication implements CommandLineRunner {

	@Autowired
	private SubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectCoursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creating and storing Subject objects in the database
		Subject subject1 = new Subject();
		subject1.setName("Spring Cloud");
		subject1.setDescription("Spring Cloud simplifies building scalable microservices with tools for service discovery and configuration management in the Spring framework.");
		subject1.setCredit(3);
		subject1.setTeacher("Mrs. Retbi");
		subjectRepository.save(subject1);

		Subject subject2 = new Subject();
		subject2.setName("Containerization");
		subject2.setDescription("Containerization, using tools like Docker, involves encapsulating applications and their dependencies into lightweight, portable containers, facilitating consistent and efficient deployment across various computing environments.");
		subject2.setCredit(4);
		subject2.setTeacher("Mr. Anwar");
		subjectRepository.save(subject2);
	}
}
