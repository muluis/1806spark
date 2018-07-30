package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Student;

//A CLASS SPECIFICALLY MADE TO ACCESS DATA ABOUT STUDENTS
public class StudentDao {
	private static final String filePathAndName = "src/com/revature/person.txt";
	
	public static void serializeStudent(Student stud) throws IOException {
		// Serialize Student to a file.
		
		//the blank template of this only provides constructors to take arguments, cant take no args.
		
		//ObjectOutputStream is better than FileOutputStream.
			FileOutputStream os = new FileOutputStream(filePathAndName);
					// ill add an additional catch clause to my catch.
					ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(stud);
				oos.close();
				os.close();
				
				
			
			
		
	}
	public static Student deserializeStudent() {
		
		// CONVERT BYTECODE BACK INTO A JAVA OBJECT.
		
		Student john = null; // DECLARE JOHN OUTSIDE OF THE TRY BLOCK TO GET A BIGGER LOCAL SCOPE.
		try (FileInputStream is = new FileInputStream(filePathAndName);
			ObjectInputStream ois = new ObjectInputStream(is);){
			
			// ois.readObject(); will ONLY read an obj, it doesnt know what kind!
			// must downcast to a student.
			john = (Student) ois.readObject();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return john; //another way of saying TODO.
	}
}
