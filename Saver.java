package mancala;

import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;
import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.IOException;

//Utility class for saving and loading Serializable objects
public class Saver {

    //Save a Serializable object to a file
    public static void saveObject(final Serializable toSave, final String filename) throws IOException {

        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("assets:" + filename))) {
            objectOut.writeObject(toSave);
            System.out.println("serialization - " + filename);

        } catch (IOException e) {
            handleIOException(e);
        }
    }

    //Load a UserProfile object from a file
    public static UserProfile loadUserProfile(final String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("assets:" + filename))) {

            UserProfile loadedUserProfile = (UserProfile) objectIn.readObject();
            System.out.println("UserProfile load - " + filename);
            return loadedUserProfile;

        } catch (IOException | ClassNotFoundException e) {
            handleIOExceptionOrClassNotFoundException(e);
        }

        return null;
    }

    //Load a Serializable object from a file
    public static Serializable loadObject(final String filename) throws IOException, ClassNotFoundException {

        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("assets:" + filename))) {
            Serializable loadedObject = (Serializable) objectIn.readObject();
            System.out.println("Object loaded - " + filename);
            return loadedObject;

        } catch (IOException | ClassNotFoundException e) {
            handleIOExceptionOrClassNotFoundException(e);
        }

        return null;
    }

    //Handle IOException by printing the stack trace
    private static void handleIOException(IOException e) {
        e.printStackTrace();
    }

    //Handle IOException or ClassNotFoundException by printing the stack trace
    private static void handleIOExceptionOrClassNotFoundException(Exception e) {
        e.printStackTrace();
    }
}