var data = [
    {
        "question": "M'arrive-t-il d'être d'humeurs euphorique et colérique dans une même journée ?",
        "answers": [" Souvent", " Parfois", " Jamais"],
        "values": ["0", "3", "7"]
    },
    {
        "question": "Quel pourcentage de mes collaborateurs a des bonnes idées que je n'ai pas eues ?",
        "answers": [" Peu malheureusement : moins de 10%", " De 10 à 66%", " Plus de 66%"],
        "values": ["0", "4", "7"]
    },
    {
        "question": "Combien d'heures suis-je prêt(e) à passer sur internet pour trouver l'hôtel ou la location de vacances de mes rêves ?",
        "answers": [" 10 minutes (ça me gonfle)", " 1 heure", " Le temps nécessaire"],
        "values": ["0", "2", "4"]
    },
    {
        "question": "L'un de mes collaborateurs a terminé une tâche simple, qui n'a rien d'exceptionnel, et m'en fait part :",
        "answers": [" Je lui fait remarquer qu'il n'a pas lancé Ariane 6", " J'acquiesce (je ne vais tout de même pas lui faire une statue)", " Je le remercie pour cela"],
        "values": ["0", "2", "4"]
    },
    {
        "question": "Combien de fois avez-vous ri ou fait rire au cours des 10 dernières réunions que vous avez animées ?",
        "answers": [" 10 fois", "Quelques fois", " 0 (je ne suis pas un clown)"],
        "values": ["4", "3", "0"]
    },
    {
        "question": "Quel délai maximum m’est nécessaire afin d’exprimer une insatisfaction à un de mes collaborateurs ?",
        "answers": [" Quelques heures", " Quelques jours", " J'attends le prochain bilan formel"],
        "values": ["5", "2", "0"]
    },
    {
        "question": "Combien de temps vous a pris la décision la plus longue à prendre ?",
        "answers": [" Quelques minutes", " Quelques jours", " Quelques semaines"],
        "values": ["3", "1", "0"]
    },
    {
        "question": "Je travaille :",
        "answers": [" Au milieu de mes équipes", " Dans un bureau fermé", " A un autre étage que celui de mes équipes"],
        "values": ["4", "2", "0"]
    },
    {
        "question": "J'essaie d'être présent à un maximum de réunions où des décisions se prennent.",
        "answers": [" Oui", " Non"],
        "values": ["0", "6"]
    },
    {
        "question": "Combien de documents ou d'icônes sont non classés sur le fond d'écran de votre PC de bureau ?",
        "answers": [" Aucune", " Quelques-unes", " Plusieurs dizaines"],
        "values": ["3", "1", "0"]
    },
    {
        "question": "Connaissez-vous Pushbullet ?",
        "answers": [" Oui", " Non"],
        "values": ["3", "0"]
    },
    {
        "question": "Quel pourcentage de mon temps est consacré à des tâches ingrates ou chiantes (j'imprime moi-même mes documents) ?",
        "answers": [" 0%", " 10%", " Au-delà"],
        "values": ["0", "5", "3"]

    },
    {
        "question": "Combien d'événements conviviaux ai-je organisé au cours des 12 derniers mois (hors séminaires, pots de départ) ?",
        "answers": [" 0", " 1", " Au moins 2"],
        "values": ["0", "2", "6"]
    },
    {
        "question": "Il a pu m'arriver d'enjoliver la réalité pour obtenir rapidement l'accord d'un collaborateur :",
        "answers": [" Oui", " Non"],
        "values": ["0", "6"]
    },
    {
        "question": "Le plus gros concurrent de ma société :",
        "answers": [" Je peux en parler des heures", " Je le connais mal", " Cela ne m'intéresse pas, je suis focalisé sur notre entreprise"],
        "values": ["4", "2", "0"]
    },
    {
        "question": "Combien de personnes sont dans la boucle de mes réflexions stratégiques (même si je n'ai pas besoin d'elles pour les prendre) ?",
        "answers": [" 0 (perte de temps)", " 1 à 5", " Au-delà"],
        "values": ["0", "4", "2"]
    },
    {
        "question": "Vous arrive-t-il de vous engueuler vous-même ?",
        "answers": [" Oui", " Non"],
        "values": ["5", "0"]
    },
    {
        "question": "Lorsque je fixe des objectifs annuels à mes collaborateurs :",
        "answers": [" L'essentiel est qualitatif", " 50% quali, 50% quanti", " L'essentiel est quantitatif"],
        "values": ["7", "3", "0"]
    },
    {
        "question": "Vous arrive-t-il de sonder vos collaborateurs pour prendre une décision ?",
        "answers": [" Quasiment jamais", " Parfois", " Presque toujours"],
        "values": ["0", "6", "2"]
    },
    {
        "question": "Combien d'innovations managériales / produits / outils sont sorties de votre bureau et ont changé le quotidien de vos équipes ou clients au cours des 12 derniers mois ?",
        "answers": [" Aucune, ce n'est pas mon rôle", " De multiples", " Toutes !"],
        "values": ["0", "7", "3"]
    }];

var createAnswer = function (questionNb, answerNb, content) {
    var id = "q" + questionNb + "-a" + answerNb;
    var div = document.createElement("div");
    var label = document.createElement("label");
    var input = document.createElement("input");

    div.setAttribute("class", "col-sm-4");
    label.setAttribute("for", id);
    input.setAttribute("id", id);
    input.setAttribute("type", "radio");
    input.setAttribute("name", "q" + questionNb);
    input.setAttribute("value", data[questionNb-1]["values"][answerNb-1]);

    label.appendChild(input);
    label.appendChild(document.createTextNode(content));
    div.appendChild(label);

    return div;
}

var createQuestionFieldset = function (content, idx) {
    var fieldset = document.createElement("fieldset");
    var heading = document.createElement("p");
    var status = document.createElement("input");

    status.setAttribute("id", "q" + idx + "-isChecked");
    status.setAttribute("type", "hidden");
    status.setAttribute("name", "q" + idx + "-isChecked");
    status.setAttribute("value", 0);

    if (idx > 10)
        fieldset.setAttribute("class", "second-set");
    else
        fieldset.setAttribute("class", "first-set");

    heading.appendChild(document.createTextNode(idx + ". " + content));
    fieldset.appendChild(heading);
    fieldset.appendChild(status);

    return fieldset;
}

function generateQuestions(current, qidx)
{
    var question = createQuestionFieldset(current["question"], qidx + 1);

    current["answers"].forEach(function (current, idx) {
        question.appendChild(createAnswer(qidx + 1, idx + 1, current));
    });

    $(".form-group > div").append(question);
    $(".second-set").css("display", "none");
}

function radioButtonChanged(button)
{
    var id = button.attr("id").split("-")[0];
    var elem = "#" + id + "-isChecked";
    var percent = $("#progressbar").progressbar("value");

    if ($(elem).val() === "0")
    {
        $("#progressbar").progressbar({value: percent + 5});
        percent = $("#progressbar").progressbar("value");
        $(elem).val(1);
    }

    if ((percent === 50) || (percent === 100))
        $("button").removeAttr("disabled");
}

function updateQuestions()
{
    $(".first-set").css("display", "none");
    $(".second-set").css("display", "block");
    $("button").attr("disabled", "disabled");
    return true;
}

function goToNextPage()
{
    $("#questionsForm").submit();
}

$(document).ready(function ()
{
    var status = false;

    $("#progressbar").progressbar({value: 0});
    $("button").attr("disabled", "disabled");

    data.forEach(function (current, idx)
    {
        generateQuestions(current, idx);
    });

    $(":radio").change(function ()
    {
        radioButtonChanged($(this));
    });

    $("button").click(function ()
    {
        if (status === false)
            status = updateQuestions();
        else
            goToNextPage();
    });
});

