<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session != null) && (session.getAttribute("total") != null)) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Management Game Davidson</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta property="og:title" content="Management Game - Davidson" />
        <meta property="og:type" content="site" />
        <meta property="og:url" content="http://managementgame.davidson.fr/" />
        <meta property="og:image" content="http://managementgame.davidson.fr/img/Management-Game_Facebook.png" />
        <meta property="og:description" content="Évaluez vos aptitudes et découvrez des insights à adopter pour devenir un manager moderne." />
        <!-- Bootstrap -->
        <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/style.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link rel="icon" type="image/vnd.microsoft.icon" href="./img/favicon.ico">
        <link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
    </head>
    <body>
        <div id="fb-root"></div>
        <script>
            window.fbAsyncInit = function () {
                FB.init({appId: '330652907135981', status: true, cookie: true,
                    xfbml: true});
            };
            (function () {
                var e = document.createElement('script');
                e.async = true;
                e.src = document.location.protocol +
                        '//connect.facebook.net/en_US/all.js';
                document.getElementById('fb-root').appendChild(e);
            }());
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#fb-share-button').click(function (e) {
                    e.preventDefault();
                    FB.ui(
                            {
                                method: 'feed',
                                name: 'Mon score est <%=session.getAttribute("total")%> sur 100 dans le jeu Management Game Davidson',
                                link: ' http://managementgame.davidson.fr/play?id=<%= session.getAttribute("referralID")%>',
                                picture: 'http://managementgame.davidson.fr/img/Management-Game_Facebook.png',
                                caption: 'Etes vous un manager moderne?',
                                description: 'Evaluez vos aptitudes et découvrez des insights à adopter pour devenir un manager moderne.',
                                message: '',
                                display: 'iframe'
                            });
                });
            });
        </script>
        <div id="wrap">
            <header>
                <img id="res-mg-logo" src="./img/management-game-logo.png"/>
            </header>
            <div id="res-content" class="container">
                <div class="row">
                    <div class="col-lg-12">
                       	<div class="line-med"></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                       	<p class="big-txt">
                            MERCI D'AVOIR PARTICIPÉ !
                       	</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                       	<div class="line"></div>
                    </div>
                </div>
                <div class="row hidden-xs">
                    <div class="col-lg-12">
                        <p class="med-txt">
                            SCORE
                        </p>
                    </div>
                </div>
                <div id="scoreboard" class="row">
                    <div class="col-lg-12">
                        <div class="row visible-xs">
                            <div class="col-lg-12">
                                <p class="med-txt">
                                    SCORE
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-offset-4 col-md-4 col-xs-offset-3 col-xs-6">
                                <p id="score">
                                    <%=session.getAttribute("total")%><br/>
                                    <font style="font-size: 14px !important;">sur 100</font>
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 hidden-xs no-padding">
                                <div class="line-sm" style="margin-right:5px;"></div>
                            </div>
                            <div class="col-sm-4 col-xs-12 no-padding">
                                <p class="med-txt">
                                    RECOMMANDATIONS
                                </p>
                            </div>
                            <div class="col-sm-4 hidden-xs no-padding">
                                <div class="line-sm"  style="margin-left:5px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="recommandations" class="row">
                    <%
                        List<String> recommandationTab = (List<String>) session.getAttribute("recommandationTab");
                        int i = 0;
                        for (String rec : recommandationTab) {
                            i++;

                    %>
                    <div class="col-lg-4" style="padding-bottom:10px;">
                        <div class="res-box" style="border-width: 5px;">
                            <div class="row">
                                <p class="box-title">#<%=i%></p>
                            </div>
                            <div class="row">
                                <p class="box-content">
                                    <%= rec%>
                                </p>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <p class="med-txt">PARTAGEZ !</p>
                        </div>
                        <div class="row">
                            <div id="social" class="col-lg-offset-4 col-lg-4">
                                <img id="fb-share-button" src="img/facebook.png" style="cursor:pointer;"/>
                                <a href="http://www.linkedin.com/shareArticle?mini=true&url=http://managementgame.davidson.fr/play?id=<%= session.getAttribute("referralID")%>&title=<%= java.net.URLEncoder.encode("Mon score est " + session.getAttribute("total") + " sur 100 dans le jeu Management Game Davidson", "UTF-8")%>&summary=<%= java.net.URLEncoder.encode("Evaluez vos aptitudes et découvrez des insights à adopter pour devenir un manager moderne.", "UTF-8")%>&source=ManagementGameDavidson">
                                    <img src="img/linkedin.png"/>
                                </a>
                                <a class="custom-tweet-button" id="custom-tweet-button" href="https://twitter.com/share?text=<%= java.net.URLEncoder.encode("Mon score est " + session.getAttribute("total") + " sur 100 dans le jeu Management Game Davidson", "UTF-8")%>&summary=<%= java.net.URLEncoder.encode("Evaluez vos aptitudes et découvrez des insights à adopter pour devenir un manager moderne.", "UTF-8")%>&url=http://managementgame.davidson.fr/play?id=<%= session.getAttribute("referralID")%>" target="_blank">
                                    <img src="img/twitter.png"/>
                                </a>
                                <style type="text/css" media="screen">
                                    #custom-tweet-button a {
                                        display: block;
                                        padding: 20px 0px 0px 20px;
                                        background: url('img/twitter.png') no-repeat;
                                        border: 0px;
                                    }
                                </style>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-xs-3 col-md-3">
                        <a href="http://www.greatplacetowork.fr">
                            <img id="gptw" src="img/gptw.png"/>
                        </a>
                    </div>
                    <div class="col-xs-3 col-md-3">
                        <a href="http://www.ethikonsulting.com">
                            <img id="ethik" src="img/ethik.png"/>
                        </a>
                    </div>
                    <div class="col-xs-3 col-md-3">
                        <a href="http://www.corporate-games.fr">
                            <img id="corp-games" src="img/corporate-games.png"/>
                        </a>
                    </div>
                    <div class="col-xs-3 col-md-3">
                        <a href="http://www.davidson.fr">
                            <img id="dav" src="img/logo-dav.png"/>
                        </a>
                    </div>
                </div>
                <div class="row">
                    <p>
                        Tous droits réservés Davidson consulting 2015 - 
                        <a id="dav-link" href="http://www.davidson.fr">www.davidson.fr</a>
                    </p>
                </div>
            </div>
        </footer>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.html");
    }
%>
