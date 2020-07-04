package com.ashwin.bingo.services;

import com.ashwin.bingo.domain.Ticket;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TicketService {

    Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());

    /**
     * Used to form html table of ticket
     * @param ticket Ticket needed as html
     * @return String HTML returned as html for ticket
     */
    public String formHtmlTable(Ticket ticket) {
        StringBuilder ticketBuilder = new StringBuilder();
        ticketBuilder.append("<html>");
        ticketBuilder.append("<head>" +
                "<style>" +
                "table, th, td {" +
                "  border: 1px solid black;" +
                "  border-collapse: collapse;" +
                "}" +
                "th, td {" +
                "  padding: 5px;" +
                "  text-align: left;" +
                "}" +
                "</style>" +
                "</head>");
        ticketBuilder.append("<body>");
        ticketBuilder.append("<h2>"+"Ticket number is : "+ticket.getId()+"</h2>");
        ticketBuilder.append("<table>");
        Integer[][] ticketValues = ticket.getTicket();
        for (int i = 0; i < 5; i++) {
            ticketBuilder.append("<tr>");
            for (int j = 0; j < 5; j++) {
                ticketBuilder.append("<td>"+ticketValues[i][j]+"</td>");
            }
            ticketBuilder.append("</tr>");
        }

        ticketBuilder.append("</body></table></html>");
        logger.info("HTML ticket formed for ticket :"+ticket.getId());
        return ticketBuilder.toString();
    }

}
