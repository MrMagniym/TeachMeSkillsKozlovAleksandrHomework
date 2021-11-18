package Lessons.Lesson8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ArchiSerialivazer {

    public static final String filePathToCards = "src/Resources/Cards/";

    public static void main(String[] args){

        Card demonOfTheAbyss = new Card("Demon of the Abyss", "Why do u call me?", new Stats(1, 3));
        printCardInfo(demonOfTheAbyss);

        String filePath = filePathToCards + demonOfTheAbyss.serializedObjectName + ".out";

        serializeObject(demonOfTheAbyss, filePath);

        printArrayOfBytes("Serialized object in byte array:", getByteArrayDataFromFile(filePath));

        Card deserializedDemonOfTheAbyss = deserializeObject(filePath);

        printCardInfo(deserializedDemonOfTheAbyss);
    }

    public static void packObject(String filePathForZip){
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(filePathForZip));
            pack(filePathForZip, zos);
            zos.close();
        } catch (IOException ioException) {
            System.out.println("IO Serialization Error " + ioException);
        }
    }

    static void pack(String filePathForZip, ZipOutputStream zos){
        try {
            FileInputStream fis = new FileInputStream(filePathForZip);
            zos.putNextEntry(new ZipEntry(filePathForZip));
            int c;
            while((c = fis.read()) != -1){
                zos.write(c);
            }
            fis.close();
        }
        catch (IOException ioException) {
            System.out.println("IO Pack Error " + ioException);
        }
    }

    public static void unpackObject(String filePathForZip){
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(filePathForZip));
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                unpack(zipEntry.getName(), zis);
            }
        } catch (IOException ioException) {
            System.out.println("IO Serialization Error " + ioException);
        }
    }

    static void unpack(String filePathForZip, ZipInputStream zis){
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePathForZip));
            int c;
            while((c = zis.read()) != -1){
                bos.write(c);
            }
            bos.close();
        }
        catch (IOException ioException) {
            System.out.println("IO Unpack Error " + ioException);
        }
    }

    public static void serializeObject(Card card, String filePathForSerialization){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePathForSerialization));
            oos.writeObject(card);
            oos.close();
        } catch (IOException ioException) {
            System.out.println("IO Serialization Error " + ioException);
        }
    }

    public static Card deserializeObject(String filePathForSerialization){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePathForSerialization));
            Card card = (Card)ois.readObject();
            ois.close();
            return card;
        }
        catch (IOException ioException) {
            System.out.println("IO DESerialization Error " + ioException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.print("Class DESerialization Error " + classNotFoundException);
        }
        return new Card("lol", "error", new Stats(0, 0));
    }

    public static byte[] getByteArrayDataFromFile(String filePath){
        try {
            return Files.readAllBytes(Paths.get(filePath));
        }
        catch (IOException ioException) {
            System.out.println("IO ReadData Error: " + ioException);
        }
        return new byte[]{};
    }

    public static void printCardInfo(Card card){
        System.out.println("Name: " + card.serializedObjectName +
                "\nBattleROAR: " + card.whyDoYouSerializeMe +
                "\nHp | Damage  ---   " + card.hp + " | " + card.damage +
                '\n');
    }

    private static void printArrayOfBytes(String message, byte[] arrayOfBytes) {
        System.out.print(message + '\n');
        for (byte arrayOfByte : arrayOfBytes) System.out.print(arrayOfByte + " ");
        System.out.println('\n');
    }

}
