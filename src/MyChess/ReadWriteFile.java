package MyChess;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ReadWriteFile {
	private String fileName;

	public ReadWriteFile(String fileN) {
		this.fileName = fileN;
	}

	public void writeKokOuk(ArrayList<KonOuk> obj) throws FileNotFoundException {
		// System.out.println(obj.size());
		try {
			OutputStream file = new FileOutputStream(fileName);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput write = new ObjectOutputStream(buffer);
			write.writeObject(obj);
			write.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Errorrrrrrrr");
			e1.printStackTrace();
			System.out.println("Errorrrrrrrr1111111111111");
		}
	}

	public ArrayList<KonOuk> readKokOuk() {

		try {
			InputStream file = new FileInputStream(fileName);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput read = new ObjectInputStream(buffer);
			@SuppressWarnings("unchecked")
			ArrayList<KonOuk> readKonOuk = (ArrayList<KonOuk>) read
					.readObject();
			read.close();
			return readKonOuk;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
