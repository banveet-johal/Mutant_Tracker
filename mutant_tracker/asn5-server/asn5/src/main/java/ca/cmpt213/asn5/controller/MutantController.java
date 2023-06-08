package ca.cmpt213.asn5.controller;

import ca.cmpt213.asn5.model.Mutant;
import com.google.gson.reflect.TypeToken;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import com.google.gson.*;
import java.io.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@RestController
public class MutantController {
    private final AtomicLong counter = new AtomicLong(0);
    private List<Mutant> mutant = new ArrayList<>();
   String f=System.getProperty("user.dir");
   String filen=f+ "\\data\\mutant.json";


    @GetMapping("/api/mutant/all")
    public List<Mutant> mutant() {
        System.out.println("display all mutants");
        return this.mutant;
    }

    @GetMapping("/api/mutant/{id}")
    public Mutant getById(@PathVariable long id) {
        System.out.println("specific id mutant");

        for (Mutant m : mutant) {
            if (m.getMid() == id) {
                System.out.println(m.getName());
                return m;

            }
        }

        return null;
    }

    @PostMapping("/api/mutant/add")
    public Mutant addMutant(@RequestBody Mutant newMutant, HttpServletResponse resp) throws IOException {
        System.out.println("adding " + newMutant.getName());
        mutant.add(newMutant);
        resp.setStatus(201);
        String str="{\"mutant\":[";
        for (Mutant m: mutant)
        {
            String n, c;float h, w,oa;

            n=(m.getName());
            h=(m.getHeight());
            w=(m.getWeight());
            c=(m.getCategory());
            oa=(m.getOverall_ability());
            str = str +"{\"name\":\""+n+"\",\"height\":"+h+",\"weight\":"+w+",\"category\":\""+c+"\",\"overall_ability\":"+oa+"}"+ ",";
        }
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        str=str+"]}";
        FileWriter myWriter = new FileWriter(filen);
        myWriter.write(str);
        myWriter.close();

        return newMutant;
    }

    @DeleteMapping("/api/mutant/{id}")
    public void deleteMutant(@PathVariable long id, HttpServletResponse resp) throws IOException {
        int a=0;
        for(Mutant m: mutant)
        {
            if(m.getMid()==id) {
                break;
            }
            a++;
        }
        mutant.remove(a);
        resp.setStatus(204);
        String str = "{\"mutant\":[";

            for (Mutant m : mutant) {
                String n, c;
                float h, w, oa;
                System.out.println("parsing to json after deleteing");
                System.out.println(m.getName());

                n = (m.getName());
                h = (m.getHeight());
                w = (m.getWeight());
                c=(m.getCategory());
                oa=(m.getOverall_ability());
                str = str + "{\"name\":\"" + n + "\",\"height\":" + h + "," + "\"weight\":" + w +",\"category\":\""+c+"\",\"overall_ability\":"+oa+"}" + ",";
            }
            if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "]}";
            System.out.println(str);  FileWriter myWriter = new FileWriter(filen);
             myWriter.write(str);
             myWriter.close();
        }

 @PostConstruct
    public void initIt() throws FileNotFoundException {
        // retrieve data from json
        System.out.println("POST CONSTRUCT CODE");


        JsonParser parser = new JsonParser();
        JsonObject obj = (JsonObject) parser.parse(new FileReader(filen));
        JsonArray arr = (JsonArray) obj.get("mutant");

        System.out.println(arr);

        for (Object mut : arr) {
            JsonObject m = (JsonObject) mut;
            String name = (((JsonObject) mut).get("name").getAsString());
            float weight = Float.parseFloat((((JsonObject) mut).get("weight").getAsString()));
            float height = Float.parseFloat((((JsonObject) mut).get("height").getAsString()));
            String category = (((JsonObject) mut).get("category").getAsString());
            float overall_ability = Float.parseFloat((((JsonObject) mut).get("overall_ability").getAsString()));
            mutant.add(new Mutant(name, height, weight, category, overall_ability));
            }

    }
    }





