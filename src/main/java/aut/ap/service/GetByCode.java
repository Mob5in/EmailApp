package aut.ap.service;

import aut.ap.graphic.PopUpWindow;
import aut.ap.graphic.userEnvironment.MenuWindow;
import aut.ap.model.Email;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.Objects;

public class GetByCode{

    private static SessionFactory sessionFactory;

    public static Email getCode(String code) {
        String query = "FROM Email WHERE sender.id = :userId";
        List<Email> unreadEmail = GetQueryService.getQuery(query);
        query = "SELECT er.email FROM EmailRecipient er WHERE er.recipient.id = :userId";
        List<Email> allEmails = GetQueryService.getQuery(query);

        allEmails.addAll(unreadEmail);

        for(Email e: allEmails){
            if(Objects.equals(e.getCode(), code)){
                IsReadService.markEmailAsRead(code, MenuWindow.getCorrentUser().getId());
                return e;
            }
        }
        PopUpWindow.pupUp("No email found");
        return null;
    }
}
