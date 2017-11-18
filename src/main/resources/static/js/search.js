$(document).ready(function () {
    $("#search-button").click(function () {
        targetUrl = "http://localhost:8080/api/search?tags=" + document.getElementById('tag-input').value || "";
        drawContent(targetUrl)
    });

    $("#tags").click(function (event) {
        targetUrl = "http://localhost:8080/api/remove?tags=" + event.target.textContent || "";
        drawContent(targetUrl);
    });
});

function drawContent(url) {
    $.ajax({
        url: url,
        type: 'GET'
    }).then(function drawContent(response) {
        document.getElementById('tag-input').value = '';
        if (response == '') {
            document.getElementById('tags').innerHTML = '';
            document.getElementById('result-table').innerHTML = '';
        } else {
            var currentTags = '';
            for (var k in response.tags) {
                currentTags = currentTags + '<span class="tag">' + response.tags[k] + '</span>';
            }
            document.getElementById('tags').innerHTML = currentTags;

            var table = '<thead class="table-header"><tr><th rowspan="2">Title</th><th colspan="2">Author</th><th rowspan="2">Question</th><th colspan="2">Respondent</th><th rowspan="2">Answer</th></tr><tr><td>Name</td><td>Reputation</td><td>Name</td><td>Reputation</td></tr></thead>';
            for (var r in response.questions) {
                table = table
                    + '<tr ' + ((response.questions[r].accepted) ? 'class="accepted"' : '') + '><td>'
                    + '<a href="' + response.questions[r].link + '">' + response.questions[r].title + '</a>'
                    + '</td><td>'
                    + '<a href="' + response.questions[r].author.link + '">' + response.questions[r].author.name + '</a>'
                    + '</td><td>'
                    + response.questions[r].author.reputation
                    + '</td><td>'
                    + '<details><summary>Question</summary><p>' + response.questions[r].bodyQuestion + '</p></details>'
                    + '</td><td>'
                    + ((response.questions[r].accepted) ? '<a href="' + response.questions[r].respondent.link + '">' + response.questions[r].respondent.name + '</a></td><td>' + response.questions[r].respondent.reputation + '</td><td><details><summary>Answer</summary><p>' + response.questions[r].bodyAnswer + '</p></details>' : '')
                    + '</td></tr>';
            }
            document.getElementById('result-table').innerHTML = table;
        }
    });
}