package ru.stqa.pft.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.adressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "group count")
    public int count;

    @Parameter (names = "-f", description = "target file")
    public String file;

    @Parameter (names = "-d", description = "data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
        }
        generator.run();
    }


    private void run() throws IOException {
        List<ContactData> contacts = generateContact(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File (".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getMiddlename(), contact.getLastname(),
                    contact.getNickname(),contact.getHomePhone(),contact.getEmail(), contact.getEmail2(), contact.getEmail3(),
                    contact.getPhoto(),contact.getGroup()));
        }
        writer.close();
    }

    private List<ContactData> generateContact(int count) {
        File photo = new File("src/test/resources/smile.jpg");
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactData().withFirstname(String.format("TestName %s", i)).withMiddlename(String.format("TestMiddlename %s", i))
                    .withLastname(String.format("TestLastName %s", i)).withNickname(String.format("Test %s", i))
                    .withHomePhone(String.format("9097778881 %s", i)).withEmail(String.format("dadada@lol.net %s", i))
                    .withPhoto(photo).withGroup(String.format("test %s", i)).withCreation(true));
        }
        return contacts;
    }
}
