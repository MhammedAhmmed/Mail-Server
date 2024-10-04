package com.example.MailDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String convertFoldersToJson(Map<String, Folder> folders){
        try {
            return objectMapper.writeValueAsString(folders);
        }catch (Exception e){
            throw new RuntimeException("Error converting folders to json", e);
        }
    }
    public Map<String, Folder> convertJsonToFolders(String Json){
        try{
            return objectMapper.readValue(Json, new TypeReference<Map<String, Folder>>() {});
        }catch (Exception e){
            throw new RuntimeException("Error converting Json to folders", e);
        }
    }
    public String convertTrashFolderToJson(List<Email> trashFolder){
        try{
            return objectMapper.writeValueAsString(trashFolder);
        }catch (Exception e){
            throw new RuntimeException("Error converting trash folder to Json", e);
        }
    }
    public List<Email> convertJsonToTrashFolder(String Json){
        try{
            return objectMapper.readValue(Json, new TypeReference<List<Email>>() {});
        }catch (Exception e){
            throw new RuntimeException("Error converting Json to trash folder");
        }
    }
    public String convertContactsFolderToJson(List<Contact>contacts){
        try{
            return objectMapper.writeValueAsString(contacts);
        }catch (Exception e){
            throw new RuntimeException("Error converting Contacts folder to json", e);
        }
    }
    public List<Contact> convertJsonToContactsFolder(String Json){
        try{
            return objectMapper.readValue(Json, new TypeReference<List<Contact>>() {});
        }catch (Exception e){
            throw new RuntimeException("Error converting Json to Contacts folder");
        }
    }
}
