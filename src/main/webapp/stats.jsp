<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.davidson.dev.qcm.entity.Person"%>
<%@page import="java.util.List"%>
<%@page import="com.davidson.dev.qcm.facade.AnswerFacade"%>
<%@page import="com.davidson.dev.qcm.facade.PersonFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="//www.datatables.net/release-datatables/extensions/TableTools/css/dataTables.tableTools.css" rel="stylesheet">
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="//cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="//www.datatables.net/release-datatables/extensions/TableTools/js/dataTables.tableTools.js"></script>
	<title>Statistiques The Management Game</title>
    </head>
    <body>
        <script>
            $(document).ready(function () {
                $('#tableauStat').dataTable({
		dom: 'T<"clear">lfrtip'
		});
            });
        </script>
        <div class="container">
            <h1>Statistiques The Management Game</h1>
            <%
                PersonFacade personFacade = new PersonFacade();

                List<Person> persons = personFacade.listAll();
                if (persons.size() > 0) {
            %>
            <div class="table-responsive">
                <table id="tableauStat" class="table table-bordered table-hover" data-sort-name="name" data-sort-order="desc">
                    <caption>Liste des participants</caption>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Entreprise</th>
                            <th>Date Participation</th>
                            <th>Score</th>
                            <th>Invitation</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int i = 0;
                            for (Person p : persons) {
                                i++;
                        %>
                        <tr>
                            <%
                                out.println("<td>" + i + "</td>");
                                out.println("<td>" + p.getFamilyName() + "</td>");
                                out.println("<td>" + p.getName() + "</td>");
                                out.println("<td>" + ("".equals(p.getCompanyName()) ? "-" : p.getCompanyName()) + "</td>");
                                out.println("<td>" + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(p.getAnswer().getResponseDate()) + "</td>");
                                out.println("<td>" + p.getAnswer().getScore() + "</td>");

                                if ("".equals(p.getInvitation()) || p.getInvitation() == null) {
                                    out.println("<td>Non</td>");
                                } else {
                                    Person ref = personFacade.findPersonByReferralID(p.getInvitation());
                                    if (ref != null) {
                                        out.println("<td>" + ref.getName() + " " + ref.getFamilyName() + "</td>");
                                    } else {
                                        out.println("<td>Non</td>");
                                    }
                                }

                            %>
                        </tr>      
                        <%}
                        %>
                </table>
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>
