package alapozo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonWrite {
    User user = new User(
            1,"Leanne Graham","Bret","Sincere@april.biz","1-770-736-8031 x56442","hildegard.org",
            new Address("Kulas Light","Apt. 556","92998-3874","Gwenborough",new Geo(-37.3159,81.1496)),
            new Company("Romaguera-Crona","Multi-layered client-server neural-net","harness real-time e-markets")
    );

    public static void main(String[] args) {
        JsonWrite jsonWrite = new JsonWrite();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<User> users = new ArrayList<>();
        users.add(jsonWrite.user);
        try {
            objectMapper.writeValue(new File("user.json"), users);
        }catch (IOException e){
            System.out.println("Nem tudom létrehozni a filet");
        }
    }
}
