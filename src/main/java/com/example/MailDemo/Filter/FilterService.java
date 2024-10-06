package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;
import com.example.MailDemo.Folder.Folder;
import com.example.MailDemo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FilterService {
    @Autowired
    private UserService userService;
    private final FilterCriteriaFactory filterCriteriaFactory = new FilterCriteriaFactory();

    public List<Email> filterEmails(String folderName, Map<String, Object> allCriteria, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        Folder folder = this.getFolder(folderName, emailAddress)
                .orElseThrow(() -> new IllegalArgumentException("There is no folder with name " + folderName));

        List<Email> emails = folder.getEmails();
        for(Map.Entry<String, Object> entry : allCriteria.entrySet()){
            Criteria criteria = filterCriteriaFactory.getCriteria(entry.getKey(), entry.getValue());

            if(criteria != null) {
                emails = criteria.meetCriteria(emails);
            }
        }
        return emails;
    }

    // Check if the folder exist and return it if exist
    private Optional<Folder> getFolder(String folderName, String emailAddress){
        return userService.getUserDB().get(emailAddress).getFolders().stream()
                .filter(folder -> folder.getName().equals(folderName))
                .findFirst();
    }
}
