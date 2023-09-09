package alapozo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class JsonRead {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = Files.readString(Path.of("users.json"));
            users = objectMapper.readValue(json, new TypeReference<ArrayList<User>>() { });
            System.out.println(users);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
