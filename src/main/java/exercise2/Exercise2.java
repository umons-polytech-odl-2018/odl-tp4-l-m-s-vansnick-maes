package exercise2;

import java.io.*; //* = tout ce qu'il y a dans l'IO
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Exercise2 {
	public static void save(Classroom classroom, Path filePath) throws IOException{
		try (OutputStream out = Files.newOutputStream(filePath)){
			ObjectOutput oos = new ObjectOutputStream(out);
			oos.writeObject(classroom);

		}
	}

	public static Classroom load(Path filePath) throws IOException, ClassNotFoundException{
		try(InputStream in = Files.newInputStream(filePath)){
			ObjectInput ois = new ObjectInputStream(in);
			return (Classroom) ois.readObject();
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Teacher teacher = new Teacher("Claire", "Barnett",
			LocalDate.of(1975, 3, 7), new PhoneNumber("+32 65 123 456"),
			new Location("Ho.23", "Houdain"));
		Student[] students = {
			new Student("Jo", "Henderson", LocalDate.of(1981, 3, 8)),
			new Student("Caleb", "Stephen", LocalDate.of(1983, 5, 9)),
			new Student("Diana", "Shelton", LocalDate.of(1981, 2, 9))
		};
		Classroom classroom = new Classroom(teacher, students);

		Path filePath = Paths.get("classroom.ser");

		save(classroom, filePath);

		System.out.printf("Classroom saved to %s, size=%d bytes\n", filePath.toString(), Files.size(filePath));

		Classroom loadedClassroom = load(filePath);

		System.out.printf("Classroom loaded from %s: %s\n", filePath.toString(), loadedClassroom.toString());
	}
}
