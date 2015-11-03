/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.creators;

import com.davidson.dev.qcm.entity.Answer;
import com.davidson.dev.qcm.entity.Person;
import com.davidson.dev.qcm.entity.Question;
import com.davidson.dev.qcm.entity.Reponse;
import com.davidson.dev.qcm.facade.AnswerFacade;
import com.davidson.dev.qcm.facade.PersonFacade;
import com.davidson.dev.qcm.facade.QuestionFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nebrass
 */
@WebServlet(name = "get", urlPatterns = {"/get"})
public class get extends HttpServlet {

    private static final int numberOfRecommandations = 3;

    static AnswerFacade answerFacade = new AnswerFacade();
    static QuestionFacade questionFacade = new QuestionFacade();
    static PersonFacade personFacade = new PersonFacade();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SortedMap<Integer, Integer> map = new TreeMap<>();

        HttpSession session = request.getSession(false);

        if (session == null || "".equals(session.getAttribute("name")) || "".equals(session.getAttribute("family"))
                || session.getAttribute("name") == null || session.getAttribute("family") == null) {
            response.sendRedirect("index.html");
        } else {
            
            String name = (String) session.getAttribute("name");
            String family = (String) session.getAttribute("family");
            String company = (String) session.getAttribute("company");
            String invitation = (String) session.getAttribute("invitation");

            if (invitation == null) {
                invitation = "";
            }

            int total = 0;
            Answer answer = new Answer();
            Person person = new Person(name, family, company, invitation);
            person.setAnswer(answer);
            answer.setPerson(person);

            for (int idQuestion = 1; idQuestion <= 20; idQuestion++) {
                int responseValue = Integer.valueOf(request.getParameter("q" + idQuestion));

                answer.getReponses().add(new Reponse(answer, (long) idQuestion, String.valueOf(responseValue)));

                total += responseValue;

                //Failed case
                if (responseValue < 5) {
                    map.put(getQuestionPriority(idQuestion), idQuestion);
                }
            }

            if (request.getParameter("lang") == null) {
                answer.setLang("fr");
            } else {
                answer.setLang(request.getParameter("lang"));
            }

            answer.setScore(total);
            answerFacade.createAnswer(answer);

            Iterator<Integer> iterator = map.keySet().iterator();
            int counter = 0;
            List<String> recommandationTab = new ArrayList<>();
            while (iterator.hasNext() && counter < 3) {
                recommandationTab.add(getRecommandation(map.get(iterator.next())));
                counter++;
            }
            session.setAttribute("recommandationTab", recommandationTab);
            session.setAttribute("total", total);
            session.setAttribute("referralID", person.getReferral_id());

            response.sendRedirect("result.html");
        }
    }
    
    /**
     * Recommandation
     * @param idQuestion long
     * @return 
     */
    private String getRecommandation(int idQuestion) {
        Question question = questionFacade.findQuestion(new Long(idQuestion));
        if (question == null) {
            return "";
        } else {
            return question.getRecommandation().get(0);
        }
    }

    /**
     *
     * @param url String
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {

        String source = "";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()))) {
                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        source += inputLine;
                    }
                }
                return source;
    }

    /**
     *
     * @param id int
     * @return
     */
    private int getQuestionPriority(int id) {
        Question question = questionFacade.findQuestion(new Long(id));
        if (question == null) {
            return 99;
        } else {
            return question.getPriority();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
